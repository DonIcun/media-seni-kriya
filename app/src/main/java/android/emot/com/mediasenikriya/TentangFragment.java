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

public class TentangFragment extends Fragment {
 //   TextView isitentang;
    WebView isitentang;
    ProgressBar progressBar;
    String tentangteks;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tentang,container,false);

        isitentang = view.findViewById(R.id.webviewtentang);
        progressBar = view.findViewById(R.id.progressBarTentang);
        progressBar.setMax(100);
//        Typeface type = Typeface.createFromAsset (getActivity().getAssets(),"fonts/TrajanPro-Bold.otf");
//
//
//        String teks = "<html>" +
//        "<style type='text/css'>" +
//        "@font-face { font-family: MyFont; src: url('fonts/TrajanPro-Bold.otf'); }" +
//         "body p {font-family: spqr;}"+
//         "</style>"+
//         "<body >" +
//         "<p align=\"justify\" style=\"font-size: 22px; font-family: spqr;\">" +
//         getString(R.string.app_name) + "</p> "+ "</body></html>";

//        tentangteks =getContext().getResources().getString(R.string.isitentang) ;
//        Spanned spantekstentang = Html.fromHtml(tentangteks);

//       isitentang.loadDataWithBaseURL("file:///android_asset/tentang.html",teks,"teks/html","utf-8",null);
        isitentang.loadUrl("file:///android_asset/tentang.html");
        isitentang.getSettings().setJavaScriptEnabled(true);
        isitentang.setWebViewClient(new WebViewClient());

        isitentang.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                progressBar.setProgress(newProgress);
//                progressBar.setVisibility(View.INVISIBLE);
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


        return view;
        
    }
}
