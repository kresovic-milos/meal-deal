package com.povio.mealdeal.networking;

import com.povio.mealdeal.utils.RequestType;

import java.util.Map;
import java.util.Objects;

import retrofit2.Call;

/**
 * Created by Kresa on 2/16/17.
 */

public interface RESTClient {

    void fireRequest(RequestType requestType, Map<String, String> params, RequestCompleteListener completeListener);
}
