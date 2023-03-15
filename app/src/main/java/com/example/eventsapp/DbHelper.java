package com.example.eventsapp;

public class DbHelper {

    public DbHelper() {
        super();
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
                "VALUES ('passPhr1', 'Title here1', '13', 'dluga 5, 21-123 warszawa', 'Jakis tam opis', 0)");
        MainActivity.eventsDB.execSQL("INSERT INTO " +
                "events (passphrase, title, type, address, description, is_visible)" +
                "VALUES ('passPhr2', 'Title here2', '14', 'dluga 5, 21-123 warszawa', 'Jakis tam opis', 0)");
        MainActivity.eventsDB.execSQL("INSERT INTO " +
                "events (passphrase, title, type, address, description, is_visible)" +
                "VALUES ('passPhr3', 'Title here3', '15', 'dluga 5, 21-123 warszawa', 'Jakis tam opis', 0)");
    }
}

