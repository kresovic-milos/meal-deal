package com.povio.mealdeal.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayList;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.povio.mealdeal.AppMealDeal;
import com.povio.mealdeal.entities.Deal;
import com.povio.mealdeal.networking.RequestCompleteListener;
import com.povio.mealdeal.networking.retrofit.RESTClientRetrofit2;
import com.povio.mealdeal.persistance.SharedPrefsAPI;
import com.povio.mealdeal.ui.adapters.AdapterDealsFeed;
import com.povio.mealdeal.utils.Constants;
import com.povio.mealdeal.utils.RequestType;
import com.povio.mealdeal.utils.ToggleFavListener;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Kresa on 2/21/17.
 */

public class ViewModelDealsFeed extends ViewModelTab {

    @Inject
    SharedPrefsAPI sharedPrefsAPI;

    @Inject
    RESTClientRetrofit2 restClient;

    public ObservableArrayList<Deal> deals;

    public ViewModelDealsFeed(@Nullable State savedInstanceState, ToggleFavListener toggleFavListener, Activity activity) {
        super(savedInstanceState);
        this.toggleFavListener = toggleFavListener;
        ((AppMealDeal) activity.getApplication()).getComponent().inject(this);
        deals = new ObservableArrayList<>();
    }

    @Override
    public void onStart() {
        super.onStart();
        sharedPrefsAPI.registerOnChangeListener(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        sharedPrefsAPI.unregisterOnChangeListener(this);
    }

    @BindingAdapter({"items", "ctx"})
    public static void loadItems(final RecyclerView recyclerView, final List<Deal> deals, Fragment ctx) {
        if (recyclerView.getAdapter() == null) {
            recyclerView.setAdapter(new AdapterDealsFeed((ObservableArrayList<Deal>) deals, ctx));
        } else {
            recyclerView.getAdapter().notifyDataSetChanged();
        }
    }

    public void onRefresh() {

        restClient.fireRequest(RequestType.GET_ALL_DEALS, null, new RequestCompleteListener() {


            @Override
            public void onSuccess(Object response) {
                Log.d(Constants.TAG, "onSuccess " + ((List) response).size());

                deals.addAll((List<Deal>) response);
            }

            @Override
            public void onFailure(String message) {
                Log.d(Constants.TAG, "onFailure " + message);
            }

            @Override
            public void onError(String message) {
                Log.d(Constants.TAG, "onError " + message);
            }
        });
    }
}
