package com.dynamica.alaport;


import android.content.Context;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dynamica.alaport.R;
import com.dynamica.alaport.dummy.AppStatus;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;


/**
 * A simple {@link Fragment} subclass.
 */
public class RaspFragment extends Fragment {
    boolean deps;
    FrameLayout fmProg;
    ProgressBar pb;
    TextView raspNamr;
    TextView raspCity;
    TextView arrdepT, t154;
    ImageView arrdepI;
    String conn;
    FrameLayout fm;
    RelativeLayout arrdep;
    View frag;
    FrameLayout recFrame;
    LinearLayout lMain;
    LinearLayout lCity;
    getXml3 x3;
    getXml4 x4;
    LinearLayout back;
    View view;
    EditText et;
    RecyclerView rvCity;
    RecyclerView rvRasp;
    SwipeRefreshLayout srl;
    public ArrayList<LongTime> longs;
    public ArrayList<LongTime> lt;
    public ArrayList<LongTime> ltF;
    public ArrayList<LongTime> rt;
    public ArrayList<LongTime> rtF;
    ArrayList<String> fu;
    HashSet<String> set;
    TopList arr,dep;
    String lang, raspName, search, arrTs,depTs;
    public class getXml3 extends AsyncTask<Practice,Integer, String> {
        boolean running=true;
        protected String doInBackground(Practice... practices) {
            if(running){
            try {
                int count = practices.length;
                return practices[0].getXml();
            } catch (Exception e) {e.printStackTrace();return " ";}
            }
            else{
                return " ";
            }
        }
        @Override
        protected void onCancelled() {
            running = false;
        }
        protected void onProgressUpdate(Integer... ints){}
        protected void onPostExecute(String result){try{if(!result.equals(null))if(result.length()>1){((MainActivity)getActivity()).setLongArrs(result);new parseAr().execute(result);} else{ Toast.makeText(getActivity(),conn,Toast.LENGTH_SHORT).show();}}
        catch (Exception e){ }

        }
    }

    public class getXml4 extends AsyncTask<Practice,Integer, String> {
        boolean running=true;
        protected String doInBackground(Practice... practices) {
            if (running) {
                try {
                    int count = practices.length;
                    return practices[0].getXml();
                } catch (Exception e) {
                    e.printStackTrace();
                    return " ";
                }
            }
            else return " ";
        }
        protected void onProgressUpdate(Integer... ints){}
        @Override
        protected void onCancelled() {
            running = false;
        }
        protected void onPostExecute(String result){try {
            if (running) if (!result.equals(null)) if (result.length() > 1) {
                ((MainActivity) getActivity()).setLongDeps(result);
                new parseDep().execute(result);
            } else {
                Toast.makeText(getActivity(), conn, Toast.LENGTH_SHORT).show();
            }
        }
        catch (Exception e){
            e.printStackTrace();
            Toast.makeText(getActivity(), conn, Toast.LENGTH_SHORT).show();
        }
        }
    }
    public class parseAr extends AsyncTask<String,Integer,ArrayList<LongTime>>{
        @Override
        protected void onPostExecute(ArrayList<LongTime> longTimes) {
            pb.setVisibility(View.INVISIBLE);parse(false,longTimes);
        }

        @Override
        protected ArrayList<LongTime> doInBackground(String... params) {
            Parser parser=new Parser();
            ltF=parser.LongParsing(params[0]);
            lt.clear();
            lt.addAll(ltF);
            set=parser.set;
            return lt;
        }
        protected void onProgressUpdate(Integer... ints){}
    }
    public class parseDep extends  AsyncTask<String, Integer,ArrayList<LongTime>>{
        @Override
        protected void onPostExecute(ArrayList<LongTime> longTimes) {
            parse(true,longTimes);
        }

        @Override
        protected ArrayList<LongTime> doInBackground(String... params) {

            Parser parser=new Parser();
            rtF=parser.LongParsing(params[0]);
            rt.clear();
            rt.addAll(rtF);
            set.addAll(parser.set);
            return rt;
        }
        protected void onProgressUpdate(Integer... ints){}
    }
    public RaspFragment() {
        // Required empty public constructor
    }

    @Override
    public void onResume(){
        super.onResume();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_rasp,container,false);
        this.view=view;
        pb=(ProgressBar) view.findViewById(R.id.progressBar);
        fmProg=(FrameLayout) view.findViewById(R.id.frameProg);
        pb.setVisibility(View.INVISIBLE);
        srl=(SwipeRefreshLayout) view.findViewById(R.id.srl);
        t154=(TextView) view.findViewById(R.id.textView154);
        lang=((MainActivity)getActivity()).lang;
        switch (lang){
            case "K":
                raspName="Кесте";
                search="Қаланы іздеу";
                arrTs="Ұшып келу";
                conn="Ғаламтор жоқ";
                depTs="Ұшып кету";
                break;
            case "E":
                raspName="Schedule";

                search="Search by city";
                arrTs="Arrivals";
                conn="Connection trouble";
                depTs="Departures";
                break;
            default:
                raspName="Расписание";
                conn="Проблема подключения";
                search="Поиск городов";
                arrTs="Прилеты";
                depTs="Вылеты";
                break;
        }
        t154.setText(raspName);
        if(Calendar.getInstance().getTimeInMillis()-((MainActivity)getActivity()).timmillis2>150000 || ((MainActivity)getActivity()).longArrs.equals(" ") || ((MainActivity)getActivity()).longArrs.equals("")) {
            ((MainActivity) this.getActivity()).rasp();
          //  Log.d("RaspFragment","First");
            if(AppStatus.getInstance(getActivity()).isOnline()){
                x3=new getXml3();
                x3.execute(new Practice("http://www.alaport.com/year_xml_eng.php?t=arr"));
                x4=new getXml4();
                x4.execute(new Practice("http://www.alaport.com/year_xml_eng.php?t=dep"));
                pb.setVisibility(View.VISIBLE);
            }
            else{
                Toast.makeText(getActivity(),conn,Toast.LENGTH_SHORT).show();
            }
        }
        else{
          //  Log.d("RaspFragment","Second");
            new parseAr().execute(((MainActivity)getActivity()).longArrs);
            new parseDep().execute(((MainActivity)getActivity()).longDeps);
        }
        deps=false;
        lt=new ArrayList<>();ltF=new ArrayList<>();rt=new ArrayList<>();rtF=new ArrayList<>();

        arrdepT=(TextView) view.findViewById(R.id.textView9);
        arrdepT.setTypeface(arrdepT.getTypeface(),Typeface.BOLD);
        arrdepI=(ImageView) view.findViewById(R.id.imageView10);
        raspNamr=(TextView) view.findViewById(R.id.raspNamr);
        recFrame=(FrameLayout) view.findViewById(R.id.recFrame);
        fm=(FrameLayout)view.findViewById(R.id.frameLong);
        frag= view.findViewById(R.id.fragment4);
        srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                ((MainActivity)getActivity()).refreshL();
            }
        });
        arrdep=(RelativeLayout) view.findViewById(R.id.arrddep);
        lMain=(LinearLayout) view.findViewById(R.id.longCities);
        raspCity=(TextView) view.findViewById(R.id.raspCity);
        lCity=(LinearLayout) view.findViewById(R.id.longOne);
        back=(LinearLayout) view.findViewById(R.id.backLong);
        rvCity=(RecyclerView) view.findViewById(R.id.rvCity);
        rvRasp=(RecyclerView) view.findViewById(R.id.rvRasp);
        rvCity.setAdapter(new RecyclerView.Adapter() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return null;
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

            }

            @Override
            public int getItemCount() {
                return 0;
            }
        });
        removeChoose();
        et=(EditText) view.findViewById(R.id.editText2);
        setLang();
        longs=new ArrayList<>();
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                onSearch(et.getText()+"");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        ((ImageView) view.findViewById(R.id.imageView8)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSearch(et.getText()+"");
            }
        });
        arrdep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(recFrame.getChildCount()==1){
                    setChoose();
                }
                else{
                    removeChoose();
                }
            }
        });

        LinearLayoutManager qwe=new LinearLayoutManager(getActivity());
        rvCity.setLayoutManager(qwe);
        rvRasp.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvCity.setItemAnimator(new DefaultItemAnimator());
        rvRasp.setItemAnimator(new DefaultItemAnimator());
        set=new HashSet<>();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeAll();
            }
        });

        removeAll();
        return view;
    }
    public void setLang(){
        arrdepT.setText(arrTs);
        raspNamr.setText(raspName);
        et.setHint(search);
    }
    public void parse(boolean deps, ArrayList<LongTime> a){
        fu=new ArrayList<String>(set);
        Collections.sort(fu,String.CASE_INSENSITIVE_ORDER);
        rvCity.setAdapter(new CityAdapter(fu,"R",this.deps, RaspFragment.this));

        if(!deps){
            arr=new TopList(lt, lang, getActivity());
            rvRasp.setAdapter(arr);
        }
        else{
            dep=new TopList(rt, lang, getActivity());
        }
    }
    @Override
    public void onDestroyView(){
        super.onDestroyView();
        if(x3!=null){
            x3.onCancelled();
            x4.onCancelled();
        }
    }
    public void onSearch(String s){
        ArrayList<String> fo;
        if(s.equals("")){
            fo=new ArrayList<>();
        }
        else {
            fo=new ArrayList<>();

            for (String i : set) {
              //  Log.d("Contains",i);
                if (i.toLowerCase().startsWith(s.toLowerCase())) {

                    fo.add(i);
                }
            }

        }
        if(fo.size()==0){
            fo.clear();
            fo.addAll(set);
        }
        Collections.sort(fo,String.CASE_INSENSITIVE_ORDER);
        rvCity.setAdapter(new CityAdapter(fo,"R",deps, RaspFragment.this));
    }
    public void removeAll(){
        if(fm.getChildAt(0)==lMain && recFrame.getChildAt(1)!=frag){
            ((MainActivity)getActivity()).Back();
        }
        else {
            fm.removeAllViews();
            fm.addView(lMain);
            fm.addView(fmProg);
        }
    }
    public void setCity(String s){
        hideKey();
        if(s.length()>14){
            raspCity.setTextSize(12);
            raspCity.setText(s);
        }
        else if(s.length()>8){
            raspCity.setTextSize(15);
            raspCity.setText(s);
        }
        else {
            raspCity.setTextSize(17);
            raspCity.setText(s);
        }
      //Log.d("Cities","This city is "+s);
        fm.removeAllViews();
        fm.addView(lCity);
        lt.clear();
        rt.clear();
        for(LongTime i:ltF){
            if(i.city.equals(s)){
                lt.add(i);
            }
        }
        for(LongTime i:rtF){
            if(i.city.equals(s)){
                rt.add(i);
            }
        }
        rvRasp.getAdapter().notifyDataSetChanged();

    }
    public void setArrs(){
        removeChoose();
        rvRasp.setAdapter(arr);
        arrdepT.setText(arrTs);
        arrdepI.setImageResource(R.drawable.plandeps);
    }
    public void setDeps(){
        removeChoose();
        rvRasp.setAdapter(dep);
        arrdepT.setText(depTs);
        arrdepI.setImageResource(R.drawable.planarrival);
    }
    public void setChoose(){
        hideKey();
        recFrame.removeAllViews();
        recFrame.addView(srl);
        recFrame.addView(frag);
        rvCity.setAlpha(Float.valueOf("0.15"));
    }
    public void removeChoose(){
        hideKey();
        recFrame.removeAllViews();
        recFrame.addView(srl);
        rvCity.setAlpha(1);
    }
    public void hideKey(){
        InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
