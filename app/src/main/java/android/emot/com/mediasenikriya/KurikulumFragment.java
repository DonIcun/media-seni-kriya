package android.emot.com.mediasenikriya;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Windows 8.1 on 29/03/2019.
 */

public class KurikulumFragment extends Fragment {

    WebView isikurikulum;
    ProgressBar progressBar;
    String teksKurikulum;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_kurikulum, container, false);

       isikurikulum = view.findViewById(R.id.webviewKuriklum);
       progressBar = view.findViewById(R.id.progressBarKurikulum);
       progressBar.setMax(100);

/*        teksKurikulum = "\tDalam prespektif kebijakan pendidikan nasional sebagaimana dilihat dalam Undang-Undang Sistem Pendidikan " +
                "Nasional No.20 Tahun 2003 menyatakan bahwa: “Kurikulum adalah seperangkat rencana dan pengaturan mengenai tujuan, isi, dan bahan pelajaran serta cara yang digunakan sebagai pedoman penyelenggaran pembelajaran untuk mencapai tujuan pendidikan tertentu”." +
                "\n\tKurikulum 2013 ada karena ada sebuah kegelisahan dalam sistem pendidikan yang diterapkan yang hanya berbasis pada pemenuhan pengetahuan siswa. Kurikulum 2013 memadukan  tiga konsep yang menyeimbangkan sikap, pengetahuan, dan keterampilan. Kurikulum 2013 menenkankan pada dimensi pedagogik modern dalam pembelajaran, yaitu menggunakan pendekatan ilmiah (scientific approach) dalam pembelajaran sebagaimana dimaksud meliputi  mengamati, menalar, mencoba, dan membentuk jaring-jaring untuk semua pembelajaraan.\n";


        isikurikulum.setText(teksKurikulum);
        Typeface typeface = Typeface.createFromAsset(getContext().getApplicationContext().getAssets(),"fonts/TrajanPro-Regular");
        isikurikulum.setTypeface(typeface);*/

//       teksKurikulum = getContext().getResources().getString(R.string.isitekskurikulum);
//        isikurikulum.loadDataWithBaseURL(null,teksKurikulum,"teks/html","utf-8",null);
        isikurikulum.loadUrl("file:///android_asset/kurikulum.html");
        isikurikulum.getSettings().setJavaScriptEnabled(true);
        isikurikulum.setWebViewClient(new WebViewClient());

        isikurikulum.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                progressBar.setProgress(newProgress);
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
            }

            @Override
            public void onReceivedIcon(WebView view, Bitmap icon) {
                super.onReceivedIcon(view, icon);
            }
        });




        /*       Spanned spannedhtml= Html.fromHtml(teksKurikulum);
        isikurikulum.setText(spannedhtml);*/


        return view;
    }



    /*
    public void setText(String text ) {
        TextView mJudulteks = getView().findViewById(R.id.isiteksKurikulum);
        mJudulteks.setText(text);
    }
    */
}
