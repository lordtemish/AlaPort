package com.dynamica.alaport;

import com.dynamica.alaport.Fragment.VipFragment;

import java.lang.Integer;

import android.Manifest;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.StrictMode;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;

import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.dynamica.alaport.R;
import com.dynamica.alaport.dummy.AppStatus;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity{
    public long timmillis=0;
    public long timmillis2=0;
    Menu menu;
    int top=0;
    ArrayList<Fragment> topFs;
    ArrayList<Integer> tops;
    int pagenum=0;
    DrawerLayout drawerLayout;
    LinearLayout drL;
    Fragment frfr;
    TextView close;
    String clos;
    MenuItem menuitem;
    public Date date;
    public String arrivals=" ";
    public String departures=" ";
    public String longDeps=" ";
    public String longArrs=" ";
    public boolean arrtrue=true;
    private final Handler handler=new Handler();
    public static final String EXTRA_DRINKNO = "drinkNo";
    private Toolbar TB;
    public String lang="";
    public Thread thread;
    Practice ccc,cc1,ccc1,ccc2,ccc3;
    Fragment fragment;


    private String[] titles;
    private int[] logos={
            R.drawable.laneon,
            R.drawable.clocks,
            R.drawable.bel1l,
            R.drawable.diamond,
            R.drawable.ticket,
            R.drawable.plan,
            R.drawable.alapo,
            R.drawable.healthy,
            R.drawable.sett,

    };
    private ListView drawerList;

    public String getArrivals(){
        return arrivals;
    }

    public void arrtrue(View view){
        if(view.getId()==R.id.deps){

        }
        else if(view.getId()==R.id.arrs){

        }
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view,int position, long id){
            selectItem(position);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu);
        this.menu=menu;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        menuitem=item;
        switch(item.getItemId()){
            case R.id.action_create_order:
                ClickDr();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void setActionBarTitle(int position) {
        String title;
        if (position == 0){
            title = getResources().getString(R.string.app_name);
        } else {
            title = titles[position];
        }
        System.out.println(title);

    }

    private void selectItem(int position){
        MailController mc=new MailController();
        fragment=new Fragment();
        top=position;
        switch(position) {
            case 1:
                fragment = new RaspFragment();

                String stt;
                if(AppStatus.getInstance(MainActivity.this).isOnline()){
                    stt="Yeah";
                }
                else{
                    switch (lang) {
                        case "E":
                            stt = "No Internet Connection";
                            break;
                        case "K":
                            stt="Ғаламтор жоқ";
                            break;
                        default:
                            stt="Нет подключения к интернету";
                    }
                    Toast toast=Toast.makeText(this,stt,Toast.LENGTH_LONG);

                    toast.show();
                }


                break;
            case 2:
                fragment = new NotificationFragment();
                //HttpReq httpReq=new HttpReq("http://www.alaport.com/getdb.php?t=arr");                String s= httpReq.make();

                // mc.sendMessage("lordtemich@gmail.com","FUCK","Suc0k");
                break;
            case 3:
                fragment = new VipFragment();
                break;
            case 4:
                fragment=new AviaCashFragment();
                break;
            case 5:
                fragment=new MapFragment();
                break;
            case 6:
                fragment=new AlaportFragment();
                break;
            case 7:
                fragment=new HealthyFragment();
                break;
            case 8:
                fragment=new SettingsFragment();
                break;
            default:
                top=0;
                fragment =(Fragment) new TopFragment();
                String st1;
                if(AppStatus.getInstance(MainActivity.this).isOnline()){
                    st1="Yeah";
                }
                else{
                    switch (lang) {
                        case "E":
                            stt = "No Internet Connection";
                            break;
                        case "K":
                            stt="Ғаламтор жоқ";
                            break;
                        default:
                            stt="Нет подключения к интернету";
                    }
                    Toast toast=Toast.makeText(this,stt,Toast.LENGTH_LONG);
                    toast.show();
                }

                break;

        }
        //frfr.onDestroyView();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame,fragment);
        ft.addToBackStack((pagenum++)+"");
        frfr=fragment;
        tops.add(position);
        topFs.add(frfr);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
        setActionBarTitle(position);


        drawerLayout.closeDrawer(drL);
    }
    public void CloseDr(View view){
        LinearLayout drL=(LinearLayout) findViewById(R.id.drawerLayout);
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawerl);
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(drL);

        }
        else{
            drawerLayout.openDrawer(drL);

        }
    }
    public void ClickDr(){
        LinearLayout drL=(LinearLayout) findViewById(R.id.drawerLayout);
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawerl);
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(drL);

        }
        else{
            drawerLayout.openDrawer(drL);

        }
    }
    private void doTheAutoRefresh() {

        SQLiteOpenHelper AlaportDataHelper = new AlaportDatabaseHelper(getApplicationContext());
        SQLiteDatabase db = AlaportDataHelper.getReadableDatabase();
        Cursor cursor = db.query("user", new String[]{"LANGUAGE"}, "_id = ?", new String[] {Integer.toString(1)},null,null,null);
        if(cursor.moveToFirst()){
            String lan=cursor.getString(0);
            lang=lan;
            drawerList.setAdapter(
                    ChangeLanguage(lang));
            //Log.d("lang",lang);
        }
        cursor.close();
        db.close();
        doTheAutoRefresh();
    }
    public void DrawerChange(String s){
        drawerList.setAdapter(ChangeLanguage(s));
    }
    public CustomList ChangeLanguage(String s){
        this.lang=s;
        if(s.equals("R")){
            clos="Закрыть";
            titles=getResources().getStringArray(R.array.titles);
        }
        else if(s.equals("K")){
            clos="Жабу";
            titles=getResources().getStringArray(R.array.titleskaz);
        }
        else{
            clos="Close";
            titles=getResources().getStringArray(R.array.titleseng);
        } ccc = new Practice("http://www.alaport.com/getdb.php?t=arr");
        cc1= new Practice("http://www.alaport.com/getdb.php?t=dep");
        close.setText(clos);
        return new CustomList(MainActivity.this,titles,logos);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState){
        ccc = new Practice("http://www.alaport.com/getdb.php?t=arr");
        cc1= new Practice("http://www.alaport.com/getdb.php?t=dep");
        ccc1=new Practice("http://www.alaport.com/year_xml_eng.php?t=arr");
        ccc2=new Practice("http://www.alaport.com/year_xml_eng.php?t=dep");

        //startT();
        this.date=new Date();
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        //doTheAutoRefresh();
        tops=new ArrayList<>();
        topFs=new ArrayList<>();
        super.onCreate(savedInstanceState);
        titles=getResources().getStringArray(R.array.titles);
//        int drinkNo=(Integer) getIntent().getExtras().get(EXTRA_DRINKNO);
        try {
            SQLiteOpenHelper AlaportDataHelper = new AlaportDatabaseHelper(this);
            SQLiteDatabase db = AlaportDataHelper.getReadableDatabase();
            Cursor cursor = db.query("user", new String[]{"LANGUAGE"}, "_id = ?", new String[] {Integer.toString(1)},null,null,null);
            if(cursor.moveToFirst()){
                String lang=cursor.getString(0);
                this.lang=lang;

            }
            cursor.close();
            db.close();
        }
        catch (SQLException e){
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
        }
        if(this.lang.equals("R")){
            clos="Закрыть";
            titles=getResources().getStringArray(R.array.titles);
        }
        else if(this.lang.equals("K")){
            clos="Жабу";
            titles=getResources().getStringArray(R.array.titleskaz);
        }
        else{
            clos="Close";
            titles=getResources().getStringArray(R.array.titleseng);
        }

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        frfr=new TopFragment();
        ft.replace(R.id.content_frame,frfr);
        ft.addToBackStack((pagenum++)+"").commit();
        tops.add(0);
        topFs.add(frfr);
        boolean fvar=AppStatus.isFirst(this);

        //fvar=true;
        if(fvar){
            Intent start_int=new Intent(MainActivity.this,StartActivity.class);
            Intent start_int1=new Intent(MainActivity.this,Lang.class);
            setContentView(R.layout.activity_main);
            startActivity(start_int1);
            startActivity(start_int);
        }
        else {
            setContentView(R.layout.activity_main);
            //startActivity(start_int);
            System.out.println("SHIT");
        }
        drL=(LinearLayout) findViewById(R.id.drawerLayout);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerl);
        TextView dynamica= (TextView) findViewById(R.id.dynamica);
        dynamica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startDynInt();
            }
        });
        close=(TextView) findViewById(R.id.textView7);
        close.setText(clos);
        drawerList = (ListView) findViewById(R.id.drawer);
        drawerList.setAdapter(new CustomList(MainActivity.this, titles, logos));
        drawerList.setOnItemClickListener(new DrawerItemClickListener());

    }
    public void no(View view){
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
    }
    @Override
    protected void onResume() {
        super.onResume();
        SQLiteOpenHelper AlaportDataHelper = new AlaportDatabaseHelper(getApplicationContext());
        SQLiteDatabase db = AlaportDataHelper.getReadableDatabase();
        Cursor cursor = db.query("user", new String[]{"LANGUAGE"}, "_id = ?", new String[] {Integer.toString(1)},null,null,null);
        if(cursor.moveToFirst()){
            String lan=cursor.getString(0);
            lang=lan;
            drawerList.setAdapter(ChangeLanguage(lang));
        }
        cursor.close();
        db.close();
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
    }

    public void onCall(String s) {
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);

        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    123);
        } else {
            startActivity(new Intent(Intent.ACTION_CALL).setData(Uri.parse("tel:"+s)));
        }
    }

    public void sendNotification(String s, String b){
        NotificationCompat.Builder mBuilder=new NotificationCompat.Builder(this).setSmallIcon(R.drawable.planarrival).setContentTitle(s).setContentText(b);
        NotificationManager notificationManager=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        //notificationManager.notify(001,mBuilder.build());
    }

    public class getXml3 extends AsyncTask<Practice,Integer, String> {
        protected String doInBackground(Practice... practices) {
            try {
                int count = practices.length;
                return practices[0].getXml();
            } catch (Exception e) {e.printStackTrace();return "";}}
        protected void onProgressUpdate(Integer... ints){}
        protected void onPostExecute(String result){if(result.length()>0){longArrs=result;} else{}}
    }
    public class getXml4 extends AsyncTask<Practice,Integer, String> {
        protected String doInBackground(Practice... practices) {
            try {
                int count = practices.length;
                return practices[0].getXml();
            } catch (Exception e) {e.printStackTrace();return "";}}
        protected void onProgressUpdate(Integer... ints){}
        protected void onPostExecute(String result){if(result.length()>0){longDeps=result;} else{}}
    }
    public void setArrivals(String s) {arrivals = s;}
    public void setDepartures(String s) {departures = s;}
    public void setLongArrs(String s) {longArrs = s;}
    public void setLongDeps(String s) {longDeps = s;}
    public void startT(){
        if(AppStatus.getInstance((MainActivity)this).isOnline()) {
            try {
                timmillis = Calendar.getInstance().getTimeInMillis();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            // Toast.makeText(this,conn,Toast.LENGTH_SHORT).show();
        }
    }
    public void rasp(){
        if(AppStatus.getInstance((MainActivity)this).isOnline()) {
            try {
                timmillis2 = Calendar.getInstance().getTimeInMillis();


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            //   Toast.makeText(this,"Подключитесь к интернету",Toast.LENGTH_SHORT).show();
        }
    }
    public void Back(){
        int index = tops.size()-1;
        if(index>0) {
            tops.remove(index);
            top=tops.get(index-1);
            topFs.remove(index--);
            frfr=topFs.get(index);
            if(top<=1){
                switch (top){
                    case 0:
                        frfr=new TopFragment();
                        break;
                    case 1:
                        frfr=new RaspFragment();
                        break;
                }
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, frfr).commit();
        }
        else{
            Intent startMain = new Intent(Intent.ACTION_MAIN);
            startMain.addCategory(Intent.CATEGORY_HOME);
            startActivity(startMain);
        }
    }
    @Override
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(drL);
        }
        else {
            if (top == 0) {
                ((TopFragment) frfr).topClear();
            } else if (top == 1) {
                ((RaspFragment) frfr).removeAll();
                try {
                    ((RaspFragment) frfr).removeChoose();
                }
                catch (ClassCastException e){
                    e.printStackTrace();
                }
            }
            else if(top==3){
                ((VipFragment)frfr).Back();
            }
            else if (top == 5) {
                ((MapFragment) frfr).Back();
            }
            else{
                Back();
            }
        }
    }
    public void refreshL(){
        if(top==0){
            top=0;
            frfr=new TopFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,frfr).commit();
            topFs.set(topFs.size()-1,frfr);
        }
        else {
            top=1;
            frfr=new RaspFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,frfr).commit();
            topFs.set(topFs.size()-1,frfr);
        }
    }
    public void startIntent(Intent intent){
        startActivity(intent);
    }
    public void startDynInt(){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.dynamica.kz"));
        startActivity(intent);
    }
}