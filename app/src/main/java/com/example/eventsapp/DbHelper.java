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
                "is_visible BOOLEAN" +
                ")");

        Log.i("wypeelnijbefore", String.valueOf(getFirstRecordOfEvents()));

//        protection so db is filled only if no data exists in db
        if (getFirstRecordOfEvents() == 0) {
            Log.i("wypeelnijpo", String.valueOf(getFirstRecordOfEvents()));
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
}

