package com.povio.mealdeal.ui.adapters;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.databinding.ViewDataBinding;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.povio.mealdeal.BR;
import com.povio.mealdeal.R;
import com.povio.mealdeal.entities.Deal;
import com.povio.mealdeal.viewmodel.ViewModelFeedItem;

/**
 * Created by Kresa on 2/16/17.
 */

public class AdapterDealsFeed extends RecyclerView.Adapter<AdapterDealsFeed.FeedItemHolder> {

    private ObservableArrayList<Deal> deals = new ObservableArrayList<>();

    public AdapterDealsFeed(ObservableArrayList<Deal> deals, Fragment context) {
        this.deals = deals;
    }

    class FeedItemHolder extends RecyclerView.ViewHolder {

        private final ViewDataBinding binding;

        FeedItemHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(Object obj) {
            binding.setVariable(BR.viewModel, obj);
            binding.executePendingBindings();
        }
    }

    @Override
    public FeedItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item_feed, parent, false);
        return new FeedItemHolder(binding);
    }

    @Override
    public void onBindViewHolder(FeedItemHolder holder, int position) {
        Object obj = new ViewModelFeedItem(deals.get(position));
        holder.bind(obj);
    }

    @Override
    public int getItemCount() {
        return deals.size();
    }
}
