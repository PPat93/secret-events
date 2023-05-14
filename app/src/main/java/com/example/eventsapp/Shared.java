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
        eventTypesMap.put("Hotel", R.drawable.baseline_hotel_24);
        eventTypesMap.put("Breakfast", R.drawable.baseline_breakfast_dining_24);
        eventTypesMap.put("IceCream", R.drawable.baseline_icecream_24);
        eventTypesMap.put("Teahouse", R.drawable.baseline_emoji_food_beverage_24);
        eventTypesMap.put("Joker", R.drawable.baseline_star_24);
    }

    public static void setEventImagesMap() {
        eventImagesMap.put("testimg", R.drawable.testimg);
        eventImagesMap.put("testimg2", R.drawable.testimg2);
        eventImagesMap.put("testimg3", R.drawable.testimg3);

//            MISC
        eventImagesMap.put("example", R.drawable.example);
        eventImagesMap.put("pct_flight_to", R.drawable.pct_flight_to);
        eventImagesMap.put("pct_dupa", R.drawable.pct_dupa);

//            FOOD
//            Breakfast
        eventImagesMap.put("pct_naplavka_market", R.drawable.pct_naplavka_market);
        eventImagesMap.put("pct_bistro_monk", R.drawable.pct_bistro_monk);
        eventImagesMap.put("pct_venue", R.drawable.pct_venue);
        eventImagesMap.put("pct_jewel", R.drawable.pct_jewel);
        eventImagesMap.put("pct_bajgle", R.drawable.pct_bajgle);
        eventImagesMap.put("pct_wsrod_jeleni", R.drawable.pct_wsrod_jeleni);

//            Lunch/Dinner
        eventImagesMap.put("pct_glaubicowie", R.drawable.pct_glaubicowie);
        eventImagesMap.put("pct_pork", R.drawable.pct_pork);
        eventImagesMap.put("pct_vytopna", R.drawable.pct_vytopna);
        eventImagesMap.put("pct_knedle", R.drawable.pct_knedle);

//            Supper
        eventImagesMap.put("pct_frites_butik", R.drawable.pct_frites_butik);

//            Pubs/Additional food
        eventImagesMap.put("pct_shrinks_office", R.drawable.pct_shrinks_office);
        eventImagesMap.put("pct_trdelnik_coffe", R.drawable.pct_trdelnik_coffe);
        eventImagesMap.put("pct_oh_deer", R.drawable.pct_oh_deer);
        eventImagesMap.put("pct_kolacze", R.drawable.pct_kolacze);
        eventImagesMap.put("pct_artic_bakery", R.drawable.pct_artic_bakery);
        eventImagesMap.put("pct_crem_de_la", R.drawable.pct_crem_de_la);
        eventImagesMap.put("pct_dobra_cajownia", R.drawable.pct_dobra_cajownia);

//            Fine Dining

//            Misc
        eventImagesMap.put("pct_louvre", R.drawable.pct_louvre);

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
        eventImagesMap.put("pct_narodni_divadlo", R.drawable.pct_narodni_divadlo);
        eventImagesMap.put("pct_obecni_dum", R.drawable.pct_obecni_dum);
        eventImagesMap.put("pct_muzeum_sliwowica", R.drawable.pct_muzeum_sliwowica);

//            Strolling
        eventImagesMap.put("pct_charles_bridge", R.drawable.pct_charles_bridge);
        eventImagesMap.put("pct_municipal_library", R.drawable.pct_municipal_library);
        eventImagesMap.put("pct_brama_prochowa", R.drawable.pct_brama_prochowa);
        eventImagesMap.put("pct_franz_kafka", R.drawable.pct_franz_kafka);
        eventImagesMap.put("pct_dancing_house", R.drawable.pct_dancing_house);
        eventImagesMap.put("pct_church_tyn", R.drawable.pct_church_tyn);
        eventImagesMap.put("pct_gardens", R.drawable.pct_gardens);

    }

    public static Integer getEventImagesMap(String hashKey) {
        return eventImagesMap.get(hashKey);
    }

    public static Integer getEventTypesHashmap(String hashKey) {
        return eventTypesMap.get(hashKey);
    }
}
