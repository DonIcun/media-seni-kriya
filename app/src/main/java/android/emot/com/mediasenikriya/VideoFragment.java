package android.emot.com.mediasenikriya;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.ArrayList;

public class VideoFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private VideoAdapter mAdapter;
    private TextView tvjudul;
    private VideoView videoView;
    private RecyclerView.LayoutManager mlayoutManager;
    ArrayList<ItemVideo> videoArrayList;
    private Uri uri;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_video,container,false);

        additem();
        videoView = view.findViewById(R.id.video_view);
        tvjudul = view.findViewById(R.id.tv_judulVideo);

        playvideo(0);
        mRecyclerView = view.findViewById(R.id.recylerview_video);
        mRecyclerView.setHasFixedSize(true);
        mlayoutManager = new LinearLayoutManager(view.getContext().getApplicationContext());
        mAdapter = new VideoAdapter(videoArrayList);

        mRecyclerView.setLayoutManager(mlayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new VideoAdapter.OnitemclickListener() {
            @Override
            public void onItemClick(int position) {
               switch (position){
                   case 0:
                       playvideo(position);
                       break;
                   case 1:
                       playvideo(position);
                       break;
                   case 2:
                       playvideo(position);
                       break;
                   case 3:
                       playvideo(position);
                       break;
                   case 4:
                       playvideo(position);
                       break;
               }
                Toast.makeText(getActivity(),videoArrayList.get(position).getJudul(),Toast.LENGTH_LONG).show();
                videoView.start();
            }
        });
        return view;
    }

    private void additem() {
        videoArrayList = new ArrayList<>() ;
        videoArrayList.add(new ItemVideo("Teknik Pijat Video","Jenifer Cave – How to make a pinch pot",R.raw.teknik_pijat_video));
        videoArrayList.add(new ItemVideo("Teknik Pilin Video","Brooke stewart - Coil Pot Time Lapse Brooke Stewart",R.raw.teknik_pilin_video));
        videoArrayList.add(new ItemVideo("Teknik Slab  Video","Apryl Fischer – Slab Mug",R.raw.teknik_slab_video));
        videoArrayList.add(new ItemVideo("Teknik Cetak Video","1815569R - Horny Toad Mold 2",R.raw.teknik_cetak_video));
        videoArrayList.add(new ItemVideo("Teknik Putar Video","Ingleton Pottery - How to Make some Easy Simple Small Pottery Ceramic Bowls on the Wheel",R.raw.teknik_putar_video));
    }

    private void playvideo(int i){
        String videopath = "android.resource://"+ getContext().getPackageName()+"/"+ videoArrayList.get(i).getLinkvideo();
        uri = Uri.parse(videopath);
        videoView.setVideoURI(uri);
        MediaController mediaController = new MediaController(getContext());
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
        tvjudul.setText(videoArrayList.get(i).getJudul());
    }
}
