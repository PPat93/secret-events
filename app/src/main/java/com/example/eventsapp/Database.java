package com.example.eventsapp;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class Database {

    public Database() {    }


        protected void onCreate() {
        try {
            try (SQLiteDatabase mydatabase = SQLiteDatabase.openOrCreateDatabase("your database name", MODE_PRIVATE, null)) {

        }
        catch (Exception e){
            Log.i("sql error", e.toString());
        }
}
