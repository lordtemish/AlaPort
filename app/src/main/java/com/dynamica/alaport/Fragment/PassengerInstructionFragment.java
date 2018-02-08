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

/**
 * A simple {@link Fragment} subclass.
 */
public class PassengerInstructionFragment extends Fragment {
    TextView tv,tv156,tv157,tv158;

    public PassengerInstructionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_passenger_instruction, container, false);
        tv=(TextView) view.findViewById(R.id.textView155);
        tv.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/avenir-light.ttf"));
        tv157=(TextView) view.findViewById(R.id.textView157);
        tv157.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/AvenirNext-Medium.ttf"));
        tv158=(TextView) view.findViewById(R.id.textView158);
        tv158.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/AvenirNext-Medium.ttf"));
        tv157.setText("\"О порядке производства контрольной проверки техническими средствами, досмотра пассажиров и изъятия веществ и предметов, запрещенных к провозу на гражданских ВС\"");
        tv.setText("1.Контрольная проверка (досмотр) проводится в интересах безопасности пассажиров в целях предотвращения актов незаконного вмешательства в деятельность ГА.\n" +
                "2.Лично – выборочный досмотр производится в случае возникновения подозрений на наличие у пассажира запрещенных к перевозке на борту воздушного судна предметов и веществ, которые были выявлены при прохождении досмотра с использованием технических средств досмотра: рентгенотелевизионной установки, стационарного и ручного металлоискателей, а также по оперативной информации.\n" +
                "3.Пассажиру предоставляется право выбора процедуры следующего этапа досмотра: " +
                "\n" +
                "Бесконтактный досмотр с помощью специальной рентгеновской установки «Secure – 1000» или личный ручной досмотр в специальной комнате обученным персоналом службы досмотра АО «Международный аэропорт Алматы». " +
                "\n" +
                "Конфиденциальность этих процедур гарантируется !\n" +
                "4.Пассажир, отказавшийся от прохождения процедуры досмотра, на борт воздушного судна не допускается.");
        tv158.setText("«Для сведения пассажиров»\n" +
                "Внутри или снаружи здания: в день 25 мкР\n" +
                "Доза пассажиров во время полета\n" +
                "Один рейс (1 час): в час до 500 мкР \n" +
                "За одно сканирование устройством «Secure– 1000» " +
                "- 0,94 мкЗ или 94 мкР");
        setLang(((HealthyInfoActivity)getActivity()).lang);
        return view;
    }
    void setLang(String s){
        switch (s){
            case "K":
                tv157.setText("\"Техникалық құралдармен жолаушыларды бақылаудан өткізу тәртібі және азаматтық ӘК тасымалдауға тыйым салынған заттарды алып қалу туралы\"");
                        tv.setText("1.\tТексеру (досмотр) жұмыстары жолаушылардың қауіпсіздігі үшін АА қызметіне заңсыз қол сұғу әрекеттерінің алдын алу мақсатында орындалады.\n" +
                        "2.\tЖеке іріктеп тексеру жұмыстары техникалық құралдарды пайдалану арқылы (олар: рентгендік-теледидарлық қондырғы; стационарлық және қолмен тексеру, сондай-ақ жедел ақпарат) жолаушыны тексеру нәтижесінде айқындалған, әуе кемесінің бортында тасымалдауға тыйым салынған заттар болу күдігі туындаған жағдайда орындалады.\n" +
                        "3.\tЖолаушыға тексерудің келесі кезең процедураларын таңдау құқығы беріледі: \n" +
                        "\n" +
                        "- арнайы «Secure – 1000» рентгендік құрылғы арқылы контактысыз тексеру немесе арнайы бөлмеде «Халықаралық Алматы әуежайы»АҚ тексеру қызметінің қызметкерлерінің тексеруі.\n" +
                        "\n" +
                        "Бұл процедураның құпиялылығына кепілдік беріледі !\n" +
                        "4.\tТексеру процедурасынан бас тартқан жолаушы әуе кемесінің бортына жіберілмейді.\n");
                tv158.setText("«Жолаушылар назарына»\n" +
                        "Ғимараттың ішінде немесе сыртында: күніне 25 мкР \n" +
                        "Ұшу барысындағы жолаушылар мөлшері (доза):\n" +
                        "Бір рейс (1сағат): сағатына 500 мкР дейін \n" +
                        "«Secure– 1000» жабдығымен бір рет сканерлеу - 0,94 мкЗ немесе 94 мкР");
                break;
            case "E":
                tv157.setText("Procedure of control inspection by technical means, passenger inspection, and confiscation of substances and items prohibited for carriage on civil aircraft."+"Confidentiality of these procedures is guaranteed!" );
                        tv.setText(
                        "1.\tControl inspection (security check) is carried out for passenger safety for the purpose of prevention of unlawful interference with activity of civil aviation.\n" +
                        "2.\tPersonal and random inspection is carried out in case of any suspicion that a passenger has any item or substance prohibited for carriage on board the aircraft which were detected during the inspection using technical means such as X-ray television equipment, stationary and hand-held metal detectors, and as per operation information as well.\n" +
                        "3.\tA passenger may choose the procedure of the following security check steps:\n" +
                        "contact-free inspection using the special X-ray equipment Secure-1000, or personal inspection in a special room to be carried out by trained personnel of the Security Check Service of Almaty International Airport JSC.\n" +
                        "4.\tA passenger who refused to pass the inspection will not be admitted on board the aircraft.");
                tv158.setText("For the attention of passengers\n" +
                        "Inside or outside the building: 25 microroentgen per day \n" +
                        "Passenger dose during the flight \n" +
                        "One flight (1 hour): up to 500 microroentgen per hour \n" +
                        "Secure-1000’s one scanning procedure: \n" +
                        "- 0,94 microsievert or 94 microroentgen.");
                break;
        }
    }
}
