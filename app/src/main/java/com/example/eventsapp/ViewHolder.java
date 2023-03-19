package com.example.eventsapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {

    TextView eventTitle, eventAddress, eventTime;
    ImageView eventTypeIcon, eventTitleIcon, eventAddressIcon, eventTimeIcon;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        eventTitle = itemView.findViewById(R.id.eventTitle);
        eventAddress = itemView.findViewById(R.id.eventAddress);
        eventTime = itemView.findViewById(R.id.eventTime);
        eventTypeIcon = itemView.findViewById(R.id.eventTypeIcon);

        eventTitleIcon = itemView.findViewById(R.id.eventTitleIcon);
        eventAddressIcon = itemView.findViewById(R.id.eventAddressIcon);
        eventTimeIcon = itemView.findViewById(R.id.eventTimeIcon);
    }
}
