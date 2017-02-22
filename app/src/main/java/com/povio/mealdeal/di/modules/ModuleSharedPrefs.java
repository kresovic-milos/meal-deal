package com.povio.mealdeal.di.modules;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;

import com.povio.mealdeal.AppMealDeal;
import com.povio.mealdeal.persistance.SharedPrefsAPI;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Kresa on 2/21/17.
 */

@Module
public class ModuleSharedPrefs {

    @Provides
    @Singleton
    SharedPreferences provideSharedPrefs(@NonNull AppMealDeal app) {
        return PreferenceManager.getDefaultSharedPreferences(app);
//        return app.getSharedPreferences(Constants.PrefsKeys.MEAL_DEAL, Context.MODE_PRIVATE);
    }

    @Provides
    @Singleton
    SharedPrefsAPI provideSharedPrefsAPI(@NonNull SharedPreferences sharedPreferences) {
        return new SharedPrefsAPI(sharedPreferences);
    }
}
