package com.povio.mealdeal.ui.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.databinding.ViewDataBinding;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.povio.mealdeal.BR;
import com.povio.mealdeal.R;
import com.povio.mealdeal.entities.Deal;
import com.povio.mealdeal.utils.Constants;
import com.povio.mealdeal.utils.FontCache;
import com.povio.mealdeal.utils.RecyclerItemClickListener;
import com.povio.mealdeal.viewmodel.ViewModelFeedItem;

/**
 * Created by Kresa on 2/16/17.
 */

public class AdapterDealsFeed extends RecyclerView.Adapter<AdapterDealsFeed.FeedItemHolder> {

    private ObservableArrayList<Deal> deals = new ObservableArrayList<>();
    private RecyclerItemClickListener itemClickListener;
    private Fragment context;

    public AdapterDealsFeed(ObservableArrayList<Deal> deals, Fragment context, RecyclerItemClickListener itemClickListener) {
        this.deals = deals;
        this.itemClickListener = itemClickListener;
        this.context = context;
    }

    class FeedItemHolder extends RecyclerView.ViewHolder {

        private final ViewDataBinding binding;

        FeedItemHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(Object obj, final int position) {
            binding.setVariable(BR.viewModel, obj);
            binding.executePendingBindings();
            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemClickListener.onItemClick(view, position);
                }
            });

            setFont(position);
        }

        private void setFont(int position) {
            TextView textViewTitle = ((TextView) binding.getRoot().findViewById(R.id.textview_deal_title));
            FontCache.setTypeface(textViewTitle, position, true);

            TextView textViewShortDescription = ((TextView) binding.getRoot().findViewById(R.id.textview_short_description));
            FontCache.setTypeface(textViewShortDescription, position, false);
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
        holder.bind(obj, position);
    }

    @Override
    public int getItemCount() {
        return deals.size();
    }

}
