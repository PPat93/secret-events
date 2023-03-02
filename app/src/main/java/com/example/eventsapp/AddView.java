package com.example.eventsapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class AddView extends AppCompatActivity {

    private String title = "";
    private String description = "";
    private String image = "";
    //private Date date = TODO
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
