package com.example.aviaapplication.api.services.recentCities;

import com.example.aviaapplication.api.models.City;

import java.util.List;

import retrofit2.Call;

public interface RecentCityApi {

    Call< List<City>> getRecentCities();

    Call<City> addToRecent(City city);
}
