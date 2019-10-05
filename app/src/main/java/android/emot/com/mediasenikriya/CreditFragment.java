package android.emot.com.mediasenikriya;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Bundle;
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

/**
 * Created by Windows 8.1 on 29/03/2019.
 */

public class CreditFragment extends Fragment {
    //TextView isicredit;
    WebView isicredit;
//    ProgressBar progressBar;
    String crediteks;
    TextView tvJudulKredit;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_credit,container,false);

        isicredit = view.findViewById(R.id.webviewCredit);
        tvJudulKredit = view.findViewById(R.id.judultekscredit);
//        progressBar = view.findViewById(R.id.progressBarCredit);
//        progressBar.setMax(100);
        //crediteks =getContext().getResources().getString(R.string.creditbuku) ;

       // Spanned spankrediteks = Html.fromHtml(crediteks);
/*        crediteks = "1.Sumber Buku\n" +
                "•\tWahyu Gatot Budiyanto. (2008). Kriya Keramik Untuk SMK Jilid 1. Jakarta: Direktorat Pembinaan Sekolah Menengah Kejuruan\n" +
                "•\tWahyu Gatot Budiyanto. (2008). Kriya Keramik Untuk SMK Jilid 2. Jakarta: Direktorat Pembinaan Sekolah Menengah Kejuruan\n" +
                "\n2.Sumber Gambar\n" +
                "\n3.Sumber Video\n";*/

        Typeface tfjudul = Typeface.createFromAsset(getActivity().getAssets(),"fonts/TrajanPro-Bold.otf");
        tvJudulKredit.setTypeface(tfjudul);
        tvJudulKredit.setTextColor(getResources().getColor(R.color.colorBlack));

       // isicredit.loadDataWithBaseURL(null,crediteks,"teks/html","utf-8",null);
        isicredit.loadUrl("file:///android_asset/credit.html");
        isicredit.getSettings().setJavaScriptEnabled(true);
        isicredit.setWebViewClient(new WebViewClient());
//        isicredit.setWebChromeClient(new WebChromeClient(){
//            @Override
//            public void onProgressChanged(WebView view, int newProgress) {
//                super.onProgressChanged(view, newProgress);
//                progressBar.setProgress(newProgress);
//            }
//
//            @Override
//            public void onReceivedTitle(WebView view, String title) {
//                super.onReceivedTitle(view, title);
//            }
//
//            @Override
//            public void onReceivedIcon(WebView view, Bitmap icon) {
//                super.onReceivedIcon(view, icon);
//            }
//        });

        return view;
        
    }
}