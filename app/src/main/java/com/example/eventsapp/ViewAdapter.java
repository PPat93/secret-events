package com.example.eventsapp;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ViewAdapter extends RecyclerView.Adapter<ViewHolder> {

    Context context;
    List<Event> events;

    public ViewAdapter(Context context, List<Event> events) {
        this.context = context;
        this.events = events;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_event_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.eventTitle.setText(events.get(position).getEventTitle());
        holder.eventAddress.setText(events.get(position).getEventAddress());
        holder.eventTime.setText(events.get(position).getEventTime());
        holder.eventPassphrase.setText(events.get(position).getEventPassphrase());
        holder.eventTypeIcon.setImageResource(Shared.getEventTypesHashmap(events.get(position).getEventType()));
        holder.eventPicture.setImageResource(Shared.getEventImagesMap(events.get(position).getEventPicture()));

//        static icons for each recycler item below
        holder.eventTitleIcon.setImageResource(R.drawable.baseline_outlined_flag_24);
        holder.eventAddressIcon.setImageResource(R.drawable.baseline_location_on_24);
        holder.eventTimeIcon.setImageResource(R.drawable.baseline_access_time_24);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent openEventDetailsIntent = new Intent(context, EventDetails.class);
                openEventDetailsIntent.putExtra("passphrase", holder.eventPassphrase.getText());
                openEventDetailsIntent.setFlags(FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(openEventDetailsIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return events.size();
    }
}
