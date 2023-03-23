package com.example.eventsapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {

    TextView eventTitle, eventAddress, eventTime, eventPassphrase;
    ImageView eventTypeIcon, eventTitleIcon, eventAddressIcon, eventTimeIcon, eventPicture;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        eventTitle = itemView.findViewById(R.id.detailedEventTitle);
        eventAddress = itemView.findViewById(R.id.eventAddress);
        eventTime = itemView.findViewById(R.id.detailedEventTime);
        eventTypeIcon = itemView.findViewById(R.id.detailedEventTypeIcon);
        eventPicture = itemView.findViewById(R.id.detailedEventPicture);
        eventTitleIcon = itemView.findViewById(R.id.detailedEventTitleIcon);
        eventAddressIcon = itemView.findViewById(R.id.detailedEventAddressIcon);
        eventTimeIcon = itemView.findViewById(R.id.detailedEeventTimeIcon);
        eventPassphrase = itemView.findViewById(R.id.eventPassphrase);
    }
}
