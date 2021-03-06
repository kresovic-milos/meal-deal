package com.povio.mealdeal.viewmodel;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.MenuItem;

import com.povio.mealdeal.AppMealDeal;
import com.povio.mealdeal.R;
import com.povio.mealdeal.entities.Deal;
import com.povio.mealdeal.networking.RequestCompleteListener;
import com.povio.mealdeal.networking.retrofit.RESTClientRetrofit2;
import com.povio.mealdeal.persistance.SharedPrefsAPI;
import com.povio.mealdeal.ui.adapters.AdapterTabsMain;
import com.povio.mealdeal.utils.Constants;
import com.povio.mealdeal.utils.RequestType;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.observables.ConnectableObservable;

import static android.R.attr.x;
import static android.R.id.toggle;

/**
 * Created by Kresa on 2/21/17.
 */

public class ViewModelMain extends BaseViewModel {

    @Inject
    SharedPrefsAPI sharedPrefsAPI;

    @Inject
    RESTClientRetrofit2 restClient;

    public ViewModelMain(@Nullable State savedInstanceState, Activity activity) {
        super(savedInstanceState);
        ((AppMealDeal) activity.getApplication()).getComponent().inject(this);

    }

    public void onSearch(String query) {

    }

    public void toggleFav() {
        Log.d(Constants.TAG, "ViewModelMain.toggleFav()");
        sharedPrefsAPI.setIfMapView(!sharedPrefsAPI.isMapView());
    }
}