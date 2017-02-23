package com.povio.mealdeal.di.components;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.povio.mealdeal.AppMealDeal;
import com.povio.mealdeal.di.modules.ModuleAppMealDeal;
import com.povio.mealdeal.di.modules.ModuleGson;
import com.povio.mealdeal.di.modules.ModuleRESTClient;
import com.povio.mealdeal.di.modules.ModuleSharedPrefs;
import com.povio.mealdeal.networking.retrofit.RESTClientRetrofit2;
import com.povio.mealdeal.persistance.SharedPrefsAPI;
import com.povio.mealdeal.ui.activities.ActivityMain;
import com.povio.mealdeal.ui.fragments.FragmentDealsMap;
import com.povio.mealdeal.viewmodel.ViewModelDealsFeed;
import com.povio.mealdeal.viewmodel.ViewModelMain;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Kresa on 2/21/17.
 */

@Singleton
@Component(modules = {
        ModuleAppMealDeal.class,
        ModuleGson.class,
        ModuleRESTClient.class,
        ModuleSharedPrefs.class
})
public interface ComponentMealDeal {

    Context provideContext();
    AppMealDeal provideApplication();
    Gson provideGson();
    RESTClientRetrofit2 provideRestClientRetrofit2();
    SharedPreferences provideSharedPrefs();
    SharedPrefsAPI provideSharedPrefsAPI();
    //    LayoutInflater provideLayoutInflater();

    void inject(AppMealDeal app);
    void inject(ActivityMain activityMain);
    void inject(ViewModelDealsFeed baseViewModel);
    void inject(ViewModelMain viewModelMain);
    void inject(FragmentDealsMap fragmentDealsMap);

    final class Initializer {
        public static ComponentMealDeal init(AppMealDeal app) {
            return DaggerComponentMealDeal.builder()
                    .moduleAppMealDeal(new ModuleAppMealDeal(app))
                    .moduleGson(new ModuleGson())
                    .moduleRESTClient(new ModuleRESTClient())
                    .moduleSharedPrefs(new ModuleSharedPrefs())
                    .build();
        }
    }

}
