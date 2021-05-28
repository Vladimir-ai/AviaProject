package com.example.aviaapplication.ui.searchFlights;

import androidx.lifecycle.MutableLiveData;

import com.example.aviaapplication.api.models.Flight;
import com.example.aviaapplication.api.services.RetrofitConnection;
import com.example.aviaapplication.api.services.flights.FlightApi;
import com.example.aviaapplication.api.services.recentFlights.RecentFlightsApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchFlightsRepository {

    private static SearchFlightsRepository searchFlightsRepository;
    private FlightApi flightApi;
    private RecentFlightsApi recentFlightsApi;

    public static SearchFlightsRepository getInstance() {
        if (searchFlightsRepository == null) {
            searchFlightsRepository = new SearchFlightsRepository();

        }
        return searchFlightsRepository;
    }

    private SearchFlightsRepository() {
        flightApi = RetrofitConnection.createRetrofitConnection(FlightApi.class);
        recentFlightsApi = RetrofitConnection.createRetrofitConnection(RecentFlightsApi.class);

    }

    public MutableLiveData<List<Flight>> getRecentFlights() {
        MutableLiveData<List<Flight>> newsData = new MutableLiveData<>();
        recentFlightsApi.getRecentFlights()
                .enqueue(new Callback<List<Flight>>() {
                    @Override
                    public void onResponse(Call<List<Flight>> call,
                                           Response<List<Flight>> response) {
                        if (response.isSuccessful()) {
                            newsData.setValue(response.body());
                        } else {
                            newsData.setValue(null);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Flight>> call, Throwable t) {
                        newsData.setValue(null);
                    }
                });
        return newsData;
    }

    public MutableLiveData<List<Flight>> findFlight() {
        MutableLiveData<List<Flight>> newsData = new MutableLiveData<>();
        flightApi.searchFlights()
                .enqueue(new Callback<List<Flight>>() {
                    @Override
                    public void onResponse(Call<List<Flight>> call,
                                           Response<List<Flight>> response) {
                        if (response.isSuccessful()) {
                            newsData.setValue(response.body());
                        } else {
                            newsData.setValue(null);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Flight>> call, Throwable t) {
                        newsData.setValue(null);
                    }
                });
        return newsData;
    }
}
