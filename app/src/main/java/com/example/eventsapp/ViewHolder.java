package com.example.eventsapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {

    TextView eventTitle, eventAddress;
    ImageView eventPicture;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        eventTitle = itemView.findViewById(R.id.eventTitle);
        eventAddress = itemView.findViewById(R.id.eventAddress);
        eventPicture = itemView.findViewById(R.id.eventPicture);
    }
}
