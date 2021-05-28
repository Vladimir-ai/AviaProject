package com.example.aviaapplication.api.services.favoriteFlights;

import com.example.aviaapplication.api.models.Flight;

import java.util.List;

import retrofit2.Call;

public interface FavoriteFlightsApi {

    Call<List<Flight>> getFavoriteList();

    Call<Flight> addToFavorite();

    Call<Boolean> deleteFromFavorite();
}
