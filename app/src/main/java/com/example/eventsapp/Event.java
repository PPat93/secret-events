package com.example.eventsapp;

import static java.lang.Integer.parseInt;

public class Event {

    String eventTitle, eventAddress, eventTime, eventType, eventPicture, order_number, event_description;

    public Event(String eventTitle, String eventAddress, String eventTime, String eventType, String eventPicture, String order_number) {
        this.eventTitle = eventTitle;
        this.eventAddress = eventAddress;
        this.eventTime = eventTime;
        this.eventType = eventType;
        this.eventPicture = eventPicture;
        this.order_number = order_number;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public void setEventAddress(String eventAddress) {
        this.eventAddress = eventAddress;
    }

    public void setevent_description(String event_description) {
        this.event_description = event_description;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getevent_description() {
        return event_description;
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
}
