package service.internal.impl;

import avia.models.CityModel;
import avia.models.RecentFlightModel;
import avia.repositories.FlightRepository;
import avia.repositories.RecentFlightRepository;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.internal.CityService;
import service.internal.FlightService;
import service.mapper.CityMapper;
import service.mapper.FlightMapper;
import service.mapper.RecentFlightMapper;
import service.models.Flight;
import service.models.RecentFlight;

import java.io.IOException;
import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {

    private final RecentFlightMapper recentFlightMapper;
    private final RecentFlightRepository recentFlightRepository;
    private final FlightMapper flightMapper;
    private final FlightRepository flightRepository;
    private final CityService cityService;

    @Autowired
    public FlightServiceImpl(RecentFlightMapper recentFlightMapper,
                             RecentFlightRepository recentFlightRepository,
                             FlightMapper flightMapper, FlightRepository flightRepository, CityService cityService) {
        this.recentFlightMapper = recentFlightMapper;
        this.recentFlightRepository = recentFlightRepository;
        this.flightMapper = flightMapper;
        this.flightRepository = flightRepository;
        this.cityService = cityService;
    }

    @Override
    public List<RecentFlight> getRecentFlights(String userId) {
        List<RecentFlightModel> models = recentFlightRepository.findAllByUserId(userId);
        return recentFlightMapper.toListPurchase(models);
    }

    @Override
    public void addToRecent(RecentFlight recentFlight) {
        RecentFlightModel model = recentFlightMapper.toRecentFlightModel(recentFlight);
        recentFlightRepository.save(model);
    }

    @Override
    public List<Flight> searchFlight(RecentFlight recentFlight) throws IOException {
        //add to recent cities

        cityService.addRecentCity(recentFlight.getFlight().getDestinationPlace(), recentFlight.getUserId());

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/browsequotes/v1.0/ru/rub/ru/" + recentFlight.getFlight().getOriginPlace() + "/"
                        + recentFlight.getFlight().getDestinationPlace() + "/" + recentFlight.getFlight().getOutboundDate() + "?inboundpartialdate=%20")
                .get()
                .addHeader("x-rapidapi-key", "d8d5172365mshc2a2a837164b027p106993jsn2410bc2e15de")
                .addHeader("x-rapidapi-host", "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com")
                .build();

        Response response = client.newCall(request).execute();
        return null;
    }


}
