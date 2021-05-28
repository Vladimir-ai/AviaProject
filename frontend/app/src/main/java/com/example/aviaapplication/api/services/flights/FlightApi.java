package com.example.aviaapplication.api.services.flights;

import com.example.aviaapplication.api.models.Flight;

import java.util.List;

import retrofit2.Call;

public interface FlightApi {

    Call<List<Flight>> searchFlights();

    Call<Flight> getFlightInfo(Integer id);
}
