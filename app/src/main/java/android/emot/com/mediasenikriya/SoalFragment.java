package android.emot.com.mediasenikriya;

import android.content.DialogInterface;
import android.emot.com.mediasenikriya.matericlass.FragmentMateriSifat;
import android.os.Bundle;
import android.os.Debug;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Windows 8.1 on 12/04/2019.
 */

public class SoalFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private NomsoalRecyclerAdapter mAdapter;
    private RecyclerView.LayoutManager mlayoutManager;

    LinearLayout layoutimageview;
    TextView mtvSkor, mtvSoal,mtvNomSoal;
    ImageView mtImage;
    RadioGroup mrgPilihanJawaban;
    RadioButton mrbPilihanJawaban1, mrbPilihanJawaban2, mrbPilihanJawaban3,mrbPilihanJawaban4,mrbPilihanJawaban5;
    Button mbtnSubmit;
    ImageButton mbtnNext,mbtnPrev;
    int skor=0;
    int arr; //untuk menampung nilai panjang array
    int x = 0;   //menunjukkan konten sekarang
    int y = 0;
    String jawaban; //menampung jawaban benar
    public ArrayList<Integer> cekhasil = new ArrayList<Integer>();
    public ArrayList<String> nilaihasil = new ArrayList<String>();

    SoalPilgan soalPG = new SoalPilgan();

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_soal,container,false);
        ArrayList<Integer> nomsoalarr = new ArrayList<Integer>();
        for (int i = 0;i<soalPG.setSoal.length;i++){
            nomsoalarr.add(i);
            cekhasil.add(null);
        }
        mRecyclerView = view.findViewById(R.id.rv_numsoal);
        mRecyclerView.setHasFixedSize(false);
        mlayoutManager = new GridLayoutManager(view.getContext().getApplicationContext(),8,GridLayoutManager.VERTICAL,false);
        mAdapter = new NomsoalRecyclerAdapter(nomsoalarr,cekhasil);
        mRecyclerView.setLayoutManager(mlayoutManager);
        mRecyclerView.setAdapter(mAdapter);

//        ((MainActivity)getActivity()).enableDisableDrawer(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        //menyambungkan antara variabel KuisPilihanGanda.java dengan id activity_kuis_pilihan_ganda
        mtvSkor = view.findViewById(R.id.tvSkor);
        mtvSoal = view.findViewById(R.id.tvSoal);
        mtImage = view.findViewById(R.id.ivsoal);
        mtvNomSoal = view.findViewById(R.id.tvNomSoal);
        layoutimageview = view.findViewById(R.id.layoutivsoal);
        mrgPilihanJawaban = view.findViewById(R.id.rgPilihanJawaban);
        mrbPilihanJawaban1 = view.findViewById(R.id.rbPilihanJawaban1);
        mrbPilihanJawaban2 = view.findViewById(R.id.rbPilihanJawaban2);
        mrbPilihanJawaban3 = view.findViewById(R.id.rbPilihanJawaban3);
        mrbPilihanJawaban4 = view.findViewById(R.id.rbPilihanJawaban4);
        mrbPilihanJawaban5 = view.findViewById(R.id.rbPilihanJawaban5);

        mbtnSubmit = view.findViewById(R.id.btnSubmit);
        mbtnNext = view.findViewById(R.id.btnNext);
        mbtnPrev = view.findViewById(R.id.btnPrev);

        //set konten
        //mtvSkor.setText("skor: "+skor);
        mtvSkor.setText("   ");
        setKonten(x);

        mbtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (x<(soalPG.setSoal.length-1)){
                    cekJawaban(x);
                    y = x+1;
                    setKonten(y);
                    Log.d("nosoal",String.valueOf(y) + "dari"+ String.valueOf(soalPG.setSoal.length));
                }
            }
        });

        mbtnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (x>0) {
                    cekJawaban(x);
                    y = x - 1;
                    setKonten(y);
                    Log.d("nosoal",String.valueOf(y) + "dari"+ String.valueOf(soalPG.setSoal.length));
                }
            }
        });
        mbtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle    ("Selesai Quiz");
                builder.setMessage("apakah anda sudah selesai menjawab quiz?");
                builder.setPositiveButton("YA", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        selesaiquis();
                    }
                });
                builder.setNegativeButton("TIDAK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
                cekJawaban(x);
            }
        });

        mAdapter.setOnItemClickListener(new NomsoalRecyclerAdapter.OnitemclickListener() {
            @Override
            public void onItemClick(int position) {
                cekJawaban(x);
                setKonten(position);
            }
        });
        return view;
    }

    public void cekJawaban(int i) {
        if (mrgPilihanJawaban.getCheckedRadioButtonId()!=-1){
            int radioidcheck= mrgPilihanJawaban.getCheckedRadioButtonId();
            View radiobtn = mrgPilihanJawaban.findViewById(radioidcheck);
            int indexchild = mrgPilihanJawaban.indexOfChild(radiobtn);
            cekhasil.set(i,indexchild);
            Log.d("nosoal","no" + i + "jawaban"+ cekhasil.get(i).toString());
            mAdapter.notifyDataSetChanged();
        }
        else {
            cekhasil.set(i,null);
            mAdapter.notifyDataSetChanged();
        }
    }

    public void setKonten(int i) {
        x = i;
        arr = soalPG.setSoal.length;
        if (i >= arr || i<0){
            x=arr;
            Toast.makeText(getActivity(), "end of Soal", Toast.LENGTH_SHORT).show();
//            mbtnSubmit.setEnabled(false);
//            selesaiquis();
        }else {
            mtvNomSoal.setText("Soal No. "+ (i+1));
            mtvSoal.setText(soalPG.getPertanyaan(i));
            mrbPilihanJawaban1.setText(soalPG.getPilihanJawaban1(i));
            mrbPilihanJawaban2.setText(soalPG.getPilihanJawaban2(i));
            mrbPilihanJawaban3.setText(soalPG.getPilihanJawaban3(i));
            mrbPilihanJawaban4.setText(soalPG.getPilihanJawaban4(i));
            mrbPilihanJawaban5.setText(soalPG.getPilihanJawaban5(i));
            jawaban = soalPG.getJawabanBenar(i);
            if (soalPG.getGambar(i) == 0 ){
                layoutimageview.setVisibility(View.GONE);
                mtImage.setVisibility(View.GONE);

            }else {
                layoutimageview.setVisibility(View.VISIBLE);
                mtImage.setVisibility(View.VISIBLE);
                mtImage.setImageResource(soalPG.getGambar(i));
                mtImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
            setjawaban(i);
        }
    }

    public void setjawaban(int i){
        if (!cekhasil.isEmpty()){
            if (cekhasil.get(i)!=null) {
                ((RadioButton)mrgPilihanJawaban.getChildAt(cekhasil.get(i))).setChecked(true);
            }else{
                mrgPilihanJawaban.clearCheck();
            }
        }
    }

    public void selesaiquis(){
        for (int i=0;i<soalPG.setSoal.length;i++){
            if (cekhasil.get(i) == null){
                nilaihasil.add(null);
            }else {
                if (cekhasil.get(i) == soalPG.getjawbanid(i)) {
                    skor = skor + 10;
                    nilaihasil.add(i, "Benar");
                } else {
                    nilaihasil.add(i, "salah");
                }
            }
        }

        int skorfinal = (skor/3)*2 ;

        Bundle b = new Bundle();
        b.putString("nilaiahir",String.valueOf(skorfinal));
        b.putStringArrayList("jawaban",nilaihasil);
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        Fragment fragment = new SoalHasilFragment();
        fragment.setArguments(b);
        transaction.replace(R.id.frame_container,fragment)
                .commit();
    }

}
