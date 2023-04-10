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
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('tutorial', 'Here is the place for the title', 'Restaurant', 'Precise address will appear herePrecise address will appear herePrecise address will appear here', 'Short description of the event awaiting, will appear here. It is going to contain all thee necessary details.', '0', 'Day and the hour of the event', 'example', '1')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('1', 'Second activity there', 'Attraction', 'dluga 5, 21-123 warszawa', 'er, at 0dp the button goes away, and at wrap_content it will always choose the text to set the width. How do I force it to use the weight as its method to set w ', '0', 'Monday 08:00', 'testimg', '2')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('2', 'TThird', 'Patisserie', 'dluga 5, 21-123 warszawa', 'Jakis tam opis', '0', 'Tuesday 01:00', 'testimg2', '3')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('3', 'Fourth', 'Restaurant', 'dluga 5, 21-123 warszawa', 'Jakis tam opis', '0', ' Friday 12:00', 'testimg', '4')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('4', 'fifth', 'Event', 'dluga 5, 21-123 warszawa', 'Jakis tam opis', '0', 'Friday 11:00', 'testimg', '5')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('5', 'Sixth', 'Sightseeing', 'dluga 5, 21-123 warszawa', 'Jakis tam opis', '0', '10:00', 'testimg', '6')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('6', 'Seventh', 'Sightseeing', 'dluga 5, 21-123 warszawa', 'Jakis tam opis', '0', '12:00', 'testimg', '7')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('7', 'Eight', 'Sightseeing', 'dluga 5, 21-123 warszawa', 'Jakis tam opis', '0', '14:00', 'testimg', '8')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('8', 'Ninth', 'Event', 'dluga 5, 21-123 warszawa', 'Jakis tam opis', '0', '12:00', 'testimg', '9')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('passPhr1', 'Tenth', 'Flight', 'dluga 5, 21-123 warszawa', 'Jakis tam opis', '0', '12:00', 'testimg3', '10')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('passPhr2', 'eleven', 'Patisserie', 'dluga 5, 21-123 warszawa', 'Jakis tam opis', '0', '12:00', 'testimg3', '11')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('passPhr3', 'Twelveth', 'Attraction', 'dluga 5, 21-123 warszawa', 'Jakis tam opis', '0', '12:00', 'testimg3', '12')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('passPhr4', 'Thirteenth', 'Attraction', 'dluga 5, 21-123 warszawa', 'Jakis tam opis', '0', '15:00', 'testimg', '13')");
            MainListActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('dupa', 'No wiesz ', 'Attraction', 'dluga 5, 21-123 warszawa', 'specjalnie dla ciebie', '0', '15:00', 'testimg', '14')");
        }
    }
}