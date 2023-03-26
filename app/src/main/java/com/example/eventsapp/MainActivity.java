package com.example.eventsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import nl.dionsegijn.konfetti.core.Angle;
import nl.dionsegijn.konfetti.core.Party;
import nl.dionsegijn.konfetti.core.PartyFactory;
import nl.dionsegijn.konfetti.core.Position;
import nl.dionsegijn.konfetti.core.Spread;
import nl.dionsegijn.konfetti.core.emitter.Emitter;
import nl.dionsegijn.konfetti.core.emitter.EmitterConfig;
import nl.dionsegijn.konfetti.core.models.Size;
import nl.dionsegijn.konfetti.xml.KonfettiView;

public class MainActivity extends AppCompatActivity {
    static List<Event> events = new ArrayList<Event>();
    static HashMap<String, List<String>> dbRecordsRetrieved = new HashMap<String, List<String>>();
    static SQLiteDatabase eventsDB;
    static boolean runFanfaresAnim = false;
    ImageView fanfareRight;
    ImageView fanfareLeft;
    KonfettiView konfettiView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fanfareRight = findViewById(R.id.fanfareRight);
        fanfareLeft = findViewById(R.id.fanfareLeft);
        konfettiView = findViewById(R.id.linearRecycler);

//        setting event type icons and images drawables for recycler view
        Shared.setEventTypesHashmap();
        Shared.setEventImagesMap();

//      Open add pass view
        FloatingActionButton addPassFab = findViewById(R.id.newPass);
        addPassFab.setOnClickListener(view -> openAddView());

//        Method creating and filling DB
        createDb();

//      Event list displayment
        events = new ArrayList<Event>();
        dbRecordsRetrieved.forEach((key, value) -> {
            if (Objects.equals(value.get(4), "1")) {
                events.add(new Event(value.get(0), value.get(2), value.get(5), value.get(1), value.get(6), value.get(7), key));
            }
        });

//        Sort events object, so Recycler View will show items in correct order. It is sorted by additional order_name value from
//        the order_name column added in DB.
        Collections.sort(events, new Comparator<Event>() {
            @Override
            public int compare(final Event event1, final Event event2) {
                return event2.getOrderNumber() - event1.getOrderNumber();
            }
        });

//        Attach recycler data to layout item
        RecyclerView mainEventsList = findViewById(R.id.mainEventsList);
        mainEventsList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mainEventsList.setAdapter(new ViewAdapter(getApplicationContext(), events));

        if (runFanfaresAnim) {
            runFanfaresAnim = false;
            FanfareAnim.wholeFanfareAnimation(fanfareLeft, fanfareRight, konfettiView);
        }
    }

    public HashMap<String, List<String>> createDb() {

        eventsDB = this.openOrCreateDatabase("eventsDB", Context.MODE_PRIVATE, null);

        DbHelper.fillDB();

        Cursor c = eventsDB.rawQuery("SELECT * FROM events", null);
        c.moveToFirst();

//      create and rearrange retrieved db records
        do {
            List<String> tempEventRecord = new ArrayList<String>();
            tempEventRecord.add(c.getString(1));//  title
            tempEventRecord.add(c.getString(2));//  type
            tempEventRecord.add(c.getString(3));//  address
            tempEventRecord.add(c.getString(4));//  description
            tempEventRecord.add(c.getString(5));//  is_visible
            tempEventRecord.add(c.getString(6));//  hour
            tempEventRecord.add(c.getString(7));//  image_name
            tempEventRecord.add(c.getString(8));//  order_number

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