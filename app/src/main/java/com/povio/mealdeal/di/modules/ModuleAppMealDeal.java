package com.povio.mealdeal.di.modules;

import android.content.Context;

import com.povio.mealdeal.AppMealDeal;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Kresa on 2/21/17.
 */

@Module
public class ModuleAppMealDeal {

    private final AppMealDeal app;

    public ModuleAppMealDeal(AppMealDeal application) {
        app = application;
    }

    @Provides
    @Singleton
    AppMealDeal provideApplication() {
        return app;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return app.getApplicationContext();
    }
}
