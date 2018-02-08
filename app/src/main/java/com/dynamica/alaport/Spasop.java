package com.dynamica.alaport;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dynamica.alaport.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Spasop extends Fragment {
    TextView tv76,tv77,tv78,tv79,tv80,tv81,tv82,tv83,tv84,tv85,tv86,tv87,tv88;
    LinearLayout whole, l8,l9,l11,l12,l10;

    public Spasop() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_spasop, container, false);
        whole=(LinearLayout) view.findViewById(R.id.whole);
        l8=(LinearLayout) view.findViewById(R.id.eight);
        l9=(LinearLayout) view.findViewById(R.id.nine);
        l11=(LinearLayout) view.findViewById(R.id.eleven);
        l12=(LinearLayout) view.findViewById(R.id.twelve);
        l10=(LinearLayout) view.findViewById(R.id.ten);
        tv76=(TextView) view.findViewById(R.id.textView76);
        tv77=(TextView) view.findViewById(R.id.textView77);
        tv78=(TextView) view.findViewById(R.id.textView78);
        tv79=(TextView) view.findViewById(R.id.textView79);
        tv80=(TextView) view.findViewById(R.id.textView80);
        tv81=(TextView) view.findViewById(R.id.textView81);
        tv82=(TextView) view.findViewById(R.id.textView82);
        tv83=(TextView) view.findViewById(R.id.textView83);
        tv84=(TextView) view.findViewById(R.id.textView84);
        tv85=(TextView) view.findViewById(R.id.textView85);
        tv86=(TextView) view.findViewById(R.id.textView86);
        tv87=(TextView) view.findViewById(R.id.textView87);
        tv88=(TextView) view.findViewById(R.id.textView88);
        tv76.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/AvenirNext-Medium.ttf"));
        tv77.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/AvenirNext-Medium.ttf"));
        tv78.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/AvenirNext-Medium.ttf"));
        tv79.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/AvenirNext-Medium.ttf"));
        tv80.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/AvenirNext-Medium.ttf"));
        tv81.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/AvenirNext-Medium.ttf"));
        tv82.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/AvenirNext-Medium.ttf"));
        tv83.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/AvenirNext-Medium.ttf"));
        tv84.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/AvenirNext-Medium.ttf"));
        tv85.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/AvenirNext-Medium.ttf"));
        tv86.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/AvenirNext-Medium.ttf"));
        tv87.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/AvenirNext-Medium.ttf"));
        tv88.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/AvenirNext-Medium.ttf"));
        setLang(((AlaportInfoActivity)getActivity()).lang);
        return view;
    }
    public void setLang(String s){
        switch(s){
            case "E":
                tv76.setText("The main task of the Search and Rescue Service of Almaty International Airport is timely rendering of assistance to aircraft in emergencies. There are the most advanced rescue and fire-fighting equipments in the Service which have high dynamic characteristics and able to ensure a maximum level of fire protection on the airfield according to ICAO requirements:");
                tv77.setText("Rescue and fire station at runway-2");
                tv78.setText("Recovery lifting bags");
                tv79.setText("Recovery dolly 90-2200");
                tv80.setText("Tow bar 87164000");
                tv81.setText("Recovery dolly 7-1000");
                tv82.setText("Ground reinforcement mats");
                tv83.setText("Fire tender Cobra");
                tv84.setText("Aerodrome fire tender АА-8.0/55");
                tv85.setText("KAMAZ 43118");
                tv86.setText("Fire vehicle АСО-20 on chassis of KAMAZ 43114");
                tv87.setText("Aerodrome fire vehicle АА-12/60 INVECO");
                tv88.setText("Microbus GAZ 322131-95");
                break;
            case "K":
                tv76.setText("Халықаралық Алматы әуежайының Өртке қарсы және ұшу апаттарынан құтқаруды қамтамасыз ету қызметінің басты мақсаты – апаттық жағдайда авиакомпаниялардың әуе кемелеріне дер кезінде көмек көрсету.\n" + "Қызмет жоғары динамикалық сапаға ие, жоғары технологиялық өрттік-техникалық құралдармен жабдықталған және аэроалаңды ИКАО талаптарына сай ең жоғары деңгейде өрттен қорғауды қамтамасыз ете алатын қазіргі заманғы апаттық-құтқару және өртке қарсы техникамен қамтамасыз етілген.\n" + "Арнайы көліктердің 3-4 минут ішінде аэроалаңның кез-келген нүктесіне жеткізіп, сол уақытта 60 тонналық өрт сөндіру құралдарын алып шығуға мүмкіндігі бар, және олар жүргізуші кабинасынан басқарып отыратын өрт сөндіру сорғыларымен және монитормен жабдықталған. ӨҚжҰАҚҚҚ әскери көліктері көмірқышқылды, сукөбікті және ұнтақты өрт сөндіру амалдарын жүзеге асыра алады.\n" + "Қызмет, сондай-ақ, апатты әуе кемелерінде барлық құтқару жұмыстарын жүргізуге мүмкіндік беретін арнайы апаттық-құтқару техникасымен жабдықталған. Олар – шынжыр табанды және дөңгелекті тартқыштар, жеке электр генераторлары бар байланыс және жарық беру автокөліктері, сатылар.\n" + "Қызметтің апаттан құтқару станциясы қадағалау мұнарасынан тәулік бойы әуе кемелерінің ұшып-қонуына, құстар тобының қозғалысына, әуежай нысандарындағы өрт қауіпсіздігі жағдайына бақылау жасап отыратын аэроалаңның негізгі бақылау нүктесіне жақын орналасқан.\n" + "Ұшу алаңынан қозғалуға қабілетсіз әуе кемелерін көшіруді қамтамасыз ету үшін апаттық көшіру жабдығы бар:\n");
                tv77.setText("Буксиров. Водило 87164000");
                tv78.setText("Шассидің тұмсық және негізгі тіреулеріне арналған сүйрегіш (көшіргіш) арбалар жиынтығы.");
                tv79.setText("Төменгі қысымды ауа компрессорымен жабдықталған ауаны реттейтін және тарататын пульті бар пневмоматалы көтергіштер жиынтығы");
                tv80.setText("Арқалығы бар иілгіш фюзеляждық және қанаттық ленталы строптар жиынтығы");
                tv81.setText("Салмақты бақылайтын құрылғысы бар сүйрегіш құралдар жиынтығы");
                tv82.setText("Топырақты нығыздайтын металл-торлы төсемдер жиынтығыs");
                whole.removeView(l8);
                whole.removeView(l9);
                whole.removeView(l10);
                whole.removeView(l11);
                whole.removeView(l12);
                break;
        }
    }
}
