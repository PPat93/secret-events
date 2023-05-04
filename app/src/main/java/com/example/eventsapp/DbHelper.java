package com.example.eventsapp;

import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DbHelper {

    public DbHelper() {
        super();
    }

    public static int getFirstRecordOfEvents() {

        Cursor c = MainListActivity.eventsDB.rawQuery("SELECT * FROM events LIMIT 1;", null);

        c.moveToFirst();
        int tableSize = c.getCount();
        c.close();
        return tableSize;
    }

    public static void fillDB() {
        MainListActivity.eventsDB.execSQL("CREATE TABLE IF NOT EXISTS " +
                "events (" +
                "passphrase VARCHAR(100), " +
                "title VARCHAR(100), " +
                "type VARCHAR(15), " +
                "address VARCHAR(100), " +
                "description VARCHAR(255), " +
                "is_visible BOOLEAN, " +
                "hour VARCHAR(10), " +
                "image_name VARCHAR(20), " +
//                order_number it is a string, so List format can be easier to maintain - it is List<String, List<String>>
//                instead of more complicated List<String, List<SomeObjectWithStringAndInt>>
                "order_number VARCHAR(3)" +
                ")");

//        protection so db is filled only if no data exists in db
        if (getFirstRecordOfEvents() == 0) {

//            All passphrases must be lower cased - in order to maintain better user experience and avoid necessity of explaining
//            what should be upper and what should be lower case after giving the pass to the user, anything that matches letters and
//            special chars of the pass is accepted - no matter if lower or upper case.

//            MISC
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('tutorial', 'Tutaj pojawi się tytuł wydarzenia', 'Patisserie', 'Adres w mapach google', 'Krótki opis wydarzenia oraz wszystkie podstawowe informacje pojawią się w tej sekcji.', '0', 'Dzień i godzina wydarzenia', 'example', '100000')"); // TODO - update with our smiled photo, along with all appropriate dates and days - not for public git push
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('jedziemy na wycieczkę', '...bierzemy misia w teczkę, cel: PRAGA!', 'Flight', 'Dublin Airport', 'Właśnie tu rozpocznie się Twoja wielka przygoda z okazji 30 urodzin! Weź mnie za rękę, odpręż się i ciesz wycieczką. Daj się ponieść i niczym nie przejmuj. Całość została zorganizowana, co do minuty, przez Twoją bratnią duszę. Dobrej zabawy!', '0', 'Sobota 9:15', 'pct_flight_to', '200000')");

//            FOOD
//            Breakfast
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('czeska targowica', 'Sobotnie, świeże śniadanie', 'Restaurant', 'Rašínovo nábřeží Vltavská, Náplavka, 120 00 Praha 2, Czechy', 'Farmářské tržiště Náplavka - to sobotni targ nad brzgiem Wełtawy. Lokalni wytwórcy co tydzień wystawiają się w około 90 stoiskach oferując potrawy, wypieki, ceramikę i wiele innych lokalnych produktów. Idealne miejsce na świeże śniadanie.', '0', 'Sobota 9:15', 'pct_naplavka_market', '300000')");

//            Lunch/Dinner

//            Supper
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('praskie brambory', 'Frites Butik', 'Restaurant', 'Náplavní 11, 120 00 Nové Město, Czechy', 'Prawdziwe frytki belgijskie, prowadzone przez prawdziwego Belga! Dodatkowo przekąski belgijskie i duńskie. Podobno najlepsze w Pradze! Otwarte do późna wieczorem, więc idealne na kolację.', '0', 'Tuesday 01:00', 'pct_frites_butik', '400000')");

//            Pubs/Additional food
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('idziemy do psychologa', 'Shrink''s Office', 'Bar', 'Jungmannova 23/11, 110 00 Nové Město, Czechy', 'Nigdy nie wiesz co się może kryć w odmętach Twej zagadkowej podświadomości. Warto sprawdzić czy wszystko w porządku. Co bardziej skłania do zwierzeń niż psycholog? Alkohol! Połączmy obydwie te rzeczy w jedynym w swoim rodzaju barze!', '0', 'Piątek 11:00', 'pct_shrinks_office', '500000')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('kominowe zawijasy', 'Trdelniki, takie jak w Krakowie', 'Patisserie', 'Josefov CZ, U Starého Hřbitova 42/2, Staré Město, 110 00 Praha, Czechy', 'Trdelníki! Pomimo, że są to Czechy, a trdelniki są na każdym rogu, najczęściej nie mają wysokich ocen. I oto nadchodzi on! Zbawca słodkich kominów, najwyżej oceniane w Pradze - Trdelnik & Coffe! I to z lodami!', '0', 'Czwartek 10:00', 'pct_trdelnik_coffe', '600000')");

//            Fine Dining

//            PLACES TO VISIT
//            Activities
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('straszne rzeczy', 'Prague Ghosts Walking Tour', 'Event', '7, Týnská 627, Staré Město, 110 00 Praha-Praha 1, Czechia', 'Wyrusz w przerażającą pieszą podróż po ulicach Pragi w akompaniamencie wycia i jęków potępionych dusz. Zwiedzanie starego miasta z przewodnikiem opowiadającym o mieście oraz jego legendach to coś co tygryski lubią najbardziej. Idziemy poznawać mniej oczywistą stronę miasta!', '0', 'Piątek 19:30', 'pct_ghost_tour', '700000')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('laserowe dokulturalnianko', 'Signal Festival 2023!', 'Event', 'Cała Praga', 'Przygotuj się na mnóstwo chodzenia gdyż oto jest - jedyny w swoim rodzaju świetlny festiwal będący jednocześnie wielką wystawą sztuki. Zanurz się w ulicach Pragi z ukrytymi dziesiątkami instalacji artystycznych. Widowisko każdego dnia po zmroku rozjarzone milionami kolorów', '0', '12-15 Październik', 'pct_signal', '800000')"); // TODO - update with current year photo after tickets are available

//            Attractions
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('jakieś ruiny', 'Kompleks zamkowy!', 'Sightseeing', 'Second Courtyard of Prague Castle, Hradčany, 119 00 Praha 1, Czechy', 'Zawijaj kiecę i lecimy na kompleks zamkowy! Co prawda nie rabować i gwałcić, tylko zwiedzać i podziwiać, ale to przecież tak samo fajne. Trochę to będzie trwało, ale obejrzymy co najmniej pałac, bazylikę i katedrę. Proponuję trasę B z przewodnikiem, gdyż dodatkowe miejsca z trasy A nie są wysoko oceniane i mogą być stratą czasu, którego i tak za wiele nie mamy. W każdym razie liczę na to, że poczujesz się jak arstokratka wśród antycznych ścian!', '0', '12:00', 'pct_palace', '900000')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('prawie jak gubałówka', 'Kolejka na Petrin', 'Attraction', 'U Lanové dráhy 118 00, 118 00 Malá Strana, Czechy', 'Co może być lepsze niż bezwysiłkowy wyjazd kolejką na punkt widokowy? Darmowy bezwysiłkowy wyjazd kolejką na punkt widokowy! Wliczona w cenę 72h biletu komunikacyjnego kolejka na Petrin pozwoli Ci osiągnąć wyżyny. Poza widokami pięknymi widokami spacer po terenach zielonych uspokoi umysł i pobudzi zmysły.', '0', '12:00', 'pct_petrin', '1000000')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('czeski film', 'Narodowe muzeum filmowe', 'Attraction', 'Jungmannova 748/30, 110 00 Nové Město, Czechy', 'Pełne zanurzenie w oparach absurdu czeskiego kina! Narodowe muzum filmowe wprowadzi Cię w tajniki wielkiego ekranu, ale też udowodni, że nie bez powodu powstało w Polsce powiedzenie ''Czeski film''. Zachwyć się i pośmiej w tym jedynym w swoim rodzaju interktywnym muzeum opowiadającym o sztuce filmowej.', '0', '12:00', 'pct_na_film', '1050000')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('za darmo to uczciwa cena', 'Vysehrad czyli kompleks zamkowy', 'Attraction', 'V Pevnosti 159/5b, 128 00 Praha 2-Vyšehrad, Czechy', 'Darmowy kompleks zamkowy Vysehrad kusi nie tylko uczciwą ceną, ale też przepięknymi parkam i dawnymi budynkami. W okolicy natrafisz na małe galerie, muzea i ruiny ''Tego drugiego zamku''. Ubierz dobre buty i zadbaj o butelkę z wodą, bo fosa niestety już dawno wyschła.', '0', '12:00', 'pct_vysehrad_national_monument', '1075000')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('śmieszne ruchanki', 'Muzeum maszyn seksualnych', 'Attraction', 'Melantrichova 476 /18, 110 00 Staré Město, Czechy', 'Nie będę ukrywać, nie jest to muzeum z Amsterdamu. Wrzuciłem tu jako backup, gdyby inne opcje zawiodły. Jednakże, mimo wszystko można się tu dobrze - he he - zabawić. Maszyny do seksu wszelkich rodzajów i wielkości czekają na Ciebie! Kto wie, być może odnajdziesz tam parę pomysłów i inspiracji?', '0', '12:00', 'pct_sex_machines_museum', '1082500')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('czas ucieka', '...wietrzność czeka', 'Attraction', 'Staroměstské nám. 1, 110 00 Josefov, Czechy', 'Jeden z najsłynniejszych zegarów astronomicznych na świecie. Uważaj, może akurat wydarzy się koniunkcja planet, która - jak wiemy z filmów - nigdy nie zwiastuje niczego dobrego. A na dokładkę, obejrzyj sobie obok ratusz z XIVw. Nie jest tak skomplikowany jak zegar, ale z pewnością robi nie mniejsze wrażenie.', '0', '12:00', 'pct_astronomical_clock', '1091250')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('kolejny pałac', 'Dwór Lobkowiczów', 'Attraction', 'Jiřská 3, 119 00 Praha 1-Hradčany, Czechy', 'Lobkowiczký palác to jedyny prywatny obiekt w kompleksie zamkowym. Muzeum wewnątrz zawiera zbiór rodziny Lobkowiczów, będący jednym z największych i najstarszych zbiorów w czechach. Nie ukrywam, musiało coś srogo nie wypalić skoro płacimy za kolejne muzemu w ciągu ostatnich 3 godzin. Nogi Cię nie bolą? No nic, dawaj. Może trafimy akurat na koncert muzyki klasycznej?', '0', '12:00', 'pct_palac_lobkowiczow', '1095625')");

//            Strolling
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('karol mostowiak', 'Charles Bridge', 'Sightseeing', 'Karlův most, 110 00 Praha 1, Czechy', 'Przejdźmy się najbardziej znanym mostem w Czechach. Zbudowany w średniowieczu na rzece Wełtawie, nie tylko pozwolił rozkwitnąć Pradze dzięki umożliwieniu wschodnio-zachodniego handlu, ale też stał się jednym z najbardziej ikonicznych miejsc w Europie. Dodane w Baroku statuły przedstawiają świętych oraz lokalnych mecenasów sztuki. Daj się poprowadzić na drugą stronę! ', '0', '14:00', 'pct_charles_bridge', '1100000')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('idziom', 'Biblioteka Miejska w Pradze', 'Sightseeing', 'Mariánské nám. 98/1, 110 00 Josefov, Czechy', 'Biblioteki to miejsca, które niewątpliwie na Ciebie działają - wiemy to oboje. Z tego powodu prgnę zaprosić Cię do biblioteki miejskiej w Pradze. Rzeźba ''Idiom'' z pewnością Cię zaciekawi, choć nie wiem jak będziesz się czuła w związku z takim wykorzystaniem książek. Mi coś ona zdecydowanie przypomina...', '0', '14:00', 'pct_municipal_library', '1200000')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('o jaka wielka', 'Praska brama prochowa', 'Sightseeing', 'Nám. Republiky 5, 110 00 Staré Město, Czechy', 'Kolejny punkt spacerowy to Prasna Brama. Pierwotnie reprezentacyjna budowla obok dworu Władysława Jagiellończyka, została później zdegradowana zaledwie do składnicy prochu - stąd nazwa. Na szczycie tego 65 metrowego antycznego giganta znajduje się taras widokowy dla turystów. Niestety opłata jest dosyć znaczna, a Ty nie przepadasz za wysokościami, toteż polecam całość podziwiać z dołu.', '0', '14:00', 'pct_brama_prochowa', '1300000')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('to nie karuzela', 'Obrotowa głowa Franza Kafki', 'Sightseeing', 'Charvátova, 110 00 Nové Město, Czechy', 'Gdzież indziej można było postawić pomnika Franza Kafki jeśli nie obok jego byłego miejsca pracy (dawniej urząd, obecnie budynek towarzystwa ubezpieczeniowego) w mieście gdzie spędził większość życia? Ogromna metalowa rzeźba o wadze 39 ton robi niesamowite wrażenie, dodatkowo, cyklicznie wykonywane obroty zmieniają dynamikę obiektu i zapewniają niesamowite doznania wizualne.', '0', '14:00', 'pct_franz_kafka', '1400000')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('idz do domu, jesteś pijany', 'Tańczący dom', 'Sightseeing', 'Jiráskovo nám. 1981/6, 120 00 Nové Město, Czechy', 'Tańczący dom to jeden z najbardziej rozpoznawalnych budynków w Czechach. I jednocześnie jakiś taki... nietaki - coś jak krzywy domek w sopocie. To co prawda tylko przystanek na dłuższej trasie, ale i tak jest interesujący. Nie marudź, coś innego nie wypaliło skoro to Ci pokazuję.', '0', '14:00', 'pct_dancing_house', '1500000')");

//            Misc
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('dupa', 'Bardzo dojrzałe...', 'Sightseeing', 'Odwróć się i pochyl', 'Skąd wiedziałem że to wpiszesz? Ale z Ciebie dzieciuch, no wiesz co... No nic, doceniam ~kreatywność~, masz mema w nagrodę. Niestety nie znalazłem nic śmieszniejszego o dupie. Podrzuć mi hasło ''Bułeczka'', to dostaniesz nagrodę ;)', '0', 'Wieczorem', 'pct_dupa', '1600000')");


        }
    }
}