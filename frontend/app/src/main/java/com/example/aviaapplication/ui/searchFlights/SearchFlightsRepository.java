package com.example.aviaapplication.ui.searchFlights;

import androidx.lifecycle.MutableLiveData;

import com.example.aviaapplication.api.models.Flight;
import com.example.aviaapplication.api.models.RecentFlight;
import com.example.aviaapplication.api.services.RetrofitConnection;
import com.example.aviaapplication.api.services.flights.FlightApi;
import com.example.aviaapplication.utils.CommonUtils;
import com.example.aviaapplication.utils.Resource;
import com.yandex.metrica.impl.ob.Re;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import kotlin.jvm.functions.FunctionN;
import lombok.val;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchFlightsRepository {

    private static SearchFlightsRepository searchFlightsRepository;
    private final FlightApi flightApi;

    public static SearchFlightsRepository getInstance() {
        if (searchFlightsRepository == null) {
            searchFlightsRepository = new SearchFlightsRepository();
        }

        return searchFlightsRepository;
    }

    private SearchFlightsRepository() {
        flightApi = RetrofitConnection.createRetrofitConnection(FlightApi.class);
    }

    public void getRecentFlights(String userId, MutableLiveData<Resource<List<RecentFlight>>> liveData) {
        val user = CommonUtils.cipherEmail(userId);

        flightApi.getRecentFlights(user).enqueue(new Callback<List<RecentFlight>>() {
            @Override
            public void onResponse(Call<List<RecentFlight>> call, Response<List<RecentFlight>> response) {
                if (response.isSuccessful()) {
                    liveData.postValue(Resource.success(response.body()));
                } else {
                    liveData.postValue(Resource.error(response.message(), null));
                }
            }

            @Override
            public void onFailure(Call<List<RecentFlight>> call, Throwable t) {
                liveData.postValue(Resource.error(t.getMessage(), null));
            }
        });
    }

    public Observable<List<Flight>> findFlight(Flight flight) {

        Calendar dateFrom = Calendar.getInstance();
        dateFrom.setTime(flight.getOutboundDate());

        Calendar dateTo = Calendar.getInstance();
        dateTo.setTime(flight.getInboundDate());
        dateTo.add(Calendar.DATE, 1);

        List<Flight> query = new ArrayList<>();

        for (; dateFrom.before(dateTo); dateFrom.add(Calendar.DATE, 1)) {
            query.add(Flight.builder().originPlace(flight.getOriginPlace())
                    .destinationPlace(flight.getDestinationPlace())
                    .outboundDate(dateFrom.getTime()).build());
        }

        return Observable.fromIterable(query).flatMap(flightApi::searchFlights);
    }

    public void addToRecent(String userId, Flight flight) {
        String email = CommonUtils.cipherEmail(userId);
        flightApi.addToRecent(new RecentFlight(email, flight)).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
            }
        });
    }

}
