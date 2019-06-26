package android.emot.com.mediasenikriya;

import android.content.DialogInterface;
import android.emot.com.mediasenikriya.matericlass.FragmentMateriSifat;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
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

    TextView mtvSkor, mtvSoal,mtvNomSoal;
    ImageView mtImage;
    RadioGroup mrgPilihanJawaban;
    RadioButton mrbPilihanJawaban1, mrbPilihanJawaban2, mrbPilihanJawaban3,mrbPilihanJawaban4,mrbPilihanJawaban5;
    Button mbtnSubmit;
    int skor=0;
    int arr; //untuk menampung nilai panjang array
    int x;   //menunjukkan konten sekarang
    String jawaban; //menampung jawaban benar
    ArrayList<String> cekhasil = new ArrayList<String>();

    SoalPilgan soalPG = new SoalPilgan();

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_soal,container,false);

//        ((MainActivity)getActivity()).enableDisableDrawer(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        //menyambungkan antara variabel KuisPilihanGanda.java dengan id activity_kuis_pilihan_ganda
        mtvSkor = view.findViewById(R.id.tvSkor);
        mtvSoal = view.findViewById(R.id.tvSoal);
        mtImage = view.findViewById(R.id.ivsoal);
        mtvNomSoal = view.findViewById(R.id.tvNomSoal);
        mrgPilihanJawaban = view.findViewById(R.id.rgPilihanJawaban);
        mrbPilihanJawaban1 = view.findViewById(R.id.rbPilihanJawaban1);
        mrbPilihanJawaban2 = view.findViewById(R.id.rbPilihanJawaban2);
        mrbPilihanJawaban3 = view.findViewById(R.id.rbPilihanJawaban3);
        mrbPilihanJawaban4 = view.findViewById(R.id.rbPilihanJawaban4);
        mrbPilihanJawaban5 = view.findViewById(R.id.rbPilihanJawaban5);

        mbtnSubmit = view.findViewById(R.id.btnSubmit);

        //set konten
        //mtvSkor.setText("skor: "+skor);
        mtvSkor.setText("   ");
        setKonten();
        
        mbtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CekJawaban();
            }
        });


        return view;
    }

    public void CekJawaban() {
        if (mrbPilihanJawaban1.isChecked()){
            if (mrbPilihanJawaban1.getText().toString().equals(jawaban)){
                skor = skor + 10;
                cekhasil.add("Benar");
//                mtvSkor.setText("skor: "+skor);	//mtvSkor diset nilainya = var skor
                //Toast.makeText(getActivity(), "Jawaban Benar", Toast.LENGTH_SHORT).show(); //keluar notifikasi "Jawaban Benar"
                setKonten(); //update next konten
            }else{
                cekhasil.add("-");
//                mtvSkor.setText("skor: "+skor);
                //Toast.makeText(getActivity(), "Jawaban Salah", Toast.LENGTH_SHORT).show();
                setKonten();
            }
        }else if (mrbPilihanJawaban2.isChecked()){
            if (mrbPilihanJawaban2.getText().toString().equals(jawaban)){
                skor = skor + 10;
                cekhasil.add("Benar");
//                mtvSkor.setText("skor: "+skor);	//mtvSkor diset nilainya = var skor
                //Toast.makeText(getActivity(), "Jawaban Benar", Toast.LENGTH_SHORT).show(); //keluar notifikasi "Jawaban Benar"
                setKonten(); //update next konten
            }else{
                cekhasil.add("-");
//                mtvSkor.setText("skor: "+skor);
                //Toast.makeText(getActivity(), "Jawaban Salah", Toast.LENGTH_SHORT).show();
                setKonten();
            }
        }else if (mrbPilihanJawaban3.isChecked()){
            if (mrbPilihanJawaban3.getText().toString().equals(jawaban)){
                skor = skor + 10;
                cekhasil.add("Benar");
//                mtvSkor.setText("skor: "+skor);	//mtvSkor diset nilainya = var skor
                //Toast.makeText(getActivity(), "Jawaban Benar", Toast.LENGTH_SHORT).show(); //keluar notifikasi "Jawaban Benar"
                setKonten(); //update next konten
            }else{
                cekhasil.add("-");
//                mtvSkor.setText("skor: "+skor);
                //Toast.makeText(getActivity(), "Jawaban Salah", Toast.LENGTH_SHORT).show();
                setKonten();
            }
        }else if (mrbPilihanJawaban4.isChecked()){
            if (mrbPilihanJawaban4.getText().toString().equals(jawaban)){
                skor = skor + 10;
                cekhasil.add("Benar");
                //mtvSkor.setText("skor: "+skor);	//mtvSkor diset nilainya = var skor
                //Toast.makeText(getActivity(), "Jawaban Benar", Toast.LENGTH_SHORT).show(); //keluar notifikasi "Jawaban Benar"
                setKonten(); //update next konten
            }else{
                cekhasil.add("-");
//                mtvSkor.setText("skor: "+skor);
                //Toast.makeText(getActivity(), "Jawaban Salah", Toast.LENGTH_SHORT).show();
                setKonten();
            }
        }else if (mrbPilihanJawaban5.isChecked()){
            if (mrbPilihanJawaban5.getText().toString().equals(jawaban)){
                skor = skor + 10;
                cekhasil.add("Benar");
//                mtvSkor.setText("skor: "+skor);	//mtvSkor diset nilainya = var skor
                //Toast.makeText(getActivity(), "Jawaban Benar", Toast.LENGTH_SHORT).show(); //keluar notifikasi "Jawaban Benar"
                setKonten(); //update next konten
            }else{
                cekhasil.add("-");
//                mtvSkor.setText("skor: "+skor);
                //Toast.makeText(getActivity(), "Jawaban Salah", Toast.LENGTH_SHORT).show();
                setKonten();
            }
        }else {
            Toast.makeText(getActivity(), "Pilih Jawaban Dahulu", Toast.LENGTH_SHORT).show();
        }
    }

    public void setKonten() {
        String nomsoal;
        mrgPilihanJawaban.clearCheck();
        arr = soalPG.setSoal.length;
        if (x >= arr){
            x=0;
//            Toast.makeText(getActivity(), "Soal Habis", Toast.LENGTH_SHORT).show();
            mbtnSubmit.setEnabled(false);
            selesaiquis();
        }else {
            mtvSoal.setText(soalPG.getPertanyaan(x));
            mrbPilihanJawaban1.setText(soalPG.getPilihanJawaban1(x));
            mrbPilihanJawaban2.setText(soalPG.getPilihanJawaban2(x));
            mrbPilihanJawaban3.setText(soalPG.getPilihanJawaban3(x));
            mrbPilihanJawaban4.setText(soalPG.getPilihanJawaban4(x));
            mrbPilihanJawaban5.setText(soalPG.getPilihanJawaban5(x));
            jawaban = soalPG.getJawabanBenar(x);
            if (soalPG.getGambar(x) == 0 ){
                mtImage.setVisibility(View.GONE);

            }else {
                mtImage.setVisibility(View.VISIBLE);
                mtImage.setImageResource(soalPG.getGambar(x));
                mtImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
            x++;
            nomsoal = x + " / " + arr;
            mtvNomSoal.setText(nomsoal);
        }
    }

    public void selesaiquis(){
        int skorfinal = (skor/3)*2 ;

        Bundle b = new Bundle();
        b.putString("nilaiahir",String.valueOf(skorfinal));
        b.putStringArrayList("jawaban",cekhasil);
//        Set<String> set = new HashSet<String>();
//        set.addAll(cekjawaban);
//        b.putString("jawaban",set);

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        Fragment fragment = new SoalHasilFragment();
        fragment.setArguments(b);
        transaction.replace(R.id.frame_container,fragment)
                .commit();
//        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//        if (skorfinal > 80) {
//            builder.setTitle("Good Job!");
//        }else if (skorfinal > 60 ){
//            builder.setTitle("Nice!");
//        }else {
//            builder.setTitle("Too Bad!");
//        }
//            builder.setMessage("Skor anda adalah : \n\n" + skorfinal);
//            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialogInterface, int i) {
//                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,
//                            new MainFragment()).commit();
//                }
//            });
//            AlertDialog dialog = builder.create();
//            dialog.show();

    }

}
