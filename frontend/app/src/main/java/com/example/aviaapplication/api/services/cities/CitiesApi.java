package com.example.aviaapplication.api.services.cities;

import com.example.aviaapplication.api.models.City;

import java.util.List;

import retrofit2.Call;

public interface CitiesApi {

    Call<List<City>> findCity();
}
