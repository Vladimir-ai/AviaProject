package com.example.aviaApplication.additions.recyclerView;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aviaApplication.R;
import com.example.aviaApplication.api.models.Flight;

import java.util.List;

public class RecentFlightsViewAdapter extends RecyclerView.Adapter<FavoriteFlightsRecyclerViewAdapter.FavoriteFlightsViewHolder> {
    public static class FlightsViewHolder extends RecyclerView.ViewHolder {

        public FlightsViewHolder(View view) {
            super(view);
        }
    }

    @NonNull
    @Override
    public FavoriteFlightsRecyclerViewAdapter.FavoriteFlightsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.element_recent_flights, parent, false);
        return new FavoriteFlightsRecyclerViewAdapter.FavoriteFlightsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteFlightsRecyclerViewAdapter.FavoriteFlightsViewHolder holder, int position) {

    }

    private AsyncListDiffer<Flight> differ = new AsyncListDiffer<>(this, DIFF_CALLBACK);

    private static final DiffUtil.ItemCallback<Flight> DIFF_CALLBACK = new DiffUtil.ItemCallback<Flight>() {
        @Override
        public boolean areItemsTheSame(@NonNull Flight oldProduct, @NonNull Flight newProduct) {
            return oldProduct.getId().equals(newProduct.getId());
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull Flight oldProduct, @NonNull Flight newProduct) {
            return oldProduct.equals(newProduct);
        }
    };

    public void submitList(List<Flight> products) {
        differ.submitList(products);
    }

    @Override
    public int getItemCount() {
        return differ.getCurrentList().size();
    }
}
