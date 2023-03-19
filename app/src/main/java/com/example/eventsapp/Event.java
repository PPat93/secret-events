package com.example.eventsapp;

public class Event {

    String eventTitle;
    String eventAddress;
    String eventDescription;
    String eventTime, eventType;

    int image;

    public Event(String eventTitle, String eventAddress, String eventTime, String eventType) {
        this.eventTitle = eventTitle;
        this.eventAddress = eventAddress;
        this.eventTime = eventTime;
        this.eventType = eventType;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public void setEventAddress(String eventAddress) {
        this.eventAddress = eventAddress;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public String getEventAddress() {
        return eventAddress;
    }

    public int getImage() {
        return image;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public String getEventTime() {
        return eventTime;
    }
    public String getEventType() {
        return eventType;
    }
}
