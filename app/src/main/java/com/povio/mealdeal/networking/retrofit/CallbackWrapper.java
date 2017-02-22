package com.povio.mealdeal.networking.retrofit;

import com.povio.mealdeal.networking.RequestCompleteListener;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Kresa on 2/20/17.
 */

public class CallbackWrapper<T> implements Callback<T> {

    private RequestCompleteListener completeListener;

    CallbackWrapper(RequestCompleteListener completeListener) {
        this.completeListener = completeListener;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {

        if (response.isSuccessful()) {
            completeListener.onSuccess(response.body());
        } else {
            try {
                completeListener.onError(response.errorBody().string());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        completeListener.onFailure(t.getMessage());
    }
}
