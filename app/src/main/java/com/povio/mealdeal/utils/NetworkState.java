package com.povio.mealdeal.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Kresa on 2/20/17.
 */

public class NetworkState {

    private NetworkState() {}


    public static boolean isOnline(Context context)
    {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected());
    }


    public static int getType(Context context)
    {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if(networkInfo != null)
        {
            // returns ConnectivityManager.TYPE_WIFI, ConnectivityManager.TYPE_MOBILE etc.
            return networkInfo.getType();
        }
        else
        {
            return -1;
        }
    }


    public static String getTypeName(Context context)
    {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if(networkInfo != null)
        {
            return networkInfo.getTypeName();
        }
        else
        {
            return null;
        }
    }
}
