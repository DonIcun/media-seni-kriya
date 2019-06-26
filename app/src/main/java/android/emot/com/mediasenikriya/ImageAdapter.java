package android.emot.com.mediasenikriya;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Windows 8.1 on 13/04/2019.
 */

public class ImageAdapter extends PagerAdapter {
    private Context mContext;
    private int[] mImages = new int[] {R.drawable.slide0,R.drawable.slide1,R.drawable.slide2,R.drawable.slide3,R.drawable.slide4};
    private int custom_position = 0;

    ImageAdapter(Context context){
        mContext = context;
    }

    @Override
    public int getCount() {
        return mImages.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView iv = new ImageView(mContext);
        iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        iv.setImageResource(mImages[position]);
        container.addView(iv);
        return iv;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((ImageView)object);
    }
}
