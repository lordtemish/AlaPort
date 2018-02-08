package com.dynamica.alaport;



import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.dynamica.alaport.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 */
public class NotificationFragment extends Fragment {
    RecyclerView rv;
    ArrayList<Arrival> arrs;
    ArrayList<Arrival> deps;
    HashMap<String, Arrival> aMap;
    RecyclerView.Adapter aa;
    ArrayList<Notificat> notificats;
    TextView tv;
    boolean con;
    String conn;
    String arusure,canc,rem;
    Parser parser;

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
                if(result.equals(" ")){
                    Toast.makeText(getActivity(),conn,Toast.LENGTH_SHORT).show();
                }
                else {
                    ((MainActivity) getActivity()).setArrivals(result);
                    new parseA().execute(result);
                }
            }
            catch (NullPointerException e){
                //  Toast.makeText(getActivity(),conn,Toast.LENGTH_SHORT).show();
            }
        } else{
            try {
                Toast.makeText(getActivity(),conn,Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(getActivity(),conn,Toast.LENGTH_SHORT).show();
                }
                else {
                    ((MainActivity) getActivity()).setDepartures(result);
                    new parseD().execute(result);
                }
            }
            catch (NullPointerException e){

            }
        }else{  try {
            Toast.makeText(getActivity(),conn,Toast.LENGTH_SHORT).show();
        }
        catch (Exception e){


        }

        }}
    }
    public class parseA extends AsyncTask<String,Integer, ArrayList<Arrival>>{
        @Override
        protected ArrayList<Arrival> doInBackground(String... s) {
            Log.d("FUCKQWE",s[0].length()+"");
            arrs=(parser.ArrParsing(s[0]));
            return arrs;
        }

        protected void onProgressUpdate(Integer... ints){}
        @Override
        protected void onPostExecute(ArrayList<Arrival> arrivals) {
        }
    }
    public class parseD extends AsyncTask<String,Integer, ArrayList<Arrival>>{
        @Override
        protected ArrayList<Arrival> doInBackground(String... s) {
            Log.d("FUCKQWE",s[0].length()+"");
            deps=(parser.ArrParsing(s[0]));
            return deps;
        }

        protected void onProgressUpdate(Integer... ints){}
        @Override
        protected void onPostExecute(ArrayList<Arrival> arrivals) {
            try {
                con = true;
                aa = new NotificationAdaptor(notificats, ((MainActivity) getActivity()).lang, getActivity(), true, parser.map1);
                rv.setAdapter(aa);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public NotificationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_notification, container, false);
        rv=(RecyclerView) view.findViewById(R.id.notRec);
        con=false;
        parser=new Parser();
        aMap=new HashMap<>();
        arrs=new ArrayList<>();deps=new ArrayList<>();
        if(Calendar.getInstance().getTimeInMillis()-((MainActivity)getActivity()).timmillis>200000 || ((MainActivity)getActivity()).arrivals.equals(" ") || ((MainActivity)getActivity()).arrivals.equals("")) {
            ((MainActivity)getActivity()).startT();
            Practice ccc = new Practice("http://www.alaport.com/getdb.php?t=arr");
            Practice cc1= new Practice("http://www.alaport.com/getdb.php?t=dep");
            new getXml1().execute(ccc);
            new getXml2().execute(cc1);
        }
        else{
            new parseA().execute(((MainActivity)getActivity()).arrivals);
            new parseD().execute(((MainActivity)getActivity()).departures);
        }

        SQLiteOpenHelper AlaportDataHelper = new AlaportDatabaseHelper(view.getContext());
        SQLiteDatabase db = AlaportDataHelper.getReadableDatabase();
        tv=(TextView) view.findViewById(R.id.raspNamr);
        setLang(((MainActivity)getActivity()).lang);
        Cursor cursor = db.rawQuery("SELECT * FROM notification WHERE 1",null);
        notificats=new ArrayList<>();
        aa=new NotificationAdaptor(notificats,((MainActivity)getActivity()).lang, getActivity(), false, aMap);
        if(cursor.moveToFirst()){
            do {
                Log.d("MAKE",cursor.getString(0)+" "+cursor.getString(1));
                boolean ds=(cursor.getString(7).equals("deps"));

                Notificat not=new Notificat(cursor.getString(1),cursor.getString(4),cursor.getString(3),cursor.getInt(5),cursor.getString(2),Long.parseLong(cursor.getString(6)),ds);
                notificats.add(not);
            }
            while (cursor.moveToNext());
        }
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
                        float width = height / 3;
                        p.setColor(ContextCompat.getColor(getContext(), R.color.blueDrawer));
                        RectF background = new RectF((float) itemView.getRight() + dX, (float) itemView.getTop(), (float) itemView.getRight(), (float) itemView.getBottom());
                        c.drawRect(background, p);
                        icon =BitmapFactory.decodeResource(getResources(),R.drawable.deletecross);
                        RectF icon_dest = new RectF((float) itemView.getRight() - 2 * width, (float) itemView.getTop() + width, (float) itemView.getRight() - width, (float) itemView.getBottom() - width);
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
                    builder.setMessage(arusure);
                    builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
                        @Override
                        public void onCancel(DialogInterface dialogInterface) {
                            aa.notifyItemRangeChanged(position, aa.getItemCount());   //notifies the RecyclerView Adapter that positions of element in adapter has been changed from position(removed element index to end of list), please update it.
                            return;
                        }
                    }).setPositiveButton(rem, new DialogInterface.OnClickListener() { //when click on DELETE
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            aa.notifyItemRemoved(position);    //item removed from recylcerview
                            Notificat not=notificats.get(position);
                            SQLiteOpenHelper AlaportDataHelper = new AlaportDatabaseHelper(getContext());
                            SQLiteDatabase db = AlaportDataHelper.getReadableDatabase();
                            db.delete("notification","ID='"+not.flt+"'",null);
                            db.close();
                            notificats.remove(position);  //then remove item
                            return;
                        }
                    }).setNegativeButton(canc, new DialogInterface.OnClickListener() {  //not removing items if cancel is done
                        @Override
                        public void onClick(DialogInterface dialog, int which) {//notifies the RecyclerView Adapter that data in adapter has been removed at a particular position.
                            aa.notifyItemRangeChanged(position, aa.getItemCount());   //notifies the RecyclerView Adapter that positions of element in adapter has been changed from position(removed element index to end of list), please update it.
                            return;
                        }
                    }).show();
                }
            }

        };
        ItemTouchHelper itemTouchHelper=new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(rv);
        cursor.close();
        db.close();
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setAdapter(aa);

        return view;
    }
    public void setLang(String s){
        switch (s){
            case "E":
                tv.setText("Notifications");
                arusure="Are you sure to delete yout notification?";
                canc="Cancel";
                rem="Remove";
                conn="Connection trouble";
                break;
            case "K":
                tv.setText("Хабарламалар");
                arusure="Сіз хабарламаны өшіруге сенімдісіз бе?";
                conn="Ғаламтор жоқ";
                canc="Жою";
                rem="Өшіру";
                break;
            default:
                conn="Проблема подключения";
                arusure="Вы уверены что хотите удалить напоминание?";canc="Отмена";rem="Удалить";
                break;
        }
    }
}
