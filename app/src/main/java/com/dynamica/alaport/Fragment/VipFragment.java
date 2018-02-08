package com.dynamica.alaport.Fragment;


import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.transition.Fade;
import android.transition.Slide;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.dynamica.alaport.MainActivity;
import com.dynamica.alaport.R;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 * A simple {@link Fragment} subclass.
 */
public class VipFragment extends Fragment {
    String name, race, phone, mail;
    LinearLayout sendLin;
    Fragment fragment;
    ProgressBar pb;
    String sent, warning, all;
    EditText Name, Race, Phone, Mail;
    TextView vipname,racenum,phonenum,vipmail,sendT;
    String Fio,eFio,vRace,eRace,vPhone,ePhone,vMail,eMail, send;
    public VipFragment() {
        // Required empty public constructor
    }

    private class sendMail extends AsyncTask<String,Integer,String>{
        @Override
        protected void onPostExecute(String s) {
            switch (s){
                case "+":
                    Toast toast=Toast.makeText(getContext(),sent,Toast.LENGTH_LONG);
                    toast.show();

                    pb.setVisibility(View.INVISIBLE);
                    getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.fadein,R.anim.fadeout).replace(R.id.framevip,fragment).addToBackStack(null).commit();
                    Name.setText("");
                    Race.setText("");
                    Phone.setText("");
                    Mail.setText("");
                    break;
                case "-":
                    Toast toast1=Toast.makeText(getContext(),warning,Toast.LENGTH_LONG);
                    toast1.show();

                    break;
            }
            pb.setVisibility(View.INVISIBLE);
        }

        @Override
        protected String doInBackground(String... params) {
            Properties props=new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");
            props.put("mail.smtp.socketFactory.fallback", "false");
            Session session = Session.getDefaultInstance(props,
                    new Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            String username = "alaport.dynamica@gmail.com";
                            String password = "alaport12345";
                            return new PasswordAuthentication(username, password);
                        }
                    });
            String from="ALAPORT";
            MimeMessage ms=new MimeMessage(session);
            try{
                ms.setFrom(new InternetAddress(from));
                ms.setRecipient(MimeMessage.RecipientType.TO,new InternetAddress("vipserv@alaport.com"));
                ms.setSubject("New VIP client");
                ms.setText("Name: "+name+"\nphone: "+phone+"   email: "+mail+" \n"+"Рейс: "+race);
                Transport transport= session.getTransport("smtp");
                transport.connect();
                transport.sendMessage(ms,ms.getAllRecipients());
                transport.close();
                return "+";
            }
            catch (Exception e){
                e.printStackTrace();
                return "-";
            }

        }

        @Override
        protected void onProgressUpdate(Integer... values) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_vip, container, false);sendT=(TextView) view.findViewById(R.id.textView153);
        fragment=new BlankFragment();
        vipname=(TextView) view.findViewById(R.id.vipname);racenum=(TextView) view.findViewById(R.id.racenum);phonenum=(TextView) view.findViewById(R.id.phonenum);vipmail=(TextView) view.findViewById(R.id.vipMail);
        sendLin=(LinearLayout) view.findViewById(R.id.sendLayout);
        sendLin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pb.setVisibility(View.VISIBLE);
                sendMail();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        pb.setVisibility(View.INVISIBLE);
                    }
                }, 20000);
            }
        });
        Name=(EditText) view.findViewById(R.id.editName);
        Race=(EditText) view.findViewById(R.id.editRace);
        Phone=(EditText) view.findViewById(R.id.editPhone);
        Mail=(EditText) view.findViewById(R.id.editMail);
        sent="Заявка отправлена";
        all="Заполните все поля";
        warning="Проблемы с соеденением";
        pb=(ProgressBar) view.findViewById(R.id.progress);
        pb.setVisibility(View.INVISIBLE);
        switch(((MainActivity)getActivity()).lang){
            case "E":
                Fio="First & Last name";
                eFio="Enter your first name and last name";
                vRace="Flight number";
                eRace="Enter your flight number";
                vPhone="Phone";
                ePhone="Enter your phone number";
                vMail="E-Mail";
                eMail="Enter your e-mail";
                send="SEND";
                all="Enter all lines";
                warning="Connection trouble";
                sent="Successfully sent";
                setLang();
                break;
            case "K":
                Fio="Аты-жөні";
                eFio="Аты-жөніңізді енгізіңіз";
                vRace="Рейс нөмірі";
                eRace="Рейстің нөмірін енгізіңіз";
                vPhone="Телефон нөмірі";
                ePhone="Телефон нөмірін енгізіңіз";
                vMail="Эл. поштасы";
                eMail="Электрондық пошта";
                send="Жіберу";
                all="Мәліметтерді толық енгізіңіз";
                warning="Ғаламтор жоқ";
                sent="Жіберген";
                setLang();
                break;
        }
        return view;
    }
    public void setLang(){
        vipname.setText(Fio);
        racenum.setText(vRace);
        phonenum.setText(vPhone);
        vipmail.setText(vMail);
        Name.setHint(eFio);
        Race.setHint(eRace);
        Phone.setHint(ePhone);
        Mail.setHint(eMail);
        sendT.setText(send);
    }
    public void sendMail(){
        name=Name.getText()+"";
        race=Race.getText()+"";
        phone=Phone.getText()+"";
        mail=Mail.getText()+"";
        if(!mail.contains("@") || race.length()==0 || name.length()==0 || phone.length()==0){
            Toast toast=Toast.makeText(this.getContext(),all,Toast.LENGTH_SHORT);
            toast.show();
            pb.setVisibility(View.INVISIBLE);
        }
        else{
            new sendMail().execute("");
        }
    }
    public void Back(){
        if(getActivity().getSupportFragmentManager().getFragments().contains(fragment)){
                getActivity().getSupportFragmentManager().popBackStack();
        }
        else{
            ((MainActivity)getActivity()).Back();
        }
    }

    private void setupWindowAnimations() {
        Fade fade = new Fade();
        fade.setDuration(1000);
        getActivity().getWindow().setEnterTransition(fade);

        Slide slide = new Slide();
        slide.setDuration(1000);
        getActivity().getWindow().setReturnTransition(slide);
    }
}
