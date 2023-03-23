package com.example.eventsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class EventDetails extends AppCompatActivity {
    List<String> singleEvent = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

//        retrieve passphrase of a clicked event
        Bundle bundle = getIntent().getExtras();
        String passphrase = bundle.getString("passphrase");

        singleEvent = MainActivity.dbRecordsRetrieved.get(passphrase);
        defineAndAssignAllEventData();
    }

    private void defineAndAssignAllEventData() {

        //  title
        TextView detailedEventTitle = findViewById(R.id.detailedEventTitle);
        detailedEventTitle.setText(singleEvent.get(0));

        //   type
        TextView detailedEventType = findViewById(R.id.detailedEventType);
        detailedEventType.setText(singleEvent.get(1));

        //   address
        TextView detailedEventAddress = findViewById(R.id.detailedEventAddress);
        detailedEventAddress.setText(singleEvent.get(2));

        //   description
        TextView detailedEventDescription = findViewById(R.id.detailedEventDescription);
        detailedEventDescription.setText(singleEvent.get(3));

        //   time
        TextView detailedEventTime = findViewById(R.id.detailedEventTime);
        detailedEventTime.setText(singleEvent.get(5));

        //   image_name
        ImageView detailedEventPicture = findViewById(R.id.detailedEventPicture);
        detailedEventPicture.setImageResource(Shared.getEventImagesMap(singleEvent.get(6)));


    }
}