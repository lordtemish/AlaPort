package com.dynamica.alaport.Fragment;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dynamica.alaport.HealthyInfoActivity;
import com.dynamica.alaport.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class LuggageLimitFragment extends Fragment {

    ArrayList<TextView> tvs=new ArrayList<>();
    TextView tv140,tv141;
    int[] a={
            R.id.textView21,
            R.id.textView22,
            R.id.textView23,
            R.id.textView24,
            R.id.textView25,
            R.id.textView26,
            R.id.textView27,
            R.id.textView28,
            R.id.textView29,
            R.id.textView30
    };
    public LuggageLimitFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_luggage_limit, container, false);
        tv140=(TextView) view.findViewById(R.id.textView140);
        tv140.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/Avenir-Heavy.ttf"));
        tv141=(TextView) view.findViewById(R.id.textView141);
        tv141.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/AvenirNext-Medium.ttf"));
        tvs=new ArrayList<>();
        for (int i=0;i<10;i++){
            tvs.add((TextView) view.findViewById(a[i]));
            tvs.get(i).setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/AvenirNext-Medium.ttf"));
        }
        setLang(((HealthyInfoActivity)getActivity()).lang);
        return view;
    }
    public void setLang(String s){
        switch (s){
            case "E":
                tv140.setText("Dangerous items and substances prohibited for carriage on board the civil aircraft:");
                String[] q=("all types of firearms\n" +
                        "explosives, items filled with the explosives, and blasting devices\n" +
                        "cold arms\n" +
                        "radioactive substances\n" +
                        "compressed and liquefied gases, and ammunition for gas weapon\n" +
                        "highly inflammable liquids\n" +
                        "inflammable solid substances\n" +
                        "tpoisonous and toxic substances\n" +
                        "caustic and corrosive substances\n" +
                        "narcotic drugs\n").split("\n");
                for(int i=0;i<10;i++){
                    tvs.get(i).setText(q[i]);
                }
                tv141.setText("All other substances, cargoes, and items related to the abovementioned ones, which give rise to doubt about the safety.\n" +
                        "Please do not:\n" +
                        "•\tleave your baggage and cabin baggage unattended,\n" +
                        "•\ttake any baggage, cabin baggage, envelope or parcel for carriage from other persons,\n" +
                        "as they may contain items and substances prohibited for carriage on board the aircraft.\n" +
                        "The persons who are guilty of violation of rules for carriage of dangerous goods will be brought to administrative and criminal responsibility");
                break;
            case "K":
                tv140.setText("Азаматтық әуе кемелерімен тасымалдауға тыйым салынған қауіпті заттар:");
                String[] qq=("Оқпен атылатын қарулардың барлық түрлері\n" +
                        "Жарылғаш заттар, жарылғыш құралдар\n" +
                        "Суық қару\n" +
                        "Радиоактивті заттар\n" +
                        "Сығылған және сұйытылған заттар\n" +
                        "Тез тұтанатын сұйықтықтар\n" +
                        "Тез тұтанатын қатты заттар\n" +
                        "Улы және уландырғыш заттар\n" +
                        "Күйдіргіш, тотыққыш заттар\n" +
                        "Есірткілік заттары").split("\n");
                for(int i=0;i<10;i++){
                    tvs.get(i).setText(qq[i]);
                }
                tv141.setText("Жоғарыда аталған заттардың белгілері бар, қауіпсіздікке күдік тудыратын барлық басқа заттар.\n" +
                        "Көптен-көп өтініш:\n" +
                        "•\tБагаж және қол жүктеріңізді қараусыз қалдырмаңыздар;\n" +
                        "•\tБөтен адамдардан тасымалдауға жүк, қол жүгін, конверт және басқа посылка алмаңыздар, өйткені оның ішінде әуе кемесінің бортында тасымалдауға тыйым салынған заттар болуы мүмкін.\n" +
                        "Қауіпті заттарды тасымалдау ережелерін бұзған тұлғалар әкімшілік және қылмыстық жауапкершілікке тартылады.");
                break;
        }
    }
}
