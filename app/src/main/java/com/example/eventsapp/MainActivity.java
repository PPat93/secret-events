package com.example.eventsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    static List<Event> events = new ArrayList<Event>();
    static List<List<String>> dbRecordsRetrieved = new ArrayList<List<String>>();
    static SQLiteDatabase eventsDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//      Open add pass view
        FloatingActionButton addPassFab = findViewById(R.id.newPass);
        addPassFab.setOnClickListener(view -> openAddView());

//      Event list displayment
        RecyclerView mainEventsList = findViewById(R.id.mainEventsList);
        mainEventsList.setLayoutManager(new LinearLayoutManager(this));
        mainEventsList.setAdapter(new ViewAdapter(getApplicationContext(), events));
        Intent intent = getIntent();
//        restrict db to get created and filled only once
        createDb();
    }

    public List<List<String>> createDb() {

        eventsDB = this.openOrCreateDatabase("eventsDB", Context.MODE_PRIVATE, null);
        DbHelper.fillDB();
        Cursor c = eventsDB.rawQuery("SELECT * FROM events", null);

        List<String> tempEventRecord = new ArrayList<String>();
        c.moveToFirst();
        do {
            tempEventRecord.add(c.getString(0));//  id
            tempEventRecord.add(c.getString(1));//  passphrase
            tempEventRecord.add(c.getString(2));//  title
            tempEventRecord.add(c.getString(3));//  type
            tempEventRecord.add(c.getString(4));//  address
            tempEventRecord.add(c.getString(5));//  description
            tempEventRecord.add(c.getString(6));//  is_visible
            dbRecordsRetrieved.add(tempEventRecord);
        }
        while (c.moveToNext());
        c.close();
        dbRecordsRetrieved.forEach(item -> {
            Log.i("yazda", item.get(6));
        });

        return dbRecordsRetrieved;
    }

    public void openAddView() {
        Intent openAddViewIntent = new Intent(this, AddView.class);
        startActivity(openAddViewIntent);
    }
}