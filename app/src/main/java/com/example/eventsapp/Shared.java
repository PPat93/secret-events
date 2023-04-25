package com.example.eventsapp;

import android.view.animation.AlphaAnimation;
import android.widget.ImageView;

import java.util.HashMap;

public class Shared {
    public static HashMap<String, Integer> eventTypesMap = new HashMap<String, Integer>();
    public static HashMap<String, Integer> eventImagesMap = new HashMap<String, Integer>();

    public static void setEventTypesHashmap() {
        eventTypesMap.put("Restaurant", R.drawable.icon_restaurant_24);
        eventTypesMap.put("Patisserie", R.drawable.icon_pattisserie_24);
        eventTypesMap.put("Attraction", R.drawable.icon_attraction_24);
        eventTypesMap.put("Event", R.drawable.icon_event_24);
        eventTypesMap.put("Sightseeing", R.drawable.icon_sightseeing_24);
        eventTypesMap.put("Flight", R.drawable.icon_flight_24);
        eventTypesMap.put("Bar", R.drawable.baseline_local_bar_24);
    }

    public static void setEventImagesMap() {
        eventImagesMap.put("testimg", R.drawable.testimg);
        eventImagesMap.put("testimg2", R.drawable.testimg2);
        eventImagesMap.put("testimg3", R.drawable.testimg3);
        eventImagesMap.put("example", R.drawable.example);
        eventImagesMap.put("pct_sex_machines_museum", R.drawable.pct_sex_machines_museum);
        eventImagesMap.put("pct_naplavka_market", R.drawable.pct_naplavka_market);
        eventImagesMap.put("pct_frites_butik", R.drawable.pct_frites_butik);
        eventImagesMap.put("pct_flight_to", R.drawable.pct_flight_to);
        eventImagesMap.put("pct_ghost_tour", R.drawable.pct_ghost_tour);
        eventImagesMap.put("pct_shrinks_office", R.drawable.pct_shrinks_office);
    }

    public static Integer getEventImagesMap(String hashKey) {
        return eventImagesMap.get(hashKey);
    }

    public static Integer getEventTypesHashmap(String hashKey) {
        return eventTypesMap.get(hashKey);
    }
}
