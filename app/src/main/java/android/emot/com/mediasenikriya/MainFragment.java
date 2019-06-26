package android.emot.com.mediasenikriya;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;

/**
 * Created by Windows 8.1 on 29/03/2019.
 */

public class MainFragment extends Fragment {

    Button button;
//    ViewPager viewPager;
//    private int currentpage = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_main,container,false);

        ((MainActivity)getActivity()).enableDisableDrawer(DrawerLayout.LOCK_MODE_UNLOCKED);

        button = view.findViewById(R.id.btPilih);
//        viewPager = view.findViewById(R.id.viewPager);
        final ImageAdapter imageAdapter = new ImageAdapter(getContext().getApplicationContext());
       // viewPager.setAdapter(imageAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,
                        new FragmentCara())
                        .commit();
            }
        });


//        final android.os.Handler handler = new android.os.Handler();
//
//        final Runnable update = new Runnable() {
//            @Override
//            public void run() {
//                viewPager.setCurrentItem(currentpage,true);
//                if (currentpage == 4){
//                        currentpage =0;
//                    }else {
//                        ++currentpage;
//                    }
//            }
//        };
//
//        Timer timer = new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                handler.post(update);
//            }
//        },2000,3000);

        return view;

    }

}
