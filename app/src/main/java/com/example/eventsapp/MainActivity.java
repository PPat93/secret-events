package com.example.eventsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public Handler welcomeDelay = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        end gif displayment earlier, on long click + remove delay handler as it is no longer necessary
        findViewById(R.id.welcomeGif).setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View v) {
                welcomeDelay.removeCallbacksAndMessages(null);
                switchToMainListActivity();
                return true;
            }
        });
//        Welcoming splash screen, displayed with each app boot for 13,5 seconds - I know that it is not
//        a correct way to set up a splash screen, but it is meant to be a welcome and to make an impression
//        also, the app is loading too quickly for the correct way
        welcomeDelay.postDelayed(new Runnable() {
            @Override
            public void run() {
                switchToMainListActivity();
            }
        }, 13500);
    }

    private void switchToMainListActivity() {
        Intent i = new Intent(this, MainListActivity.class);
        startActivity(i);
    }
}