package com.example.aviaapplication.ui.cities;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.aviaapplication.api.Api;
import com.example.aviaapplication.api.models.City;
import com.example.aviaapplication.api.services.RetrofitConnection;
import com.example.aviaapplication.api.services.cities.CitiesApi;
import com.example.aviaapplication.utils.CommonUtils;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CitiesRepository {

    private static CitiesRepository citiesRepository;
    private MutableLiveData<List<City>> listCity;
    private CitiesApi citiesApi;


    public static CitiesRepository getInstance(){
        if (citiesRepository == null)
            citiesRepository = new CitiesRepository();

        return citiesRepository;
    }

    private CitiesRepository(){
        citiesApi = RetrofitConnection.createRetrofitConnection(CitiesApi.class);
        listCity = new MutableLiveData<>(new ArrayList<>());
    }

    public void findByString(String query){
        citiesApi.findCity(query).enqueue(new Callback<List<City>>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<List<City>> call, Response<List<City>> response) {
                if(response.body() != null)
                    listCity.postValue(response.body().stream().filter(CommonUtils.distinctByKey(City::getCityId)).collect(Collectors.toList()));
            }

            @Override
            public void onFailure(Call<List<City>> call, Throwable t) {
                //TO-DO
            }
        });
    }

    public LiveData<List<City>> getCityListLiveData(){
        return listCity;
    }

    public List<City> getAllCities(){
        return new ArrayList<>();
    }

    public void addCityToRecent(Long userId, City city){
        //TO-DO
    }

    public List<City> getRecentCities(Long userId){
        return new ArrayList<>();
    }

}
