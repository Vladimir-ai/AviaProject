package com.example.aviaapplication.ui.flightHistory;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.aviaapplication.api.models.Flight;
import com.example.aviaapplication.ui.home.UserRepository;

import java.util.List;

public class FlightHistoryViewModel extends AndroidViewModel {

    private FlightHistoryRepository flightHistoryRepository;
    private UserRepository userRepository;
    private MutableLiveData<List<Flight>> flightList;

    public FlightHistoryViewModel(@NonNull Application application) {
        super(application);
        userRepository = UserRepository.getInstance();
        flightHistoryRepository = FlightHistoryRepository.getInstance();
        flightList = new MutableLiveData<>(flightHistoryRepository.getFlights());
    }

    public MutableLiveData<List<Flight>> getFlights(){
        return flightList;
    }
}
