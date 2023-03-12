package com.example.eventsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    static List<Event> events = new ArrayList<Event>();

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
//        if (intent.getStringExtra("newPass") != null)
//            events.add(new Event(intent.getStringExtra("newPass"), "Plac bohaterów getta 3, Kraków ", R.drawable.testimg3));

        try {
            SQLiteDatabase mydatabase = this.openOrCreateDatabase("your database name", Context.MODE_PRIVATE, null);
        } catch (Exception e) {
            Log.i("sql error", e.toString());
        }
    }


    public void openAddView() {
        Intent openAddViewIntent = new Intent(this, AddView.class);
        startActivity(openAddViewIntent);
    }
}