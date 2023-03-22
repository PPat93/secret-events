package com.example.eventsapp;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {

    TextView eventTitle, eventAddress, eventTime;
    ImageView eventTypeIcon, eventTitleIcon, eventAddressIcon, eventTimeIcon, eventPicture;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        eventTitle = itemView.findViewById(R.id.eventTitle);
        eventAddress = itemView.findViewById(R.id.eventAddress);
        eventTime = itemView.findViewById(R.id.eventTime);
        eventTypeIcon = itemView.findViewById(R.id.eventTypeIcon);
        eventPicture = itemView.findViewById(R.id.eventPicture);

        eventTitleIcon = itemView.findViewById(R.id.eventTitleIcon);
        eventAddressIcon = itemView.findViewById(R.id.eventAddressIcon);
        eventTimeIcon = itemView.findViewById(R.id.eventTimeIcon);

        View singleEventItem = itemView.findViewById(R.id.singleEventItem);
        singleEventItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent openEventDetailsIntent = new Intent(context, EventDetails.class);
                openEventDetailsIntent.putExtra("detailedPassphrase", "pass");
                openEventDetailsIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(openEventDetailsIntent);
            }
        });
    }
}
