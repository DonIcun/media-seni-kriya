package android.emot.com.mediasenikriya;

import android.content.Context;
import android.os.Debug;
import android.support.v4.view.PagerAdapter;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Windows 8.1 on 13/04/2019.
 */

public class SliderAdapter extends PagerAdapter {
    Context mcontext;
    LayoutInflater layoutInflater;
    TextView[] mDots;

    public SliderAdapter(Context c) {

//        layoutInflater = LayoutInflater.from(c);
       mcontext  = c;
    }

    //arr
    public int[] imagecara = {
            R.drawable.m0,
            R.drawable.m1,
            R.drawable.m2,
            R.drawable.m3,
            R.drawable.m4,
            R.drawable.m5,
            R.drawable.m6,
            R.drawable.m7
    };

//    public String[] judul = {
//            "menu kurikulum",
//            "menu kompetensi",
//            "menu materi",
//            "menu latihan",
//            "menu tentang",
//            "menu credit"
//    };
//
//    public String[] deskripsi = {
//            "pada menu Kurikulum ini berisi tentang kurikulum yang di gunakan dalam menyusun media pembelajaran pocket of ceramic",
//            "pada menu Kompetensi ini berisi tentang kompetensi yang di gunakan dalam menyusun media pembelajaran pocket of ceramic",
//            "pada menu Materi ini berisi materi berdasarkan kompetensi yang sudah dipaparkan pada menu kompetensi",
//            "pada menu Latihan ini berisi soal soal untuk mengasah tingkat pemahaman terhadap materi yang sudah dibaca di aplikasi pocket of ceramic",
//            "pada menu Tentang ini berisi tentang Biodata penguji Aplikasi pocket of ceramic",
//            "pada menu Credit ini berisi tentang daftar pustaka sumber acuan materi apllikasi pocket of ceramic"
//    };


    @Override
    public int getCount() {
        return imagecara.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (RelativeLayout) object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slidecontent_cara,container,false);

//        TextView tvdeskripsi = view.findViewById(R.id.isiCara);
        ImageView ivcara = view.findViewById(R.id.ivCara);
//        TextView tvjudul = view.findViewById(R.id.judulCara);

//        tvdeskripsi.setText(deskripsi[position]);
        ivcara.setImageResource(imagecara[position]);
        ivcara.setScaleType(ImageView.ScaleType.FIT_XY);
//        tvjudul.setText(judul[position]);
//        Log.i("teks: ",deskripsi[position]);

        container.addView(view);
        return view;

//        mDots = new TextView[6];
//        LinearLayout mLinearLayout = view.findViewById(R.id.linearLayoutdot);
//
//        for (int i=0;i<mDots.length;i++){
//            mDots[i]=new TextView();
//            mDots[i].setText(Html.fromHtml("&#8226"));
//            if (position==i){
//                mDots[i].setTextSize(35);
//                mDots[i].setTextColor(container.getResources().getColor(R.color.colorTransparentWhite));
//            }else {
//                mDots[i].setTextSize(30);
//                mDots[i].setTextColor(container.getResources().getColor(R.color.colorTransparentWhite));
//            }
//            mLinearLayout.addView(mDots[i]);
//        }



    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout)object);

    }
}

