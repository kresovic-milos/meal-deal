package com.povio.mealdeal.viewmodel;

import android.app.Activity;
import android.content.Intent;
import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.povio.mealdeal.AppMealDeal;
import com.povio.mealdeal.R;
import com.povio.mealdeal.entities.Deal;
import com.povio.mealdeal.networking.retrofit.RESTClientRetrofit2;
import com.povio.mealdeal.persistance.SharedPrefsAPI;
import com.povio.mealdeal.ui.activities.ActivityDealDetails;
import com.povio.mealdeal.ui.activities.BaseActivity;
import com.povio.mealdeal.ui.adapters.AdapterDealsFeed;
import com.povio.mealdeal.utils.Constants;
import com.povio.mealdeal.utils.RecyclerItemClickListener;
import com.povio.mealdeal.utils.RequestType;
import com.povio.mealdeal.utils.ToggleFavListener;

import org.parceler.Parcels;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.observables.ConnectableObservable;

/**
 * Created by Kresa on 2/21/17.
 */

public class ViewModelDealsFeed extends ViewModelTab implements RecyclerItemClickListener {

    private BaseActivity context;

    @Inject
    SharedPrefsAPI sharedPrefsAPI;

    @Inject
    RESTClientRetrofit2 restClient;

    public ObservableBoolean isRefreshing;

    public ObservableArrayList<Deal> deals;

    private ConnectableObservable observable;

    public ViewModelDealsFeed(@Nullable State savedInstanceState, ToggleFavListener toggleFavListener, Activity activity) {
        super(savedInstanceState);
        this.toggleFavListener = toggleFavListener;
        ((AppMealDeal) activity.getApplication()).getComponent().inject(this);
        isRefreshing = new ObservableBoolean(false);
        deals = new ObservableArrayList<>();

        context = (BaseActivity) activity;

        refresh();
    }

    private void setRefreshing(boolean refreshing) {
        this.isRefreshing.set(refreshing);
    }

    public void refresh() {
        Log.d(Constants.TAG, "refresh");
        setRefreshing(true);
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
                Log.d(Constants.TAG, "Feed onSubscribe() " + d);
            }

            @Override
            public void onNext(Object value) {
                Log.d(Constants.TAG, "Feed onNext() " + value);
                deals.clear();
                deals.addAll((List<Deal>) value);
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                Log.d(Constants.TAG, "Feed onError() ");
                setRefreshing(false);
            }

            @Override
            public void onComplete() {
                Log.d(Constants.TAG, "Feed onComplete()");
                setRefreshing(false);
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        sharedPrefsAPI.registerOnChangeListener(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        sharedPrefsAPI.unregisterOnChangeListener(this);
    }


    @BindingAdapter({"items", "ctx", "itemClickListener"})
    public static void loadItems(final RecyclerView recyclerView, final List<Deal> deals, Fragment ctx, RecyclerItemClickListener itemClickListener) {
        if (recyclerView.getAdapter() == null) {
            recyclerView.setAdapter(new AdapterDealsFeed((ObservableArrayList<Deal>) deals, ctx, itemClickListener));
        } else {
            recyclerView.getAdapter().notifyDataSetChanged();
        }
    }

    @BindingAdapter("refreshing")
    public static void onRefresh(final SwipeRefreshLayout swipeRefreshLayout, boolean refreshing) {
        Log.d(Constants.TAG, "onRefresh " + refreshing);
        swipeRefreshLayout.setRefreshing(refreshing);
    }

    @Override
    public void onItemClick(View view, int position) {
        Log.d(Constants.TAG, "Recycler Item onItemClick()");

        Intent intent = new Intent(context, ActivityDealDetails.class);

        Deal deal = deals.get(position);
        intent.putExtra("deal", Parcels.wrap(deal));
        intent.putExtra("position", position);

        ImageView imageView = (ImageView) view.findViewById(R.id.imageview_blackboard);
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(context, imageView, "deal");

        context.startActivity(intent, options.toBundle());
    }
}