package com.example.aviaapplication.ui.foundFlights;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aviaapplication.R;
import com.example.aviaapplication.additions.recyclerView.FlightsRecycleViewAdapter;
import com.example.aviaapplication.api.models.Flight;
import com.example.aviaapplication.ui.flightInfo.FlightInfoFragment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class FoundFlights extends Fragment {


    private static String KEY_TO_DATE = "to_date";

    private FlightsRecycleViewAdapter flightsRecycleViewAdapter;
    private TextView emptyList;
    private RecyclerView recyclerView;
    private FoundFlightViewModel foundFlightViewModel;
    List<Flight> flightFound ;

    public static FoundFlights getInstance( List<Flight> flights){
        final FoundFlights frag = new FoundFlights();
        final Bundle args = new Bundle();
        args.putSerializable(KEY_TO_DATE, (Serializable) flights);
//        args.putLong(KEY_FROM_DATE, from.getTime());
//        args.putLong(KEY_TO_DATE, to.getTime());
//        args.putLong(KEY_FROM_CITY, cityFrom);
//        args.putLong(KEY_TO_CITY, cityTo);

        frag.setArguments(args);
        return frag;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Bundle args = getArguments();

//        fromTime = args.getLong(KEY_FROM_DATE);
//        toTime = args.getLong(KEY_TO_DATE);
//        fromCity = args.getLong(KEY_FROM_CITY);
//        toCity = args.getLong(KEY_TO_CITY);
        flightFound =( List<Flight> )args.getSerializable(KEY_TO_DATE);
        foundFlightViewModel = new ViewModelProvider(this).get(FoundFlightViewModel.class);
        View view = inflater.inflate(R.layout.fragment_found_flights, container, false);
        initViews(view);
        return view;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void initViews(View view) {
        recyclerView = view.findViewById(R.id.found_flights_rv);
        emptyList = view.findViewById(R.id.found_flights_tv);
        flightsRecycleViewAdapter = new FlightsRecycleViewAdapter(this);
        recyclerView.setAdapter(flightsRecycleViewAdapter);
        updateList(flightFound);
    }

    public void updateList(List<Flight> list) {
        if (list.isEmpty()) {
            emptyList.setVisibility(View.VISIBLE);
        } else {
            emptyList.setVisibility(View.GONE);
            flightsRecycleViewAdapter.submitList(list);
        }
    }
}
