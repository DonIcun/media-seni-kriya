package android.emot.com.mediasenikriya;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Windows 8.1 on 28/04/2019.
 */

public class SoalHasilFragment extends Fragment {

    TextView sskor,fskor,tskor;
    Button soalulang,cekhasil;
    ImageView ivskor;

    String skorvalue;
    ArrayList<String> arrayList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hasilsoal,container,false);

        sskor = view.findViewById(R.id.statusskor);
        fskor = view.findViewById(R.id.finalskor);
        ivskor = view.findViewById(R.id.ivgbskor);
//        tskor = view.findViewById(R.id.tekskor);
        soalulang = view.findViewById(R.id.buttonreplay);
        cekhasil = view.findViewById(R.id.buttoncenilai);
        Typeface type = Typeface.createFromAsset (getActivity().getAssets(),"fonts/COOPBL.TTF");

        final Bundle b = getArguments();
        skorvalue = b.getString("nilaiahir");
        arrayList = b.getStringArrayList("jawaban");
        int tempskor = Integer.parseInt(skorvalue);

        fskor.setTypeface(type);
        fskor.setText(skorvalue);
        sskor.setTypeface(type);
//        tskor.setTypeface(type);
        if (tempskor > 85) {
//            sskor.setText("Menakjubkan!");
            ivskor.setImageResource(R.drawable.popup3);
        }else if (tempskor > 70 ){
//            sskor.setText("Hebat!");
            ivskor.setImageResource(R.drawable.popup2);
        }else {
//            sskor.setText("Coba Lagi");
//            sskor.setText(arrayList.get(0));
            ivskor.setImageResource(R.drawable.popup1);
        }

        soalulang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,
                          new SoalFragment()).commit();
            }
        });

        cekhasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                Fragment fragment = new HasilJawabanFragment();
                fragment.setArguments(b);
                transaction.replace(R.id.frame_container,fragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        return view;
    }


}
