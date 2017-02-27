package com.povio.mealdeal.networking;

import com.povio.mealdeal.utils.RequestType;

import java.util.Map;

import io.reactivex.observables.ConnectableObservable;

/**
 * Created by Kresa on 2/16/17.
 */

public interface RESTClient {

    ConnectableObservable fireRequest(RequestType requestType, Map<String, String> params);
}
