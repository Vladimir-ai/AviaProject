package com.example.aviaapplication.ui.searchFlights;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.aviaapplication.api.models.Flight;

import java.util.List;

public class SearchFlightViewModel extends ViewModel {

    private SearchFlightsRepository repository = SearchFlightsRepository.getInstance();
    private MutableLiveData<Boolean> isLoading = new MutableLiveData<>();

    public MutableLiveData<Boolean> getIsLoading() {
        return isLoading;
    }

    public LiveData<List<Flight>> findFlights( ) {
        isLoading.setValue(true);
        return repository.findFlight();
    }

    public LiveData<List<Flight>>  getRecentFlights( ) {

        return repository.getRecentFlights();
    }
}
