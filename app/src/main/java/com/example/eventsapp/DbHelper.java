package com.example.eventsapp;

import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

public class DbHelper {

    public DbHelper() {
        super();
    }

    public static void getFirstRecordOfEvents() {

        List<String> firstItem = new ArrayList<>();

        Cursor c = MainActivity.eventsDB.rawQuery("SELECT * FROM events LIMIT 1", null);

        c.moveToFirst();
        do {
            firstItem.add(c.getString(0)); //  id
            firstItem.add(c.getString(1)); //  passphrase
            firstItem.add(c.getString(2)); //  title
            firstItem.add(c.getString(3));//  type
            firstItem.add(c.getString(4)); //  address
            firstItem.add(c.getString(5)); //  description
            firstItem.add(c.getString(6));  //  is_visible
        } while (c.moveToNext());
        c.close();
    }

    public static void fillDB() {
        MainActivity.eventsDB.execSQL("CREATE TABLE IF NOT EXISTS " +
                "events (" +
                "id INTEGER PRIMARY KEY, " +
                "passphrase VARCHAR(100), " +
                "title VARCHAR(100), " +
                "type INTEGER, " +
                "address VARCHAR(100), " +
                "description VARCHAR(255), " +
                "is_visible BOOLEAN" +
                ")");
        MainActivity.eventsDB.execSQL("INSERT INTO " +
                "events (passphrase, title, type, address, description, is_visible)" +
                "VALUES ('passPhr1', 'Title here1', '13', 'dluga 5, 21-123 warszawa', 'Jakis tam opis', '0')");
        MainActivity.eventsDB.execSQL("INSERT INTO " +
                "events (passphrase, title, type, address, description, is_visible)" +
                "VALUES ('passPhr2', 'Title here2', '14', 'dluga 5, 21-123 warszawa', 'Jakis tam opis', '0')");
        MainActivity.eventsDB.execSQL("INSERT INTO " +
                "events (passphrase, title, type, address, description, is_visible)" +
                "VALUES ('passPhr3', 'Title here3', '15', 'dluga 5, 21-123 warszawa', 'Jakis tam opis', '0')");
//        MainActivity.eventsDB.execSQL("DROP TABLE events");
    }
}

