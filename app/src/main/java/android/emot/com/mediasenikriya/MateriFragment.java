package android.emot.com.mediasenikriya;

import android.content.Intent;
import android.emot.com.mediasenikriya.matericlass.FragmentMateriJenis;
import android.emot.com.mediasenikriya.matericlass.FragmentMateriPengembangan;
import android.emot.com.mediasenikriya.matericlass.FragmentMateriPengertian;
import android.emot.com.mediasenikriya.matericlass.FragmentMateriSifat;
import android.emot.com.mediasenikriya.matericlass.FragmentMateriTeknik;
import android.emot.com.mediasenikriya.matericlass.MateriFragmentBahan;
import android.emot.com.mediasenikriya.matericlass.MateriFragmentPembuatan;
import android.emot.com.mediasenikriya.matericlass.MateriFragmentPeralatan;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Windows 8.1 on 29/03/2019.
 */

public class MateriFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private MateriRecyclerAdapter mAdapter;
    private RecyclerView.LayoutManager mlayoutManager;
    TextView tvjudulmateri;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_materi,container,false);

        ArrayList<ItemMateri> itemMateriArrayList = new ArrayList();
        itemMateriArrayList.add(new ItemMateri(R.drawable.mpengertian,"Pengertian Keramik"));
        itemMateriArrayList.add(new ItemMateri(R.drawable.mbahan,"Bahan Tanah Liat"));
        itemMateriArrayList.add(new ItemMateri(R.drawable.msifat,"Sifat Umum Tanah Liat"));
        itemMateriArrayList.add(new ItemMateri(R.drawable.mjenis,"Jenis Tanah Liat"));
        itemMateriArrayList.add(new ItemMateri(R.drawable.mteknik,"Teknik dasar Keramik"));
        itemMateriArrayList.add(new ItemMateri(R.drawable.malat,"Peralatan Membuat Keramik"));
        itemMateriArrayList.add(new ItemMateri(R.drawable.mpembuatan,"Pembuatan Keramik"));
        itemMateriArrayList.add(new ItemMateri(R.drawable.mpengembangan,"Pengembangan Teknik Pembuatan Keramik"));
        itemMateriArrayList.add(new ItemMateri(R.drawable.mvideo,"Video"));

        Typeface tfmenu = Typeface.createFromAsset(getActivity().getAssets(),"fonts/TrajanPro-Bold.otf");

        tvjudulmateri = view.findViewById(R.id.tvjudulmateri);
        tvjudulmateri.setTypeface(tfmenu);
        tvjudulmateri.setTextColor(getResources().getColor(R.color.colorBlack));
        mRecyclerView = view.findViewById(R.id.recyclerViewMateri);
        mRecyclerView.setHasFixedSize(true);
        mlayoutManager = new LinearLayoutManager(view.getContext().getApplicationContext());
        mAdapter = new MateriRecyclerAdapter(itemMateriArrayList);

        mRecyclerView.setLayoutManager(mlayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new MateriRecyclerAdapter.OnitemclickListener(){
            @Override
            public void onItemClick(int position) {
                Log.i("cekpos", String.valueOf(position));
                switch (position){
                    case 0:
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,
                                new FragmentMateriPengertian()).addToBackStack(null).commit();
                        break;
                    case 1:
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,
                                new MateriFragmentBahan()).addToBackStack(null).commit();
                        break;
                    case 2:
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,
                                new FragmentMateriSifat()).addToBackStack(null).commit();
                        break;
                    case 3:
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,
                                new FragmentMateriJenis()).addToBackStack(null).commit();
                    break;
                    case 4:
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,
                                new FragmentMateriTeknik()).addToBackStack(null).commit();
                        break;
                    case 5:
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,
                                new MateriFragmentPeralatan()).addToBackStack(null).commit();
                        break;
                    case 6:
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,
                                new MateriFragmentPembuatan()).addToBackStack(null).commit();
                        break;
                    case 7:
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,
                                new FragmentMateriPengembangan()).addToBackStack(null).commit();
                        break;
                    case 8:
                        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,
                                new VideoFragment()).addToBackStack(null).commit();
                        break;
                }
            }
        });

        return view;

    }
}
