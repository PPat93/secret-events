package com.example.eventsapp;

import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

public class DbHelper {

    public DbHelper() {
        super();
    }

//    Checks if any item exists, if so, it is returned, if not, empty string is returned
    public static String getFirstRecordOfEvents() {

        String firstItem = "";
        Cursor c = MainActivity.eventsDB.rawQuery("SELECT * FROM events LIMIT 1", null);

        c.moveToFirst();
        c.getString(0); //  passphrase
        c.close();
        return firstItem;
    }

    public static void fillDB() {
        MainActivity.eventsDB.execSQL("CREATE TABLE IF NOT EXISTS " +
                "events (" +
                "passphrase VARCHAR(100), " +
                "title VARCHAR(100), " +
                "type INTEGER, " +
                "address VARCHAR(100), " +
                "description VARCHAR(255), " +
                "is_visible BOOLEAN" +
                ")");
        MainActivity.eventsDB.execSQL("INSERT INTO " +
                "events " +
                "VALUES ('passPhr1', 'Title here1', '13', 'dluga 5, 21-123 warszawa', 'Jakis tam opis', '0')");
        MainActivity.eventsDB.execSQL("INSERT INTO " +
                "events " +
                "VALUES ('passPhr2', 'Title here2', '14', 'dluga 5, 21-123 warszawa', 'Jakis tam opis', '0')");
        MainActivity.eventsDB.execSQL("INSERT INTO " +
                "events " +
                "VALUES ('passPhr3', 'Title here3', '15', 'dluga 5, 21-123 warszawa', 'Jakis tam opis', '0')");
    }
}

