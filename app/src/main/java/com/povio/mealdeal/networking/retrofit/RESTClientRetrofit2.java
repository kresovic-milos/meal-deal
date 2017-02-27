package com.povio.mealdeal.networking.retrofit;

import com.povio.mealdeal.entities.Deal;
import com.povio.mealdeal.networking.RESTClient;
import com.povio.mealdeal.utils.RequestType;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

/**
 * Created by Kresa on 2/20/17.
 */

public class RESTClientRetrofit2 implements RESTClient {

    private DealsRetrofitService dealsRetrofitService;

    Map<RequestType, Observable> observables;

    @Inject
    public RESTClientRetrofit2(DealsRetrofitService dealsRetrofitService) {
        this.dealsRetrofitService = dealsRetrofitService;
    }

    @Override
    public ConnectableObservable fireRequest(RequestType requestType, Map<String, String> params) {

        Observable observable = null;

        switch (requestType) {
            case GET_ALL_DEALS:
                observable = dealsRetrofitService.getDeals();
                break;
            case TOGGLE_FAV_DEAL:
                observable = dealsRetrofitService.toggleFav(new Deal());
                break;
            default:
                //
        }

        return observable.share().replay();
    }
}
