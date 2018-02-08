package com.dynamica.alaport;



import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dynamica.alaport.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class AviaGazFragment extends Fragment {

TextView t76;
    public AviaGazFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_avia_gaz, container, false);
        t76=(TextView) view.findViewById(R.id.textView76);
        t76.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/AvenirNext-Medium.ttf"));
        setLang(((AlaportInfoActivity)getActivity()).lang);
        return view;
    }
    public void setLang(String s){
        switch (s){
            case "E":
                t76.setText("Almaty International Airport JSC is the only fuel supplier at Almaty airport. To ensure the high quality storage of fuel, there are upgraded fuel tanks with capacity 5000, 3000, and 2000 cubic meters having a corrosion-resistant coating in the airport territory, which allow increasing the fuel cleanliness. In order to comply with the international quality standards concerning the aviation fuel, the Aviation Fuel Service of Almaty airport upgraded filters and loading racks, as well as new refuelers were bought in 2010.");
                break;
            case "K":
                t76.setText("«Халықаралық Алматы әуежайы»АҚ Алматы әуежайындағы авиаотынмен қамтамасыз ету бойынша жалғыз жеткізуші болып табылады. Авиаотынды жоғары сапада сақтау үшін әуежай аумағында жетілдірілген сыйымдылықтар орнатылған, оның ішінде сыйымдығы 5000, 3000 және 2000 текше метр тоттануға қарсы өңделген сыйымдылықтар. Авиаотын сапасы бойынша әлем стандарттарына толық сәйкес болу үшін Алматы әуежайының АвиаЖЖМ қызметі сүзгілер мен құйып/төгетін эстакадаларын жаңартып, 2010 жылы қосымша жаңа жанармай құйғыштар алды.");
                break;
        }
    }
}
