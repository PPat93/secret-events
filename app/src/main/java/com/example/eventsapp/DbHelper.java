package com.example.eventsapp;

public class DbHelper {

    public DbHelper() {
        super();
    }

    public static void fillDB() {
        MainActivity.eventsDB.execSQL("CREATE TABLE IF NOT EXISTS " +
                "events(" +
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
                "VALUES ('passPhr', 'Title here', '1', 'dluga 5, 21-123 warszawa', 'Jakis tam opis', 'true')");
    }
}

