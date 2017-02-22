package com.povio.mealdeal.networking.retrofit;

import com.povio.mealdeal.entities.Deal;
import com.povio.mealdeal.networking.RESTClient;
import com.povio.mealdeal.networking.RequestCompleteListener;
import com.povio.mealdeal.utils.RequestType;

import java.util.Map;

import javax.inject.Inject;

import retrofit2.Call;

/**
 * Created by Kresa on 2/20/17.
 */

public class RESTClientRetrofit2 implements RESTClient {

    private DealsRetrofitService dealsRetrofitService;

    @Inject
    public RESTClientRetrofit2(DealsRetrofitService dealsRetrofitService) {
        this.dealsRetrofitService = dealsRetrofitService;
    }

    @Override
    public void fireRequest(RequestType requestType, Map<String, String> params, final RequestCompleteListener completeListener) {

        Call call = null;

        switch (requestType) {
            case GET_ALL_DEALS:
                call = dealsRetrofitService.getDeals();
                break;
            case TOGGLE_FAV_DEAL:
                call = dealsRetrofitService.toggleFav(new Deal());
                break;
            default:
                //
        }

        call.enqueue(new CallbackWrapper(completeListener));
    }
}
