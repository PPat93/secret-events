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
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    static List<Event> events = new ArrayList<Event>();
    static HashMap<String, List<String>> dbRecordsRetrieved = new HashMap<String, List<String>>();
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

//        Method creating and filling DB
        createDb();
    }

    public HashMap<String, List<String>> createDb() {
        // START DEBUG
//        eventsDB.execSQL("DROP TABLE events");
        // END DEBUG

        eventsDB = this.openOrCreateDatabase("eventsDB", Context.MODE_PRIVATE, null);

//        protection so db is filled only if no data exists in db
        if (DbHelper.getFirstRecordOfEvents().equals(""))
            DbHelper.fillDB();

        Cursor c = eventsDB.rawQuery("SELECT * FROM events", null);
        c.moveToFirst();

//      create and rearrange retrieved db records
        do {
//      below is - {id, title, type, address, description, is_visible}
            List<String> tempEventRecord = new ArrayList<String>();
            tempEventRecord.add(c.getString(1));//  title
            tempEventRecord.add(c.getString(2));//  type
            tempEventRecord.add(c.getString(3));//  address
            tempEventRecord.add(c.getString(4));//  description
            tempEventRecord.add(c.getString(5));//  is_visible

//          below is - key: passphrase, value: List<String>
            dbRecordsRetrieved.put(c.getString(0), tempEventRecord);
        }
        while (c.moveToNext());
        c.close();

        // START DEBUG
        dbRecordsRetrieved.forEach((key, value) -> {
            Log.i(key, value.toString());
        });
        // END DEBUG
        return dbRecordsRetrieved;
    }

    public void openAddView() {
        Intent openAddViewIntent = new Intent(this, AddView.class);
        startActivity(openAddViewIntent);
    }
}