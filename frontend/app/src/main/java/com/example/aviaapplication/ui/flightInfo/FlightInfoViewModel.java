package com.example.aviaapplication.ui.flightInfo;

import android.app.Application;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.aviaapplication.api.models.Flight;

public class FlightInfoViewModel extends AndroidViewModel {

    //private UserRepository userRepository;
    private FlightInfoRepository flightInfoRepository;
    private MutableLiveData<Flight> flight;

    @RequiresApi(api = Build.VERSION_CODES.N)
    public FlightInfoViewModel(@NonNull Application application, Long flightId) {
        super(application);
        //userRepository = UserRepository.getInstance();
        flightInfoRepository = FlightInfoRepository.getInstance();
        flight = new MutableLiveData<>(flightInfoRepository.getFlightByid(flightId));
    }

    public MutableLiveData<Flight> getFlight(){
        return flight;
    }

    public boolean isLoggedIn(){
        return true;
    //return userRepository.isLoggedIn();
    }

    public void makeFavorite(){
        flightInfoRepository.makeFavorite(1L, flight.getValue());
    }

    public void unfavorite(){
        flightInfoRepository.removeFavorite(1L, flight.getValue());
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public boolean isFavorite(){
        return false;
        //return flightInfoRepository.isFavorite(1L, flight.getValue().getFlightId());
    }

    public void addToRecentViewed(){
//        if (userRepository.isLoggedIn())
//            flightInfoRepository.addToViewed(1L, flight.getValue());
    }

}
