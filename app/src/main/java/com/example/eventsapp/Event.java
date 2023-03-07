package com.example.eventsapp;

public class Event {

    String eventTitle;
    String eventAddress;
    int image;

    public Event(String eventTitle, String eventAddress, int image) {
        this.eventTitle = eventTitle;
        this.eventAddress = eventAddress;
        this.image = image;
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

    public String getEventTitle() {
        return eventTitle;
    }

    public String getEventAddress() {
        return eventAddress;
    }

    public int getImage() {
        return image;
    }
}
