package com.example.eventsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
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

//        close activity
        Button backButton = findViewById(R.id.closeDetails);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        findViewById(R.id.detailedEventAddress).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
//                        on address click open Google Maps with event address searched
                        Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + singleEvent.get(2));
                        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                        mapIntent.setPackage("com.google.android.apps.maps");
                        startActivity(mapIntent);
                    }
                }, 500);
            }
        });
    }

    private void defineAndAssignAllEventData() {

        //  title
        TextView detailedEventTitle = findViewById(R.id.detailedEventTitle);
        detailedEventTitle.setText(singleEvent.get(0));

        //  title icon
        ImageView detailedEventTitleIcon = findViewById(R.id.detailedEventTitleIcon);
        detailedEventTitleIcon.setImageResource(R.drawable.baseline_outlined_flag_24);

        //   type
        TextView detailedEventType = findViewById(R.id.detailedEventType);
        detailedEventType.setText(singleEvent.get(1));

        //   type icon
        ImageView detailedEventTypeIcon = findViewById(R.id.detailedEventTypeIcon);
        detailedEventTypeIcon.setImageResource(Shared.getEventTypesHashmap(singleEvent.get(1)));

        //   address
        TextView detailedEventAddress = findViewById(R.id.detailedEventAddress);
        detailedEventAddress.setText(singleEvent.get(2));

        //   address icon
        ImageView detailedEventAddressIcon = findViewById(R.id.detailedEventAddressIcon);
        detailedEventAddressIcon.setImageResource(R.drawable.baseline_location_on_24);

        //   description
        TextView detailedEventDescription = findViewById(R.id.detailedEventDescription);
        detailedEventDescription.setText(singleEvent.get(3));

        //   description icon
        ImageView detailedEventDescriptionIcon = findViewById(R.id.detailedEventDescriptionIcon);
        detailedEventDescriptionIcon.setImageResource(R.drawable.baseline_text_snippet_24);

        //   time
        TextView detailedEventTime = findViewById(R.id.detailedEventTime);
        detailedEventTime.setText(singleEvent.get(5));

        //   time icon
        ImageView detailedEventTimeIcon = findViewById(R.id.detailedEventTimeIcon);
        detailedEventTimeIcon.setImageResource(R.drawable.baseline_access_time_24);

        //   image_name
        ImageView detailedEventPicture = findViewById(R.id.detailedEventPicture);
        detailedEventPicture.setImageResource(Shared.getEventImagesMap(singleEvent.get(6)));
    }
}