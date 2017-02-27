package com.povio.mealdeal.utils;

import static com.povio.mealdeal.utils.Constants.ApiUrls.DEALS;

/**
 * Created by Kresa on 2/16/17.
 */

public class Constants {

    public static final String TAG = "mealdeal";

    public static class ApiUrls {
        public static final String BASE = "http://demo7141628.mockable.io/";
        public static final String DEALS = "deals";
        public static final String TOGGLE_FAV = "fav";
    }

    public static class PrefsKeys {
        public static String MEAL_DEAL = "mealDealAppSharedPrefs";
        public static final String MAP_VIEW = "isMapView";
    }

    public static class Font {
        public static final String THICK_1 = "SmudgieCrayon.ttf";
        public static final String THICK_2 = "KraftNineDEMO.ttf";

        public static final String SKINNY_1 = "ChalkLine.ttf";
        public static final String SKINNY_2 = "Tafelschrift.ttf";
    }

}
