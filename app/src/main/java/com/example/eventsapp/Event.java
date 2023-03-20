package com.example.eventsapp;

public class Event {

    String eventTitle;
    String eventAddress;
    String eventDescription;
    String eventTime, eventType, eventPicture;


    public Event(String eventTitle, String eventAddress, String eventTime, String eventType, String eventPicture) {
        this.eventTitle = eventTitle;
        this.eventAddress = eventAddress;
        this.eventTime = eventTime;
        this.eventType = eventType;
        this.eventPicture = eventPicture;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public void setEventAddress(String eventAddress) {
        this.eventAddress = eventAddress;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getEventDescription() {
        return eventDescription;
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
}
