package com.example.eventsapp;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class dbHelper {

    public dbHelper() {
        super();
    }

    public void fillDB() {
        MainActivity.eventsDB.execSQL("CREATE TABLE " +
                "users(" +
                "id INTEGER PRIMARY KEY, " +
                "passphrase VARCHAR(100), " +
                "title VARCHAR(100), " +
                "type INTEGER, " +
                "address VARCHAR(100), " +
                "description VARCHAR(255), " +
                "is_visible BOOLEAN" +
                ")");
        MainActivity.eventsDB.execSQL("INSERT INTO " +
                "users (passphrase, title, type, address, description, is_visible)" +
                "VALUES ('passPhr', 'Title here', '1', 'dluga 5, 21-123 warszawa', 'Jakis tam opis', 'true')");
    }
}

