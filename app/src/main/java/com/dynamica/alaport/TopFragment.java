package com.dynamica.alaport;



import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;

import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.format.Time;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dynamica.alaport.R;
import com.dynamica.alaport.dummy.AppStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Calendar;


public class TopFragment extends Fragment{
    String lang, bNow,bHour,bHalf, uAsked, itWas,uAdd, notif, sucead, arrT, depT, almT, bef30, bef60;
    boolean not;
    private RecyclerView lv;
    SwipeRefreshLayout srl;
    private TopAdapter mAdap;
    SimpleDateFormat sdf=new SimpleDateFormat("dd.MM.yyyy");
    Calendar cal;
    private TopAdapter depAdap;
    public String time="";
    public String day;
    ProgressBar pb;
    boolean deps;
    Button arrbutton;
    public TextView today;
    ArrayList<Arrival> arrs;
    ArrayList<Arrival> arrsF;
    ArrayList<Arrival> depis;
    ArrayList<Arrival> depisF;

    TextView TableName;
    String yest;
    String tomm;
    String toda;
    String conn;
    String arrivs;
    String depars;
    String toA;
    String fromA;
    Practice ccc,cc1,ccc1,ccc2;



    ItemTouchHelper itemTouchHelper;
    FragmentManager fm;
    FragmentTransaction ft;
    DialogTopFragment dtf;
    fragment_chooseday fragment_chooseday;
    TimeFragment tf;

    FrameLayout frame;

    TextView datetime;
    TextView arrText,almatyText;
    TextView timeText;
    View vow;
    View datevow;
    View timevow;
    RelativeLayout topLinear;

    public TopFragment() {
    }


    public class getXml1 extends AsyncTask<Practice,Integer, String> {
        protected String doInBackground(Practice... practices) {
            try {
                int count = practices.length;
                return practices[0].getXml();
            } catch (Exception e) {e.printStackTrace();
                return " ";}}
        protected void onProgressUpdate(Integer... ints){}
        protected void onPostExecute(String result){if(result.length()>1){
            try {
                if(result.equals(" ") || result.equals("")){
                    Toast.makeText(getActivity(),conn,Toast.LENGTH_SHORT).show();
                    pb.setVisibility(View.INVISIBLE);
                }
                else{
                ((MainActivity) getActivity()).setArrivals(result);
                new parseA().execute(result);
                }
            }
            catch (NullPointerException e){
            }
        } else{
            try {
                Toast.makeText(getActivity(), conn, Toast.LENGTH_SHORT).show();
            }
        catch (Exception e){


        }
            }}
    }
    public class getXml2 extends AsyncTask<Practice,Integer, String> {
        protected String doInBackground(Practice... practices) {
            try {
                int count = practices.length;
                return practices[0].getXml();
            } catch (Exception e) {e.printStackTrace();

                return " ";}}
        protected void onProgressUpdate(Integer... ints){}
        protected void onPostExecute(String result){if(result.length()>1) {
            try {
                if(result.equals(" ")){

                }
                else {
                    ((MainActivity) getActivity()).setDepartures(result);
                    new parseD().execute(result);
                }
            } catch (NullPointerException e) {
            }
        }else{}}
    }
    public class parseA extends AsyncTask<String,Integer, ArrayList<Arrival>>{
        @Override
        protected ArrayList<Arrival> doInBackground(String... s) {
            Parser parser=new Parser();
        //    Log.d("FUCKQWE",s[0].length()+"");
                arrs=(parser.ArrParsing(s[0]));
                //
          //      Log.d("Fucking lrngt", arrs.size() + "");
                arrsF = arrs;
                return arrs;
        }

        protected void onProgressUpdate(Integer... ints){}
        @Override
        protected void onPostExecute(ArrayList<Arrival> arrivals) {
            pb.setVisibility(View.INVISIBLE);parse(false,arrivals);
        }
    }
    public class parseD extends AsyncTask<String,Integer, ArrayList<Arrival>>{
        @Override
        protected ArrayList<Arrival> doInBackground(String... s) {
            Parser parser=new Parser();
          //  Log.d("FUCKQWE",s[0].length()+"");
            depis=(parser.ArrParsing(s[0]));
            depisF=depis;
            return depis;
        }

        protected void onProgressUpdate(Integer... ints){}
        @Override
        protected void onPostExecute(ArrayList<Arrival> arrivals) {
            parse(true,arrivals);
        }
    }
    private final Runnable mRunnable=new Runnable() {
        @Override
        public void run() {

                ((MainActivity) getActivity()).startT();
                if (AppStatus.getInstance(getActivity()).isOnline()) {
                    new getXml1().execute(ccc);
                    new getXml2().execute(cc1);
                    pb.setVisibility(View.VISIBLE);
                } else {
                    Toast.makeText(getActivity(), conn, Toast.LENGTH_SHORT).show();
                }
                Log.d("Hand", "run");
        }
    };

    @Override
    public void onDestroyView(){
        super.onDestroyView();
}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       // sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        arrs=new ArrayList<>();
        arrsF=new ArrayList<>();
        depis=new ArrayList<>();
        depisF=new ArrayList<>();
        ccc = new Practice("http://www.alaport.com/getdb.php?t=arr");
        cc1= new Practice("http://www.alaport.com/getdb.php?t=dep");
        View view=inflater.inflate(R.layout.fragment_top,container,false);
        srl=(SwipeRefreshLayout) view.findViewById(R.id.swipeTop);
        pb=(ProgressBar) view.findViewById(R.id.progressBar);
        frame=(FrameLayout) view.findViewById(R.id.frameProg);
        pb.setVisibility(View.INVISIBLE);
        lang=((MainActivity) getActivity()).lang;
        fm=getFragmentManager();
        dtf=new DialogTopFragment();
        tf=new TimeFragment();
        fragment_chooseday=new fragment_chooseday();

        deps=false;
        timeText=(TextView) view.findViewById(R.id.textView13);
        timeText.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/avenir-light.ttf"));
        TableName=(TextView) view.findViewById(R.id.TableName);
        TableName.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/avenir-light.ttf"));
        setLang(lang);
     //   Log.d("Length",lang);
        android.text.format.Time time=new Time(Time.getCurrentTimezone());
        time.setToNow();
        String ss=time.hour+"";
        if(ss.length()<2){
            ss="0"+ss;
        }
        //this.time=ss;
        if(Calendar.getInstance().getTimeInMillis()-((MainActivity)getActivity()).timmillis>200000 || ((MainActivity)getActivity()).arrivals.equals(" ") || ((MainActivity)getActivity()).arrivals.equals("")){
            ((MainActivity)getActivity()).startT();
            if(AppStatus.getInstance(getActivity()).isOnline()) {
                new getXml1().execute(ccc);
                new getXml2().execute(cc1);
                pb.setVisibility(View.VISIBLE);
            }
            else{
                Toast.makeText(getActivity(),conn,Toast.LENGTH_SHORT).show();
            }
             }
        else {
            new parseA().execute(((MainActivity)getActivity()).arrivals);
            new parseD().execute(((MainActivity)getActivity()).departures);
        }





        timeText.setText("--:--");

        today=(TextView) view.findViewById(R.id.textView11);
        today.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/Avenir-Heavy.ttf"));
        datetime=(TextView) view.findViewById(R.id.textView12);
        today.setText(toda);
        String day=time.monthDay+"";String month=(time.month+1)+"";String year=time.year+"";
        if(day.length()==1){day="0"+day;}
        if(month.length()==1){month="0"+month;}
        datetime.setText(day+"."+month+"."+year);
        this.day="today";
        topLinear=(RelativeLayout) view.findViewById(R.id.relTop);
        vow=view.findViewById(R.id.topfragments);
        datevow=view.findViewById(R.id.fragment);
        timevow=view.findViewById(R.id.fragment2);
        topLinear.removeView(vow);
        topLinear.removeView(datevow);
        topLinear.removeView(timevow);


        //ListView lv=(ListView) view.findViewById(R.id.topView);
        lv=(RecyclerView) view.findViewById(R.id.topView);

        RecyclerView.LayoutManager mLayoutManager=new LinearLayoutManager(getActivity());
        lv.setLayoutManager(mLayoutManager);
        lv.setItemAnimator(new DefaultItemAnimator());

        ItemTouchHelper.SimpleCallback simpleCallback=new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT){
            @Override
            public boolean onMove(RecyclerView recyclerView,RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target){
                return false;
            }

            @Override
            public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
                Paint p = new Paint();
                Bitmap icon;
                if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {

                    View itemView = viewHolder.itemView;
                    float height = (float) itemView.getBottom() - (float) itemView.getTop();
                    float width = height/3-2;
                    p.setColor(ContextCompat.getColor(getContext(), R.color.blueDrawer));
                    RectF background = new RectF((float) itemView.getRight() + dX, (float) itemView.getTop(), (float) itemView.getRight(), (float) itemView.getBottom());
                    c.drawRect(background, p);
                    icon = BitmapFactory.decodeResource(getResources(),R.drawable.orangebell);
                    RectF icon_dest = new RectF((float) itemView.getRight() - 2 * width+5, (float) itemView.getTop() + width, (float) itemView.getRight() - width+2, (float) itemView.getBottom() - width);
                    c.drawBitmap(icon, null, icon_dest, p);
                    // c.drawText("DELETE",(float) itemView.getRight() + dX,(float) itemView.getTop(),p);

                }
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);

            }
            @Override
            public void onSwiped(final RecyclerView.ViewHolder viewHolder, int direction) {
                final int position = viewHolder.getAdapterPosition();
                if(direction == ItemTouchHelper.LEFT){
                    AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
                    String arusure;
                    switch (lang){
                        case "K":
                            arusure="Сіз хабарламаны қоюға сенімдісіз бе?";
                            break;
                        case "E":
                            arusure="Do you want to create new notification";
                            break;
                        default:
                            arusure="Вы хотите поставить уведомление?";
                            break;
                    }
                    builder.setMessage(arusure);
                    builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
                        @Override
                        public void onCancel(DialogInterface dialogInterface) {
                            lv.getAdapter().notifyItemRangeChanged(position, lv.getAdapter().getItemCount());   //notifies the RecyclerView Adapter that positions of element in adapter has been changed from position(removed element index to end of list), please update it.
                            return;
                        }
                    }).setNegativeButton(bHalf, new DialogInterface.OnClickListener() { //when click on DELETE
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            lv.getAdapter().notifyItemRangeChanged(position, lv.getAdapter().getItemCount());    //item removed from recylcerview
                            Arrival arrival=null;
                            if(lv.getAdapter()==mAdap){
                                arrival=arrs.get(position);
                            }
                            else {
                                arrival=depis.get(position);
                            }
                            SQLiteOpenHelper AlaportDataHelper = new AlaportDatabaseHelper(getContext());
                            SQLiteDatabase db = AlaportDataHelper.getReadableDatabase();
                            Cursor cursor=db.rawQuery("SELECT _id FROM notification WHERE ID='"+arrival.flt_nr+"';",null);
                            if(cursor.moveToFirst()){
                             //   Log.d("FUCK THAT FLO",cursor.getString(0));
                                Toast.makeText(getActivity(),uAdd,Toast.LENGTH_SHORT).show();
                            }
                            else{
                                NotifMake(30,arrival);
                            }
                            db.close();
                            return;
                        }
                    }).setNeutralButton(bHour, new DialogInterface.OnClickListener() { //when click on DELETE
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            lv.getAdapter().notifyItemRangeChanged(position, lv.getAdapter().getItemCount());    //item removed from recylcerview
                            Arrival arrival=null;
                            if(lv.getAdapter()==mAdap){
                                arrival=arrs.get(position);
                            }
                            else {
                                arrival=depis.get(position);
                            }
                            SQLiteOpenHelper AlaportDataHelper = new AlaportDatabaseHelper(getContext());
                            SQLiteDatabase db = AlaportDataHelper.getReadableDatabase();
                            Cursor cursor=db.rawQuery("SELECT _id FROM notification WHERE ID='"+arrival.flt_nr+"';",null);
                            if(cursor.moveToFirst()){
                                //Log.d("FUCK THAT FLO",cursor.getString(0));
                                Toast.makeText(getActivity(),uAsked,Toast.LENGTH_SHORT).show();
                            }
                            else{
                                NotifMake(60,arrival);
                            }
                            db.close();
                            return;
                        }
                    })
                            .setPositiveButton(bNow, new DialogInterface.OnClickListener() {  //not removing items if cancel is done
                        @Override
                        public void onClick(DialogInterface dialog, int which) {//notifies the RecyclerView Adapter that data in adapter has been removed at a particular position.
                            lv.getAdapter().notifyItemRangeChanged(position, lv.getAdapter().getItemCount());   //notifies the RecyclerView Adapter that positions of element in adapter has been changed from position(removed element index to end of list), please update it.
                            Arrival arrival=null;
                        //    Log.d("POSITION IN ITEM",position+" "+arrs.size());
                            if(lv.getAdapter()==mAdap){
                                arrival=arrs.get(position);
                            }
                            else {
                                arrival=depis.get(position);
                            }
                            SQLiteOpenHelper AlaportDataHelper = new AlaportDatabaseHelper(getContext());
                            SQLiteDatabase db = AlaportDataHelper.getReadableDatabase();
                            Cursor cursor=db.rawQuery("SELECT _id FROM notification WHERE ID='"+arrival.flt_nr+"';",null);
                            if(cursor.moveToFirst()){
                             //   Log.d("FUCK THAT FLO",cursor.getString(0));
                                Toast.makeText(getActivity(),uAsked,Toast.LENGTH_SHORT).show();
                            }
                            else{
                                NotifMake(0,arrival);
                            }
                            db.close();
                            return;
                        }
                    }).show();
                }
            }

        };
       itemTouchHelper=new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(lv);

        lv.addItemDecoration(new DividerItemDecoration(lv.getContext(),
                DividerItemDecoration.HORIZONTAL));
        //lv.setAdapter(topl);
        arrbutton=(Button)view.findViewById(R.id.imageView5);
        arrbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                topArrChoose();
            }
        });
        ImageView arrowimg=(ImageView) view.findViewById(R.id.imageView4);
        arrowimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                topArrChoose();
            }
        });

        LinearLayout ll=(LinearLayout) view.findViewById(R.id.timeview);
        ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                topTimeChoose();
            }
        });
        almatyText=(TextView) view.findViewById(R.id.AlmatyTop);
        arrText=(TextView) view.findViewById(R.id.arrivalsTop);
        arrText.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/Avenir-Heavy.ttf"));
        arrText.setText(arrivs);
        almatyText.setText(toA);

        ((RelativeLayout) view.findViewById(R.id.relar)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                topArrChoose();
            }
        });
        ((LinearLayout) view.findViewById(R.id.linday)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                topDateChoose();
            }
        });
        ImageView imgDate=(ImageView) view.findViewById(R.id.imageView6);
        imgDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                topDateChoose();
            }
        });

     //   Log.d("TRRRtttrr",lv.getChildCount()+"");
        topLinear.removeAllViews();
        topLinear.addView(srl);
        topLinear.addView(frame);
        srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                ((MainActivity)getActivity()).refreshL();
                srl.setRefreshing(false);
            }
        });
        SQLiteOpenHelper AlaportDataHelper = new AlaportDatabaseHelper(getContext());
        SQLiteDatabase db = AlaportDataHelper.getReadableDatabase();
        Cursor cursor=db.query("user", new String[]{"NOTIFA"}, "_id = ?", new String[] {Integer.toString(1)},null,null,null);
        if(cursor.moveToFirst()){
            if (cursor.getString(0).equals("T")) {
                not=true;
            }
            else{
                not=false;
            }
        }
     //   Log.d("FUCK SS",ss);

        Handler handler=new Handler();
        handler.postDelayed(mRunnable,200000);
        cursor.close();
        db.close();
        return view;

    }

    public void parse(boolean deps, ArrayList<Arrival> ars){
        if(!deps) {
            mAdap = new TopAdapter(arrs, lang, false, getActivity());
            lv.setAdapter(mAdap);
            setTime(time);
        }
        else {
            depAdap = new TopAdapter(depis, lang, true, getActivity());
            if(this.deps){
                lv.setAdapter(depAdap);
            }
            setTime(time);
        }
        itemTouchHelper.attachToRecyclerView(lv);
    }
    public void topClear(){
        try {
            if(topLinear.getChildCount()>2) {
                topLinear.removeAllViews();
                topLinear.addView(srl);
                topLinear.addView(frame);
            }
            else{
                ((MainActivity)getActivity()).Back();
            }
            lv.setAlpha(1);
        }
        catch (Exception e){
        //    Log.d("QWE","NO0");
        }
    }
    public void topArrChoose(){
        if(topLinear.getChildAt(1)==vow  || topLinear.getChildAt(2)==vow){
            topLinear.removeView(vow);
            lv.setAlpha(1);
        }
        else if(topLinear.getChildAt(1)==datevow || topLinear.getChildAt(2)==datevow){
            topLinear.removeView(datevow);
            topLinear.addView(vow);
            lv.setAlpha(Float.valueOf("0.15"));
        }
        else if(topLinear.getChildAt(1)==timevow || topLinear.getChildAt(2)==timevow){
            topLinear.removeView(timevow);
            topLinear.addView(vow);
            lv.setAlpha(Float.valueOf("0.15"));
        }
        else {
            topLinear.addView(vow);
            lv.setAlpha(Float.valueOf("0.15"));
        }
    }
    public void topDateChoose(){
        if(topLinear.getChildAt(1)==datevow || topLinear.getChildAt(2)==datevow){
            topLinear.removeView(datevow); lv.setAlpha(1);
        }
        else if(topLinear.getChildAt(1)==vow || topLinear.getChildAt(2)==vow){
            topLinear.removeView(vow);
            topLinear.addView(datevow);
            lv.setAlpha(Float.valueOf("0.15"));
        }
        else if(topLinear.getChildAt(1)==timevow || topLinear.getChildAt(2)==timevow){
            topLinear.removeView(timevow);
            topLinear.addView(datevow);
            lv.setAlpha(Float.valueOf("0.15"));
        }
        else{
            topLinear.addView(datevow);
            lv.setAlpha(Float.valueOf("0.15"));
        }
    }
    public void topTimeChoose(){
        if(topLinear.getChildAt(1)==timevow || topLinear.getChildAt(2)==timevow){
            topLinear.removeView(timevow); lv.setAlpha(1);
        }
        else {
            if (topLinear.getChildAt(1) == datevow || topLinear.getChildAt(2) == datevow) {
                topLinear.removeView(datevow);
                topLinear.addView(timevow);
                lv.setAlpha(Float.valueOf("0.15"));
            } else if (topLinear.getChildAt(1) == vow || topLinear.getChildAt(2) == vow) {
                topLinear.removeView(vow);
                topLinear.addView(timevow);
                lv.setAlpha(Float.valueOf("0.15"));
            } else {
                topLinear.addView(timevow);
                lv.setAlpha(Float.valueOf("0.15"));
            }
        }
    }
    public void setDepartures(){
        deps=true;
        arrText.setText(depars);
        almatyText.setText(fromA);
        setTime(time);
        arrbutton.setBackground(getResources().getDrawable(R.drawable.planarrival));
    }
    public void setArrivals(){
        deps=false;
        arrText.setText(arrivs);
        almatyText.setText(toA);
        setTime(time);
        arrbutton.setBackground(getResources().getDrawable(R.drawable.plandeps));
    }
    public void setToday(){
        cal = Calendar.getInstance();
        day="today";
        today.setText(toda);
        datetime.setText(sdf.format(cal.getTime()));
        android.text.format.Time time=new Time(Time.getCurrentTimezone());
        time.setToNow();
        String ss=time.hour+"";
        if(ss.length()<2){
            ss="0"+ss;
        }
        //this.time=ss;
        setTime("");
        topDateChoose();
    }
    public void setTomorow(){
        cal = Calendar.getInstance();
        cal.add(Calendar.DATE,+1);
        day="tomorow";
        today.setText(tomm);
        datetime.setText(sdf.format(cal.getTime()));
        setTime("");
        topDateChoose();

    }
    public void setYesterday(){
        day="yesterday";
        cal=Calendar.getInstance();
        cal.add(Calendar.DATE,-1);
        today.setText(yest);
        datetime.setText(sdf.format(cal.getTime()));
        setTime("");
        topDateChoose();

    }
    public void setTime(String s){
        if(s.equals("--") || s.equals("")){
            s="";
        }
        else {
            this.time = s;
        }
        cal=Calendar.getInstance();

        if(day.equals("yesterday")){
            cal.add(Calendar.DATE,-1);
        }
        else if(day.equals("tomorow")){
            cal.add(Calendar.DATE,1);
        }
        if(s.equals("")){
            timeText.setText("--:--");
        }
        else{
        timeText.setText(s+":00");
        }
        if(!deps){
            arrs=(arrsF);
            ArrayList<Arrival> arrivals=new ArrayList<>();
            ArrayList<Arrival> arrday=new ArrayList<>();
            for(Arrival i:arrs){
              //  Log.d("CAL",sdf.format(cal.getTime()).substring(0,2));
                if(i.transitarrival.size()>0) {
                    i.sch = i.transitarrival.get(i.transitarrival.size() - 1).sch;
                    i.est = i.transitarrival.get(i.transitarrival.size() - 1).est;
                    i.com = i.transitarrival.get(i.transitarrival.size() - 1).com;
                }
                if (i.sch.getDate().substring(8, 10).equals(sdf.format(cal.getTime()).substring(0, 2))) {
                    arrday.add(i);
                    if(!s.equals(""))
                    if(s.equals(i.sch.getTime().substring(0, 2))  || ((((Integer.parseInt(s)+1)%24))+"").equals(i.sch.getTime().substring(0, 2)) || ((((Integer.parseInt(s)-1)%24))+"").equals(i.sch.getTime().substring(0, 2))){
                        arrivals.add(i);
                    }
                    else{
                        if(time.equals("")){
                            arrivals.add(i);
                        }
                    }
                    else{
                        arrivals.add(i);
                    }
                }
            }
            arrs=(arrivals);
            ArrayList ccc=new ArrayList(arrday);
            ccc.removeAll(arrs);
            arrs.addAll(ccc);
            mAdap=new TopAdapter(arrs,lang,false,getActivity());
            lv.setAdapter(mAdap);
            itemTouchHelper.attachToRecyclerView(lv);
        }
        else{
            depis=(depisF);
            ArrayList<Arrival> arrivals=new ArrayList<>();
            ArrayList<Arrival> arrday=new ArrayList<Arrival>();
            for(Arrival i:depis){
                    if (i.sch.getDate().substring(8, 10).equals(sdf.format(cal.getTime()).substring(0, 2))) {
                        arrday.add(i);
                        if(!s.equals(""))
                        if (s.equals(i.sch.getTime().substring(0, 2)) || ((((Integer.parseInt(s)+1)%24))+"").equals(i.sch.getTime().substring(0, 2)) || ((((Integer.parseInt(s)-1)%24))+"").equals(i.sch.getTime().substring(0, 2))){
                            arrivals.add(i);
                        } else {
                            if (time.equals("")) {
                                arrivals.add(i);
                            }
                        }
                        else {
                            arrivals.add(i);
                        }
                    }
            }
            /*depis.clear();
            depis.addAll(arrivals);
            depAdap.notifyDataSetChanged();*/
            depis=(arrivals);
            ArrayList ccc=new ArrayList(arrday);
            ccc.removeAll(depis);
            depis.addAll(ccc);
            depAdap=new TopAdapter(depis,lang,true,getActivity());
            lv.setAdapter(depAdap);
            itemTouchHelper.attachToRecyclerView(lv);
        }
    }
    @Override
    public void onResume(){

        lang=((MainActivity)getActivity()).lang;
        setLang(lang);
        mAdap=new TopAdapter(arrs,lang,false,getActivity());
        depAdap=new TopAdapter(depis,lang,true,getActivity());
        switch (day){
            case "today":
                setToday();
                break;
            case "yesterday":
                setYesterday();
                break;
            case "tomorow":
                setTomorow();
                break;
        }
        if(deps) setDepartures();
        else{setArrivals();}

        setTime(time);
        topClear();
        super.onResume();
    }
    public void setLang(String s){
        if(s.equals("R")){
            TableName.setText("Онлайн Табло");
            almT="АЛМАТЫ";
            yest="Вчера";
            toda="Сегодня";
            conn="Проблема подключения";
            tomm="Завтра";
            arrivs="Прилеты";
            bef30="Через 30 минут, ";
            bef60="Через 1 час, ";
            arrT="Прилет";
            depars="Вылеты";
            depT="Вылет";
            toA="в Алматы";
            fromA="из Алматы";
            bNow="По факту";
            bHour="за час";
            bHalf="за 30 минут";
            uAsked="Вы уже попросили добавить этот рейс к уведомлениям";
            itWas="Время, которое вы выбрали уже прошло";
            notif="Напоминание ";
            sucead=" успешно добавленно";
            uAdd="Вы уже добавили рейс к уведомлениям";
        }
        else if(s.equals("K")){
            TableName.setText("Онлайн Табло");
            yest="Кеше";
            toda="Бүгін";
            almT="АЛМАТЫ";
            tomm="Ертең";
            arrivs="Ұшып келу";
            arrT="Ұшып келу";
            depT="Ұшып кету";
            toA="Алматыға";
            depars="Ұшып кету";
            conn="Ғаламтор жоқ";
            bef30="30 минуттан кейін, ";
            bef60="1 сағаттан кейін, ";
            fromA="Алматыдан";
            bNow="Қазіргі уақытта";
            bHour="1 сағат бұрын";
            bHalf="30 минут бұрын";
            uAsked="Сіз хабарламаны әлі қостыңыз";
            itWas="Уақыт өтті";
            notif="Хабарлама ";
            sucead=" қосқан";
            uAdd="Хабарлама бұрын қойған";
        }
        else if(s.equals("E")){
            TableName.setText("Online table");
            yest="Yesterday";
            toda="Today";
            tomm="Tomorrow";
            conn="Connection trouble";
            arrivs="Arrivals";
            arrT="Arrival";
            depars="Departures";
            bef30="After 30 minutes, ";
            bef60="After 1 hour, ";
            depT="Departure";
            toA="to Almaty";
            fromA="from Almaty";
            almT="ALMATY";
            bNow="In fact";
            bHalf="30 minutes before";
            bHour="1 hour before";
            uAsked="You have already added this notification";
            itWas="The time you chose has already passed";
            notif="Notification ";
            sucead=" successfully added";
            uAdd="You have already added this notification";
        }
    }
    public void NotifMake(int a, Arrival ar){
        if(not) {
            int aln_id,city_id;
            switch (lang){
                case "E":
                    aln_id=2;
                    city_id=0;
                    break;
                case "K":
                    aln_id=1;
                    city_id=1;
                    break;
                default:
                    aln_id=0;
                    city_id=2;
                    break;
            }
            Calendar cal = Calendar.getInstance();
            //cal.setTimeZone(TimeZone.getDefault());
            com.dynamica.alaport.Time datetime = null;
            try {
                if (!ar.com.getTime().equals("")) {
                    datetime = ar.com;
                } else if (!ar.est.getTime().equals("")) {
                    datetime = ar.est;
                } else {
                    datetime = ar.sch;
                }
            } catch (NullPointerException e) {
                try {
                    if (!ar.est.getTime().equals("")) {
                        datetime = ar.est;
                    } else {
                        datetime = ar.sch;
                    }
                } catch (NullPointerException ee) {
                    datetime = ar.sch;
                }
            }
            int year = Integer.parseInt(datetime.getDate().substring(0, 4));
            int month = Integer.parseInt(datetime.getDate().substring(5, 7));
            int day = Integer.parseInt(datetime.getDate().substring(8, 10));
            int hour = Integer.parseInt((datetime.getTime()).substring(0, 2));
            int minute = Integer.parseInt((datetime.getTime()).substring(3, 5));
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
              //  Log.d("Time check1", " " + time + " " + tie + " " + day + " " + month + " " + year + " " + hour + " " + minute);
                Toast.makeText(getActivity(), itWas, Toast.LENGTH_LONG).show();
            } else {
//                Log.d("Time check", " " + time + " " + tie);
                String ss, f1, f2, que="";
                if (deps) {
                    ss = depT;
                    f1=almT;
                    f2=ar.cities.get(city_id);
                } else {
                    ss = arrT;
                    f2=almT;
                    f1=ar.cities.get(city_id);
                }
                switch (a){
                    case 30:
                        que=bef30;
                        break;
                    case 60:
                        que=bef60;
                        break;
                }
                ScheduleNotification(getNotification(que+ss+" "+ar.flt_nr,  f1+ " - " + f2+" : "+datetime.getTime()+" "+datetime.getDate()), time - tie, onNotification(a, time, ar, datetime));
                Toast.makeText(getActivity(),notif + ar.cities.get(city_id) + sucead, Toast.LENGTH_LONG).show();
            }
  //          Log.d(a + "", time + " ");
        }
        else{
    //        Log.d("NOT","OFFED in TOP");
        }
    }
    public int onNotification(int bef, long t,Arrival arrival, com.dynamica.alaport.Time time){
        SQLiteOpenHelper AlaportDataHelper = new AlaportDatabaseHelper(getContext());
        SQLiteDatabase db = AlaportDataHelper.getReadableDatabase();
        ContentValues cv=new ContentValues();
        int aln_id,city_id;
        switch (lang){
            case "E":
                aln_id=2;
                city_id=0;
                break;
            case "K":
                aln_id=1;
                city_id=1;
                break;
            default:
                aln_id=0;
                city_id=2;
                break;
        }
        cv.put("ID",arrival.flt_nr);
        cv.put("CITY",arrival.cities.get(city_id));
        cv.put("TIME",time.getTime());
        cv.put("DATE",time.getDate());
        cv.put("BEFORE",bef);
        cv.put("TIMEMILL",t+"");
        if(deps){
            cv.put("DEPS","deps");
        }
        else{
            cv.put("DEPS","arrs");
        }
        db.insert("notification","",cv);
        Cursor cursor=db.rawQuery("SELECT _id FROM notification WHERE ID='"+arrival.flt_nr+"';",null);
        int i=1;
        if(cursor.moveToFirst()){
            i=cursor.getInt(0);
        }
        db.close();
        return i;
    }
    private Notification getNotification(String tit,String content) {
        Notification.Builder builder = new Notification.Builder(getActivity());
        builder.setContentTitle(tit);
        builder.setContentText(content);
        builder.setSmallIcon(R.drawable.ggg);
        Notification notification=builder.build();
        notification.defaults |=Notification.DEFAULT_SOUND;
        notification.defaults|= Notification.DEFAULT_LIGHTS;
        notification.defaults|= Notification.DEFAULT_VIBRATE;
        return notification;
    }
    public void ScheduleNotification(Notification  notification, long delay, int id){
        Intent notifIntent;
        notifIntent=new Intent(getActivity(), NotificationPublisher.class);
        notifIntent.putExtra(NotificationPublisher.NOTIFICATION_ID,id);
        notifIntent.putExtra(NotificationPublisher.NOTIFICATION,notification);
        PendingIntent pendingIntent=PendingIntent.getBroadcast(getActivity(),id,notifIntent,PendingIntent.FLAG_UPDATE_CURRENT);
        long futureTimeMil= SystemClock.elapsedRealtime() + delay;
        AlarmManager alarmManager=(AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,futureTimeMil,pendingIntent);
    }
}
