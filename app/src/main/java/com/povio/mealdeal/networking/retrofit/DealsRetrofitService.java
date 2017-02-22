package com.povio.mealdeal.networking.retrofit;

import com.povio.mealdeal.entities.Deal;
import com.povio.mealdeal.utils.Constants;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Kresa on 2/20/17.
 */

public interface DealsRetrofitService {

    @GET(Constants.ApiUrls.DEALS)
    Call<List<Deal>> getDeals();

    @POST(Constants.ApiUrls.TOGGLE_FAV)
    Call<Boolean> toggleFav(@Body Deal deal);
}
