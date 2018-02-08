package com.dynamica.alaport;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dynamica.alaport.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

public class TicketActivity extends AppCompatActivity {
    View.OnClickListener a,b;
    boolean not;
    Intent intent;
    public String dep, depT, arrT;
    public String lang;
    public String aln, fromC;
    String sts_name,tran_n,check_n,datetime_n,race_n,type_vs,sch_n,timeArr,timeDep,timeIn, uAsked, itWas,uAdd, notif, sucead,flighttime, ft, bef30,bef60;
    String est,com,bNow,bHalf,bHour;
    public String checkin;
    public String datetime;
    public String flt;
    public String sts;
    public String vs;
    TextView weathertemp;
    ImageView weatherimage;
    TextView schText;
    TextView alnText;
    TextView stsText;
    TextView tocity;
    TextView fromcity;
    TextView fromtime;
    TextView totime;
    TextView arrText;
    TextView FlightTText;
    TextView Flighttime;
    FragmentManager fm;
    TextView regis;
    TextView dateTime;
    TextView fltNumber;
    TextView typeVs;
    TextView planDate;
    RelativeLayout relAll;
    RelativeLayout arrs;
    RelativeLayout arrs1;
    RelativeLayout arrs2;
    RelativeLayout relA;
    ImageView plane;
    ImageView circle;
    ImageView bell;
    TextView butt, butt1, butt3;
    public class getWeather extends AsyncTask<String,Integer, ArrayList<String>> {
        protected ArrayList<String> doInBackground(String... strings) {
            /*try{
                    Parser parser=new Parser();
                    ArrayList<String> ar=parser.ar("R",strings[0]);
                return ar;
            }
            catch (Exception e){
                e.printStackTrace();
                return new ArrayList<>();
            }*/
            return new ArrayList<>();
        }

        @Override
        protected void onPostExecute(ArrayList<String> strings) {
            weathertemp.setText("");
            weatherimage.setImageDrawable(null);
            ((ImageView) findViewById(R.id.celsiu)).setImageDrawable(null);
          //  Log.d("size",strings.size()+"");
         /*   if(strings.size()>0){
                ((TextView) findViewById(R.id.weathertemp)).setText(strings.get(0));
                Log.d("Weather type",strings.get(1));
                if(strings.get(1).contains("thunderstorm")){
                    weatherimage.setImageResource(R.drawable.flash_rainig);
                }
                if(strings.get(1).contains("rain")){
                    weatherimage.setImageResource(R.drawable.raining);
                }
                if(strings.get(1).contains("drizzle")){
                    weatherimage.setImageResource(R.drawable.raining);
                }
                switch (strings.get(1)){
                    case "clear sky":
                        weatherimage.setImageResource(R.drawable.sunny);
                        break;
                    case "few clouds":
                        weatherimage.setImageResource(R.drawable.cloudy);
                        break;
                    case "scattered clouds":
                        weatherimage.setImageResource(R.drawable.mainly_cloudy);
                        break;
                    case "broken clouds":
                        weatherimage.setImageResource(R.drawable.mainly_cloudy);
                        break;
                    case "overcast clouds":
                        weatherimage.setImageResource(R.drawable.mainly_cloudy);
                        break;
                    case "freezing rain":
                        weatherimage.setImageResource(R.drawable.raining);
                        break;
                    case "light intensity shower rain":
                        weatherimage.setImageResource(R.drawable.raining);
                        break;
                    case "heavy intensity shower rain":
                        weatherimage.setImageResource(R.drawable.raining);
                        break;
                    case "ragged shower rain":
                        weatherimage.setImageResource(R.drawable.raining);
                        break;
                    case "rain":
                        weatherimage.setImageResource(R.drawable.sun_rainig);
                        break;
                    case "light rain":
                        weatherimage.setImageResource(R.drawable.sun_rainig);
                        break;
                    case "moderate rain":
                        weatherimage.setImageResource(R.drawable.sun_rainig);
                        break;
                    case "heavy intensity rain":
                        weatherimage.setImageResource(R.drawable.sun_rainig);
                        break;
                    case "very heavy rain":
                        weatherimage.setImageResource(R.drawable.sun_rainig);
                        break;
                    case "extreme rain":
                        weatherimage.setImageResource(R.drawable.sun_rainig);
                        break;
                    case "thunderstorm":
                        weatherimage.setImageResource(R.drawable.flash_rainig);
                        break;
                    case "snow":
                        weatherimage.setImageResource(R.drawable.snow);
                        break;
                    case "light snow":
                        weatherimage.setImageResource(R.drawable.snow);
                        break;
                    case "heavy snow":
                        weatherimage.setImageResource(R.drawable.snow);
                        break;
                    case "sleet":
                        weatherimage.setImageResource(R.drawable.snow);
                        break;
                    case "shower sleet":
                        weatherimage.setImageResource(R.drawable.snow);
                        break;
                    case "light rain and snow":
                        weatherimage.setImageResource(R.drawable.snow);
                        break;
                    case "rain and snow":
                        weatherimage.setImageResource(R.drawable.snow);
                        break;
                    case "light shower snow":
                        weatherimage.setImageResource(R.drawable.snow);
                        break;
                    case "shower snow":
                        weatherimage.setImageResource(R.drawable.snow);
                        break;
                    case "heavy shower snow":
                        weatherimage.setImageResource(R.drawable.snow);
                        break;
                    case "mist":

                        break;
                }
            }*/
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }
    }
    public void ScheduleNotification(Notification  notification, long delay, int id){
        Intent notifIntent;
        notifIntent=new Intent(this, NotificationPublisher.class);
        notifIntent.putExtra(NotificationPublisher.NOTIFICATION_ID,id);
        notifIntent.putExtra(NotificationPublisher.NOTIFICATION,notification);
        notifIntent.putExtra("key", "clicked");
        /*TaskStackBuilder tsb=TaskStackBuilder.create(this);
        tsb.addParentStack(MainActivity.class);
        tsb.addNextIntent(notifIntent);
        PendingIntent pendingIntent=tsb.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);*/
        PendingIntent pendingIntent=PendingIntent.getBroadcast(this,id,notifIntent,PendingIntent.FLAG_UPDATE_CURRENT);
        long futureTimeMil= SystemClock.elapsedRealtime() + delay;
        AlarmManager alarmManager=(AlarmManager) getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,futureTimeMil,pendingIntent);
    }

    public int onNotification(int bef, long t){
        SQLiteOpenHelper AlaportDataHelper = new AlaportDatabaseHelper(getApplicationContext());
        SQLiteDatabase db = AlaportDataHelper.getReadableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("ID",flt);
        cv.put("CITY",tocity.getText()+"");
        cv.put("TIME",fromtime.getText()+"");
        cv.put("DATE",datetime.substring(0,10));
        cv.put("BEFORE",bef);
        cv.put("TIMEMILL",t+"");
        if(dep.equals("dep")){
            cv.put("DEPS","deps");
        }
        else{
            cv.put("DEPS","arrs");
        }
        db.insert("notification","",cv);
        Cursor cursor=db.rawQuery("SELECT _id FROM notification WHERE ID='"+flt+"';",null);
        int i=1;
        if(cursor.moveToFirst()){
            i=cursor.getInt(0);
        }
        db.close();
        return i;
    }
    private Notification getNotification(String tit,String content) {
        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentTitle(tit);
        builder.setContentText(content);
        builder.setSmallIcon(R.drawable.ggg);
        Notification notification=builder.build();
        notification.defaults |=Notification.DEFAULT_SOUND;
        notification.defaults|= Notification.DEFAULT_LIGHTS;
        notification.defaults|= Notification.DEFAULT_VIBRATE;
        notification.flags |= Notification.FLAG_AUTO_CANCEL;
        return notification;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);
        fm=getSupportFragmentManager();
        intent=getIntent();
        lang=intent.getStringExtra("lang");
        dep=intent.getStringExtra("dep");
        String eng=intent.getStringExtra("cityeng");
        Practice practice=new Practice("");
        weatherimage=(ImageView) findViewById(R.id.weatherimage);
        weathertemp=(TextView) findViewById(R.id.weathertemp);
        weathertemp.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/Avenir-Black.ttf"));
        try {
            ((LinearLayout) findViewById(R.id.weatherlin)).removeAllViews();
            /*if(!dep.equals("dep"))
             new getWeather().execute(practice.weatherXml(eng));
            else{
                Log.d("Ticket","else");
                ((LinearLayout) findViewById(R.id.weatherlin)).removeAllViews();
            }*/
        }
        catch (Exception e){
            e.printStackTrace();
        }
        switch (lang){
            case "E":
                fromC="ALMATY";
                bef30="After 30 minutes, ";
                bef60="After 1 hour, ";
                    sts_name="Status";
                    tran_n="Airline";
                    if(dep.equals("dep")) {
                        check_n = "Check in";
                        datetime_n = "Gate";
                    }
                    else{
                        check_n="Actual time";
                        datetime_n="Estimated time ";
                    }
                    race_n="Flight number";
                    type_vs="Aircraft type";
                    sch_n="Schedule time";
                    timeArr="Arrives";
                    timeDep="Departs";
                bNow="In fact";
                bHalf="30 minutes before";
                bHour="1 hour before";
                flighttime="Flight time";
                uAsked="You have already added this notification";
                itWas="The time you chose has already passed";
                notif="Notification ";
                sucead=" successfully added";
                uAdd="You have already added this notification";
                depT="Departure";
                arrT="Arrival";
                    timeIn="";
                break;
            case "K":
                fromC="АЛМАТЫ";
                sts_name="Статус";
                tran_n="Авиакомпания";
                if(dep.equals("dep")) {
                    check_n = "Тіркеу";
                    datetime_n = "Ұшып шығу";
                }
                else{
                    check_n="Нақты уақыты";
                    datetime_n="Күтілетін уақыты";
                }
                race_n="Рейс нөмірі";
                bef30="30 минуттан кейін, ";
                bef60="1 сағаттан кейін, ";
                type_vs="Әуе кемесі";
                sch_n="Жоспарлы";
                timeArr="Ұшып келу уақыты";
                timeDep="Ұшып кету уақыты";
                bNow="Қазіргі уақытта";
                bHour="1 сағат бұрын";
                bHalf="30 минут бұрын";
                depT="Ұшып кету";
                arrT="Ұшып келу";
                uAsked="Сіз хабарламаны әлі қостыңыз";
                flighttime="Ұшу уақыты";
                itWas="Уақыт өтті";
                notif="Хабарлама ";
                sucead=" қосқан";
                uAdd="Хабарлама бұрын қойған";
                timeIn="";
                break;
            default:
                fromC="АЛМАТЫ";
                sts_name="Статус";
                bef30="Через 30 минут, ";
                bef60="Через 1 час, ";
                tran_n="Авиакомпания";
                if(dep.equals("dep")) {
                    check_n = "Регистрация";
                    datetime_n = "Выход";
                }
                else{
                    check_n="Фактическое время";
                    datetime_n="Ожидаемое время";
                }
                race_n="Номер рейса";
                type_vs="Воздушное судно";
                sch_n="Плановое";
                flighttime="Время полета";
                timeArr="Время прилета";
                timeDep="Время вылета";
                bNow="По факту";
                bHour="за час";
                bHalf="за 30 минут";
                uAsked="Вы уже попросили добавить этот рейс к уведомлениям";
                itWas="Время, которое вы выбрали уже прошло";
                notif="Напоминание ";
                sucead=" успешно добавленно";
                uAdd="Вы уже добавили рейс к уведомлениям";
                timeIn="";
                depT="Вылет";
                arrT="Прилет";
                break;
        }
        butt=(TextView) findViewById(R.id.butt);
        butt1=(TextView) findViewById(R.id.butt1);
        butt3=(TextView) findViewById(R.id.butt3);
        butt3.setText(bHalf);
        butt1.setText(bNow);
        butt.setText(bHour);
        arrs=(RelativeLayout) findViewById(R.id.arrs);
        arrs1=(RelativeLayout) findViewById(R.id.arrs1);
        arrs2=(RelativeLayout) findViewById(R.id.arrs2);
        relA=(RelativeLayout) findViewById(R.id.relTime);
        relAll=(RelativeLayout) findViewById(R.id.relAll);
        relAll.removeView(relA);
        relAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relAll.removeView(relA);
            }
        });
        alnText=(TextView) findViewById(R.id.textView52);
        regis=(TextView) findViewById(R.id.textView57);
        regis.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/Avenir-Heavy.ttf"));
        datetime=intent.getStringExtra("datetime")+"";
        dateTime=(TextView)  findViewById(R.id.textView59);
        dateTime.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/Avenir-Heavy.ttf"));
        sts=intent.getStringExtra("sts");
        stsText=(TextView) findViewById(R.id.textView55);
        stsText.setText(sts);
        stsText.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/Avenir-Heavy.ttf"));
        flt=intent.getStringExtra("flt");
        fltNumber=(TextView) findViewById(R.id.textView61);
        schText=(TextView) findViewById(R.id.textView65);
        schText.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/Avenir-Heavy.ttf"));
        fltNumber.setText(flt);
        fltNumber.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/Avenir-Heavy.ttf"));
        vs=intent.getStringExtra("typevs");
        typeVs=(TextView) findViewById(R.id.textView63);
        typeVs.setText(vs);
        typeVs.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/Avenir-Heavy.ttf"));
        fromcity=(TextView) findViewById(R.id.textView30);
        fromcity.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/AvenirNext-Medium.ttf"));
        bell=(ImageView) findViewById(R.id.imageView23);
        arrText=(TextView) findViewById(R.id.textView39);
        FlightTText=(TextView) findViewById(R.id.textView40);
        FlightTText.setText(flighttime);
        FlightTText.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/avenir-light.ttf"));
        tocity=(TextView) findViewById(R.id.textView31);
        tocity.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/AvenirNext-Medium.ttf"));
        fromtime=(TextView) findViewById(R.id.textView49);
        fromtime.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/avenir-light.ttf"));
        //totime=(TextView) findViewById(R.id.textView51);
        Flighttime=(TextView) findViewById(R.id.textView50);
        Flighttime.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/avenir-light.ttf"));
        planDate=(TextView) findViewById(R.id.textView65);
        planDate.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/Avenir-Heavy.ttf"));
        planDate.setText(intent.getStringExtra("comdate"));
        Flighttime.setText("");
        ft=intent.getStringExtra("flight_time");
        Flighttime.setText(ft);
        aln=intent.getStringExtra("aln");
        est=intent.getStringExtra("est");
        com=intent.getStringExtra("com");
        schText.setText(datetime);
        plane=(ImageView) findViewById(R.id.imageView25);
        String city=intent.getStringExtra("city");
        if(city.length()<17){
            tocity.setText(city);
        }
        else{
            tocity.setText(city);
        }

        if(dep.equals("dep")){
            dateTime.setText(intent.getStringExtra("gate"));
            checkin=intent.getStringExtra("checkin");
            regis.setText(checkin);
            try {
                if (!com.equals("")) {
                    fromtime.setText(com.substring(13,18));
                } else if (!est.equals("")) {
                    fromtime.setText(est.substring(13,18));
                } else
                    fromtime.setText(intent.getStringExtra("time"));
            }
            catch (NullPointerException e){
                try{
                    if (!est.equals("")) {
                        fromtime.setText(est.substring(13,18));
                    } else
                        fromtime.setText(intent.getStringExtra("time"));
                }
                catch (NullPointerException ee){
                fromtime.setText(intent.getStringExtra("time"));
                }
            }
           // totime.setText("--:--");
            plane.setImageResource(R.drawable.tothere);
        }
        else{
            dateTime.setText("");
            regis.setText("");
            try {
                if (!com.equals("")) {
                    fromtime.setText(com.substring(13,18));
                    regis.setText(com);
                } else if (!est.equals("")) {
                    fromtime.setText(est.substring(13,18));
                    dateTime.setText(est);
                }
                else
                    fromtime.setText(intent.getStringExtra("time"));
            }
            catch (NullPointerException e){
                try{
                    if (!est.equals("")) {
                        fromtime.setText(est.substring(13,18));
                        dateTime.setText(est);
                    } else
                        fromtime.setText(intent.getStringExtra("time"));
                }
                catch (NullPointerException ee){
                    fromtime.setText(intent.getStringExtra("time"));
                }
            }
            plane.setImageResource(R.drawable.fromthere);
        }
        alnText.setText(aln);
        if(aln.length()>15){
            alnText.setTextSize(10);
        }
        alnText.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/Avenir-Heavy.ttf"));
       // Log.d("Ticket",aln+" "+dep);
        a=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(relAll.getChildAt(1)==relA){
                    relAll.removeView(relA);
                }
                else{
                    relAll.addView(relA);
                }
            }
        };
        b=new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        };
        SQLiteOpenHelper AlaportDataHelper = new AlaportDatabaseHelper(getApplicationContext());
        SQLiteDatabase db = AlaportDataHelper.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * from notification WHERE ID='"+flt+"';"  ,null);
        if(cursor.moveToFirst()){
            do{
             //   Log.d("QWEQWE",cursor.getString(1));
                bell.setImageResource(R.drawable.bell);
                bell.setOnClickListener(b);
            }
            while (cursor.moveToNext());
        }
        else{
            bell.setImageResource(R.drawable.bell1);
            bell.setOnClickListener(a);
        }
        cursor=db.query("user", new String[]{"NOTIFA"}, "_id = ?", new String[] {Integer.toString(1)},null,null,null);
        if(cursor.moveToFirst()){
            if(cursor.getString(0).equals("T")){
                not=true;
            }
            else{
                not=false;
            }
        }
        cursor.close();
        db.close();
        arrs.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {NotifMake(0);}});
        arrs2.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {NotifMake(30);}});
        arrs1.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) {NotifMake(60);}});
        Calendar calendar=Calendar.getInstance();
        long milisnow=calendar.getTimeInMillis();
        calendar.set(Integer.parseInt(datetime.substring(0,4)),Calendar.DECEMBER,30);
        //calendar.set(Calendar.HOUR_OF_DAY,);
        setLang();
      //  Log.d("AbTime",milisnow+" "+calendar.getTimeInMillis()+" "+Calendar.JANUARY);
        ((FrameLayout)findViewById(R.id.flImage)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TicketActivity.super.onBackPressed();
            }
        });
       // NotifMake(15);
        String tran="Транзит";
        if(lang.equals("E")){
            tran="Transit";
        }
        ((TextView) findViewById(R.id.textView060)).setText(tran);
        ((TextView) findViewById(R.id.textView060)).setTypeface(Typeface.createFromAsset(getAssets(),"fonts/avenir-light.ttf"));
        if(intent.getBooleanExtra("transits",false)){
            String ssss=intent.getStringExtra("transitcities");
            ((TextView)findViewById(R.id.transitText)).setTypeface(Typeface.createFromAsset(getAssets(),"fonts/Avenir-Heavy.ttf"));
            ((TextView)findViewById(R.id.transitText)).setText(ssss);
        }
        else{
            ((LinearLayout) findViewById(R.id.scrollLay)).removeView(((LinearLayout) findViewById(R.id.transitLay)));
        }
    }
    public void setLang(){
        fromcity.setText(fromC);
        ((TextView) findViewById(R.id.textView64)).setText(sch_n);((TextView) findViewById(R.id.textView64)).setTypeface(Typeface.createFromAsset(getAssets(),"fonts/avenir-light.ttf"));
        ((TextView) findViewById(R.id.textView62)).setText(type_vs);((TextView) findViewById(R.id.textView62)).setTypeface(Typeface.createFromAsset(getAssets(),"fonts/avenir-light.ttf"));
        ((TextView) findViewById(R.id.textView60)).setText(race_n);((TextView) findViewById(R.id.textView60)).setTypeface(Typeface.createFromAsset(getAssets(),"fonts/avenir-light.ttf"));
        ((TextView) findViewById(R.id.textView58)).setText(datetime_n);((TextView) findViewById(R.id.textView58)).setTypeface(Typeface.createFromAsset(getAssets(),"fonts/avenir-light.ttf"));
        ((TextView)findViewById(R.id.textView56)).setText(check_n);((TextView)findViewById(R.id.textView56)).setTypeface(Typeface.createFromAsset(getAssets(),"fonts/avenir-light.ttf"));
        ((TextView)findViewById(R.id.textView53)).setText(tran_n);((TextView)findViewById(R.id.textView53)).setTypeface(Typeface.createFromAsset(getAssets(),"fonts/avenir-light.ttf"));
        ((TextView)findViewById(R.id.textView54)).setText(sts_name);((TextView)findViewById(R.id.textView54)).setTypeface(Typeface.createFromAsset(getAssets(),"fonts/avenir-light.ttf"));
        if(dep.equals("dep")){
            arrText.setText(timeDep);
        }
        else{
            arrText.setText(timeArr);
        }

    }

    public void NotifMake(int a){
        if(not) {
          //  Log.d("sasas", a + "");
            relAll.removeView(relA);
            Calendar cal = Calendar.getInstance();
            cal.setTimeZone(TimeZone.getDefault());
            int year = Integer.parseInt(datetime.substring(0, 4));
            int month = Integer.parseInt(datetime.substring(5, 7));
            int day = Integer.parseInt(datetime.substring(8, 10));
            int hour = Integer.parseInt((fromtime.getText() + "").substring(0, 2));
            int minute = Integer.parseInt((fromtime.getText() + "").substring(3, 5));
            if(dateTime.getText().length()>1){
                String swe;
                if(!com.equals("")){
                    swe=com;
                }
                else if(!est.equals("")){
                    swe=est;
                }
                else{
                    swe=datetime.substring(0,10);
                }
                year = Integer.parseInt(swe.substring(0, 4));
                month = Integer.parseInt(swe.substring(5, 7));
                day = Integer.parseInt(swe.substring(8, 10));
                hour = Integer.parseInt((fromtime.getText() + "").substring(0, 2));
                minute = Integer.parseInt((fromtime.getText() + "").substring(3, 5));
            }
            switch (month) {
                case 1:
                    cal.set(year, Calendar.JANUARY, day, hour, minute);
                    break;
                case 2:
                    cal.set(year, Calendar.FEBRUARY, day, hour, minute);
                    break;
                case 3:
                    cal.set(year, Calendar.MARCH, day, hour, minute);
                    break;
                case 4:
                    cal.set(year, Calendar.APRIL, day, hour, minute);
                    break;
                case 5:
                    cal.set(year, Calendar.MAY, day, hour, minute);
                    break;
                case 6:
                    cal.set(year, Calendar.JUNE, day, hour, minute);
                    break;
                case 7:
                    cal.set(year, Calendar.JULY, day, hour, minute);
                    break;
                case 8:
                    cal.set(year, Calendar.AUGUST, day, hour, minute);
                    break;
                case 9:
                    cal.set(year, Calendar.SEPTEMBER, day, hour, minute);
                    break;
                case 10:
                    cal.set(year, Calendar.OCTOBER, day, hour, minute);
                    break;
                case 11:
                    cal.set(year, Calendar.NOVEMBER, day, hour, minute);
                    break;
                case 12:
                    cal.set(year, Calendar.DECEMBER, day, hour, minute);
                    break;
            }
            long time = cal.getTimeInMillis();
            time = time - (a * 60000);
            long tie = Calendar.getInstance().getTimeInMillis();
            if (time - tie < 0) {
                Toast.makeText(this, itWas, Toast.LENGTH_LONG).show();
            } else {
                bell.setOnClickListener(b);
                bell.setImageResource(R.drawable.bell);
                String ss,f1,f2, que="";
                if (dep.equals("dep")) {
                    ss = depT;
                    f1=fromC;f2=tocity.getText()+"";
                } else {
                    ss = arrT;
                    f2=fromC;f1=tocity.getText()+"";
                }
                switch (a){
                    case 30:
                        que=bef30;
                        break;
                    case 60:
                        que=bef60;
                        break;
                    }
                ScheduleNotification(getNotification(que+ss+" "+flt,f1+" - "+f2 + " : " + datetime), time - tie, onNotification(a, time));
                Toast.makeText(this, notif + tocity.getText() + sucead, Toast.LENGTH_SHORT).show();
            }

          //  Log.d(a + "", time + " ");
        }
        else{
            relAll.removeView(relA);
            //    Log.d("Not","OFF");
        }
    }
    @Override
    public void onBackPressed(){
        if(relAll.getChildAt(1)==relA){
            relAll.removeView(relA);
        }
        else{
            super.onBackPressed();
        }

    }
}
