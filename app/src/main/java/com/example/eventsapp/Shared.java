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

//            MISC
        eventImagesMap.put("example", R.drawable.example);
        eventImagesMap.put("pct_flight_to", R.drawable.pct_flight_to);

//            FOOD
//            Breakfast
        eventImagesMap.put("pct_naplavka_market", R.drawable.pct_naplavka_market);

//            Lunch/Dinner

//            Supper
        eventImagesMap.put("pct_frites_butik", R.drawable.pct_frites_butik);

//            Pubs/Additional food
        eventImagesMap.put("pct_shrinks_office", R.drawable.pct_shrinks_office);
        eventImagesMap.put("pct_trdelnik_coffe", R.drawable.pct_trdelnik_coffe);

//            Fine Dining

//            PLACES TO VISIT
//            Activities
        eventImagesMap.put("pct_ghost_tour", R.drawable.pct_ghost_tour);
        eventImagesMap.put("pct_signal", R.drawable.pct_signal);

//            Attractions
        eventImagesMap.put("pct_petrin", R.drawable.pct_petrin);
        eventImagesMap.put("pct_palace", R.drawable.pct_palace);
        eventImagesMap.put("pct_na_film", R.drawable.pct_na_film);
        eventImagesMap.put("pct_vysehrad_national_monument", R.drawable.pct_vysehrad_national_monument);
        eventImagesMap.put("pct_sex_machines_museum", R.drawable.pct_sex_machines_museum);
        eventImagesMap.put("pct_astronomical_clock", R.drawable.pct_astronomical_clock);
        eventImagesMap.put("pct_palac_lobkowiczow", R.drawable.pct_palac_lobkowiczow);

//            Strolling
        eventImagesMap.put("pct_charles_bridge", R.drawable.pct_charles_bridge);
        eventImagesMap.put("pct_municipal_library", R.drawable.pct_municipal_library);
        eventImagesMap.put("pct_brama_prochowa", R.drawable.pct_brama_prochowa);
        eventImagesMap.put("pct_franz_kafka", R.drawable.pct_franz_kafka);
        eventImagesMap.put("pct_dancing_house", R.drawable.pct_dancing_house);

//            Misc

    }

    public static Integer getEventImagesMap(String hashKey) {
        return eventImagesMap.get(hashKey);
    }

    public static Integer getEventTypesHashmap(String hashKey) {
        return eventTypesMap.get(hashKey);
    }
}
