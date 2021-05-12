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
import com.example.aviaapplication.api.models.City;
import com.example.aviaapplication.api.models.Flight;
import com.example.aviaapplication.ui.flightInfo.FlightInfoFragment;
import com.example.aviaapplication.ui.foundFlights.FoundFlights;
import com.example.aviaapplication.utils.CommonUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FlightsRecycleViewAdapter extends RecyclerView.Adapter<FlightsRecycleViewAdapter.FlightsViewHolder> {


    public static class FlightsViewHolder extends RecyclerView.ViewHolder {
        private TextView titleTV, priceTV, depDateTV, fromTimeTV, toTimeTV, fromCodeTV, toCodeTV, durationTV;

        public FlightsViewHolder(View view) {
            super(view);
            titleTV = view.findViewById(R.id.from_to_title_tv);
            priceTV = view.findViewById(R.id.ticket_cost);
            depDateTV = view.findViewById(R.id.flight_info_departure_date_tv);
            fromTimeTV = view.findViewById(R.id.flight_info_departure_time_tv);
            toTimeTV = view.findViewById(R.id.flight_info_arrival_time_tv);
            fromCodeTV = view.findViewById(R.id.departure_code_tv);
            toCodeTV = view.findViewById(R.id.arrival_code_tv);
            durationTV = view.findViewById(R.id.flight_time_duration_tv);
        }
    }

    private Fragment fragment;

    public FlightsRecycleViewAdapter(Fragment fragment) {
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public FlightsRecycleViewAdapter.FlightsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.element_of_found_flights, parent, false);
        return new FlightsRecycleViewAdapter.FlightsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FlightsRecycleViewAdapter.FlightsViewHolder holder, int position) {
        Flight flight = differ.getCurrentList().get(position);


        flight.setArrivalCity(new City(5L, "Париж", "CDG"));
        flight.setDepCity(new City(1L, "Воронеж", "VOZ"));

        DateFormat dateFormat = new SimpleDateFormat("d MMM");
        DateFormat timeFormat = new SimpleDateFormat("H:mm");
        DateFormat diff = new SimpleDateFormat("H час");

        holder.titleTV.setText(flight.getDepCity().getCityName() + " - " + flight.getArrivalCity().getCityName());
        holder.priceTV.setText(flight.getEconomyPrice().toString() + "₽");
        holder.depDateTV.setText(dateFormat.format(flight.getDepartureDate()));
        holder.fromTimeTV.setText(timeFormat.format(flight.getDepartureDate()));
        holder.toTimeTV.setText(timeFormat.format(flight.getArrivalDate()));
        holder.fromCodeTV.setText(flight.getDepCity().getCityCode());
        holder.toCodeTV.setText(flight.getArrivalCity().getCityCode());

        holder.durationTV.setText(diff.format(new Date(flight.getDepartureDate().getTime() - flight.getArrivalDate().getTime())));

        Fragment target = FlightInfoFragment.getInstance(flight.getFlightId());
        holder.itemView.setOnClickListener(v -> CommonUtils.goToFragment(fragment.getParentFragmentManager(),
                R.id.nav_host_fragment, target));


    }

    private AsyncListDiffer<Flight> differ = new AsyncListDiffer<>(this, DIFF_CALLBACK);

    private static final DiffUtil.ItemCallback<Flight> DIFF_CALLBACK = new DiffUtil.ItemCallback<Flight>() {
        @Override
        public boolean areItemsTheSame(@NonNull Flight oldProduct, @NonNull Flight newProduct) {
            return oldProduct.getFlightId().equals(newProduct.getFlightId());
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
