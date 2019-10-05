package android.emot.com.mediasenikriya;

import android.content.DialogInterface;
import android.emot.com.mediasenikriya.matericlass.FragmentMateriJenis;
import android.emot.com.mediasenikriya.matericlass.FragmentMateriPengertian;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawer;
//    private static final int MENU_ITEM = 7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);

        final Typeface tftrajan = Typeface.createFromAsset(getAssets(),"fonts/comicbd.ttf");


        // immersive buat hide statusbar dan navbar
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
//                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);

        drawer = (DrawerLayout) findViewById(R.id.activity_drawer);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        final NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view1);
        navigationView.setNavigationItemSelectedListener(this);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,
                    new MainFragment()).commit();
        }

        View headerview = navigationView.getHeaderView(0);
        TextView textView4 = headerview.findViewById(R.id.textView4);
        TextView textViewauthor = headerview.findViewById(R.id.textViewauthor);
        textView4.setTypeface(tftrajan);
        textView4.setTextSize(21);
        textView4.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_END);
        textViewauthor.setTypeface(tftrajan);
        textViewauthor.setTextSize(14);

        for (int i = 0;i<toolbar.getChildCount();i++){
            View view = toolbar.getChildAt(i);
                if (view instanceof TextView){
                    TextView textViewtoolbar = (TextView) view;
                    textViewtoolbar.setTypeface(tftrajan);
                }
        }

//        final Menu navmenu =  navigationView.getMenu();
//
//        navigationView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
//            @Override
//            public void onGlobalLayout() {
//                ArrayList<View> menuItems = new ArrayList<View>();
//                navigationView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
//                for (int i=0 ; i < navmenu.size() ; i++){
////                    final String id = "menuItem"+i;
////                    final MenuItem item = navmenu.findItem(getResources().getIdentifier(id,"id",getPackageName()));
//                    final MenuItem item = navmenu.getItem(i);
//                    navigationView.findViewsWithText(menuItems,item.getTitle(),View.FIND_VIEWS_WITH_TEXT);
//                }
//                for (final View menuItem : menuItems){
//                    ((TextView) menuItem).setTypeface(tftrajan,Typeface.NORMAL);
//                }
//            }
//        });

    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if(getSupportFragmentManager().getBackStackEntryCount() == 0) {
                exitAps();
        }else{
            getSupportFragmentManager().popBackStack();
        }
    }


    public void exitAps(){
        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle    ("keluar");
        builder.setMessage("apakah anda ingin keluar dari aplikasi ini?");
        builder.setPositiveButton("YA", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        builder.setNegativeButton("TIDAK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);

       switch (item.getItemId()){
           case R.id.menuItem1:
               getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,
                       new KurikulumFragment()).commit();
               break;
           case R.id.menuItem2:
               getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,
                       new KompetensiFragment()).commit();
               break;
           case R.id.menuItem3:
               getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,
                       new MateriFragment()).commit();
               break;
           case R.id.menuItem4:
               getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,
                       new SoalFragment()).commit();
               break;
           case R.id.menuItem5:
               getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,
                       new TentangFragment()).commit();
               break;
           case R.id.menuItem6:
               getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,
                       new CreditFragment()).commit();
               break;
           case R.id.menuItem7:
               exitAps();
               break;
       }
       //nek eror dihapus
//        FragmentManager.BackStackEntry first = getSupportFragmentManager().getBackStackEntryAt(0);
//        getSupportFragmentManager().popBackStack(first.getId(), FragmentManager.POP_BACK_STACK_INCLUSIVE);

       drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void enableDisableDrawer(int mode) {
        if (drawer != null) {
            drawer.setDrawerLockMode(mode);
        }
    }
}
