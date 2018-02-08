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
public class GarsonRulesFragment extends Fragment {
    TextView tv144,tv147;

    public GarsonRulesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_garson_rules, container, false);
        tv144=(TextView) view.findViewById(R.id.textView144);
        tv144.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/Avenir-Heavy.ttf"));
        tv147=(TextView) view.findViewById(R.id.textView147);
        tv147.setTypeface(Typeface.createFromAsset(getActivity().getAssets(),"fonts/AvenirNext-Medium.ttf"));
        switch (((HealthyInfoActivity)getActivity()).lang){
            case "E":
                tv144.setText("Resolution by Government of the Republic of Kazakhstan No. 1512 dd. December 31, 2010 " +
                        "On approval of Rules for passenger service in airports in the Republic of Kazakhstan " +
                        "(as amended on 22.01.2013)");
                        tv147.setText("In accordance with sub-clause 36) of Article 13 of the Law of the Republic of Kazakhstan dd. July 15, 2010 ‘On use of air space of the Republic of Kazakhstan and aviation activity’, the Government of the Republic of Kazakhstan DECIDES:\n" +
                                "     1. To approve the attached Rules for passenger service in airports in the Republic of Kazakhstan.\n" +
                                "     2. To implement this Resolution upon expiration of ten calendar days from the date of first official publication\n" +
                                "Prime Minister " +
                                "Republic of Kazakhstan  \tK. Massimov\n" +
                                "Rules are set out in the version of the Resolution by Government of the Republic of Kazakhstan No. 24 dd. 22.01.13 (see previous version) " +
                                "Approved " +
                                "with the Resolution by Government of the Republic of Kazakhstan " +
                                "No. 1512 dd. December 31, 2010 \n" +
                                "Rules for " +
                                "passenger service " +
                                "in airports in the Republic of Kazakhstan\n" +
                                "1. General provisions\n" +
                                "   1. These Rules for passenger service in airports in the Republic of Kazakhstan (‘Rules’) have been developed in accordance with the Law of the Republic of Kazakhstan dd. July 15, 2010 ‘On use of air space of the Republic of Kazakhstan and aviation activity’. \n" +
                                "   2. These Rules shall govern the procedure and organization of passenger service in airports in the Republic of Kazakhstan and designed to ensure safety and quality of passenger service. \n" +
                                "   3. Terms and definitions used in these Rules: \n" +
                                "1) agent – an individual or a legal entity representing airlines, airport, which is authorized to directly act on its behalf when performing all procedures associated with arrival, departure, and clearance of an aircraft of the airlines, crew, passengers, baggage, cargo, mail, and catering; \n" +
                                "2) column ‘Last Minute Change’ (LMC) of the loadsheet – a column which indicates the changes in number of passengers, baggage made at the last minute; \n" +
                                "3) passenger service – procedures associated with preparation and implementation of air carriage, as well as providing them with additional paid or free services to meet the needs; \n" +
                                "4) ramp vehicle – a vehicle designed to transport passengers between an aircraft and an airport building; \n" +
                                "5) claim – a demand filed in written (electronically) by a concerned person who seeks compensation for damage (loss) which occurred during an improper air carriage of baggage; \n" +
                                "6) property irregularity report (PIR) – a document issued by the carrier or the handling company before a passenger or his/her authorized representative as soon as damage caused to any baggage is detected; \n" +
                                "7) baggage – belongings of a passenger transported by the carrier aboard an aircraft under an air carriage contract; \n" +
                                "8) baggage label – a document issued by the carrier for identification of checked-in baggage of a passenger; \n" +
                                "9) itinerary receipt – a document or documents that are part of an electronic ticket and contain the necessary information (e.g., name of the passenger, route, fare, etc.) and notices; \n" +
                                "10) checked-in baggage – baggage of a passenger accepted by the carrier for carriage under the responsibility of the carrier, and for which the carrier issued a baggage receipt and a baggage label; \n" +
                                "11) unclaimed baggage – baggage which arrived at a destination airport (point) indicated in a baggage label and not collected by a passenger; \n" +
                                "12) unchecked baggage (carry-on baggage) – baggage of passengers, other than registered, marked with labels ‘carry-on baggage’ carried in the cabin of an aircraft with the consent of the carrier; \n" +
                                "13) transfer baggage – baggage that under an air carriage contract is loaded at the transfer airport (point) from an aircraft operating a flight to an aircraft operating another flight on route of the air transportation; \n" +
                                "14) transit passenger – a person who subject to an air carriage contract arrives in an intermediate airport and is carried further by the same flight; \n" +
                                "15) transfer passenger – a person who subject to an air carriage contract arrives in a transfer (transshipment) point by one flight and is carried further by another flight on route of the air transportation; \n" +
                                "16) person with reduced mobility (PRM) – a passenger whose capacity is limited due to (sensory or motor, chronic or temporary) disability, mental disability, age changes or other restrictions, and whose condition requires appropriate support and adaptation; \n" +
                                "17) column ‘endorsement’ – a column in a ticket which indicates passenger data. \n" +
                                "   4. When servicing the passengers in airports of the Republic of Kazakhstan, the passenger handling department, which is a structural subdivision of the airport, performs the following functions: \n" +
                                "1) ensuring the regularity of flights; \n" +
                                "2) development and implementation of measures to ensure the safety and timely delivery of baggage of passengers; \n" +
                                "3) check-in of tickets of passengers, weighing and check-in of baggage of passengers in accordance with the aviation standards of international organization in the field of civil aviation, as well as the provisions of airlines; \n" +
                                "4) providing with a package of traffic documents for each flight; \n" +
                                "5) summarizing a check-in at the end of the check-in; \n" +
                                "6) identification of available seats and control of loading of an aircraft (passengers, baggage) according to traffic documents, aircraft loading documents, and provisions of airlines; \n" +
                                "7) invitation of passengers to board and accompanying them to an aircraft; \n" +
                                "8) boarding of passengers, loading of baggage onto an aircraft verifying the actual number of passengers with that of traffic documents; \n" +
                                "9) unloading of baggage of no-show passengers; \n" +
                                "10) meeting and accompanying the arriving passengers to the arrival lounge of the terminal; \n" +
                                "11) acceptance and accompanying the baggage between an airport terminal and an aircraft; \n" +
                                "12) ensuring the quality of service of passengers using air transport services at the airport in accordance with international standards which provisions are listed in Annex 1 to these Rules. \n" +
                                "   5. Passenger service in airports is performed in the following order: \n" +
                                "1) service of departing passengers; \n" +
                                "2) service of arriving passengers; \n" +
                                "3) service of transfer passengers; \n" +
                                "4) service of transit passengers; \n" +
                                "5) service of a passenger filing a claim for improper air carriage, involving a representative of airlines; \n" +
                                "6) service of persons with reduced mobility.\n" +
                                "2. Service of departing passengers\n" +
                                "   6. The procedure for service of departing passengers is as follows: \n" +
                                "1) check-in of departing passengers in an airport begins no later than two hours prior to departure of an aircraft (depending on aircraft type and number of passengers) for international flights, and 1.5 hours prior to departure of an aircraft (depending on aircraft type and number of passengers) for domestic flights, and it closes 40 minutes prior to departure of an aircraft; \n" +
                                "2) agents receive from a dispatcher the information on number and type of aircraft, number of seats, airlines, number of sold tickets, and more information on departing very important passengers, disabled, sick, transfer, and transit passengers, passengers checked-in using the internet, self check-in counters, and other communications; \n" +
                                "3) an agent prepares travel documents required for a flight (boarding passes, baggage labels, ‘hand baggage’ label, ‘glass’ label, and, in case of manual check-in, passenger manifests and baggage manifests); \n" +
                                "4) agents check the validity and correctness of tickets given to passengers, flight dates and numbers, departure time, destination airport, availability of a stamp of sales point, ticket validity, and name of a passenger in the PNL list. If necessary, an agent checks the availability of a record and a stamp in the column ‘Endorsement’; \n" +
                                "5) visual inspection of baggage accepted for carriage; \n" +
                                "6) weighing of baggage and carry-on baggage given by a passenger; \n" +
                                "7) entering data on baggage for the given/connecting flight (-s); \n" +
                                "8) an agent shall determine the number of pieces and weight of baggage and carry-on baggage, fix numbered baggage labels onto the baggage accepted for transportation and ‘carry-on baggage’ labels onto the carry-on baggage. The tear-off coupons of baggage labels should be given to a passenger. When checking-in a group of passengers traveling to the same destination point in automatic check-in, an agent checks-in all baggage accepted for carriage for one adult in the group in the ‘family’ or ‘group’ mode, and an agent verifies in manual check-in the total weight with total weight of free baggage allowance for the whole group, and makes relevant notes on the passenger manifest; \n" +
                                "9) identification and check-in of excess baggage entering data into the ticket check-in system; \n" +
                                "10) for the avoidance of potential conflicts when detecting any violations related to procedures of ticket and baggage check-in (passenger's refusal to follow the airlines requirements, breaches in ticket check-in), an agent shall immediately inform a shift manager; \n" +
                                "11) after the check-in, an agent working with an agent of airport official delegations lounge (VIP, CIP lounges) servicing very important passengers verifies the number of checked-in passengers for each boarding point and for the whole flight. \n" +
                                "In case of automatic check-in an agent prints the required number of passenger manifests, and in case of manual check-in an agent summarizes each check-in sector and transfers the check-in summary to a dispatcher for making a consolidated loadsheet; \n" +
                                "12) a baggage handling agent/ a baggage loader counts the number of pieces of baggage for each loading item and compares it with the data from each check-in sector. \n" +
                                "In case of manual check-in a baggage handling agent/ a baggage loader receives from an agent the data on number of pieces and weight of checked-in baggage recorded in the passenger manifest. By verifying the received data to the actual number of pieces of baggage for each unloading item, a baggage handling agent/ a baggage loader loads an aircraft in accordance with the airlines’ provisions for aircraft loading and signs the actual data; \n" +
                                "13) check-in of passengers late for check-in shall not be performed; \n" +
                                "14) an agent asks passengers to go from the waiting lounge to the air bridge for boarding, or to the ramp vehicle in case of boarding at distant parking; \n" +
                                "15) an agent checks boarding passes of passengers and compares passenger name indicated on the boarding pass with the name on the identity document, enters data of passengers into a system, and, if having special devices, scans the information from the boarding pass. \n" +
                                "Before dispatching a ramp vehicle, an agent announces for passengers the name of airlines, route and flight number; \n" +
                                "16) all violations associated with the boarding procedure of departing passengers and flight documentation (mismatch of quantity of boarding passes to the total number of checked-in passengers, mismatch of quantity of boarding passes by class of service, no-show passenger) shall be immediately reported to an airport shift manager; \n" +
                                "17) after boarding of passengers onto an aircraft, an agent verifies the actual number of passengers on the flight with a flight attendant, comparing it with the boarding passes and summarized check-in data obtained from an airport dispatcher, and makes the necessary changes in the column ‘LMC’ of a consolidated loadsheet; \n" +
                                "18) an agent transfers a consolidated loadsheet and a weight and balance sheet to a co-pilot of an aircraft, and informs a dispatcher on completion of the boarding and beginning of aircraft taxiing; \n" +
                                "19) baggage of no-show passengers shall be unloaded without fail. \n" +
                                "   7. When checking-in the baggage of passengers checked-in using the internet, self check-in counters, and other communications, agents at separate counters (check-in of baggage of the checked-in passengers) verify the boarding passes with documents of passengers, and check-in baggage in accordance with the provisions of airlines. A self check-in counter and a baggage check-in counter closes 40 minutes prior to departure. \n" +
                                "   8. Admission, check-in, delivery, loading, and claim of baggage are ensured by the following persons involved in the procedures: \n" +
                                "1) agent; \n" +
                                "2) baggage handling agent/baggage loader; \n" +
                                "3) flight attendant / representative of airlines. \n" +
                                "   9. For the international flights an itinerary receipt is required during passport control as proof of a return ticket. \n" +
                                "   10. Ticket and baggage check-in of departing passengers is carried out at counters in the operating lounge or using other check-in methods. \n" +
                                "   11. When checking-in a passenger with children, an agent checks a document certifying the age of a child (birth certificate). \n" +
                                "   12. Check-in of ticket of an unaccompanied child upon presentation of a document identifying a child shall be in accordance with the provisions of airlines. Seats in an aircraft cabin are provided according to the status of a ticket. \n" +
                                "   13. When servicing the sick passengers, an agent checks a ticket and a medical report containing a permit for transportation by air, indicating the specific requirements for conditions of carriage of such passenger, and then draws traffic documents in accordance with the aviation standards of international organization in the field of civil aviation, as well as the provisions of airlines. \n" +
                                "   14. When servicing the pregnant passengers, an agent checks a ticket, a prenatal record (at any stage of pregnancy), and a medical report for pregnant passengers whose duration of gestation is twenty eight to thirty six weeks containing a permit for transportation by air. Pregnant passengers with more than thirty six weeks of gestation are not accepted to carriage by air.\n" +
                                "3. Service of arriving passengers\n" +
                                "   15. The procedure for service of arriving passengers is as follows: \n" +
                                "1) after the estimated time of arrival has been announced by a dispatcher, agents receive from a dispatcher of the passenger handling department the following information on the arriving aircraft: \n" +
                                "   flight number; \n" +
                                "   arrival time; \n" +
                                "   planned parking; \n" +
                                "   number of passengers including transfer and transit passengers; \n" +
                                "   weight of baggage; \n" +
                                "   information on passengers who require special assistance or services; \n" +
                                "2) an agent meets passengers at the air bridge or accompanies passengers to the ramp vehicle going to the terminal building; \n" +
                                "3) an agent keeps order and delivery of passengers in arrival lounge of the airport terminal for passing the passport control (for international flights) and receiving the baggage; \n" +
                                "4) a baggage handling agent/ a baggage loader unloading baggage from an aircraft inspects integrity of packaging and in case of any fault informs a representative of airlines and an agent; \n" +
                                "5) a representative of airlines / a baggage handling agent / a baggage loader / an agent receives baggage from an aircraft, calculates the number of pieces of baggage during loading, and compares data with those in the flight documents. \n" +
                                "All revealed faults are recorded on the baggage manifest (nature of fault, number of baggage label), certified with signature and name of an agent and a representative of airlines. \n" +
                                "6) baggage is delivered to the airport baggage compartment; \n" +
                                "7) a baggage handling agent / a baggage loader unloads the baggage onto a conveyor belt. \n" +
                                "Baggage of business-class passengers (‘priority’) and transfer baggage is delivered to the airport baggage compartment in the first place. \n" +
                                "8) in all cases of improper air carriage of baggage, an agent prepares a commercial act regarding the improper air carriage of baggage (‘PIR’). In case of non-arrival / damaged baggage, a basis for preparing the PIR is a passenger’s application.\n" +
                                "4. Service of transfer passengers\n" +
                                "   16. When checking-in the transfer passengers and baggage, an agent uses special numbered baggage labels of airlines. \n" +
                                "   17. Transfer baggage is loaded into a separate baggage compartment of an aircraft. If there is no free baggage compartment, the transfer baggage is loaded last. \n" +
                                "   18. Transfer baggage is delivered to the airport baggage compartment in the first place.\n" +
                                "5. Service of transit passengers\n" +
                                "   19. A transit passenger leaves a transit airport in accordance with the date and flight specified on a ticket. In case of international flight, a transit passenger stays in a transit lounge of a transit airport. \n" +
                                "   20. In case of impossibility to offer a transit passenger a flight desirable for him, the airlines offer the passenger a seat on another flight or another departure date. If the transit passenger refuses the flight or the departure date offered by the airlines, the airlines at request of the transit passenger refunds for unperformed carriage in accordance with the airlines’ fare rules.\n" +
                                "6. Service of passengers filing a claim for improper air carriage of baggage\n" +
                                "   21. A fact of improper air carriage of baggage which serves as the basis for filing a claim by a passenger is certified with a commercial act of the PIR. The act is prepared at an airport where a fault has been revealed or at an arrival airport. \n" +
                                "   22. The basis for making a commercial act of the PIR includes: \n" +
                                "1) mismatch of baggage name, weight or number of pieces of baggage specified on documents); \n" +
                                "2) lack of baggage contents; \n" +
                                "3) damage to baggage; \n" +
                                "4) baggage without documents. \n" +
                                "   23. A commercial act of the PIR is made and signed by the following persons: \n" +
                                "1) representative of airlines – a person responsible for the registered baggage; \n" +
                                "2) agent – a person certifying the fact set out in an act; \n" +
                                "3) recipient of baggage (a person concerned). \n" +
                                "An additional number of persons involved in drafting an act depends on the nature of improper air carriage of baggage. A representative of airlines after making a commercial act of the PIR sends a message with the data specified in the act to a claim agent to airlines’ base airport, conducts a search, and finds out a fact and a reason. \n" +
                                "   24. All cases of improper air carriage of baggage shall be immediately reported to an airport shift manager or an agent and a representative of airlines. \n" +
                                "   25. In case of non-arrival of baggage or shortage in number of pieces of baggage, an agent accepts a passenger's statement of claim, prepares an act of the PIR in three copies which indicates flight number, departure date, route, number of baggage labels, and baggage description.\n" +
                                "7. Service of persons with reduced mobility\n" +
                                "   26. The procedure for service of persons with reduced mobility is as follows: \n" +
                                "1) check-in of a passenger having vision impairment and being accompanied by a guide dog is carried out in accordance with the provisions of airlines; \n" +
                                "2) when carrying the persons with limited mobility, after the appropriate check-in procedures a representative of airlines / airport accompanies them to (from) an aircraft and transfers them together with the documents directly to the crew; \n" +
                                "3) an agent assists in passing the border and customs control and other clearance procedures. \n" +
                                "Service of people with reduced mobility is carried out by an agent in accordance with the provisions of airlines. \n" +
                                "When carrying the persons using a wheelchair, a representative of airlines / airport provides a special wheelchair for transportation in the cabin of an aircraft. \n" +
                                "Embarkation of persons with reduced mobility onto an aircraft is carried out by an airport representative in the first place before the announcement of boarding for the main part of passengers, and disembarkation from an aircraft is carried out last. \n");
                break;
            case "K":
                tv144.setText("\"Қазақстан Республикасының әуежайларында жолаушыларға қызмет көрсетуді ұйымдастыру қағидасын бекіту туралы\" Қазақстан Республикасы Үкіметінің 2010 жылғы 31 желтоқсандағы № 1512 қаулысына өзгеріс енгізу туралы");
                tv147.setText("Қазақстан Республикасы Үкіметінің 2013 жылғы 22 қаңтардағы № 24 Қаулысы. \n" +
                        "Қазақстан Республикасының Үкіметі ҚАУЛЫ ЕТЕДІ:\n" +
                        "     1. «Қазақстан Республикасының әуежайларында жолаушыларға қызмет көрсетуді ұйымдастыру қағидасын бекіту туралы» Қазақстан Республикасы Үкіметінің 2010 жылғы 31 желтоқсандағы № 1512 қаулысына (Қазақстан Республикасының ПҮАЖ-ы, 2011 ж., № 10-11, 146-құжат) мынадай өзгеріс енгізілсін: " +
                        "көрсетілген қаулымен бекітілген Қазақстан Республикасының әуежайларында жолаушыларға қызмет көрсетуді ұйымдастыру қағидалары осы қаулыға қосымшаға сәйкес жаңа редакцияда жазылсын.\n" +
                        "     2. Осы қаулы алғашқы ресми жарияланған күнінен бастап күнтізбелік он күн өткен соң қолданысқа енгізіледі.\n" +
                        "Қазақстан Республикасының " +
                        "Премьер-Министрі                                                                              К. Масимов\n" +
                        "Қазақстан Республикасы Үкіметінің 2013 жылғы 22 қаңтардағы № 24 қаулысына қосымша " +
                        "Қазақстан Республикасы " +
                        "Үкіметінің " +
                        "2012 жылғы 31 желтоқсандағы " +
                        "№ 1512 қаулысымен " +
                        "бекітілген.\n" +
                        "Қазақстан Республикасының әуежайларында " +
                        "жолаушыларға қызмет көрсетуді ұйымдастыру " +
                        "қағидасы \n" +
                        "1. Жалпы ережелер\n" +
                        "     1. Осы Қазақстан Республикасының әуежайларында жолаушыларға қызмет көрсетуді ұйымдастыру қағидасы (бұдан әрі – Қағида) «Қазақстан Республикасының әуе кеңістігін пайдалану және авиация қызметі туралы» 2010 жылғы 15 шілдедегі Қазақстан Республикасының заңына сәйкес әзірленді.\n" +
                        "     2. Осы Қағида жолаушыларға қауіпсіз және сапалы қызмет көрсетуді қамтамасыз етуге бағытталған Қазақстан Республикасының әуежайларында жолаушыларға қызмет көрсетуді ұйымдастырудың тәртібін белгілейді.\n" +
                        "     3. Осы Қағидада қолданылатын терминдер және анықтамалар:\n" +
                        "1) агент – авиакомпанияны, аэропортты білдіретін, осы авиакомпанияның әуе кемесінің, экипаждың, жолаушылардың, багаждың, жүктің, поштаның және борттық қорлардың келуімен, жөнелтілуімен және ресімделуімен байланысты барлық рәсімдерді орындау кезінде оған тікелей немесе оның атынан әрекет етуге уәкілеттік берілген жеке немесе заңды тұлға;\n" +
                        "2) жиынтық-тиелім ведомосінің «соңғы минутта өзгерту» бағаны (бұдан әрі - «LMC бағаны») жолаушылар, багаж санының соңғы минуттағы өзгерістері көрсетілетін баған;\n" +
                        "3) жолаушыларға қызмет көрсету – әуе тасымалын ресімдеумен және жүзеге асырумен, сондай-ақ қажеттіліктерді қанағаттандыру мақсатында оларға қосымша ақылы немесе тегін қызметтер көрсетумен байланысты рәсімдерді орындау жөніндегі қызмет;\n" +
                        "4) перрондық көлік құралы – әуе кемесі мен әуежай ғимараты арасында жолаушыларды тасымалдауға арналған көлік құралы;\n" +
                        "5) шағым арыз – мүдделі тұлғаның багажды әуеде тиісті түрде тасымалдамауы нәтижесінде туындаған зиянның (шығынның) орнын толтыруы туралы жазбаша электрондық нысанда жасаған талабы;\n" +
                        "6) багажды тасымалдау кезіндегі ақаулықтар туралы акт (PIR – property irregularity report) – багажға келтірілген зиян анықталған кезде жолаушының немесе оның уәкілетті адамының қатысуымен тасымалдаушы немесе қызмет көрсетуші ұйым ресімдейтін құжат;\n" +
                        "7) багаж – әуе тасымалы шарты негізінде әуе кемесінде тасымалдаушы тасымалдайтын жолаушының жеке заттары;\n" +
                        "8) багаж белгісі – жолаушының тіркелген багажын тану (сәйкестендіру) үшін тасымалдаушы беретін құжат;\n" +
                        "9) маршруттық түбіртек – электрондық билеттің құрамдас бөлігі болып табылатын және қажетті мәліметтерді (мысалы, жолаушының тегін, маршрутты, тарифті және т.б.), хабарламалар мен хабарландыруларды қамтитын құжат немесе құжаттар;\n" +
                        "10) тіркелген багаж – тасымалдаушының жауапкершілігіне қабылданған және оған багаждық түбіртек пен багаж белгісін берген, тасымалдаушы әуе тасымалына қабылдаған жолаушы багажы;\n" +
                        "11) талап етілмеген багаж – багаж белгісінде көрсетілген межелі әуежайға (пунктке) келіп жеткен және жолаушы алмаған багаж;\n" +
                        "12) тіркелмеген багаж (қол жүгі) – тасымалдаушының келісімімен әуе кемесінің салонында тасымалданатын, «қол жүгі» белгісімен таңбаланатын, жолаушылардың тіркелген жүктерінен басқа багажы;\n" +
                        "13) трансферлік багаж – әуе тасымалының шартына сәйкес трансфер әуежайында (пунктінде) белгілі бір рейсті орындайтын әуе кемесінен әуе тасымалының маршруты бойынша басқа рейс орындайтын әуе кемесіне аударылып тиелетін багаж;\n" +
                        "14) транзиттік жолаушы – әуе тасымалының шартына сәйкес аралық әуежайға келген сол рейспен одан әрі тасымалданатын жолаушы;\n" +
                        "15) трансферлік жолаушы – әуе тасымалының шартына сәйкес трансфер (ауыстыру) әуежайына (пунктіне) белгілі бір рейспен келген және тасымал маршруты бойынша басқа рейспен ұшуын жалғастыратын жолаушы;\n" +
                        "16) мүмкіндігі шектеулі жолаушы (PRM - Persons with Reduced Mobility) – қабілеті (сенсорлық немесе моторлық, созылмалы немесе уақытша) мүгедектік, ақыл кемістігі, өзге шектеулер немесе жасына байланысты өзгерістер салдарынан шектелген және жағдайы тиісті түрде күтім мен бейімделуді талап ететін жолаушы;\n" +
                        "17) «деректемелер жазуы» бағаны – билетте бұл бағанда жолаушы туралы деректер көрсетіледі.\n" +
                        "     4. Қазақстан Республикасының әуежайларында жолаушыларға қызмет көрсетуді ұйымдастыру кезінде әуежайдың құрылымдық бөлімшесі болып табылатын авиатасымалдау ұйымы мынадай функцияларды жүзеге асырады:\n" +
                        "1) ұшулардың тұрақтылығын қамтамасыз етеді;\n" +
                        "2) жолаушылар багажының сақталуын және уақтылы жеткізілуін қамтамасыз ету бойынша іс-шараларды әзірлейді және жүзеге асырады;\n" +
                        "3) азаматтық авиация саласындағы халықаралық ұйымның авиациялық стандарттарына сәйкес, сондай-ақ авиакомпания ережелерін ескере отырып, жолаушылар билеттерінің тіркелуін, жолаушылар багажының өлшенуін және ресімделуін жүргізеді;\n" +
                        "4) әр рейс бойынша тасымалдау құжаттары пакетінің ұсынылуын қамтамасыз етеді;\n" +
                        "5) тіркеу аяқталғанда тіркеу қорытындыларын шығарады;\n" +
                        "6) тасымалдау құжаттарына, әуе кемесінің тиелуі бойынша құжаттарға және авиакомпанияның ережелеріне сәйкес бос орындардың болуын анықтайды және әуе кемесінің (жолаушылардың, багаждың) тиелуін бақылайды;\n" +
                        "7) отырғызуға шақырады және жолаушыларды әуе кемесіне дейін шығарып салады;\n" +
                        "8) жолаушылардың іс жүзінде болуын тасымал құжаттарының деректерімен салыстыра отырып, жолаушыларды әуе кемесіне отырғызуды, багажды тиеуді жүзеге асырады;\n" +
                        "9) отырғызуға келмеген жолаушылардың багажын түсіруді ұйымдастырады;\n" +
                        "10) келіп жеткен жолаушыларды қарсы алуды және оларды аэровокзалдың келу залына дейін шығарып салуды жүргізеді;\n" +
                        "11) әуежай ғимараты мен әуе кемесі арасында багажды қабылдауды, сүйемелдеуді жүргізеді;\n" +
                        "12) ережелері осы Қағидаларға 1-қосымшада келтірілген халықаралық стандарттарға сәйкес әуе көлігінің қызмет көрсетулерін пайдаланатын жолаушыларға, әуежайда қызмет көрсету сапасын қамтамасыз етеді.\n" +
                        "     5. Әуежайларда жолаушыларға қызмет көрсету мынадай тәртіппен жүзеге асырылады:\n" +
                        "1) ұшатын жолаушыларға қызмет көрсету;\n" +
                        "2) ұшып келетін жолаушыларға қызмет көрсету;\n" +
                        "3) трансферлік жолаушыларға қызмет көрсету;\n" +
                        "4) транзиттік жолаушыларға қызмет көрсету;\n" +
                        "5) тиісінше орындалмаған әуе тасымалына шағымданған жолаушыларға авиакомпания өкілінің қатысуымен қызмет көрсету;\n" +
                        "6) мүмкіндіктері шектеулі жолаушыларға қызмет көрсету.\n" +
                        "2. Ұшып шығатын жолаушыларға қызмет көрсету тәртібі\n" +
                        "     6. Ұшып шығатын жолаушыларға қызмет көрсету мынадай тәртіпті көздейді:\n" +
                        "1) әуежайдағы халықаралық рейстерде ұшатын жолаушыларды тіркеу әуе кемесінің ұшып шығуына дейін кемінде екі сағат (әуе кемесінің үлгісіне және жолаушылардың санына байланысты) және ішкі рейстерде әуе кемесіне ұшуына дейін кемінде 1,5 сағат (әуе кемесінің үлгісіне және жолаушылардың санына байланысты) қалғанда басталады және әуе кемесінің ұшуына 40 минут қалған кезде аяқталады;\n" +
                        "2) агенттердің диспетчерден әуе кемесінің нөмірі және үлгісі, отыратын орын саны, ММавиакомпания, сатылған билеттер саны және ұшатын ерекше маңызды жолаушылар, мүгедектер, науқастар, трансферлік және транзиттік жолаушылар, интернет, өзін-өзі тіркеу бағандары және басқа байланыс түрлері арқылы тіркелген жолаушылар туралы мәліметтерді алуы;\n" +
                        "3) агенттің рейсті ресімдеу үшін қажетті тасымал құжаттамасын (отырғызу талондары, багаждың нөмірлік белгілері, «қол жүгі», «шыны» белгісін және, қолмен тіркеу жағдайында, жолаушылар манифестері мен багаждық ведомостері) дайындауы;\n" +
                        "4) агенттердің жолаушыларға ұсынылған билеттің, рейстің күні мен нөмірінің, жөнелтілетін уақытының, межелі әуежайының, сатып алынған орынның бұрыштамасының, билет жарамдылығы мерзімінің және жолаушының тегінің PNL тізімінде болуының шынайылығын және ресімделуінің дұрыстығын тексеруі. Қажет болған кезде, «Тапсыру жазбасы» бағанында жазбаның және бұрыштаманың болуын тексереді.\n" +
                        "5) тасымалдауға қабылданатын багажды сыртынан тексеру;\n" +
                        "6) жолаушы ұсынған багаж бен қол жүгін өлшеу;\n" +
                        "7) багаж туралы деректерді осы/түйіспелі рейске (терге) енгізу;\n" +
                        "8) агент орын санын, багаж бен қол жүгінің салмағын анықтайды, тасымалдауға қабылданған багажға багаждың нөмірлік белгісін және қол жүгіне «қол жүгі» белгісін жапсырады. Багаж белгісінің үзбелі талондары жолаушыға беріледі. Бір межелі пунктке жөнелтілген жолаушылар тобын автоматтық тіркеу кезінде тасымалдауға өзара қабылданған барлық багажды топтағы «отбасылық» немесе «топтық» режимде бір ересек жолаушының атына ресімдейді, агент қолмен тіркегенде бүкіл топтың тегін тасымалданатын багажының салмағын жалпы салмақпен салыстырады және жолаушы манифесіне тиісті белгілер жасайды;\n" +
                        "9) билеттерді тіркеу жүйесіне деректер енгізе отырып, нормадан асатын багажды анықтау және ресімдеу;\n" +
                        "10) билеттерді тіркеу және багажды ресімдеу рәсімдеріне байланысты әлдебір бұзушылықтар (жолаушының авиакомпания талабын орындаудан бас тартуы, билет ресімдеудегі бұзушылықтар) анықталған кезде қақтығыс жағдайларына жол бермеу үшін ол жөнінде ауысымның бастығын дереу хабардар етіледі;\n" +
                        "11) тіркеу аяқталған соң агент әуежайдың ресми делегациялар залының (АМТ/ВИП, КМТ/СИП залы) аса маңызды жолаушыларға қызмет көрсететін агентімен өзара іс-қимыл жасай отырып, отырғызудың әр тармағы бойынша және бүкіл рейс бойынша тіркелген жолаушылар санын салыстырады.\n" +
                        "Автоматты тіркеу кезінде агент жолаушылар манифестерінің қажетті санын баспаға шығарады, қолмен тіркеу кезінде тіркеудің әр секторы бойынша қорытындыларын шығарады және тіркеудің жалпы қорытындысын жиынтық тиеу ведомосін құрастыру үшін диспетчерге береді;\n" +
                        "12) багажды қабылдаушы-тапсырушы/тиеуші тиеудің әр тармағы бойынша багаж орындарының санын санайды және оны тіркеудің әр секторы бойынша деректерімен салыстырады. " +
                        "Қолмен тіркеу кезінде багажды қабылдаушы-тапсырушы/тиеуші агенттен жолаушы манифестінде белгіленіп тіркелген багаждың орындарының саны және салмағы туралы деректерді алады. Алынған деректерді әр тиеу тармағы бойынша багаж орнының нақты санымен салыстырып, әуе кемесін тиеу бойынша авиакомпанияның ережелеріне сәйкес әуе кемесіне жүкті тиейді және өзінің қолын қойып нақты деректерді растайды;\n" +
                        "13) тіркеу уақыты аяқталу уақытынан кешіккен жолаушылардың тіркелуі жүргізілмейді;\n" +
                        "14) агент жолаушыларды күту залынан әуе кемесіне отыруға шығуы үшін телескоптық трапқа шақырады немесе алыс тұрақтарға барып отыру кезінде перрондық көлік құралына отыруға шақырады;\n" +
                        "15) агент жолаушылардың отырғызу талондарын тексереді, отырғызу талонында көрсетілген жолаушының тегін жеке басын куәландыратын құжатындағы тегімен салыстырады, жүйеге отыруға өткен жолаушының деректерін енгізеді және арнайы құралдары болған кезде отыру талонындағы ақпаратты көшіріп алады.\n" +
                        "Перрондық көлік құралын жөнелтудің алдында агент жолаушыларға авиакомпанияның атауын, ұшу бағытын және рейс нөмірін хабарлайды;\n" +
                        "16) ұшып шығатын жолаушыларды отырғызу және ұшу құжаттамасын ресімдеу ресіміне байланысты барлық бұзушылықтар (отырғызу талондары санының тіркелген жолаушылардың жалпы санына сәйкес келмеуі, отырғызу талондары санының қызмет көрсету кластары бойынша сәйкес келмеуі, жолаушының отырғызуға келмеуі) туралы диспетчер мен әуежай ауысымының бастығына дереу хабардар етіледі;\n" +
                        "17) жолаушыларды әуе кемесіне отырғызу аяқталғаннан кейін агент әуежайдың диспетчерінен алынған тіркеудің қорытынды деректерімен және отырғызу талондарымен салыстыра отырып, бортсеріктен рейстегі жолаушылардың іс жүзіндегі санын нақтылайды және жиынтық тиеу ведомосінің «LMC» бағанына қажетті өзгерістер енгізеді;\n" +
                        "18) агент жиынтық тиеу ведомосін және центрлеу кестесін әуе кемесінің екінші пилотына тапсырады және рейске отырғызудың аяқталғаны және әуе кемесінің рульдеуі басталғаны туралы диспетчерге хабарлайды;\n" +
                        "19) әуе кемесінің бортына келмеген жолаушылардың багажы міндетті түрде алынып тасталады.\n" +
                        "     7. Интернет, өздігінен тіркелу бағандары және басқа байланыс түрлері арқылы тіркелген жолаушылардың багажын тіркеу кезінде агенттер жеке тағанда (Тіркелген жолаушылардың багажын ресімдеу) отырғызу купондарын жолаушының құжаттарымен салыстырады және авиакомпанияның ережелеріне сәйкес багаждың тіркелуін жүргізеді. Өздігінен тіркелу және багажды тіркеу тағаны ұшып шығуға дейін 40 минут қалғанда жабылады.\n" +
                        "     8. Багаждың қабылдануын, ресімделуін, жеткізілуін, тиелуін және берілуін мынадай операциялармен өзара іс-қимыл жасайтын адамдар қамтамасыз етеді:\n" +
                        "1) агент;\n" +
                        "2) қабылдаушы-тапсырушы/тиеуші;\n" +
                        "3) бортсерік/авиакомпания өкілі.\n" +
                        "9. Халықаралық ұшуларды жүзеге асырған кезде маршруттық түбіртек паспорттық бақылаудан өткен кезде кері қайту билетінің дәлелі ретінде көрсетілуі үшін қажет.\n" +
                        "    10. Ұшып шығатын жолаушылардың билеттерін тіркеу және багажын ресімдеу операциялық залдағы тағандарда немесе басқа тіркеу тәсілдерін қолданып жүргізіледі.\n" +
                        "    11. Балалары бар жолаушыларды тіркеу кезінде агент баланың жасын растайтын құжатты (тууы туралы куәлік) тексереді.\n" +
                        "    12. Баланың жеке басын куәландыратын құжатты көрсету кезінде бірге жүретін адамы жоқ балалардың билеттерін тіркеу авиакомпанияның ережелеріне сәйкес жүзеге асырылады. Әуе кемесінің салонында орын ұсыну билеттің мәртебесіне сәйкес жүзеге асырылады.\n" +
                        "    13. Агент науқас жолаушыларға қызмет көрсету кезінде авиабилеттің және осындай жолаушыны тасымалдау шарттарына қойылатын арнайы талаптар көрсетілген, оны әуе көлігімен тасымалдауға рұқсат ететін медициналық қорытындының болуын тексереді, содан кейін азаматтық авиация саласындағы халықаралық ұйымның авиациялық стандарттарына сәйкес, сондай-ақ авиакомпания ережелерін ескере отырып, тасымалдау құжаттарын ресімдейді.\n" +
                        "    14. Жүкті жолаушыларға қызмет көрсету кезінде рейстің агент авиабилеттің, айырбас картасының (жүктіліктің кез келген мерзімінде) және де әуе көлігімен тасымалдауға рұқсат берілген жүктілік мерзімі жиырма сегіз аптадан отыз алты аптаға дейінгі жолаушылар үшін олардың медициналық қорытындысының болуын тексереді. Жүктілік мерзімі отыз алты аптадан астам жүкті жолаушылар әуе көлігімен тасымалдауға қабылданбайды.\n" +
                        "3. Ұшып келген жолаушыларға қызмет көрсету тәртібі\n" +
                        "     15. Ұшып келген жолаушыларға қызмет көрсету мынадай тәртіпті көздейді:\n" +
                        "1) диспетчер рейстің келуінің есептік уақытын хабарлағаннан кейін, агенттер тасымалдау қызметінің диспетчерінен ұшып келе жатқан әуе кемесі жөнінде мынадай ақпаратты алады:\n" +
                        "рейстің нөмірі;\n" +
                        "келу уақыты;\n" +
                        "жоспарланған тұрағы;\n" +
                        "трансферлік және транзиттік жолаушыларды қоса алғанда, жолаушылар саны;\n" +
                        "багаж салмағының саны;\n" +
                        "көмекті немесе арнайы қызмет көрсетуді қажет ететін жолаушылар туралы ақпарат;\n" +
                        "2) агент жолаушыларды телескопиялық траптың алдында қарсы алады немесе жолаушылармен бірге перрондық көлік құралымен әуежайға дейін бірге барады;\n" +
                        "3) агент тәртіптің сақталуын бақылайды және жолаушылардың әуежай терминалының ұшып келу залына паспорттық бақылаудан өтуі (халықаралық рейстерде) және багажды алуы үшін жеткізілуін қадағалайды;\n" +
                        "4) багаждың әуе кемесінің бортынан түсірілуін жүргізетін қабылдаушы-тапсырушы/тиеуші қаптаманың жарамдылығын тексереді және бұзылуын анықтаған жағдайда авиакомпанияның өкіліне және агентке хабарлайды;\n" +
                        "5) авиакомпания өкілі/қабылдаушы-тапсырушы/тиеуші/ агент әуе кемесінен багаждың қабылдап алуын жүргізеді, тиеу кезіндегі багаж орындарының санын есептейді және деректерді ұшу құжаттарына сәйкес салыстырады.\n" +
                        "Барлық анықталған ақаулықтар багаждың ведомосінде көрсетіледі (ақаулықтың сипаты, багаж белгісінің нөмірі), агенттің және авиакомпания өкілінің қолымен және тегімен куәландырылады;\n" +
                        "6) багаж әуежайдың багаждық бөліміне жеткізіледі;\n" +
                        "7) қабылдаушы-тапсырушы/тиеуші багаждың транспортерлік таспаға аударып түсірілуін жүргізеді.\n" +
                        "Әуежайдың багаждық бөліміне бизнес-класс («приорити») жолаушыларының және трансферлік жолаушылардың багажы бірінші кезекте жеткізіледі;\n" +
                        "8) багаждың әуе арқылы тиесілі тасымалданбауының барлық жағдайы бойынша агент, багаждың әуе арқылы дұрыс тасымалданбауы туралы коммерциялық актісін (бұдан әрі – PIR актісі) жасайды. Багаж келмеген/бұзылған жағдайда, жолаушының өтініші PIR актісін жасауға негіз болып саналады.\n" +
                        "4. Трансферлік жолаушыларға қызмет көрсету тәртібі\n" +
                        "     16. Трансферлік жолаушыларды тіркеу және багажды ресімдеу кезінде агент авиакомпанияның арнайы багаждық нөмірлік белгілерін пайдаланады.\n" +
                        "     17. Трансферлік багаж әуе кемесінің бортында бөлек багаж бөлігіне тиеледі. Бос багаж бөлігі болмаған жағдайда трансферлік жолаушылардың багажы ең соңғы кезекпен тиеледі.\n" +
                        "     18. Әуежайдың багаж бөлмесіне трансферлік жолаушылардың багажы бірінші кезекте жеткізіледі.\n" +
                        "5. Транзиттік жолаушыларға қызмет көрсету тәртібі\n" +
                        "     19. Транзиттік жолаушы транзит әуежайынан билетте көрсетілген күні мен рейске сәйкес жөнелтіледі. Халықаралық тасымал кезінде транзиттік жолаушы аялдау әуежайында транзиттік жолаушыларға арналған залда болады.\n" +
                        "     20. Транзиттік жолаушыны өзі қалаған рейспен жөнелту мүмкін болмаған жағдайда авиакомпания жолаушыға басқа рейстен орын немесе басқа ұшу күнін ұсынады. Транзиттік жолаушы авиакомпания ұсынған рейстен немесе ұшу күнінен бас тартқан жағдайда авиакомпания жолаушының талабы бойынша орындалмаған тасымал үшін авиакомпанияның тарифтерін қолдану ережесіне сәйкес билеттің ақшасын қайтарады.\n" +
                        "6. Жолаушы багажды тиісті түрде әуеде тасымалдамағаны жөнінде наразылық берген кезде оған қызмет көрсету тәртібі\n" +
                        "     21. Жолаушының наразылығына негіз болатын багажды әуеде тиісті түрде тасымалдамау фактісі PIR коммерциялық актісімен куәландырылады. Акт тікелей жарамсыздық анықталған әуежайда немесе ұшып келген әуежайда жасалады.\n" +
                        "     22. PIR коммерциялық актісін жасауға мыналар негіз болады:\n" +
                        "1) багаж атауының, құжаттарда көрсетілген салмағының немесе багаж орындарындағы санының сәйкес келмеуі;\n" +
                        "2) багаждағы заттардың жетіспеуі;\n" +
                        "3) багаждың зақымдануы;\n" +
                        "4) құжатсыз багаждың анықталуы.\n" +
                        "     23. PIR коммерциялық актісін мыналар жасайды және оған қол қояды:\n" +
                        "1) авиакомпания өкілі – акті жасалған багаж үшін жауапты адам;\n" +
                        "2) агент – актіде жазылған фактіні куәландырушы адам;\n" +
                        "3) багаж алушы (мүдделі адам).\n" +
                        "Актіні жасауға тартылатын қосымша адамдар саны багажды тиісті түрде әуеде тасымалдау сипатына байланысты болады. Авиакомпанияның өкілі PIR коммерциялық актісін жасағаннан кейін авиакомпанияның негізгі әуежайының жарнама агентіне актіде көрсетілген деректері бар хабар жібереді, іздестіру жүргізеді, фактісі мен себептерін анықтайды.\n" +
                        "     24. Багаждың тиісті түрде тасымалданбауы туралы барлық жағдайлар жөнінде ауысым бастығы немесе агент және авиакомпания өкілі дереу хабардар етіледі.\n" +
                        "     25. Багаж келмегенде немесе оның орындарының саны бойынша кем болғанда агент жолаушыдан арыз өтінішін қабылдайды, PIR актісін үш данада жасайды, онда рейстің нөмірін, күнін, әуе кемесінің ұшу бағытын, багаждық белгілердің нөмірлерін және багаждың сипаттамасын көрсетеді.\n" +
                        "7. Мүмкіндіктері шектеулі жолаушыларға қызмет көрсету тәртібі\n" +
                        "     26. Мүмкіндіктері шектеулі жолаушыларға қызмет көрсету мынадай тәртіпті көздейді:\n" +
                        "1) көзінің көрмеуі бойынша мүгедектігі бар және өзін жетектеуші ит сүйемелдеген жолаушыны тіркеу авиакомпанияның ережелеріне сәйкес жүзеге асырылады;\n" +
                        "2) қозғалу мүмкіндіктері шектеулі адамдарды тасымалдау кезінде, тіркеу желісі бойынша тиісті рәсімдерді жүргізгеннен кейін авиакомпанияның/әуежайдың өкілі оларды әуе кемесіне/н шығарып салады және құжаттарымен қоса оны/оларды тікелей экипажға тапсырады;\n" +
                        "3) агент шекаралық, кедендік бақылаудан және өзі ресімдеу рәсімдерінен өтуге көмек көрсетеді.\n" +
                        "     Мүмкіндіктері шектеулі адамдарға қызмет көрсетуді авиакомпанияның ережелеріне сәйкес агент жүзеге асырады.\n" +
                        "     Арбаша-креслоны пайдаланатын адамдарды тасымалдау кезінде авиакомпанияның/әуежайдың өкілі әуе кемесінің салонында тасымалдауға арналған арнайы креслоны ұсынуы тиіс.\n" +
                        "     Мүмкіндіктері шектеулі адамдарды әуе кемесіне отырғызуды әуежай өкілі жолаушылардың негізгі бөлігінің отырғызуын хабарлағанға дейін бірінші кезекте және әуе кемесінен түсіруін соңғы кезекте жүргізеді.\n");
                break;
            default:
                tv144.setText("Постановление Правительства Республики Казахстан " +
                        "от 31 декабря 2010 года № 1512\n" +
                        "Об утверждении Правил организации обслуживания пассажиров в аэропортах Республики Казахстан " +
                        "(с изменениями от 22.01.2013г.)");
                tv147.setText("В соответствии с подпунктом 36) статьи 13 Закона Республики Казахстан от 15 июля 2010 года «Об использовании воздушного пространства Республики Казахстан и деятельности авиации» Правительство Республики Казахстан ПОСТАНОВЛЯЕТ:\n1. Утвердить прилагаемые Правила организации обслуживания пассажиров в аэропортах Республики Казахстан. \n2. Настоящее постановление вводится в действие по истечении десяти календарных дней со дня первого официального опубликования.\n" +
                        "Премьер-Министр " +
                        "Республики Казахстан \tК. Масимов\n" +
                        "Правила изложены в редакции постановления Правительства РК от 22.01.13 г. № 24 (см. стар. ред.)\n" +
                        "Утверждены " +
                        "постановлением Правительства " +
                        "Республики Казахстан " +
                        "от 31 декабря 2010 года № 1512\n" +
                        "Правила " +
                        "организации обслуживания пассажиров в аэропортах Республики Казахстан " +
                        "1. Общие положения \n" +
                        "   1. Настоящие Правила организации обслуживания пассажиров в аэропортах Республики Казахстан (далее - Правила) разработаны в соответствии с Законом Республики Казахстан от 15 июля 2010 года «Об использовании воздушного пространства Республики Казахстан и деятельности авиации».\n" +
                        "   2. Настоящие Правила устанавливают порядок и организации обслуживания пассажиров в аэропортах Республики Казахстан и направлены на обеспечение безопасного и качественного обслуживания пассажиров.\n" +
                        "   3. Термины и определения, используемые в настоящих Правилах:\n" +
                        "1) агент - физическое или юридическое лицо, представляющее авиакомпанию, аэропорт, которое уполномочено непосредственно выступать от его имени при выполнении всех процедур, связанных с прибытием, отправлением и оформлением воздушного судна данной авиакомпании, экипажа, пассажиров, багажа, груза, почты и бортприпасов;\n" +
                        "2) графа «изменение в последнюю минуту» сводно-загрузочной ведомости (далее - графа «LMC») - графа, в которой указываются изменения в последнюю минуту количества пассажиров, багажа;\n" +
                        "3) обслуживание пассажиров - деятельность по выполнению процедур, связанных с оформлением и осуществлением воздушной перевозки, а также с предоставлением им дополнительных платных или бесплатных услуг с целью удовлетворения потребностей;\n" +
                        "4) перронное транспортное средство - транспортное средство, предназначенное для перевозки пассажиров между воздушным судном и зданием аэропорта;\n" +
                        "5) претензия - составленное в письменной (электронной) форме требование заинтересованного лица о возмещении вреда (убытков), возникшее в результате ненадлежащей воздушной перевозки багажа;\n" +
                        "6) акт о неисправностях при перевозке багажа (PIR - property irregularity report) - документ, оформленный перевозчиком или обслуживающей организацией в присутствии пассажира или уполномоченного им лица при обнаружении вреда, причиненного багажу;\n" +
                        "7) багаж - личные вещи пассажира, перевозимые перевозчиком на воздушном судне на основании договора воздушной перевозки;\n" +
                        "8) багажная бирка - документ, выдаваемый перевозчиком для опознавания (идентификации) зарегистрированного багажа пассажира;\n" +
                        "9) маршрутная квитанция - документ или документы, являющиеся составной частью электронного билета и содержащие необходимые сведения (например, фамилию пассажира, маршрут, тариф и т.д.), извещения и уведомления;\n" +
                        "10) багаж зарегистрированный - багаж пассажира, принятый перевозчиком к воздушной перевозке под ответственность перевозчика и на который он выдал багажную квитанцию и багажную бирку;\n" +
                        "11) багаж невостребованный - багаж, который прибыл в аэропорт (пункт) назначения, указанный на багажной бирке, и не был получен пассажиром;\n" +
                        "12) багаж незарегистрированный (ручная кладь) - багаж пассажиров, кроме зарегистрированного, маркируемый бирками «ручная кладь», перевозимый в салоне воздушного судна с согласия перевозчика;\n" +
                        "13) трансферный багаж - багаж, который в соответствии с договором воздушной перевозки перегружается в аэропорту (пункте) трансфера с воздушного судна, выполняющего один рейс, на воздушное судно, выполняющее другой рейс по маршруту воздушной перевозки;\n" +
                        "14) транзитный пассажир - пассажир, который в соответствии с договором воздушной перевозки перевозится далее тем же рейсом, которым прибыл в промежуточный аэропорт;\n" +
                        "15) трансферный пассажир - пассажир, который в соответствии с договором воздушной перевозки прибыл в аэропорт (пункт) трансфера (пересадки) одним рейсом и продолжает полет другим рейсом по маршруту перевозки;\n" +
                        "16) пассажир с ограниченной возможностью (PRM - Persons with Reduced Mobility) - пассажир, способность которого ограничена вследствие (сенсорной или моторной, хронической или временной) инвалидности, умственного недостатка, иного ограничения или возрастных изменений, и состояние которого требует надлежащей поддержки и адаптации." +
                        "17) графа «передаточная надпись» - в билете в этой графе указываются данные о пассажире.\n" +
                        "   4. При организации обслуживания пассажиров в аэропортах Республики Казахстан служба организации авиаперевозок, являющаяся структурным подразделением аэропорта, осуществляет следующие функции:\n" +
                        "1) обеспечивает регулярность полетов;\n" +
                        "2) разрабатывает и осуществляет мероприятия по обеспечению сохранности и своевременной доставке багажа пассажиров;\n" +
                        "3) проводит регистрацию билетов пассажиров, взвешивание и оформление багажа пассажиров в соответствии с авиационными стандартами международной организации в сфере гражданской авиации, а также с учетом положений авиакомпании;\n" +
                        "4) обеспечивает представление пакета перевозочных документов по каждому рейсу;\n" +
                        "5) по окончании регистрации подводит итоги регистрации;\n" +
                        "6) выявляет наличие свободных мест и контролирует загрузку воздушного судна (пассажиров, багажа) в соответствии с перевозочными документами, документами по загрузке воздушного судна и положениями авиакомпании;\n" +
                        "7) приглашает к посадке и сопровождает пассажиров до воздушного судна;\n" +
                        "8) осуществляет посадку пассажиров в воздушное судно, загрузку багажа, сверяя фактическое наличие пассажиров с данными перевозочных документов;\n" +
                        "9) организует снятие багажа не явившихся на посадку пассажиров;\n" +
                        "10) проводит встречу и сопровождение прибывающих пассажиров до зала прилета аэровокзала;\n" +
                        "11) производит прием, сопровождение багажа между зданием аэропорта и воздушным судном;\n" +
                        "12) обеспечивает в аэропорту качество обслуживания пассажиров, пользующихся услугами воздушного транспорта в соответствии с международными стандартами, положения которых приведены в приложении 1 к настоящим Правилам. \n" +
                        "   5. Обслуживание пассажиров в аэропортах осуществляется в следующем порядке:\n" +
                        "1) обслуживание вылетающих пассажиров;\n" +
                        "2) обслуживание прилетающих пассажиров;\n" +
                        "3) обслуживание трансферных пассажиров;\n" +
                        "4) обслуживание транзитных пассажиров,\n" +
                        "5) обслуживание пассажира при предъявлении им претензии на ненадлежащую воздушную перевозку с участием представителя авиакомпании;\n" +
                        "6) обслуживание пассажиров с ограниченными возможностями.\n" +
                        "2. Порядок обслуживания вылетающих пассажиров\n" +
                        "   6. Обслуживание вылетающих пассажиров предусматривает следующий порядок:\n" +
                        "1) регистрация вылетающих пассажиров в аэропорту начинается не позднее двух часов до вылета воздушного судна (в зависимости от типа воздушного судна и количества пассажиров) на международных рейсах и не позднее 1,5 часов до вылета воздушного судна (в зависимости от типа воздушного судна и количества пассажиров) на внутренних рейсах и заканчивается за 40 минут до вылета воздушного судна;\n" +
                        "2) получение агентами от диспетчера сведений о номере и типе воздушного судна, количестве посадочных мест, авиакомпании, количестве проданных билетов и дополнительных сведений о вылетающих особо важных пассажирах, инвалидах, больных, трансферных и транзитных пассажирах, пассажирах зарегистрированных через интернет, стойки саморегистрации и другие виды связи;\n" +
                        "3) подготовка агентом перевозочной документации, необходимой для оформления рейса (посадочные талоны, багажные номерные бирки, бирки «ручная кладь», «стекло» и, в случае ручной регистрации, пассажирские манифесты и багажные ведомости);\n" +
                        "4) проверка агентами действительности и правильности оформления предоставленного пассажирам билета, даты и номера рейса, времени отправления, аэропорта назначения, наличия штампа места продажи, срока годности билета и наличия фамилии пассажира в списке PNL. При необходимости проверяет наличие записи и штампа в графе «Передаточная надпись».\n" +
                        "5) наружный осмотр принимаемого к перевозке багажа;\n" +
                        "6) взвешивание предъявленного пассажиром багажа и ручной клади;\n" +
                        "7) внесение данных о багаже на данный/стыковочный рейс(ы);\n" +
                        "8) агент определяет количество мест, массу багажа и ручной клади, наклеивает багажные номерные бирки на принятый к перевозке багаж и бирки «ручная кладь» на ручную кладь. Отрывные талоны багажных бирок передаются пассажиру. При регистрации группы пассажиров, следующих в один пункт назначения, автоматической регистрации агент оформляет весь принятый к перевозке багаж на одного взрослого пассажира в группе в режиме «семейный» или «групповой», ручной регистрации агент сверяет общую массу с общей массой бесплатного провоза багажа на всю группу и делает соответствующие пометки в пассажирском манифесте.\n" +
                        "9) определение и оформление сверхнормативного багажа с внесением данных в систему регистрации билетов;\n" +
                        "10) во избежание возникновения конфликтных ситуаций при выявлении каких-либо нарушений, связанных с процедурой регистрации билетов и оформления багажа (отказ пассажира выполнять требования авиакомпании, нарушения в оформлении билетов), немедленно информируется начальник смены;\n" +
                        "11) по окончании регистрации агент, взаимодействуя с агентом зала официальных делегаций (ВИП, СИП залы) аэропорта, обслуживающим особо важных пассажиров, сверяет количество зарегистрированных пассажиров по каждому пункту посадки и в целом по рейсу.\n" +
                        "При автоматической регистрации агент выводит на печать необходимое количество пассажирских манифестов, ручной регистрации подводит итоги по каждому сектору регистрации и передает общий итог регистрации диспетчеру для составления сводной загрузочной ведомости.\n" +
                        "12) приемосдатчик/грузчик багажа подсчитывает количество мест багажа по каждому пункту загрузки и сверяет его с данными по каждому сектору регистрации.\n" +
                        "При ручной регистрации приемосдатчик/грузчик багажа получает от агента данные о количестве мест и весе зарегистрированного багажа, зафиксированные в пассажирском манифесте. Сверив полученные данные с фактическим количеством мест багажа по каждому пункту разгрузки, загружает воздушное судно в соответствии с положениями авиакомпании по загрузке воздушного судна и заверяет фактические данные подписью.\n" +
                        "13) регистрация пассажиров, опоздавших ко времени окончания регистрации, не производится;\n" +
                        "14) агент приглашает пассажиров из зала ожидания в телескопический трап на посадку, или, при посадке на дальние стоянки в перронное транспортное средство;\n" +
                        "15) агент проверяет у пассажиров посадочные талоны, сверяет фамилию пассажира, указанную на посадочном талоне, с фамилией в документе, удостоверяющем личность, вносит данные пассажира, прошедшего посадку в систему, и при наличии специальных устройств, сканирует информацию с посадочного талона.\n" +
                        "Перед отправкой перронного транспортного средства агент объявляет пассажирам наименование авиакомпании, маршрут следования и номер рейса.\n" +
                        "16) обо всех нарушениях, связанных с процедурой посадки вылетающих пассажиров и оформлением полетной документации (несоответствие количества посадочных талонов общему количеству зарегистрированных пассажиров, несоответствие количества посадочных талонов по классам обслуживания, неявка пассажира на посадку), немедленно информируются диспетчер и начальник смены аэропорта;\n" +
                        "17) по окончании посадки пассажиров в воздушное судно агент уточняет у бортпроводника фактическое количество пассажиров на рейсе, сверяя его с посадочными талонами и итоговыми данными регистрации, полученными от диспетчера аэропорта, и делает необходимые изменения в графе «LMC» сводной загрузочной ведомости;\n" +
                        "18) агент передает сводную загрузочную ведомость и центровочный график второму пилоту воздушного судна и докладывает диспетчеру о завершении посадки на рейс и начале руления воздушного судна;\n" +
                        "19) багаж неявившихся пассажиров на борт воздушного судна снимается в обязательном порядке.\n" +
                        "   7. При регистрации багажа пассажиров, зарегистрированных через интернет, стойки саморегистрации и другие средства связи, агенты на отдельной стойке (оформление багажа зарегистрированных пассажиров) сверяют посадочные купоны с документами пассажира и производят регистрацию багажа в соответствии с положениями авиакомпании. Стойка саморегистрации и регистрации багажа закрывается за 40 минут до вылета.\n" +
                        "   8. Прием, оформление, доставку, погрузку и выдачу багажа обеспечивают взаимодействующие в указанных операциях:\n" +
                        "1) агент;\n" +
                        "2) приемосдатчик/грузчик;\n" +
                        "3) бортпроводник/представитель авиакомпании.\n" +
                        "   9. При осуществлении международных полетов маршрутная квитанция необходима во время прохождения паспортного контроля в качестве доказательства обратного билета.\n" +
                        "   10. Регистрация билетов и оформление багажа вылетающих пассажиров производятся на стойках в операционном зале или посредством других способов регистрации.\n" +
                        "   11. При регистрации пассажира с детьми агент проверяет документ, подтверждающий возраст ребенка (свидетельство о рождении).\n" +
                        "   12. Регистрация билета несопровождаемого ребенка при предъявлении документа, удостоверяющего личность ребенка, осуществляется в соответствии с положениями авиакомпании. Предоставление мест в салоне воздушного судна осуществляется согласно статуса билета.\n" +
                        "   13. При обслуживании больных пассажиров агент проверяет наличие авиабилета и медицинское заключение, содержащее разрешение на их перевозку воздушным транспортом, с указанием специальных требований к условиям перевозки такого пассажира, после чего оформляет перевозочные документы согласно авиационным стандартам международной организации в сфере гражданской авиации, а также с учетом положений авиакомпании.\n" +
                        "   14. При обслуживании беременных пассажиров агент рейса проверяет наличие авиабилета, обменной карты (при любом сроке беременности) и медицинское заключение для беременных пассажиров со сроком беременности от двадцати восьми до тридцати шести недель, содержащее разрешение на его перевозку воздушным транспортом. Беременные пассажиры с более чем тридцатью шести неделями беременности к перевозке на воздушном транспорте не принимаются.\n" +
                        "3. Порядок обслуживания прилетающих пассажиров\n" +
                        "   15. Обслуживание прилетающих пассажиров предусматривает следующий порядок:\n" +
                        "1) после объявления диспетчером расчетного времени прибытия рейса агенты получают от диспетчера службы перевозок следующую информацию о прибывающем воздушном судне:\n" +
                        "номер рейса;\n" +
                        "время прибытия;\n" +
                        "планируемая стоянка;\n" +
                        "количество пассажиров, включая трансферных и транзитных пассажиров;\n" +
                        "количество веса багажа;\n" +
                        "информация о пассажирах, которым необходимы помощь или специальное обслуживание;\n" +
                        "2) агент встречает пассажиров у телескопического трапа или следует с пассажирами в перронное транспортное средство до здания аэровокзала;\n" +
                        "3) агент следит за порядком и доставкой пассажиров в зал прилета терминала аэропорта для прохождения паспортного контроля (на международных рейсах) и получения багажа;\n" +
                        "4) приемосдатчик/грузчик, производящий выгрузку багажа с борта воздушного судна, осматривает исправность упаковки и в случае обнаружения неисправности сообщает представителю авиакомпании и агенту;\n" +
                        "5) представитель авиакомпании/приемосдатчик/грузчик/агент ведет прием багажа с воздушного судна, подсчитывает количество мест багажа при загрузке, сверяет данные в соответствии с полетными документами.\n" +
                        "Все обнаруженные неисправности отражаются в багажной ведомости (характер неисправности, номер багажной бирки), заверяются подписью и фамилией агента и представителя авиакомпании.\n" +
                        "6) багаж доставляется в багажное отделение аэропорта;\n" +
                        "7) приемосдатчик/грузчик производит выгрузку багажа на транспортерную ленту.\n" +
                        "В багажное отделение аэропорта багаж пассажиров бизнес-класса («приорити») и трансфертных пассажиров доставляется в первую очередь.\n" +
                        "8) по всем случаям ненадлежащей воздушной перевозки багажа агентом составляется коммерческий акт о ненадлежащей воздушной перевозке багажа (далее - акт PIR). В случае неприбытия/повреждения багажа основанием для составления акта PIR служит заявление пассажира.\n" +
                        "4. Порядок обслуживания трансферных пассажиров\n" +
                        "   16. При регистрации трансферных пассажиров и оформлении багажа агент использует специальные багажные номерные бирки авиакомпании.\n" +
                        "   17. Трансферный багаж загружается на борт воздушного судна в отдельный багажный отсек. При отсутствии свободного багажного отсека багаж трансферных пассажиров загружается в последнюю очередь.\n" +
                        "   18. В багажное отделение аэропорта багаж трансферных пассажиров доставляется в первую очередь.\n" +
                        "5. Порядок обслуживания транзитных пассажиров\n" +
                        "   19. Транзитный пассажир отправляется из аэропорта транзита согласно указанным в билете дате и рейсу. При международной перевозке транзитный пассажир в аэропорту остановки находится в зале для транзитных пассажиров.\n" +
                        "   20. В случае невозможности отправки транзитного пассажира желательным для него рейсом, авиакомпания предлагает пассажиру место на другой рейс или другую дату вылета. При отказе транзитного пассажира от предложенных авиакомпанией рейса или даты вылета авиакомпания по требованию транзитного пассажира возвращает деньги за невыполненную перевозку по билету в соответствии с правилами применения тарифов авиакомпании.\n" +
                        "6. Порядок обслуживания пассажира при предъявлении им претензии на ненадлежащую воздушную перевозку багажа\n" +
                        "   21. Факт ненадлежащей воздушной перевозки багажа, который служит основанием для подачи пассажиром претензии, удостоверяют коммерческим актом PIR. Акт составляют непосредственно в аэропорту обнаружения неисправности либо в аэропорту прибытия.\n" +
                        "   22. Основаниями для составления коммерческого акта PIR являются:\n" +
                        "1) несоответствие наименования багажа, массы или числа мест багажа, указанных в документах;\n" +
                        "2) недостача содержимого багажа;\n" +
                        "3) повреждение багажа;\n" +
                        "4) обнаружение багажа без документов.\n" +
                        "   23. Коммерческий акт PIR составляют и подписывают:\n" +
                        "1) представитель авиакомпании - лицо, ответственное за актируемый багаж;\n" +
                        "2) агент - лицо, удостоверяющее факт, изложенный в акте;\n" +
                        "3) получатель багажа (заинтересованное лицо).\n" +
                        "Дополнительное количество лиц, привлекаемых к составлению акта, зависит от характера ненадлежащей воздушной перевозки багажа. Представитель авиакомпании после составления коммерческого акта PIR отправляет сообщение с указанными в акте данными агенту по рекламациям в базовый аэропорт авиакомпании, проводит розыск, выясняет факт и причины.\n" +
                        "   24. Обо всех случаях ненадлежащей воздушной перевозки багажа немедленно информируется начальник смены либо агент и представитель авиакомпании.\n" +
                        "   25. При неприбытии багажа или недостаче его по количеству мест агент принимает от пассажира претензионное заявление, составляет акт PIR в трех экземплярах, в которых указывает номер, дату вылета рейса, маршрут следования воздушного судна, номера багажных бирок и описание багажа.\n" +
                        "7. Порядок обслуживания пассажиров с ограниченными возможностями\n" +
                        "   26. Обслуживание пассажиров с ограниченными возможностями предусматривает следующий порядок:\n" +
                        "1) регистрация пассажира, имеющего инвалидность по зрению и в сопровождении собаки-поводыря, осуществляется в соответствии с положениями авиакомпании;\n" +
                        "2) при перевозке людей, имеющих ограниченные возможности передвижения, после проведения соответствующих процедур по линии регистрации представитель авиакомпании/аэропорта сопровождает их к (от) воздушному судну и вместе с документами передает его/их непосредственно экипажу;\n" +
                        "3) агент оказывает помощь в прохождении пограничного, таможенного контроля и других процедур оформления.\n" +
                        "    Обслуживание людей с ограниченными возможностями в соответствии с положениями авиакомпании осуществляет агент.\n" +
                        "    При перевозке лиц, пользующихся креслом-коляской, представитель авиакомпании/аэропорта предоставляет специальное кресло для транспортировки в салоне воздушного судна.\n" +
                        "   Посадка в воздушное судно лиц с ограниченными возможностями производятся представителем аэропорта в первую очередь до объявления посадки основной части пассажиров и высадка из воздушного судна в последнюю очередь.");
                break;
        }
        return view;
    }

}
