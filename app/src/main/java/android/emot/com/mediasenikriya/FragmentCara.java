package android.emot.com.mediasenikriya;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Windows 8.1 on 13/04/2019.
 */

public class FragmentCara extends Fragment {
    private ViewPager mSlidepager;
    private LinearLayout mLinearLayout;

    private TextView[] mDots;

    SliderAdapter sliderAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_penggunaan,container,false);

        mSlidepager = view.findViewById(R.id.vpPenggunaan);
        mLinearLayout = view.findViewById(R.id.linearLayoutdot);

        sliderAdapter = new  SliderAdapter(getContext().getApplicationContext());
        mSlidepager.setAdapter(sliderAdapter);
        addDotsIndicator();

        mSlidepager.addOnPageChangeListener(new ViewPager.OnPageChangeListener(){
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                addDotsIndicator();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        return view;
    }

    public void addDotsIndicator(){

        if (mLinearLayout.getChildCount() > 0){
            mLinearLayout.removeAllViews();
        }

        mDots = new TextView[8];

        for (int i=0;i<mDots.length;i++){
            mDots[i]=new TextView(getActivity());
            mDots[i].setText(Html.fromHtml("&#8226"));
            if (mSlidepager.getCurrentItem()==i){
                mDots[i].setTextSize(35);
                mDots[i].setTextColor(getResources().getColor(R.color.primaryTextColor));
            }else {
                mDots[i].setTextSize(35);
                mDots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));
            }
            mLinearLayout.addView(mDots[i]);
        }
//        Toast.makeText(getActivity(), "slide ke" + mSlidepager.getCurrentItem(), Toast.LENGTH_SHORT).show();

    }

}
