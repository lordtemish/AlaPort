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
public class AirportAlaFragment extends Fragment {
    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7;

    public AirportAlaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_airport_ala, container, false);
        tv1=(TextView) view.findViewById(R.id.textView69);
        tv2=(TextView) view.findViewById(R.id.textView70);
        tv3=(TextView) view.findViewById(R.id.textView71);
        tv4=(TextView) view.findViewById(R.id.textView72);
        tv5=(TextView) view.findViewById(R.id.textView73);
        tv6=(TextView) view.findViewById(R.id.textView74);
        tv7=(TextView) view.findViewById(R.id.textView75);
        tv1.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/Avenir-Heavy.ttf"));
        tv2.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/avenir-light.ttf"));
        tv3.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/avenir-light.ttf"));
        tv4.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/avenir-light.ttf"));
        tv5.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/avenir-light.ttf"));
        tv6.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/avenir-light.ttf"));
        tv7.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/avenir-light.ttf"));
        setLang(((AlaportInfoActivity)getActivity()).lang);
        return view;
    }
    public void setLang(String s){
        switch (s){
            case "K":
                tv1.setText("ӘУЕЖАЙ");
                tv2.setText("Халықаралық Әуежай (Алматы, Қазақстан) Оңтүстік-Шығыс Азия мен Еуропа арасындағы тиімді географиялық ортада орналасқан.\n" + "Біздің қаламыз арқылы көне заманда Қытайдан әлемнің түкпір-түкпіріне жол салған Ұлы Жібек Жолы өтеді.\n" + "Халықаралық Алматы әуежайының еліміздегі жетекші әуежай ретіндегі жоғары мәртебесі онда көрсетілетін қызметті үнемі жетілдіріп, сапасын арттырып отыруды талап етеді. Сондықтан Алматы әуежайының басшылығы техникалық жабдықты заман талабына сай жаңалап, қызметкерлердің кәсіби біліктілігін жетілдіріп отыруды әуежай дамуының басым бағыты деп есептейді.\n" + "Қазіргі кезде Халықаралық әуежайдың басшылары әуежай қызметін пайдаланушы авиакомпаниялардың Боинг 747 тәрізді кең фюзеляжды әуе кемелерін Алматы әуежайында техникалық мақсатта қабылдап, оларды жүк тасымалдау жұмысына тарту мақсатында ауқымды жұмыс атқаруда. В-747 әуе кемелеріне жанармай құю үшін Алматы әуежайын пайдалана отырып, авиакомпаниялар жүк тиеу мүмкіндіктерін арттырып, қосымша пайдаға қол жеткізеді.");
                tv3.setText("Қазан айында Волга-Днепр, Антонов авиажолдары авиакомпанияларының рейстері ашылып, олармен жердегі көрсетілетін қызмет жөнінде шарт жасалды. Сонымен қатар, Ан-124 (Руслан) (ең жоғарғы ұшып көтерілу салмағы 392 тонна) жүк әуе кемелерін пайдаланушы «Полет» авиакомпаниясының өкілдерімен келіссөздер жүргізілді");
                tv4.setText("Ил-76 (ең жоғарғы көтерілу салмағы – 190 тонна) әуе кемелерімен орындалатын Газпром және Добролет авиакомпанияларының рестері ұшуды бастады, рейстер аптасына 4 рет орындалады;");
                tv5.setText("Халықаралық Ганновер, Франкфурт, Берлин, Гандер әуежайлары тарапынан өзара тиімді ынтымақтастық жөнінде ұсыныстар түсіп, олардың өкілдерімен келіссөздер жүргізілді");
                tv6.setText("China Southwest Airlines (Қытай) авиакомпаниясы өкілдерімен, сондай-ақ Люксембургтың Көлік Министрлігі өкілдерімен Cargolux авиакомпаниясы рейстерін Алматы әуежайы арқылы ұшыру туралы келіссөздерді ұйымдастыру жұмыстары жүргізілуде");
                tv7.setText("Көптеген алдыңғы қатарлы шетелдік авиакомпаниялар біздің әуежайды өздерінің тұрақты рейстерін жүзеге асыру үшін де, техникалық мақсатта қону үшін де пайдаланады. Атап айтқанда.");
                break;
            case "E":
                tv1.setText("AIRPORT");
                tv2.setText("The Almaty International Airport (Almaty, Kazakhstan) has an advantageous geographical location on the route from South-Eastern Asia to Europe and back.\n" + "The Great Silk Road from China to other parts of the globe passes through our city since the earliest times. The high status of the leading airport of the Republic makes it necessary to provide services that are continually improved and modern. Thus, up to date technology and advanced qualifications of personnel to match, is one of the priority directions in the Almaty airport’s management action plan.\n" + "Currently the Almaty International Airportpersonnel works hard to improve the facilities making able the technical landing ofand cargo transportations with such largeaircrafts as Boeing 747. Using the Almaty airport for the re-fueling of Boeing 747 aircrafts allows for economic benefits to the airlines as the aircrafts' capacity may be increased.");
                tv3.setText("The management of the Almaty airport concluded agreements on rendering surface maintenance and since October 2002 started implementing flights by “Volga – Dnepr” and “Antonov Airlines” air companies, as well as holding negotiations with representatives from “Polet” air company which uses cargo aircraft Antonov124 (Rouslan) (maximum flight mass 392 tones)");
                tv4.setText("Flights by “Gazprom” and “Dobrolyot” air companies on aircrafts ILyushin76 (maximum flight mass 190 tones) were implemented with 4 flights per week");
                tv5.setText("Proposals on mutually beneficial cooperation and negotiations with representatives from the international airports of Hanover, Frankfurt, Berlin, Gander were received");
                tv6.setText("Finally, initial preparations for negotiations with representatives from the Luxemburg Ministry of Transport in order to attract the “Cargolux” air company to bring flights to the Almaty Airport, and negotiations with representatives of “China Southwest Airlines” air company were held");
                tv7.setText("Many leading foreign air companies have chosen our airport for implementing regular flights and technical landings.");
                break;
        }
    }

}
