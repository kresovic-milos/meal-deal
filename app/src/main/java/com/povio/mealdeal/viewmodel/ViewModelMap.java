package com.povio.mealdeal.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.databinding.ObservableArrayList;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.povio.mealdeal.AppMealDeal;
import com.povio.mealdeal.R;
import com.povio.mealdeal.entities.ContactInfo;
import com.povio.mealdeal.entities.Deal;
import com.povio.mealdeal.networking.retrofit.RESTClientRetrofit2;
import com.povio.mealdeal.utils.Constants;
import com.povio.mealdeal.utils.RequestType;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.observables.ConnectableObservable;

/**
 * Created by Kresa on 2/22/17.
 */

public class ViewModelMap extends ViewModelTab implements OnMapReadyCallback {

    private GoogleMap map;
    private Context context;

    @Inject
    RESTClientRetrofit2 restClient;

    public ObservableArrayList<Deal> deals;

    private ConnectableObservable observable;

    public ViewModelMap(@Nullable State savedInstanceState, Activity context) {
        super(savedInstanceState);
        this.context = context;
        ((AppMealDeal) context.getApplication()).getComponent().inject(this);
        deals = new ObservableArrayList<>();

        fetchDeals();
    }

    private void fetchDeals() {
        subscribeToDealsService();
        observable.connect();
    }

    private void subscribeToDealsService() {

        this.observable = restClient.fireRequest(RequestType.GET_ALL_DEALS, null);

        observable.subscribe(new Observer() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(Constants.TAG, "map onSubscribe() " + d);

            }

            @Override
            public void onNext(Object value) {
                Log.d(Constants.TAG, "map onNext() " + value);
                deals.addAll((List<Deal>) value);
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                Log.d(Constants.TAG, "map onError() ");
            }

            @Override
            public void onComplete() {
                Log.d(Constants.TAG, "map onComplete()");
                showDeals();
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;

        try {
            boolean success = map.setMapStyle(MapStyleOptions.loadRawResourceStyle(context, R.raw.map_style));
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
        }

        map.setMinZoomPreference(3.0f);
        map.setMaxZoomPreference(17.0f);

        showDeals();
    }

    private void showDeals() {
        if (map != null) {
            for (Deal deal : deals) {
                ContactInfo contactInfo = deal.getRestaurant().getContactInfo();
                LatLng latLngTest = new LatLng(contactInfo.getLat(), contactInfo.getLng()); //44.7866f, 20.4489);
                map.addMarker(new MarkerOptions().position(latLngTest).title(deal.getName()));
            }
            map.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(40.7128, -74.0059)));
        }
    }
}
