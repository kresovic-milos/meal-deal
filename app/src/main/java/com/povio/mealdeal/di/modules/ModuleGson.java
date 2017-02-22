package com.povio.mealdeal.di.modules;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.text.DateFormat;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Kresa on 2/21/17.
 */

@Module
public class ModuleGson {

    @Provides
    @Singleton
    GsonBuilder provideDefaultGsonBuilder() {

        GsonBuilder gsonBuilder = new GsonBuilder();

        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.IDENTITY);
        gsonBuilder.setDateFormat(DateFormat.FULL);
//        .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
        return gsonBuilder;
    }

    @Provides
    @Singleton
    Gson provideGson(GsonBuilder gsonBuilder) {
        return gsonBuilder.create();
    }
}
