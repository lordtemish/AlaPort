package com.dynamica.alaport.Fragment;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dynamica.alaport.AlaportInfoActivity;
import com.dynamica.alaport.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MultiModalFragment extends Fragment {
    TextView tv120,tv121,tv88,tv1,tv2,tv4,tv5,tv6,tv7,tv3;

    public MultiModalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_multi_modal, container, false);
        tv120=(TextView) view.findViewById(R.id.textView120);tv120.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/AvenirNext-Medium.ttf"));
        tv121=(TextView) view.findViewById(R.id.textView121);tv121.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/avenir-light.ttf"));
        tv88=(TextView) view.findViewById(R.id.textView88);tv88.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/AvenirNext-Medium.ttf"));
        tv1=(TextView) view.findViewById(R.id.textView1);tv1.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/AvenirNext-Medium.ttf"));
        tv2=(TextView) view.findViewById(R.id.textView2);tv2.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/AvenirNext-Medium.ttf"));
        tv4=(TextView) view.findViewById(R.id.textView4);tv4.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/AvenirNext-Medium.ttf"));
        tv5=(TextView) view.findViewById(R.id.textView5);tv5.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/AvenirNext-Medium.ttf"));
        tv6=(TextView) view.findViewById(R.id.textView6);tv6.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/AvenirNext-Medium.ttf"));
        tv7=(TextView) view.findViewById(R.id.textView7);tv7.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/AvenirNext-Medium.ttf"));
        tv3=(TextView) view.findViewById(R.id.textView3);tv3.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/AvenirNext-Medium.ttf"));
        setLang(((AlaportInfoActivity)getActivity()).lang);
        return view;
    }
    public void setLang(String s){
        switch (s){
            case "K":
                tv120.setText("Орта Азиядағы ең ірі мультимодалды терминал");
                tv121.setText("Халықаралық Алматы әуежайы хаб статусына ие. Халықаралық көлік – дистрибьютерлік торап Азия-Еуропа-Азия бағытындағы негізгі жүк ағымдарын тартуға бағытталған." + "Алдағы уақытта Халықаралық Алматы әуежайы 60 миллионға жуық адамы бар барлық Орта Азия өңіріндегі нарығы үшін жүк хабының барлық артықшылығын дамытуға мүмкіндігі зор. 2007 жылы Халықаралық Алматы әуежайының құрамындағы Жүк тасымалдау қызметі ISO 9001-2000 халықаралық сапа сертификатын алды. Жүк тасымалдау қызметінің білікті персоналы халықаралық тренингтерден өткен, сонымен қатар қауіпті жүк пен паллетайзингтерді рәсімдеуге арналған сертификаттарына ие.\n" + " \n" + "Халықаралық Алматы әуежайының қолданыстағы жүк терминалының жалпы аймағы 28000 ш.м. құрайды, соның ішінде уақытша сақтау қоймалары мен транзиттік-трансферлік аймақтар. Терминалда қауіпті жүктерді сақтауға арналған орындар, ірі габаритті жүктерге арналған жабық бөлмелер, халықаралық талаптарға сәйкес келетін техникалық және өндірістік параметрлер, бағалы жүктерді сақтауға арналған сейфтер, жалпы көлемі 240 м3 және температуралық режимі +10 С0 тан 18С0 дейінгі тозаңытқыш камералар бар. Жүкті тиеп-түсіру жұмыстарына арналған техниканың барлық түрімен жабдықталған қоймалар халықаралық талаптарға сай.");
                tv88.setText("Халықаралық Алматы әуежайының қолданыстағы жүк терминалының жалпы аймағы 5,5 га. Құрайды ");
                tv1.setText("«А» класстағы жылыту жүйесі бар жабық қойма алаңы 20000 м2");
                tv2.setText("Рельс бойындағы қойма 2700 м2");
                tv4.setText("Бағалы жүктерді сақтауға арналған сейфтер, жалпы көлемі 240 м3 және температуралық режимі +10 С0 тан 18С0 дейінгі тозаңытқыш камералар ");
                tv5.setText("Заманауи бейнебақылау жүйесі");
                tv6.setText("Жүкті есепке алу бойынша көпфункционалды бағдарламалық жасау");
                tv7.setText("E-freight стандарттағы электронды хабарламалармен алмасу");
                tv3.setText("TREPEL компаниясының паллеттік/ контейнерлік тиеп/түсіру техникасы");
                break;
            case "E":
                tv120.setText("The largest multimodal terminal in the Central Asia");
                tv121.setText("Almaty International Airport has international - distribution transport hub status, focused on attracting major freight flows in the Asia - Europe - Asia. In the short term, Almaty International Airport is able to develop all the advantages of cargo hub for the whole Central Asian region with a population of over 60 million people. In 2007, Freight Service as part of Almaty International Airport, received the international quality certificate ISO 9001-2000, which corresponds to the requirements of the quality management system. Freight Service has qualified personnel who have received international training and having certificates for registration of dangerous cargo and palletizing.\n" + " \n" + "The total area of the existing cargo terminal at Almaty International Airport is 28 000 square meters, including temporary storage, and the territory of transit-transfer zone. In the terminal there are specially marked places for storage of dangerous cargo covered areas for bulky cargo, safe storage of goods, cold stores with total volume of 240 cubic meters and temperature from +10°C to -18°C. Warehouses equipped with all kinds of equipment for loading and unloading operations, technical and production parameters in line with international requirements.");
                tv88.setText("The total area of the existing cargo terminal at Almaty International Airport is 5.5 hectares.");
                tv1.setText("Heated indoor warehouse class \"A\" area of 20,000 m2");
                tv2.setText("Separate warehouse with railroad 2700 m2");
                tv4.setText("Lockers for storage of valuable cargo, refrigerated cells totaling 240m3");
                tv5.setText("The modern CCTV system ");
                tv6.setText("Multifunctional cargo management software");
                tv7.setText("E-freight standard electronic messaging");
                tv3.setText("TREPEL pallet/container cranes.");
                break;
        }
    }
}
