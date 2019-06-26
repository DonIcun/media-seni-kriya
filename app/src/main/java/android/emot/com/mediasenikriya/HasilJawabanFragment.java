package android.emot.com.mediasenikriya;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Windows 8.1 on 29/04/2019.
 */

public class HasilJawabanFragment extends Fragment {
    private RecyclerView recyclerView;
    private JawabanRecyclerviewAdaptor jawabanRecyclerview;
    private RecyclerView.LayoutManager mlayout;
//    String hasil;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jawabansoal,container,false);

        Bundle b = getArguments();
        ArrayList<String> hasil = new ArrayList<String>();
        hasil = b.getStringArrayList("jawaban");
//        hasil = b.getString("nilaiahir");
        ArrayList<ItemJawaban> itemJawaben = new ArrayList();
        for (int i = 0;i<15;i++) {
            itemJawaben.add(new ItemJawaban(String.valueOf(i+1), hasil.get(i)));
        }
        recyclerView = view.findViewById(R.id.recyclerViewJawaban);
        recyclerView.setHasFixedSize(true);
        mlayout = new LinearLayoutManager(view.getContext().getApplicationContext());
        jawabanRecyclerview = new JawabanRecyclerviewAdaptor(itemJawaben);

        recyclerView.setLayoutManager(mlayout);
        recyclerView.setAdapter(jawabanRecyclerview);



        return view;
    }
}
