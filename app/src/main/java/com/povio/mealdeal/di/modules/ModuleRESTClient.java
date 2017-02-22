package com.povio.mealdeal.di.modules;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.povio.mealdeal.networking.retrofit.DealsRetrofitService;
import com.povio.mealdeal.networking.retrofit.RESTClientRetrofit2;
import com.povio.mealdeal.utils.Constants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Kresa on 2/21/17.
 */

@Module
public class ModuleRESTClient {

    @Provides
    @Singleton
    Retrofit provideRestAdapter(@NonNull Gson gson) {
        return new Retrofit.Builder()
                .baseUrl(Constants.ApiUrls.BASE)
                .addConverterFactory(GsonConverterFactory.create(gson))
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    DealsRetrofitService provideDealsService(@NonNull Retrofit retrofit) {
        return retrofit.create(DealsRetrofitService.class);
    }

    @Provides
    @Singleton
    RESTClientRetrofit2 provideRESTClient(@NonNull DealsRetrofitService dealsRetrofitService) {
        return new RESTClientRetrofit2(dealsRetrofitService);
    }
}
