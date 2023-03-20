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
                "image_name VARCHAR(20)" +
                ")");

//        protection so db is filled only if no data exists in db
        if (getFirstRecordOfEvents() == 0) {
            MainActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('Tutorial', 'This is event title!', 'Restaurant', 'Here, the address will be shown', 'Short description about the event will be here', '1', '16:00', 'testimg')");
            MainActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('1', 'Title here1', 'Restaurant', 'dluga 5, 21-123 warszawa', 'Jakis tam opis', '1', '12:00', 'testimg')");
            MainActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('2', 'Title here2', 'Patisserie', 'dluga 5, 21-123 warszawa', 'Jakis tam opis', '1', '01:00', 'testimg2')");
            MainActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('3', 'Title here3', 'Attraction', 'dluga 5, 21-123 warszawa', 'Jakis tam opis', '1', '08:00', 'testimg')");
            MainActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('4', 'Title here1', 'Event', 'dluga 5, 21-123 warszawa', 'Jakis tam opis', '1', '11:00', 'testimg')");
            MainActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('5', 'Title here2', 'Sightseeing', 'dluga 5, 21-123 warszawa', 'Jakis tam opis', '1', '10:00', 'testimg')");
            MainActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('6', 'Title here3', 'Sightseeing', 'dluga 5, 21-123 warszawa', 'Jakis tam opis', '1', '12:00', 'testimg')");
            MainActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('7', 'Title here1', 'Sightseeing', 'dluga 5, 21-123 warszawa', 'Jakis tam opis', '1', '14:00', 'testimg')");
            MainActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('8', 'Title here2', 'Event', 'dluga 5, 21-123 warszawa', 'Jakis tam opis', '1', '12:00', 'testimg')");
            MainActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('passPhr3', 'Title here3', 'Flight', 'dluga 5, 21-123 warszawa', 'Jakis tam opis', '0', '12:00', 'testimg3')");
            MainActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('passPhr2', 'Title here1', 'Patisserie', 'dluga 5, 21-123 warszawa', 'Jakis tam opis', '0', '12:00', 'testimg3')");
            MainActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('passPhr1', 'Title here2', 'Attraction', 'dluga 5, 21-123 warszawa', 'Jakis tam opis', '0', '12:00', 'testimg3')");
            MainActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('9', 'Title here3', 'Attraction', 'dluga 5, 21-123 warszawa', 'Jakis tam opis', '1', '15:00', 'testimg')");
        }
    }
}