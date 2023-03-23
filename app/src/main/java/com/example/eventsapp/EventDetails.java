package com.example.eventsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class EventDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);
        Intent passphraseIntent = new Intent();
        String str = passphraseIntent.getStringExtra("detailedPassphrase");
        TextView textView2 = findViewById(R.id.textView2);
        textView2.setText(str + "siema");

    }
}