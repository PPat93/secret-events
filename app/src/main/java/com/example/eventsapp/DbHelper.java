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
                    "VALUES ('tutorial', 'Tutaj pojawi się tytuł wydarzenia', 'Patisserie', 'Adres w mapach google', 'Krótki opis wydarzenia oraz wszystkie podstawowe informacje pojawią się w tej sekcji.', '0', 'Dzień i godzina wydarzenia', 'example', '1')"); // TODO - update with our smiled photo, along with all appropriate dates and days - not for public git push
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('jedziemy na wycieczkę', '...bierzemy misia w teczkę, cel: PRAGA!', 'Flight', 'Dublin Airport', 'Właśnie tu rozpocznie się Twoja wielka przygoda z okazji 30 urodzin! Weź mnie za rękę, odpręż się i ciesz wycieczką. Daj się ponieść i niczym nie przejmuj. Całość została zorganizowana, co do minuty, przez Twoją bratnią duszę. Dobrej zabawy!', '0', 'Sobota 9:15', 'pct_flight_to', '100')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('dupa', 'Bardzo dojrzałe...', 'Sightseeing', 'Odwróć się i pochyl', 'Skąd wiedziałem że to wpiszesz? Ale z Ciebie dzieciuch, no wiesz co... No nic, doceniam ~kreatywność~, masz mema w nagrodę. Niestety nie znalazłem nic śmieszniejszego o dupie. Podrzuć mi hasło ''Bułeczka'', to dostaniesz nagrodę ;)', '0', 'Wieczorem', 'pct_dupa', '200')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('prawie królewskie warunki', 'Królewski hotel czeka', 'Hotel', 'to be filled', 'Fakt, może przesadziłem delikatnie z tytułem, ale z drugiej strony takie oceny i ilość gwiazdek coś obiecują, prawda? Standard wysoki, jest nawet recepcja i prawie samo centrum. Poza tym sorry, nic lepszego w moim budżecie nie było :P To będzie nasza baza wypadowa na kilka najbliższych dni. Jak to mówią, nasze spanko i ru... chu dużo.', '0', 'długo', 'pct_dupa', '300')"); //  TODO add picture, name, address and dates but without pushing to git


//            FOOD
//            Breakfast
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('czeska targowica', 'Sobotnie, świeże śniadanie', 'Breakfast', 'Rašínovo nábřeží Vltavská, Náplavka, 120 00 Praha 2, Czechy', 'Farmářské tržiště Náplavka - to sobotni targ nad brzgiem Wełtawy. Lokalni wytwórcy co tydzień wystawiają się w około 90 stoiskach oferując potrawy, wypieki, ceramikę i wiele innych lokalnych produktów. Idealne miejsce na świeże śniadanie.', '0', 'Sobota 9:15', 'pct_naplavka_market', '300000')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('fancy śniadanko', 'Bistro Monk', 'Breakfast', 'Michalská 20, 110 00 Staré Město, Czechy', 'Bistro Monk to knajpka ze śniadaniami w samym centrum Pragi. Z uwagi na wysokie opinie i świetne składniki, może być problem się tam dostać, ale najwyżej poczekamy w kolejce, c''nie? Poza tym zdjęcie mówi wszystko - ładne, dobre i w miarę umirakowane ceny.', '0', 'Sobota 9:15', 'pct_bistro_monk', '350000')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('revenue pewnie wysokie', 'Venue', 'Breakfast', 'Havelská 4, 110 00 Staré Město, Czechy', 'Wymyślne śniadania cały dzień? Toż to spełnienie marzeń! Co prawda rano dostać się na miejsce to podobno koszmar, ale cóź to dla nas? Posiłki nie są ogromne, ale za to może spróbujesz dwóch? A jeśli nie, to dopchniemy Cię na przykład jakimś deserem.', '0', 'Sobota 9:15', 'pct_venue', '355000')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('oby faktycznie brylant', 'Jewel by Venue', 'Breakfast', 'Rytířská 529/3, 110 00 Staré Město, Czechy', 'Sublokal znanego i powszechnie lubianego bistro Venue. Z grubsza to samo - wymyślne śniadania w akompaniamencie długiej kolejki czekającej na stolik. Podobnie tutaj, porcje nie są ogromne, ale za to będziesz miała miejsce na desrki z piekarni!', '0', 'Sobota 9:15', 'pct_jewel', '355500')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('jemy bagle', 'Bajgle na śniadnie?', 'Breakfast', 'Letenská 118/1, 118 00 Malá Strana, Czechy', 'Jak mówiła Smutna Grubaska z TikToka - ''Idziemy jeść bagle!''. Idealnie umiejscowiona restauracja Bagel Lounge z bajgielkami na śniadanie, w sam raz na naszej trasie do zamku i zwiedzania. Złap jednego albo dwa, z frytkami - żebyś miała dużo siły na oglądanie i podziwianie zabytków. No i poza tym jedz, bo w domu takiego nie ma.', '0', 'Sobota 9:15', 'pct_bajgle', '355550')");
MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('nie tylko trawa', 'Mezi Srnky', 'Breakfast', 'Sázavská 19, 120 00 Praha 2-Vinohrady, Czechy', '''Wśród Jeleni'', wbrew nazwie nie serwuje wyłącznie wegetariańskich posiłków. Obfite śniadanko w sensownej cenie? Oczywiście, że tak! Miejsce nie jest wielkie, ale za to bardzo popularne i ma niesamowicie wysokie opinie. Dzięki temu będziesz miała dużo siły na mnóstwo chodzenia przez cały dzień.', '0', 'Sobota 9:15', 'pct_wsrod_jeleni', '355555')");

//            Lunch/Dinner
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('fancy ale z umiarem', 'Jemy u Glaubiců', 'Restaurant', 'Malostranské nám. 266/5, 118 00 Malá Strana, Czechy', 'Czeskie, tradycyjne jedzenie - u Glaubiców - tak naprawdę to jest jedyne tłumaczenie jakie ogarnąłem, więc zapewne jest to nazwisko? Czyli co? Zasmażany syr i piwo? Po zamku na pewno jesteś głodna, a to jest najbliższa sensowna knajpka. Opinie i ich ilość mówią same za siebie. Jest co prawda troszkę fancy, ale w granicach rozsądku. Będziesz zadowolona!', '0', 'Sobota 9:15', 'pct_glaubicowie', '356000')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('ordynarna świnia', 'Pork''s', 'Restaurant', 'Mostecká 16, 110 00 Malá Strana, Czechy', 'No Bób mi świadkiem! Chciałem tego uniknąć. Musiało coś się wydarzyć z Glaubicowami, bo naprawdę nie chciałem Cię brać na tak ordynarne wiejśkie dania ze świni. Ale za to ceny rozsądne, opinie wysokie, blisko zamku po latach zwiedzania - kto wie, może nawet Ci się przypomni nasza kuchnia narodowa?', '0', 'Sobota 9:15', 'pct_pork', '356600')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('ciuchcia', 'Lepszy trainspotting', 'Restaurant', 'Václavské nám. 802/56, 110 00 Nové Město, Czechy', 'Jedzenie zajeżdza na stół pociągiem! I klimat jest naprawdę niepowtarzalny! Jestem mega ciekawy. Ale z drugiej strony to tylko burgery (zwłaszcza że to Twoje święto!), są trochę przepłacone i lokal Výtopna jest zawsze full. Plus opinie nie urywają czterech liter. Wrzucam tu jako alternatywkę, gdybyś jakimś cudem chciała burgera :P', '0', 'Sobota 9:15', 'pct_vytopna', '360000')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('kluski z mydłem', 'Wielkie knedliska', 'Restaurant', 'Národní 115/24, 110 00 Nové Město, Czechy', 'Jadłaś kiedyś prawdziwe knedle? Ale takie oryginalne od czeskiego chłopa? Nie? No to teraz może nie do końca od chłopa, ale na pewno oryginalne i z Czech!. Kolejny klasyk kuchni naszego sąsiada - ale uważaj, są WIELKIE! Ceny też zajebiste, czyt. nie żałuj sobie bo prędko takich nie zobaczysz.', '0', 'Sobota 9:15', 'pct_knedle', '366000')");

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
                    "VALUES ('kominowe zawijasy', 'Trdelniki, takie jak w Krakowie', 'Patisserie', 'Josefov CZ, U Starého Hřbitova 42/2, Staré Město, 110 00 Praha, Czechy', 'Trdelník & Coffee - nazwa trochę bez polotu, ale... TRDELNIKI! Pomimo, że są to Czechy, a trdelniki są na każdym rogu, najczęściej nie mają wysokich ocen. I oto nadchodzi on! Zbawca słodkich kominów, najwyżej oceniane w Pradze - Trdelnik & Coffe! I to z lodami!', '0', 'Czwartek 10:00', 'pct_trdelnik_coffe', '600000')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('pączkosanty', 'Oh Jeleń Piekania', 'Patisserie', 'Bělehradská 606/87, 120 00 Praha 2-Vinohrady, Czechy', 'Ok, tak naprawdę miejsce nazywa się ''Oh Deer Bakery'' - w wolnym tłumaczeniu - tak jak tytuł. Pozwól się zaszokować niesamowitymi pączko-croissantami. Mam podejrzenia że będzie to twoje ulubione miejsce w całym mieście. Mają 4 miejsca - to wymienione jest blisko hotelu, drugie wygodne - w centrum. Zdobądźmy kolejny level nad dotychczasowymi pączkarniami!', '0', 'Czwartek 10:00', 'pct_oh_deer', '650000')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('bez pracy nie ma kołaczy', 'Czeskie kołacze', 'Patisserie', 'Korunní 90, 101 00 Vinohrady, Czechy', 'Nie wiem jak Ty, ale pamiętam że dawniej kołacze były w każdej piekani. W sumie, nie mam pojęcia kiedy ostatnio je jedliśmy. No i dobrze się składa, bo Czechy to ojczyzna kołacza! Ta cukiernia akurat jest trochę nie po drodze, ale za to opinie ma wybitne. I widziałem na zdjęciach że czasem mają pistacjowe... Poza tym , śmiesznie się nazywa - Kus Koláče.', '0', 'Czwartek 10:00', 'pct_kolacze', '655000')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('artystyczne wypieki', 'Artic Bakehouse', 'Patisserie', 'Myslíkova 187/13, 110 00 Nové Město, Czechy', 'Jak sama nazwa wskazuje, czeskie kraftowe wypieki w swej pełnej krasie. od chlebów po dziwne wieżo-cynamonki. Trochę nam nie po drodze, ale może warto nadłożyć trasy aby spróbować tych małych cudów? Mają kilka miejsc i ewidentnie trzymają poziom. Nie mam pojęcie jak nazywa się połowa rzeczy na wystawie, więc ufam że mi wytłumaczysz.', '0', 'Czwartek 10:00', 'pct_artic_bakery', '655500')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('jakubie zrób mi loda', 'Crème de la Crème', 'IceCream', '12, Husova 231, Staré Město, 110 00, Czechy', 'Z jakiegoś powodu ludzie dostają szału gdy słyszą nazwę ''Crème de la Crème - Zmrzlinárna Husova''. Przecież to tylko lody! Chociaż nigdy nie możesz być pewna czy to faktycznie TYLKO to. Myślę, że trzeba to sprawdzić. Mam nadzieję że nie będzie zimno - ale z drugiej strony - czy to nas kiedykolwiek powstrzymało przed lodami?', '0', 'Czwartek 10:00', 'pct_crem_de_la', '655550')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('czajniczkowanie', 'Dobrá čajovna Praha-Václavské náměstí', 'Teahouse', 'Václavské nám. 778/14, 110 00 Nové Město, Czechy', 'Mam nadzieję że szlaczki w tytule Cię nie wystraszyły? To dobrze, bo idziemy właśnie do Dobrej Czajowni. No ok, ok. Herbaciarni. Mają herbatki ze wszystkich stron świata, podobno jest nawet jedna niebieska! Jedzenia tam zbyt wiele nie uświadczysz, ale przecież nie o to w tym chodzi.', '0', 'Czwartek 10:00', 'pct_dobra_cajownia', '655555')");

//            Fine Dining


//            Misc
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('joker', 'Café Louvre', 'Joker', 'Národní 22, 110 00 Nové Město, Czechy', 'Trzymaj się stołka, bo oto jest! Cafe Louvre - ogromny, ponad stuletni lokal o antycznym wystroju serwujący śniadania, obiady oraz kolacje. Poczujesz się jak gdybyś była częścią Bohemy, a duch dawnych czasów przenikający wnętrze z pewnością wywoła dreszcze ekscytacji. Usiądź tam, gdzie spędzały czas takie osobistości jak Enistein czy Kafka! Prawdziwy praski Jack of all trades.', '0', 'Czwartek 10:00', 'pct_louvre', '660000')");

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
                    "VALUES ('prawie jak gubałówka', 'Kolejka na Petřín', 'Attraction', 'U Lanové dráhy 118 00, 118 00 Malá Strana, Czechy', 'Co może być lepsze niż bezwysiłkowy wyjazd kolejką na punkt widokowy? Darmowy bezwysiłkowy wyjazd kolejką na punkt widokowy! Wliczona w cenę 72h biletu komunikacyjnego kolejka na Petřín pozwoli Ci osiągnąć wyżyny. Poza widokami pięknymi widokami spacer po terenach zielonych uspokoi umysł i pobudzi zmysły.', '0', '12:00', 'pct_petrin', '1000000')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('czeski film', 'Narodowe muzeum filmowe', 'Attraction', 'Jungmannova 748/30, 110 00 Nové Město, Czechy', 'Pełne zanurzenie w oparach absurdu czeskiego kina! Narodowe muzum filmowe wprowadzi Cię w tajniki wielkiego ekranu, ale też udowodni, że nie bez powodu powstało w Polsce powiedzenie ''Czeski film''. Zachwyć się i pośmiej w tym jedynym w swoim rodzaju interktywnym muzeum opowiadającym o sztuce filmowej - NaFilM: Národní filmové muzeum.', '0', '12:00', 'pct_na_film', '1050000')");
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
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('narodowe dziwadło', 'Zauważyłem, że lubisz teatr', 'Attraction', 'Národní 2, 110 00 Nové Město, Czechy', 'Z tego powodu Narodni Divadlo zostało wybrane by poszerzyć Twoje horyzonty. Właściwie to sama nazwa wszystko wyjaśnia - Teatr Narodowy, zwiedzanko z przewodnikiem. Jeden z najbardziej wyróżniających się budynków w okolicy. Wnętrza bogato zdobione złotem zostały dodatkowo udekorowane malowidłami najznamienitszych czeskich malarzy. Aha, dodatkowo kręcono tu fragmenty Jamesa Bonda Casino Royale.', '0', '12:00', 'pct_narodni_divadlo', '1097812')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('obecny dum', 'Obecní dům', 'Attraction', 'Náměstí Republiky 5, 111 21 Staré Město, Czechy', 'Przyznam szczerze, że tłumaczenie nazwy tego miejsca jest co najmniej konfundujące. Najbliższe i najswnsowniejsze co znalazłem to ''Dom reprezentacyjny'' albo po angielsku ''Municipal House''. Tak czy siak - duże, ładne, stare, antyczne, z historią. Jednen z najstarszych budynków secesyjnych. Pełni obecnie funkcje reprezentacyjne. Ma sale koncertowe i zakładam że zwiedzanie zapadnie Ci w pamięć.', '0', '12:00', 'pct_obecni_dum', '1098906')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('nie bądź jeleń', 'Muzeum Slivovice R. Jelínek', 'Attraction', 'U Lužického semináře 116/48, 118 00 Malá Strana, Czechy', 'Coś na rozluźnienie - Muzeum kolejnego czeskiego regionalnego produktu - Śliwowicy! Niemal godzinne, jedyne w swoim rodzaju zwiedzanie zakończone jest degustacją 3 lokalnie produkowanych śliwowic oraz 3 rodzajów finger foods. Dzięki temu spróbujesz nie tylko tradycyjnego napitku, ale też doświadczysz autentycznej zagrychy. I może w końcu trochę wyjmiesz kija z... :P', '0', '14:00', 'pct_muzeum_sliwowica', '1098956')");

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
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('musiał być kościół', 'Kościół Marii Panny przed Tynem', 'Sightseeing', 'Staroměstské nám., 110 00 Staré Město, Czechy', 'O co chodzi w nazwie tego kościoła? Totalnie nie mam pojęcia. Jednakże, wysokie opinie, darmowy wstęp i podobno niesamowite wnętrze zachęcają do zwiedzania. Poza tym, jeden z bardziej rozpoznawalnych i widocznych kościołów w Pradze. Plus jest na naszej trasie spacerków. Chodźmy do środka podziwiać niepotrzebnie wywalone pieniądze i zmarnowane życia robotników (xD) ', '0', '14:00', 'pct_church_tyn', '1600000')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('tajemniczy ogród', 'Valdštejnská zahrada', 'Sightseeing', 'Letenská 123/4, 118 00 Malá Strana, Czechy', 'Tytuł trochę zadziwia, co? Nie bój się - to tylko 17-wieczne ogrody. Pomniki, statuły, pawie, fontanny, a nawet ściana artyficjalnych stalaktytów - wszystko to i jeszcze więcej czeka na odkrycie w przyzamkowych ogrodach. Zanurz się w zieloności i jak łódka... popłyń.', '0', '14:00', 'pct_gardens', '1700000')");
        }
    }
}