package com.example.aviaapplication.api.services.cities;

import com.example.aviaapplication.api.models.City;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface CitiesApi {

    @GET("city/{name}")
    Call<List<City>> findCity(@Path("name") String cityName);
}
