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

        Cursor c = MainActivity.eventsDB.rawQuery("SELECT * FROM events LIMIT 1;", null);

        c.moveToFirst();
        int tableSize = c.getCount();
        c.close();
        return tableSize;
    }

    public static void fillDB() {
        MainActivity.eventsDB.execSQL("CREATE TABLE IF NOT EXISTS " +
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
            MainActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('Tutorial', 'Tutaj pojawią się tytuły', 'Restaurant', 'Tutaj będzie dokładny adres miejsca', 'To jest krótki opis aktywności która na nas czeka.', '0', 'Dzień i godzina', 'example', '1')");
            MainActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('2', 'Second', 'Attraction', 'dluga 5, 21-123 warszawa', 'Jakis tam opis', '0', 'Monday 08:00', 'testimg', '2')");
            MainActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('3', 'TThird', 'Patisserie', 'dluga 5, 21-123 warszawa', 'Jakis tam opis', '0', 'Tuesday 01:00', 'testimg2', '3')");
            MainActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('4', 'Fourth', 'Restaurant', 'dluga 5, 21-123 warszawa', 'Jakis tam opis', '0', ' Friday 12:00', 'testimg', '4')");

            MainActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('5', 'fifth', 'Event', 'dluga 5, 21-123 warszawa', 'Jakis tam opis', '0', 'Friday 11:00', 'testimg', '5')");
            MainActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('6', 'Sixth', 'Sightseeing', 'dluga 5, 21-123 warszawa', 'Jakis tam opis', '0', '10:00', 'testimg', '6')");
            MainActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('passPhr3', 'Seventh', 'Sightseeing', 'dluga 5, 21-123 warszawa', 'Jakis tam opis', '0', '12:00', 'testimg', '7')");
            MainActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('8', 'Eight', 'Sightseeing', 'dluga 5, 21-123 warszawa', 'Jakis tam opis', '0', '14:00', 'testimg', '8')");
            MainActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('passPhr4', 'Ninth', 'Event', 'dluga 5, 21-123 warszawa', 'Jakis tam opis', '0', '12:00', 'testimg', '9')");
            MainActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('10', 'Tenth', 'Flight', 'dluga 5, 21-123 warszawa', 'Jakis tam opis', '0', '12:00', 'testimg3', '10')");
            MainActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('11', 'eleven', 'Patisserie', 'dluga 5, 21-123 warszawa', 'Jakis tam opis', '0', '12:00', 'testimg3', '11')");
            MainActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('12', 'Twelveth', 'Attraction', 'dluga 5, 21-123 warszawa', 'Jakis tam opis', '0', '12:00', 'testimg3', '12')");
            MainActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('13', 'Thirteenth', 'Attraction', 'dluga 5, 21-123 warszawa', 'Jakis tam opis', '0', '15:00', 'testimg', '13')");
        }
    }
}