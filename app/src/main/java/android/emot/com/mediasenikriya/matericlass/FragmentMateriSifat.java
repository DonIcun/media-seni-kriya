package android.emot.com.mediasenikriya.matericlass;

import android.emot.com.mediasenikriya.R;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Windows 8.1 on 15/04/2019.
 */

public class FragmentMateriSifat extends Fragment {

    WebView webView;
//    ProgressBar progressBar;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_materi_c1, container, false);

        webView = view.findViewById(R.id.webviewmateriConten1);
        //    progressBar = view.findViewById(R.id.progressBarmateric1);
        //      progressBar.setMax(100);

        WebSettings webSettings = webView.getSettings();
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(true);
        webSettings.setSupportZoom(true);
        webSettings.setJavaScriptEnabled(true);

        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("file:///android_asset/materisifat.html");

//        webView.setWebChromeClient(new WebChromeClient(){
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
