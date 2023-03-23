package com.example.eventsapp;

import static java.lang.Integer.parseInt;

import android.util.Log;

public class Event {

    String eventTitle, eventAddress, eventTime, eventType, eventPicture, order_number, event_description, event_passphrase;

    public Event(String eventTitle, String eventAddress, String eventTime, String eventType, String eventPicture, String order_number, String event_passphrase) {
        this.eventTitle = eventTitle;
        this.eventAddress = eventAddress;
        this.eventTime = eventTime;
        this.eventType = eventType;
        this.eventPicture = eventPicture;
        this.order_number = order_number;
        this.event_passphrase = event_passphrase;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public String getEventAddress() {
        return eventAddress;
    }

    public String getEventTime() {
        return eventTime;
    }

    public String getEventType() {
        return eventType;
    }

    public String getEventPicture() {
        return eventPicture;
    }

    public int getOrderNumber() {
        return parseInt(order_number);
    }

    public String getEventPassphrase() {
        return event_passphrase;
    }
}
