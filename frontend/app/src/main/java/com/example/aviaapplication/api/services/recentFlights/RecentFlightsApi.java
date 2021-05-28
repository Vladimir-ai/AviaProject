package com.example.aviaapplication.api.services.recentFlights;

import com.example.aviaapplication.api.models.Flight;

import java.util.List;

import retrofit2.Call;

public interface RecentFlightsApi {

    Call<List<Flight>> getRecentFlights();

    Call<Flight> addToRecent();
}
