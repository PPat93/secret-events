package com.example.eventsapp;

import java.util.HashMap;

public class Shared {

    public static HashMap<String, Integer> eventTypesMap = new HashMap<String, Integer>();
    public static HashMap<String, Integer> eventImagesMap = new HashMap<String, Integer>();

    public static void setEventTypesHashmap(){
        eventTypesMap.put("Restaurant", R.drawable.icon_restaurant_24);
        eventTypesMap.put("Patisserie", R.drawable.icon_pattisserie_24);
        eventTypesMap.put("Attraction", R.drawable.icon_attraction_24);
        eventTypesMap.put("Event", R.drawable.icon_event_24);
        eventTypesMap.put("Sightseeing", R.drawable.icon_sightseeing_24);
        eventTypesMap.put("Flight", R.drawable.icon_flight_24);
    }

    public static void setEventImagesMap() {
        eventImagesMap.put("testimg", R.drawable.testimg);
        eventImagesMap.put("testimg2", R.drawable.testimg2);
        eventImagesMap.put("testimg3", R.drawable.testimg3);
    }

    public static Integer getEventImagesMap(String hashKey) {
        return eventImagesMap.get(hashKey);
    }

    public static Integer getEventTypesHashmap(String hashKey) {
        return eventTypesMap.get(hashKey);
    }
}
