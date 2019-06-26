package android.emot.com.mediasenikriya;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;/**
 * Created by Windows 8.1 on 28/03/2019.
 */

public class splashActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // langsung pindah ke MainActivity atau activity lain
        // begitu memasuki splash screen ini
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
