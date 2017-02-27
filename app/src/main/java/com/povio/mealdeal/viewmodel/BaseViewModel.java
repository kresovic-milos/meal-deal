package com.povio.mealdeal.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;

import com.povio.mealdeal.BR;
import com.povio.mealdeal.utils.Constants;

/**
 * Created by Kresa on 2/22/17.
 */

public abstract class BaseViewModel extends BaseObservable {

    protected BaseViewModel(@Nullable State savedInstanceState) {}

    @CallSuper
    public void onStart() {

    }

    public State getInstanceState() {
        return new State(this);
    }

    @CallSuper
    public void onStop() {

    }

    public static class State implements Parcelable {

        protected State(BaseViewModel viewModel) {

        }

        public State(Parcel in) {

        }

        @Override
        public int describeContents() {
            return 0;
        }

        @CallSuper
        @Override
        public void writeToParcel(Parcel dest, int flags) {

        }

        public static Creator<State> CREATOR = new Creator<State>() {
            @Override
            public State createFromParcel(Parcel source) {
                return new State(source);
            }

            @Override
            public State[] newArray(int size) {
                return new State[size];
            }
        };
    }

}
