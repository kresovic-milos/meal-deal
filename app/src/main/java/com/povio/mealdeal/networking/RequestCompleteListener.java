package com.povio.mealdeal.networking;

/**
 * Created by Kresa on 2/20/17.
 */

public interface RequestCompleteListener<T extends Object> {

    void onSuccess(T response);
    void onFailure(String message);
    void onError(String message);
}
