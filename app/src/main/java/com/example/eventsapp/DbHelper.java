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
                    "VALUES ('jedziemy na wycieczkę', '...bierzemy misia w teczkę, cel: PRAGA!', 'Flight', 'Dublin Airport', 'Właśnie tu rozpocznie się Twoja wielka przygoda z okazji 30 urodzin! Weź mnie za rękę, odpręż się i ciesz zaplanowanymi wydarzeniami. Daj się ponieść i niczym nie przejmuj. Całość została zorganizowana co do minuty, przez Twoją bratnią duszę. Dobrej zabawy!', '0', 'Sobota 9:15', 'pct_flight_to', '100')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('dupa', 'Bardzo dojrzałe...', 'Sightseeing', 'Odwróć się i pochyl', 'Skąd wiedziałem że to wpiszesz? Ale z Ciebie dzieciuch, no wiesz co... No nic, doceniam ~kreatywność~, masz mema w nagrodę. Niestety nie znalazłem nic śmieszniejszego o dupie. Podrzuć mi hasło ''Bułeczka'', to dostaniesz nagrodę ;)', '0', 'Wieczorem', 'pct_dupa', '200')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('miejsce zakwaterowania', 'Królewski hotel czeka', 'Hotel', 'to be filled', 'Fakt, może przesadziłem delikatnie z tytułem, ale z drugiej strony takie oceny i ilość gwiazdek coś obiecują, prawda? Standard wysoki, jest nawet recepcja i wszędzie blisko. Poza tym sorry, nic lepszego w moim budżecie nie było :P To będzie nasza baza wypadowa na kilka najbliższych dni. Jak to mówią, nasze spanko i ru... chu dużo.', '0', 'długo', 'pct_dupa', '300')"); //  TODO add picture, name, address and dates but without pushing to git

//            FOOD
//            Breakfast
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('pod rolnikiem ciągnik', 'Sobotnie, świeże śniadanie', 'Breakfast', 'Rašínovo nábřeží Vltavská, Náplavka, 120 00 Praha 2, Czechy', 'Farmářské tržiště Náplavka - to sobotni targ nad brzgiem Wełtawy. Lokalni wytwórcy co tydzień wystawiają, na około 90 stoiskach, potrawy, wypieki, ceramikę i wiele, wiele innych lokalnych produktów. Idealne miejsce na świeże śniadanie, spacerki i może jakiś prezent dla znajomych?', '0', 'Sobota 9:15', 'pct_naplavka_market', '300000')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('zdrowa medytacja', 'Bistro Monk', 'Breakfast', 'Michalská 20, 110 00 Staré Město, Czechy', 'Bistro Monk to knajpka ze śniadaniami w samym centrum Pragi. Z uwagi na wysokie opinie i świetne składniki, może być problem się tam dostać, ale najwyżej poczekamy w kolejce, c''nie? Poza tym zdjęcie mówi wszystko - ładne, dobre, a ceny w miarę umirakowane.', '0', 'Sobota 9:15', 'pct_bistro_monk', '350000')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('lokal lokal', 'Venue', 'Breakfast', 'Havelská 4, 110 00 Staré Město, Czechy', 'Wymyślne śniadania cały dzień? Toż to spełnienie marzeń! Co prawda rano dostać się na miejsce to podobno koszmar, ale cóź to dla nas? Posiłki nie są ogromne, ale za to może spróbujesz dwóch? A jeśli nie, to dopchniemy Cię na przykład jakimś deserem i lodami.', '0', 'Sobota 9:15', 'pct_venue', '355000')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('brylant jestem', 'Jewel by Venue', 'Breakfast', 'Rytířská 529/3, 110 00 Staré Město, Czechy', 'Sublokal znanego i powszechnie lubianego bistro Venue. Z grubsza to samo - wymyślne śniadania w akompaniamencie długiej kolejki czekającej na stolik. Podobnie tutaj, porcje nie są ogromne, ale za to będziesz miała miejsce na desrki z piekarni!', '0', 'Sobota 9:15', 'pct_jewel', '355500')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('bagle z dziurką', 'Bajgle na śniadnie?', 'Breakfast', 'Letenská 118/1, 118 00 Malá Strana, Czechy', 'Jak mówiła Smutna Grubaska z TikToka - ''Idziemy jeść bagle!''. Idealnie umiejscowiona restauracja Bagel Lounge z bajgielkami na śniadanie, w sam raz na naszej trasie do zamku i zwiedzania. Złap jednego albo dwa, a najlepiej z frytkami - żebyś miała dużo siły na oglądanie i podziwianie zabytków. No i poza tym jedz, bo w domu takiego nie ma. Jest to raczej mniejsza rzecz - na szybko. Jakby co, to wynagrodzimy Ci jakimś deserkiem.', '0', 'Sobota 9:15', 'pct_bajgle', '355550')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('nie bądź jeleń', 'Mezi Srnky', 'Breakfast', 'Sázavská 19, 120 00 Praha 2-Vinohrady, Czechy', '''Wśród Jeleni'', wbrew nazwie, nie serwuje wyłącznie wegetariańskich posiłków. Obfite śniadanko w sensownej cenie? Oczywiście, że tak! Miejsce nie jest wielkie, ale za to bardzo popularne i ma niesamowicie wysokie opinie. Dzięki temu będziesz miała dużo siły na mnóstwo chodzenia przez cały dzień. Poza tym, jest to kolejny punkt na naszym jedzeniowym planie podróży.', '0', 'Sobota 9:15', 'pct_wsrod_jeleni', '355555')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('słodko słone', 'Kolejne fancy śniadanko', 'Breakfast', 'Anglická 390/19, 120 00 Praha 2-Vinohrady, Czechy', 'Uroczna knajpka nieopodal hotelu z eleganckimi śniadankami. Mają trochę miejsc wewnątrz i na zewnątrz. Jedzenie wygląda apetycznie, a poza śniadaniami są tu też desery! Dodatkowo, mają lokalny sklepik i można zamówić u nich ciasta, ciastka, granolę, hummus, a nawet jajka! Jeśli deserek Ci zasmakował, to niczym się nie martw i zamów sobie trochę na drogę! Odbierzemy przy okazji.', '0', 'Sobota 9:15', 'pct_sweet_peppers', '355600')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('jojko z jojkiem', 'Zagadkowy Oak', 'Breakfast', 'Lublaňská 1837/39, 120 00 Nové Město, Czechy', 'To jest coś niespotykanego - ma tylko 200 opinii, średnia ocen to 4.9, a śniadanie to głównie jajka, jajunie, jajecznica lub śniadania brytyjskie. Nie wiem o co chodzi, ale ludzie zachwycają się smakiem i obsługą. Może warto spróbować? Zwłaszcza że nie dą daleko i mają kilka wygodnych miejsc siedzących. Aha, widziałem na zdjęciach croissanta z pistacjami. Nie jest to co prawda jajko, ale chyba im to wybaczysz?', '0', 'Sobota 9:15', 'pct_oak', '355650')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('wafele i gofery', 'Coffee & Waffles', 'Breakfast', 'Valentinská 1061/6, 110 00 Staré Město, Czechy', 'Coś co tygryski lubią najbardziej - gofry na milion sposobów! Słodkie? Słone? Bita śmietana? Awokado? Pieczona fasolka? Niesamowity wybór oraz mnóstwo nieoczywistych opcji. O czymkolwiek marzysz, tutaj się spełni! Pod warunkiem że marzysz o gofrach. Mają dwie lokalizacje, ale zakładam że ta w centrum będzie nam bardziej po drodze. Chodźmy, nie jadłaś takch wafeli od wielu miesięcy.', '0', 'Sobota 9:15', 'pct_waffels', '355655')");

//            Lunch/Dinner
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('ceske potraviny', 'Jemy u Glaubiců', 'Restaurant', 'Malostranské nám. 266/5, 118 00 Malá Strana, Czechy', 'Czeskie, tradycyjne jedzenie - u Glaubiców - tak naprawdę to jest jedyne tłumaczenie jakie ogarnąłem, więc zapewne jest to nazwisko? Czyli co? Zasmażany syr i piwo? Po zamku na pewno jesteś głodna, a to jest najbliższa sensowna knajpka. Opinie i ich ilość mówią same za siebie. Jest co prawda troszkę fancy, ale w granicach rozsądku. Będziesz zadowolona - o ile lubisz tłuste i smażone.', '0', 'Sobota 9:15', 'pct_glaubicowie', '356000')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('jak sie nie ma co się lubi', 'Lokál U Bílé kuželky', 'Restaurant', 'Míšeňská 12, 110 00 Malá Strana, Czechy', 'Czeskie, tradycyjne jedzenie - niestety nie u Glaubiców - prawdopodbnie coś nie pykło, ale idziemy do bardzo zbliżonej restauracji. Jedyne co to mają połowę mniej opinii, tylko 6k. Piwo ważą sami na miejscu i chwalą się że dają tyle sosu i side dish ile dasz radę zjeść. To teraz przestań się krzywić i pij ten sos. Zapłacone, więc nie grymaś!', '0', 'Sobota 9:15', 'pct_bile_kuzelky', '356500')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('ordynarna świnia', 'Pork''s', 'Restaurant', 'Mostecká 16, 110 00 Malá Strana, Czechy', 'No Bób mi świadkiem! Chciałem tego uniknąć. Musiało coś bardzo nie pyknąć, bo naprawdę nie chciałem Cię brać na tak ordynarne wiejskie dania ze świni. Ale za to ceny rozsądne, opinie wysokie, blisko zamku po latach zwiedzania - kto wie, może nawet Ci się przypomni nasza kuchnia narodowa? Na szczęście nie jesteś wegetarianką, bo byś tylko piwo piła.', '0', 'Sobota 9:15', 'pct_pork', '356600')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('ciuchcia', 'Lepszy trainspotting', 'Restaurant', 'Václavské nám. 802/56, 110 00 Nové Město, Czechy', 'Jedzenie zajeżdza na stół pociągiem! I klimat jest naprawdę niepowtarzalny! Jestem mega ciekawy. Ale z drugiej strony to tylko burgery (zwłaszcza że to Twoje święto!), są trochę przepłacone i lokal Výtopna jest zawsze full. Plus opinie nie urywają czterech liter. Wrzucam tu jako alternatywkę, gdybyś jakimś cudem chciała burgera :P', '0', 'Sobota 9:15', 'pct_vytopna', '360000')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('kluski z mydłem', 'Wielkie knedliska', 'Restaurant', 'Národní 115/24, 110 00 Nové Město, Czechy', 'Jadłaś kiedyś prawdziwe knedle? Ale takie oryginalne od czeskiego chłopa? Nie? No to teraz może nie do końca od chłopa, ale na pewno oryginalne i z Czech!. Kolejny klasyk kuchni naszego sąsiada - ale uważaj, są WIELKIE! Ceny też zajebiste, czyt. nie żałuj sobie, bo ponownie takich rzeczy prędko nie zobaczysz. W sumie, ta potrawa to wielka niewiadoma. Niby wiesz co to jest i czego się spodziewać, ale rzeczywistość prawie na pewno będzie inna.', '0', 'Sobota 9:15', 'pct_knedle', '366000')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('falafel z paprykiem', 'Kameralnie po izraelsku', 'Restaurant', 'Rumunská 8/16, 120 00 Vinohrady, Czechy', 'Maleńka knajpka obiadowa serwująca kuchnię śródziemnomorsko-izraelską. Bardziej na szybki obiad, gdyż zbyt wielu miejsc siedzących tu nie ma. Z drugiej strony, wyśmienite opinie i śmiesznie niskie ceny zachęcają do zajrzenia. No i jest blisko kwaterunku. To co, idziemy zjeść falalefelalela?', '0', 'Sobota 9:15', 'pct_paprika', '366600')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('wcale nie ostre', 'Indyjskie niesamowitości', 'Restaurant', 'Rumunská 15, 120 00 Vinohrady, Czechy', '''Masala IP. Pavlova Indian restaurant'' - indyjskie jedzenie, w świetnych cenach i z niesamowicie wysokimi opiniami. Ewidentnie widać że jedzą tutaj lokalni hindusi. Jedzenie wygląda super (tzn. jak na indyjskie papki), co dodaje od cholery autentyczności. Poza tym baaaaaaaardzo dawno nie byliśmy w takim miejscu. Tylko uważaj z ostrością, żebyśmy nie musieli spędzić reszty dnia w hotelu.', '0', 'Sobota 9:15', 'pct_masala', '366660')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('jaffa ale nie ciastka', 'A może kebsik?', 'Restaurant', 'Na Příkopě 12, 110 00 Staré Město, Czechy', 'Od dawna opowiadałaś, że strasznie chesz zjeść kebaba więc oto jest! Jaffa restaurant! Jednak nie pomyl jej z ciasteczkami, gdyż jest to arabska restauracja halal z najlepszym mięskiem jakie możesz sobie wyobrazić. Troszkę wyższe niż zazwyczaj ceny są wynagradzane przez opinie o obsłudze i jedzeniu. To chyba jedyny typ kuchni który lubimy, a nie jedliśmy od dawna - chyba od Warszawy. No to dawaj na kebsa, niech przypomni Ci się ojczyzna i nasze dawne randki!', '0', 'Sobota 9:15', 'pct_jaffa', '366666')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('tanie i dobre', 'U Kroka', 'Restaurant', 'Vratislavova 28/12, 128 00 Praha 2, Czechy', 'Czeska restauracja z wyśmienitym jedzeniem i z ogromną ilością mega pozytywnych opinii. Ceny są nieskie, szczególnie dla opcji lunchowej. Lokal umiejscowiony jest w miarę niedaleko od hotelu i zaraz obok zabytkowego dawnego zamku. Restauracja ma ponad 120 lat i radzi sobie wyśmienicie. Jedzonko jest trochę fancy, ale bez przesady. Idealne po lub przed spacerkami i zwiedzaniem pobliskich pozostałości zamkowych.', '0', 'Sobota 9:15', 'pct_u_kroka', '370000')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('każdy zasługuje na drugą szansę', 'Ngo restaurant', 'Restaurant', 'Jugoslávská 661/23, 120 00 Vinohrady, Czechy', 'Wiem, wiem. Wietnamska i tylko 800 opinii. Jednakże, każdy zasługuje na druga szansę, nawet kolendra w kuchni wietnamskiej! Mają wyśmienite opinie, a ich karta dań jest krótka i wygląda mega interesująco. No i ceny - nader przystępne. Na lunch, żeby sobie podjeść, spróbować (znów) czegoś nowego. Poza tym, ta kuchnia używa dużo afrodyzjaków, więc wiesz - warto.', '0', 'Sobota 9:15', 'pct_ngo', '380000')");

//            Supper
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('praskie brambory', 'Frites Butik', 'Restaurant', 'Náplavní 11, 120 00 Nové Město, Czechy', 'Prawdziwe frytki belgijskie, prowadzone przez prawdziwego Belga! Dodatkowo przekąski z Belgii i Danii. Podobno najlepsze w Pradze! Otwarte do późna wieczorem, więc idealne na kolację po festiwalu, a nawet w trakcie. Mają jakieś problemy z piekarnikiem i na dzień 13.09 są tymczasowo zamknięci. Mam nadzieję że zdążą z otwarciem na nasze wielkie przybycie. Jeśli nie, to w okolicy powinny być jeszcze jakieś frytki belgijskie.', '0', 'Tuesday 01:00', 'pct_frites_butik', '400000')");

//            Pubs/Additional food
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('idziemy do psychologa', 'Shrink''s Office', 'Bar', 'Jungmannova 23/11, 110 00 Nové Město, Czechy', 'Nigdy nie wiesz co się może kryć w odmętach Twej zagadkowej podświadomości. Warto sprawdzić czy wszystko w porządku. Co bardziej skłania do zwierzeń niż psycholog? Alkohol! Połączmy obydwie te rzeczy w jedynym w swoim rodzaju barze!', '0', 'Piątek 11:00', 'pct_shrinks_office', '500000')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('smaki kazimierza', 'Trdelniki, takie jak w Krakowie', 'Patisserie', 'Josefov CZ, U Starého Hřbitova 42/2, Staré Město, 110 00 Praha, Czechy', 'Trdelník & Coffee - nazwa trochę bez polotu, ale... TRDELNIKI! Pomimo, że są to Czechy, a trdelniki są na każdym rogu, najczęściej nie mają wysokich ocen. I oto nadchodzi on! Zbawca słodkich kominów, najwyżej oceniane w Pradze - Trdelnik & Coffe! Tradycyjne, a jednak z lodami! Nasz must aby spróbować prawdziwych, oryginalnych kominowych zawijasów!', '0', 'Czwartek 10:00', 'pct_trdelnik_coffe', '600000')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('modernistyczne kominowe zawijasy', 'Trydelniki naszych czasów', 'Patisserie', 'Karlova 160/8, 110 00 Staré Město, Czechy', 'Good Food Coffee & Bakery serwuje trydelniki w formie turystycznej. Totalnie przesadzone, milion posypek, lodów i niestety trochę wyższe ceny. Są nawet trydelniki wytrawne z serem i pomidorem! Co prawda miejsce stworzone pod turystów, ale biorąc pod uwagę że większość Trydenlików ma niskie opinie, może warto spróbować Trydelnika w całości OBSYPANEGO PISTACJAMI? Kicz też potrafi urzec.', '0', 'Czwartek 10:00', 'pct_good_food', '630000')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('pączkosanty', 'Oh Jeleń Piekania', 'Patisserie', 'Bělehradská 606/87, 120 00 Praha 2-Vinohrady, Czechy', 'Ok, tak naprawdę miejsce nazywa się ''Oh Deer Bakery'' - w wolnym tłumaczeniu - tak jak tytuł. Pozwól się zaszokować niesamowitymi pączko-croissantami. Mam podejrzenia że będzie to twoje ulubione miejsce w całym mieście. Mają 4 lokale - to wymienione jest blisko hotelu, drugie wygodne - w centrum. Zdobądźmy kolejny level nad dotychczasowymi pączkarniami! Zwłaszcza, że wiem że bardzo chciałaś tego spróbować!', '0', 'Czwartek 10:00', 'pct_oh_deer', '650000')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('bez pracy nie ma kołaczy', 'Czeskie kołacze', 'Patisserie', 'Korunní 90, 101 00 Vinohrady, Czechy', 'Nie wiem jak Ty, ale pamiętam że dawniej kołacze były w Polsce w każdej piekarni. W sumie, nie mam pojęcia kiedy ostatnio je jedliśmy. No i dobrze się składa, bo Czechy to ojczyzna kołacza! Ta cukiernia akurat jest trochę nie po drodze, ale za to opinie ma wybitne. I widziałem na zdjęciach, że czasem mają pistacjowe. Ahh, widzę że przykułem Twoją uwagę! Widzę, że mamy troszkę czasu i sił, tak wiec kurs na Kus Koláče!', '0', 'Czwartek 10:00', 'pct_kolacze', '655000')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('artystyczne wypieki', 'Artic Bakehouse', 'Patisserie', 'Myslíkova 187/13, 110 00 Nové Město, Czechy', 'Jak sama nazwa wskazuje, czeskie kraftowe wypieki w swej pełnej krasie. od chlebów po dziwne wieżo-cynamonki. Trochę nam nie po drodze, ale może warto nadłożyć trasy aby spróbować tych małych cudów? Mają kilka miejsc i ewidentnie trzymają poziom. Nie mam pojęcie jak nazywa się połowa rzeczy na wystawie, więc ufam że mi wytłumaczysz.', '0', 'Czwartek 10:00', 'pct_artic_bakery', '655500')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('jakubie zrób mi loda', 'Crème de la Crème', 'IceCream', '12, Husova 231, Staré Město, 110 00, Czechy', 'Z jakiegoś powodu ludzie dostają szału gdy słyszą nazwę ''Crème de la Crème - Zmrzlinárna Husova''. Przecież to tylko lody! Chociaż nigdy nie możesz być pewna czy to faktycznie TYLKO to. Myślę, że musimy to sprawdzić. Mam nadzieję, że nie będzie zimno - ale z drugiej strony - czy to nas kiedykolwiek powstrzymało przed lodami?', '0', 'Czwartek 10:00', 'pct_crem_de_la', '655550')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('smyrfna herbacianka', 'Dobrá čajovna Praha-Václavské náměstí', 'Teahouse', 'Václavské nám. 778/14, 110 00 Nové Město, Czechy', 'Mam nadzieję że szlaczki w tytule Cię nie wystraszyły? To dobrze, bo idziemy właśnie do Dobrej Czajowni. No ok, ok. Herbaciarni. Mają herbatki ze wszystkich stron świata, podobno jest nawet jedna niebieska! Jedzenia tam zbyt wiele nie uświadczysz, ale przecież nie o to w tym chodzi.', '0', 'Czwartek 10:00', 'pct_dobra_cajownia', '655555')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('czoko spoko zamek', 'Choco Café', 'Patisserie', 'Nerudova 49, 110 00 Malá Strana, Czechy', 'Jedna z dwóch lokalizacji kawiarni czekoladowej, która wręcz krzyczy: JEMY CZEKOLADĘ! Jest niedaleko zamku, więc w sam raz na szybki strzał energii po długim zwiedzaniu. Jest czekoladowe pićko, ciastełko i miłe miejsce do siedzenia. Poza tym sporo rzeczy do kupna - makaroniki, czekolady, ciasteczka, praliny i wiele więcej. Jednym słowem - twoje personalne niebo!', '0', 'Czwartek 10:00', 'pct_choco', '656000')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('czoko spoko centrum', 'Choco Café', 'Patisserie', 'Liliová 250/4, 110 00 Staré Město, Czechy', 'Jedna z dwóch lokalizacji kawiarni czekoladowej, która wręcz krzyczy: JEMY CZEKOLADĘ! Jest w centrum, więc w sam raz na szybki strzał energii po długim zwiedzaniu. Jest czekoladowe pićko, ciastełko i miłe miejsce do siedzenia. Poza tym sporo rzeczy do kupna - makaroniki, czekolady, ciasteczka, praliny i wiele więcej. Jednym słowem - twoje personalne niebo!', '0', 'Czwartek 10:00', 'pct_choco', '656500')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('ciostko w ogrodzie', 'Cafe V zahradě', 'Patisserie', 'nám. Bratří Synků 400/12, 140 00 Praha 4-Nusle, Czechy', 'Urokliwa kawiarnio-śniadaniownia z malowniczym ogródkiem. Niech nie zwiedzie Cię niewielka ilość opinii (tylko 400) - ocena 4,9 to coś, w co zawsze celujemy. Poza tym, na fotkach widać że ewidentnie ''robią to dobrze''. Czy chcesz słodkie, czy słone - na pewno znajdziesz tu coś dla siebie, wraz z chwilą wytchnienia.', '0', 'Czwartek 10:00', 'pct_cafe_zahrade', '656550')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('czajniczkowanie', 'Čajovna jedna báseň', 'Patisserie', 'Pod Zvonařkou 14, 120 00 Praha 2-Vinohrady, Czechy', 'Nie lubisz kawy, ja oczywiście też nie. Ta nienawiść zawsze łączyła nas bardziej niż cokolwiek innego! Dlatego chodź ze mną, po raz pierwszy w życiu, do prawdziwej herbaciarni! Jedna Baśń oferuje (jak nazwa wskazuje) baśniowy, jedyny w swoim rodzaju wystrój. Niespotykane napary zrelaksują nas i pozwolą odpocząć po nieustającej gonitwie. Poza tym, w środku mieszka KOTEŁ!', '0', 'Czwartek 10:00', 'pct_jedna_basen', '656555')");

//            Fine Dining
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('gwóźdź programu', 'V Zátiši', 'Restaurant', 'Liliová 1, Liliová 216, Staré Město, 110 00 Praha 1, Czechia', 'No i jest, chwila na którą wszyscy czekaliśmy. Najważniejsza i największa atrakcja całego wyjazdu - pierwsze w Twoim życiu, pełnowymiarowe Fine Dining! V Zátiši to niewątpliwie jedna z najlepszych restauracji w Pradze. Serwowane jedzenie to mix kuchni czeskiej, europejskiej oraz indyjskiej. Oczywiście jest w przewodniku Michelin. Bierzemy to lepsze menu degustacyjne oraz parowanie potraw z winem. Mam nadzieję, że zapamiętasz to doświadzenie do końca życia. Dosłownie niczym się nie przejmuj, wszystko jest już załatwione. Ubierz się ładnie i przygotuj na nieziemskie doznania!', '0', 'Czwartek 10:00', 'pct_zatisi', '656600')");

//            Misc
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('prawdziwa bohema', 'Cyganeria Artystyczna', 'Joker', 'Národní 22, 110 00 Nové Město, Czechy', 'Trzymaj się stołka, bo oto jest! Cafe Louvre - ogromny, ponad stuletni lokal o niepowtarzalnym wystroju serwujący śniadania, obiady oraz kolacje. Poczujesz się jak gdybyś była częścią Bohemy, a duch dawnych czasów przenikający wnętrze z pewnością wywoła dreszcze ekscytacji. Usiądź tam, gdzie spędzały czas takie osobistości jak Enistein czy Kafka! Jest tu nawet bilard i kawiarnia z deserkami. To miejsce to prawdziwy Joker wśród lokali.', '0', 'Czwartek 10:00', 'pct_louvre', '660000')");

//            PLACES TO VISIT
//            Activities
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('straszne rzeczy', 'Prague Ghosts Walking Tour', 'Event', '7, Týnská 627, Staré Město, 110 00 Praha-Praha 1, Czechia', 'Wyrusz w przerażającą pieszą podróż po ulicach Pragi w akompaniamencie wycia i jęków potępionych dusz. Zwiedzanie starego miasta z przewodnikiem opowiadającym o mieście oraz jego legendach to coś co tygryski lubią najbardziej. Idziemy poznawać mniej oczywistą stronę miasta!', '0', 'Piątek 19:30', 'pct_ghost_tour', '700000')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('idziemy na spacerek', 'Na słoneczko i wiaterek', 'Event', 'Na Příkopě 864/28, 110 00 Praha 1-Nové Město, Czechia', 'Na początku chciałem Cię zabrać na wieczorny spacer z przewodnikiem przebierańcem, strasznymi historiami i legedami dotyczącymi Pragi. Okazało się jednak, że nie ma terminów, a same histore są nudne i tandetne. Tak więc wybieram bardziej dopasowane do Ciebie wydarzenie - Dzienny walking tour z przewodnikiem. Na dodatek tani jak barszcz i z przewodnikami-pasjonatami. No chodź, posłuchamy sobie o historycznej Pradze! Aha, to jest tip-based tour, więc jeśli Ci się podobało, to rzuć im coś na zakończenie.', '0', 'Piątek 19:30', 'pct_walking_tour', '770000')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('kultura i lasery', 'Signal Festival 2023!', 'Event', 'Cała Praga', 'Przygotuj się na mnóstwo chodzenia gdyż oto jest - jedyny w swoim rodzaju świetlny festiwal będący jednocześnie wielką wystawą sztuki nowoczesnej. Zanurz się w ulicach Pragi z ukrytymi dziesiątkami instalacji artystycznych. Widowisko każdego dnia po zmroku rozjarzone milionami kolorów. Musimy odebrać nasze opaski, gdyż są wymagane na płatnych instalacjach. Musimy obejrzeć wszysko, bo wiesz... zapłacone i nie może się zmarnować. Czas mamy codziennie, więc - raz, dwa - do dzieła!', '0', 'Czwartek - Sobota, 19:00-24:00', 'pct_signal', '800000')"); // TODO - update with current year photo after tickets are available

//            Attractions
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('królowa na zamku', 'Kompleks zamkowy!', 'Sightseeing', 'Second Courtyard of Prague Castle, Hradčany, 119 00 Praha 1, Czechy', 'Przygotuj swój organizm na kompleks zamkowy! Liczę że twoja kondycja nie jest najgorsza - co prawda nie idziemy tam rabować i gwałcić, tylko zwiedzać i podziwiać, ale to przecież tak samo fajne. Trochę to będzie trwało, ale obejrzymy co najmniej pałac, bazylikę i katedrę. Mamy trasę B, gdyż dodatkowe miejsca z trasy A nie są wysoko oceniane i raczej to strata czasu, którego i tak za wiele nie mamy. W każdym razie liczę na to, że poczujesz się jak arstokratka wśród antycznych ścian!', '0', '12:00', 'pct_palace', '900000')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('prawie jak gubałówka', 'Kolejka na Petřín', 'Attraction', 'U Lanové dráhy 118 00, 118 00 Malá Strana, Czechy', 'Co może być lepsze niż bezwysiłkowy wyjazd kolejką na punkt widokowy? Darmowy bezwysiłkowy wyjazd kolejką na punkt widokowy! Wliczona w cenę 72h biletu komunikacyjnego kolejka na Petřín pozwoli Ci osiągnąć wyżyny. Poza widokami pięknymi widokami spacer po terenach zielonych uspokoi umysł i pobudzi zmysły.', '0', '12:00', 'pct_petrin', '1000000')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('czeski film', 'Narodowe muzeum filmowe', 'Attraction', 'Jungmannova 748/30, 110 00 Nové Město, Czechy', 'Pełne zanurzenie w oparach absurdu czeskiego kina! Narodowe muzum filmowe wprowadzi Cię w tajniki wielkiego ekranu, ale też udowodni, że nie bez powodu powstało w Polsce powiedzenie ''Czeski film''. Zachwyć się i pośmiej w tym niepowtarzalnym, interktywnym muzeum opowiadającym o sztuce filmowej - NaFilM: Národní filmové muzeum otwiera się o 13, więc w sam raz po śniadanku i spacerkach.', '0', '12:00', 'pct_na_film', '1050000')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('za darmo to uczciwa cena', 'Vysehrad czyli kompleks zamkowy', 'Attraction', 'V Pevnosti 159/5b, 128 00 Praha 2-Vyšehrad, Czechy', 'Darmowy dawny kompleks zamkowy Vysehrad kusi nie tylko uczciwą ceną, ale też przepięknymi parkam i zabytkowymi budynkami. W okolicy natrafisz na małe galerie, muzea i ruiny ''Tego drugiego zamku''. Ubierz dobre buty i zadbaj o butelkę z wodą, bo fosa niestety już dawno wyschła. A jeśli będzie padać, to schowamy się w którejś z pobliskich kawiarenek.', '0', '12:00', 'pct_vysehrad_national_monument', '1075000')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('śmieszne ruchanki', 'Muzeum maszyn seksualnych', 'Attraction', 'Melantrichova 476 /18, 110 00 Staré Město, Czechy', 'Nie będę ukrywać, nie jest to muzeum z Amsterdamu. Wrzuciłem tu jako backup, gdyby inne opcje zawiodły. Jednakże, mimo wszystko można się tu dobrze - he he - zabawić. Maszyny do seksu wszelkich rodzajów i wielkości czekają na Ciebie! Kto wie, być może odnajdziesz tam parę pomysłów i inspiracji?', '0', '12:00', 'pct_sex_machines_museum', '1082500')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('czas ucieka', '...wietrzność czeka', 'Attraction', 'Staroměstské nám. 1, 110 00 Josefov, Czechy', 'Jeden z najsłynniejszych zegarów astronomicznych na świecie. Uważaj, może akurat wydarzy się koniunkcja planet, która - jak wiemy z filmów - nigdy nie zwiastuje niczego dobrego. A na dokładkę, obejrzyj sobie obok ratusz z XIVw. Nie jest tak skomplikowany jak zegar, ale z pewnością robi nie mniejsze wrażenie.', '0', '12:00', 'pct_astronomical_clock', '1091250')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('pałac bogoli', 'Dwór Lobkowiczów', 'Attraction', 'Jiřská 3, 119 00 Praha 1-Hradčany, Czechy', 'Lobkowiczký palác to jedyny prywatny obiekt w kompleksie zamkowym. Muzeum wewnątrz zawiera zbiór rodziny Lobkowiczów, będący jednym z największych i najstarszych zbiorów w czechach. Nie ukrywam, musiało coś srogo nie wypalić skoro płacimy za kolejne muzemu w ciągu ostatnich 3 godzin. Nogi Cię nie bolą? No nic, dawaj. Może trafimy akurat na koncert muzyki klasycznej?', '0', '12:00', 'pct_palac_lobkowiczow', '1095625')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('narodowe dziwadło', 'Zauważyłem, że lubisz teatr', 'Attraction', 'Národní 2, 110 00 Nové Město, Czechy', 'Z tego powodu Narodni Divadlo zostało wybrane by poszerzyć Twoje horyzonty. Właściwie to sama nazwa wszystko wyjaśnia - Teatr Narodowy, zwiedzanko z przewodnikiem. Jeden z najbardziej wyróżniających się budynków w okolicy. Wnętrza bogato zdobione złotem zostały dodatkowo udekorowane malowidłami najznamienitszych czeskich malarzy. Aha, dodatkowo kręcono tu fragmenty Jamesa Bonda Casino Royale.', '0', '12:00', 'pct_narodni_divadlo', '1097812')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('dom publiczny', 'Obecní dům', 'Attraction', 'Náměstí Republiky 5, 111 21 Staré Město, Czechy', 'Przyznam szczerze, że tłumaczenie nazwy tego miejsca jest co najmniej konfundujące. Najbliższe i najswnsowniejsze co znalazłem to ''Dom reprezentacyjny'' albo po angielsku ''Municipal House''. Tak czy siak - duże, ładne, stare, antyczne, z historią. Jednen z najstarszych budynków secesyjnych. Pełni obecnie funkcje reprezentacyjne. Ma sale koncertowe i zakładam że zwiedzanie zapadnie Ci w pamięć.', '0', '12:00', 'pct_obecni_dum', '1098906')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('paląca rogacizna', 'Muzeum Slivovice R. Jelínek', 'Attraction', 'U Lužického semináře 116/48, 118 00 Malá Strana, Czechy', 'Coś na rozluźnienie - Muzeum czeskiego regionalnego produktu - Śliwowicy! Niemal godzinne, wyjątkowe zwiedzanie zakończone jest degustacją trzech lokalnie produkowanych śliwowic oraz trzech rodzajów finger foods. Dzięki temu spróbujesz nie tylko tradycyjnego napitku, ale też doświadczysz autentycznej zagrychy. I może w końcu trochę wyjmiesz kija z...', '0', '14:00', 'pct_muzeum_sliwowica', '1098956')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('upiór w operze', 'Statni Opera', 'Attraction', 'Wilsonova 4, 110 00 Praha 1-Vinohrady, Czechy', 'Kultura? Stary budynek? Ozdobne ściany i obrazy? Wszystko co uwielbiasz w jednym miejscu! Idziemy z przewodnikiem na zwiedzanie Praskiej Opery Narodowej! Mam nadzieję, że niesamowita architektura wprost zaprze Ci dech w piersi! Po pierwsze, nigdy nie byliśmy w operze, a po drugie - kto powiedział, że od razu musimy słuchać śpiewania? Oby nas tylko żaden upiór nie dopadł... ', '0', '14:00', 'pct_statni_opera', '1099478')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('emocje jak na grzybach', 'Muzeum narodowe', 'Attraction', 'Václavské nám. 68, 110 00 Nové Město, Czechy', 'Ciekawa rzecz, w Krakowie nigdy nie byliśmy w Muzeum Narodowym, a w Dublinie i owszem. Co więcej, teraz zmierzamy do takowego w Czechach. Zaiste - przedziwne. Jeśli chodzi o same wystawy, zdecydowanie polecam ''History'' - z pewnością docenisz czasy Bohemy i Cyganerii Artystycznej. Pozostałe wystawy są mniej interesujące, ale hej! To w końcu muzeum!', '0', '14:00', 'pct_narodni_museum', '1099739')");

//            Strolling
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('karol mostowiak', 'Charles Bridge', 'Sightseeing', 'Karlův most, 110 00 Praha 1, Czechy', 'Przejdźmy się najbardziej znanym mostem w Czechach. Zbudowany w średniowieczu na rzece Wełtawie, nie tylko pozwolił rozkwitnąć Pradze dzięki umożliwieniu wschodnio-zachodniego handlu, ale też stał się jednym z najbardziej ikonicznych miejsc w Europie. Dodane w Baroku statuły przedstawiają świętych oraz lokalnych mecenasów sztuki. Daj się poprowadzić na drugą stronę! ', '0', '14:00', 'pct_charles_bridge', '1100000')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('idziom', 'Biblioteka Miejska w Pradze', 'Sightseeing', 'Mariánské nám. 98/1, 110 00 Josefov, Czechy', 'Biblioteki to miejsca, które niewątpliwie na Ciebie działają - wiemy to oboje. Z tego powodu prgnę zaprosić Cię do biblioteki miejskiej w Pradze. Rzeźba ''Idiom'' z pewnością Cię zaciekawi, choć nie wiem jak będziesz się czuła w związku z takim wykorzystaniem książek. Taka sztuka mi zdecydowanie coś przypomina... To taki mały przystanek w naszej celebracji.', '0', '14:00', 'pct_municipal_library', '1200000')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('o jaka wielka', 'Praska brama prochowa', 'Sightseeing', 'Nám. Republiky 5, 110 00 Staré Město, Czechy', 'Kolejny punkt spacerowy to Prasna Brama. Pierwotnie reprezentacyjna budowla obok dworu Władysława Jagiellończyka, została później zdegradowana zaledwie do składnicy prochu - stąd nazwa. Na szczycie tego 65 metrowego antycznego giganta znajduje się taras widokowy dla turystów. Niestety opłata jest dosyć znaczna, a Ty nie przepadasz za wysokościami, toteż polecam całość podziwiać z dołu.', '0', '14:00', 'pct_brama_prochowa', '1300000')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('to nie karuzela', 'Obrotowa głowa Franza Kafki', 'Sightseeing', 'Charvátova, 110 00 Nové Město, Czechy', 'Gdzież indziej można było postawić pomnika Franza Kafki jeśli nie obok jego byłego miejsca pracy (dawniej urząd, obecnie budynek towarzystwa ubezpieczeniowego) w mieście gdzie spędził większość życia? Ogromna metalowa rzeźba o wadze 39 ton robi niesamowite wrażenie, dodatkowo, cyklicznie wykonywane obroty zmieniają dynamikę obiektu i zapewniają niesamowite doznania wizualne. Sztuka nowoczesna w nieprzeciętnym wydaniu.', '0', '14:00', 'pct_franz_kafka', '1400000')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('idź do domu, jesteś pijany', 'Tańczący dom', 'Sightseeing', 'Jiráskovo nám. 1981/6, 120 00 Nové Město, Czechy', 'Tańczący dom to jeden z najbardziej rozpoznawalnych budynków w Czechach. I jednocześnie jakiś taki... nietaki - coś jak krzywy domek w sopocie. To co prawda tylko przystanek na dłuższej trasie, ale i tak jest interesujący. Nie marudź, coś innego nie wypaliło skoro to Ci pokazuję.', '0', '14:00', 'pct_dancing_house', '1500000')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('musiał być kościół', 'Kościół Marii Panny przed Tynem', 'Sightseeing', 'Staroměstské nám., 110 00 Staré Město, Czechy', 'O co chodzi w nazwie tego kościoła? Totalnie nie mam pojęcia. Jednakże, wysokie opinie, darmowy wstęp i podobno niesamowite wnętrze zachęcają do zwiedzania. Poza tym, jeden z bardziej rozpoznawalnych i widocznych kościołów w Pradze. Plus jest na naszej trasie spacerków. Chodźmy do środka podziwiać niepotrzebnie wywalone pieniądze i zmarnowane życia robotników (xD) ', '0', '14:00', 'pct_church_tyn', '1600000')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('tajemniczy ogród', 'Valdštejnská zahrada', 'Sightseeing', 'Letenská 123/4, 118 00 Malá Strana, Czechy', 'Tytuł trochę zadziwia, co? Nie bój się - to tylko 17-wieczne ogrody. Pomniki, statuły, pawie, fontanny, a nawet ściana artyficjalnych stalaktytów - wszystko to i jeszcze więcej czeka na odkrycie w przyzamkowych ogrodach. Zanurz się w zieloności i jak łódka... popłyń. To raczej tylko dodatek niż prawdziwa atrakcja, ale hej! Odpczynek wśród roślin przed dalszym galopem? No jasne że tak.', '0', '14:00', 'pct_gardens', '1700000')");
        }
    }
}