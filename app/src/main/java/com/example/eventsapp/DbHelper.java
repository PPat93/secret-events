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
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('tutorial', 'Tutaj pojawi się tytuł wydarzenia', 'Patisserie', 'Adres w mapach google', 'Krótki opis wydarzenia oraz wszystkie podstawowe informacje pojawią się w tej sekcji.', '0', 'Dzień i godzina wydarzenia', 'example', '100000')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('jedziemy na wycieczkę', '...bierzemy misia w teczkę, cel: PRAGA!', 'Flight', 'Dublin Airport', 'Właśnie tu rozpocznie się Twoja wielka przygoda z okazji 30 urodzin! Weź mnie za rękę, odpręż się i ciesz wycieczką. Daj się ponieść i niczym nie przejmuj. Całość została zorganizowana, co do minuty, przez Twoją bratnią duszę. Dobrej zabawy!', '0', 'Sobota 9:15', 'pct_flight_to', '200000')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('czeska targowica', 'Sobotnie, świeże śniadanie', 'Restaurant', 'Rašínovo nábřeží Vltavská, Náplavka, 120 00 Praha 2, Czechy', 'Farmářské tržiště Náplavka, inaczej - sobotni targ nad brzgiem Wełtawy. Lokalni wytwórcy co tydzień wystawiają się w około 90 stoiskach oferując potrawy, wypieki, ceramikę i wiele innych lokalnych produktów. Idealne miejsce na świeże śniadanie.', '0', 'Sobota 9:15', 'pct_naplavka_market', '300000')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('praskie brambory', 'Frites Butik', 'Restaurant', 'Náplavní 11, 120 00 Nové Město, Czechy', 'Prawdziwe frytki belgijskie, prowadzone przez prawdziwego Belga! Dodatkowo przekąski belgijskie i duńskie. Podobno najlepsze w Pradze! Otwarte do późna wieczorem, więc idealne na kolację.', '0', 'Tuesday 01:00', 'pct_frites_butik', '400000')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('straszne rzeczy', 'Prague Ghosts Walking Tour', 'Event', '7, Týnská 627, Staré Město, 110 00 Praha-Praha 1, Czechia', 'Wyrusz w przerażającą pieszą podróż po ulicach Pragi w akompaniamencie wycia i jęków potępionych dusz. Zwiedzanie starego miasta z przewodnikiem opowiadającym o mieście oraz jego legendach to coś co tygryski lubią najbardziej. Idziemy poznawać mniej oczywistą stronę miasta!', '0', 'Piątek 19:30', 'pct_ghost_tour', '450000')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('idziemy do psychologa', 'Shrink''s Office', 'Bar', 'Jungmannova 23/11, 110 00 Nové Město, Czechy', 'Nigdy nie wiesz co się może kryć w odmętach Twej zagadkowej podświadomości. Warto sprawdzić czy wszystko w porządku. Co bardziej skłania do zwierzeń niż psycholog? Alkohol! Połączmy obydwie te rzeczy w jedynym w swoim rodzaju barze!', '0', 'Piątek 11:00', 'pct_shrinks_office', '500000')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('kominowe zawijasy', 'Trdelniki, takie jak w kKrakowie', 'Patisserie', 'Josefov CZ, U Starého Hřbitova 42/2, Staré Město, 110 00 Praha, Czechy', 'Trdelníki! Pomimo, że są to Czechy, a trdelniki są na każdym rogu, najczęściej nie mają wysokich ocen. I oto nadchodzi on! Zbawca słodkich kominów, najwyżej oceniane w Pradze - Trdelnik & Coffe! I to z lodami!', '0', 'Czwartek 10:00', 'pct_trdelnik_coffe', '600000')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('6', 'Seventh', 'Sightseeing', 'dluga 5, 21-123 warszawa', 'Jakis tam opis', '0', '12:00', 'testimg', '700000')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('7', 'Eight', 'Sightseeing', 'dluga 5, 21-123 warszawa', 'Jakis tam opis', '0', '14:00', 'testimg', '800000')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('8', 'Ninth', 'Event', 'dluga 5, 21-123 warszawa', 'Jakis tam opis', '0', '12:00', 'testimg', '900000')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('passphr1', 'Tenth', 'Flight', 'dluga 5, 21-123 warszawa', 'Jakis tam opis', '0', '12:00', 'testimg3', '1000000')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('passphr2', 'eleven', 'Patisserie', 'dluga 5, 21-123 warszawa', 'Jakis tam opis', '0', '12:00', 'testimg3', '1100000')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('passphr3', 'Twelveth', 'Attraction', 'dluga 5, 21-123 warszawa', 'Jakis tam opis', '0', '12:00', 'testimg3', '1200000')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('passphr4', 'Thirteenth', 'Attraction', 'dluga 5, 21-123 warszawa', 'Jakis tam opis', '0', '15:00', 'testimg', '1300000')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('dupa', 'No wiesz ', 'Attraction', 'dluga 5, 21-123 warszawa', 'specjalnie dla ciebie', '0', '15:00', 'testimg', '1400000')");
        }
    }
}