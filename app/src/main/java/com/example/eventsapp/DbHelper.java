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
                "type INTEGER, " +
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
                    "VALUES ('Tutorial', 'This is event title!', '13', 'Here, the address will be shown', 'Short description about the event will be here', '1',  '16:00',  'name1.png')");
            MainActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('1', 'Title here1', '13', 'dluga 5, 21-123 warszawa', 'Jakis tam opis', '1',  '12:00',  'name2.png')");
            MainActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('2', 'Title here2', '14', 'dluga 5, 21-123 warszawa', 'Jakis tam opis', '1',  '01:00',  'name3.png')");
            MainActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('3', 'Title here3', '15', 'dluga 5, 21-123 warszawa', 'Jakis tam opis', '1',  '08:00',  'name4.png')");
            MainActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('4', 'Title here1', '13', 'dluga 5, 21-123 warszawa', 'Jakis tam opis', '1',  '11:00',  'name5.png')");
            MainActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('5', 'Title here2', '14', 'dluga 5, 21-123 warszawa', 'Jakis tam opis', '1',  '10:00',  'name6.png')");
            MainActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('6', 'Title here3', '15', 'dluga 5, 21-123 warszawa', 'Jakis tam opis', '1',  '12:00',  'name7.png')");
            MainActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('7', 'Title here1', '13', 'dluga 5, 21-123 warszawa', 'Jakis tam opis', '1',  '14:00',  'name8.png')");
            MainActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('8', 'Title here2', '14', 'dluga 5, 21-123 warszawa', 'Jakis tam opis', '1',  '12:00',  'name9.png')");
            MainActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('passPhr3', 'Title here3', '15', 'dluga 5, 21-123 warszawa', 'Jakis tam opis', '0',  '12:00',  'passPhr3.png')");
            MainActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('passPhr2', 'Title here1', '13', 'dluga 5, 21-123 warszawa', 'Jakis tam opis', '0',  '12:00',  'passPhr2.png')");
            MainActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('passPhr1', 'Title here2', '14', 'dluga 5, 21-123 warszawa', 'Jakis tam opis', '0',  '12:00',  'passPhr1.png')");
            MainActivity.eventsDB.execSQL("INSERT INTO " +
                    "events " +
                    "VALUES ('9', 'Title here3', '15', 'dluga 5, 21-123 warszawa', 'Jakis tam opis', '1',  '15:00',  'name.png')");
        }
    }
}