package com.example.aviaapplication.additions.recyclerView;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aviaapplication.R;
import com.example.aviaapplication.api.models.Flight;
import com.example.aviaapplication.api.models.RecentFlight;
import com.example.aviaapplication.ui.flightInfo.FlightInfoFragment;
import com.example.aviaapplication.ui.searchFlights.SearchFlightsFragment;
import com.example.aviaapplication.utils.CommonUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class RecentFlightsViewAdapter extends RecyclerView.Adapter<RecentFlightsViewAdapter.FlightsViewHolder> {
    public static class FlightsViewHolder extends RecyclerView.ViewHolder {
        public FlightsViewHolder(View view) {
            super(view);
        }
    }
    private SearchFlightsFragment fragment;

    public RecentFlightsViewAdapter(SearchFlightsFragment fragment) {
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public RecentFlightsViewAdapter.FlightsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.element_recent_flights, parent, false);
        return new RecentFlightsViewAdapter.FlightsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecentFlightsViewAdapter.FlightsViewHolder holder, int position) {
        RecentFlight flight = differ.getCurrentList().get(position);
        //Fragment frag = FlightInfoFragment.getInstance(flight.getFlight());

        TextView dateTV = holder.itemView.findViewById(R.id.date_tv);
        TextView destTV = holder.itemView.findViewById(R.id.destinations_tv);

        destTV.setText(flight.getFlight().getOriginPlace().getPlaceName() + " - " + flight.getFlight().getDestinationPlace().getPlaceName());
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.YYYY");
        dateTV.setText(dateFormat.format(flight.getFlight().getOutboundDate()));

//        holder.itemView.setOnClickListener(v -> CommonUtils.goToFragment(fragment.getParentFragmentManager(),
//                R.id.nav_host_fragment, frag));
    }

    private AsyncListDiffer<RecentFlight> differ = new AsyncListDiffer<>(this, DIFF_CALLBACK);

    private static final DiffUtil.ItemCallback<RecentFlight> DIFF_CALLBACK = new DiffUtil.ItemCallback<RecentFlight>() {
        @Override
        public boolean areItemsTheSame(@NonNull RecentFlight oldProduct, @NonNull RecentFlight newProduct) {
            return true;// oldProduct.getFlightId().equals(newProduct.getFlightId());
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull RecentFlight oldProduct, @NonNull RecentFlight newProduct) {
            return oldProduct.equals(newProduct);
        }
    };

    public void submitList(List<RecentFlight> products) {
        differ.submitList(products);
    }

    @Override
    public int getItemCount() {
        return differ.getCurrentList().size();
    }
}
