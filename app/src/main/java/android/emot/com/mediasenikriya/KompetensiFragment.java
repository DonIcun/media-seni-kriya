package android.emot.com.mediasenikriya;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.pixplicity.htmlcompat.HtmlCompat;

/**
 * Created by Windows 8.1 on 29/03/2019.
 */

public class KompetensiFragment extends Fragment {

    WebView isikompetensi;
    ProgressBar progressBar;
    String tekskompetensi;
    TextView tvJudulKompetensi;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_kompetensi,container,false);
        isikompetensi = view.findViewById(R.id.isikompetensi);
        progressBar = view.findViewById(R.id.progressBarKompetensi);
        progressBar.setMax(100);

        //tekskompetensi = getContext().getResources().getString(R.string.isitekskompetensi);
        /*tekskompetensi="\b1. Kompetensi</b>\n" +
                "Kompetensi yang diharapkan dari  penggunan aplikasi ini adalah pengguna mampu memahami pengetahuan mengenai kerajinan keramik dari jenis, sifat, karakter, alat pembuatan hingga teknik pengolahanya.\n\n" +
                "<b>2.\tKompetensi Inti</b>\n" +
                "\ta) Menghayati dan mengamalkan ajaran agama yang dianutnya.\n" +
                "\tb)\tMenghayati dan mengamalkan perilaku jujur, disiplin, santun, peduli (gotong royong, kerja sama, toleran, damai), bertanggung-jawab, responsif, dan proaktif melalui keteladanan, pemberian nasihat, penguatan, pembiasaan, dan pengkondisian secara berkesinambungan serta menunjukkan sikap sebagai bagian dari solusi atas berbagai permasalahan dalam berinteraksi secara efektif dengan lingkungan sosial dan alam serta dalam menempatkan diri sebagai cerminan bangsa dalam pergaulan dunia”\n" +
                "\tc)\tMemahami, menerapkan, menganalisis pengetahuan faktual, konseptual, procedural berdasarkan rasa ingin tahunya tentang ilmu pengetahuan, teknologi, seni, budaya, dan humaniora dengan wawasan kemanusiaan, kebangsaan, kenegaraan, dan peradaban terkait penyebab fenomena dan kejadian, serta menerapkan pengetahuan prosedural pada bidang kajian yang spesifik sesuai dengan bakat dan minatnya untuk memecahkan masalah\n" +
                "\td)\tMengolah, menalar, dan menyaji dalam ranah konkret dan ranah abstrak terkait dengan pengembangan dari yang dipelajarinya di sekolah secara mandiri, dan mampu menggunakanmetode sesuai kaidah keilmuan\n\n" +
                "<b>3.\tKompetensi Dasar</b>\n" +
                "\ta)\tMemahami pengetahuan tentang jenis, sifat, karakter dan teknik pengolahan bahan lunak (tanah liat, getah, lilin, clay polimer, clay tepung, plastisin, parafin, gips dan lain-lain)\n";
*/
        Typeface tfjudul = Typeface.createFromAsset(getActivity().getAssets(),"fonts/TrajanPro-Bold.otf");

        tvJudulKompetensi = view.findViewById(R.id.judulteksKompetensi);
        tvJudulKompetensi.setTypeface(tfjudul);
        tvJudulKompetensi.setTextColor(getResources().getColor(R.color.colorBlack));


        //isikompetensi.loadDataWithBaseURL(null,tekskompetensi,"teks/html","utf-8",null);
        isikompetensi.loadUrl("file:///android_asset/kompetensi.html");
        isikompetensi.getSettings().setJavaScriptEnabled(true);
        isikompetensi.setWebViewClient(new WebViewClient());

        isikompetensi.setWebChromeClient(new WebChromeClient(){
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
        return view;
        
    }
}
