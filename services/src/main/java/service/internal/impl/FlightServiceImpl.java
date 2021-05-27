package service.internal.impl;

import avia.models.CityModel;
import avia.models.RecentFlightModel;
import avia.repositories.FlightRepository;
import avia.repositories.RecentFlightRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import service.internal.CityService;
import service.internal.FlightService;
import service.mapper.CityMapper;
import service.mapper.FlightMapper;
import service.mapper.RecentFlightMapper;
import service.models.Flight;
import service.models.RecentFlight;
import service.models.city.AnswerModelCity;
import service.models.flight.AnswerModelFlight;
import service.utils.DateDeserializer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

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
//        SimpleDateFormat dt = new SimpleDateFormat("yyyyy-mm-dd");
//        String newstring = datetime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/browsequotes/v1.0/ru/rub/ru/" + recentFlight.getFlight().getOriginPlace().getPlaceId() + "/"
                        + recentFlight.getFlight().getDestinationPlace().getPlaceId() + "/" + recentFlight.getFlight().getOutboundDate()  + "?inboundpartialdate=%20")
                .get()
                .addHeader("x-rapidapi-key", "d8d5172365mshc2a2a837164b027p106993jsn2410bc2e15de")
                .addHeader("x-rapidapi-host", "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com")
                .build();

        Response response = client.newCall(request).execute();

        if (response.isSuccessful()) {
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(Date.class, new DateDeserializer())
                    .create();
            String body = Objects.requireNonNull(response.body()).string();
            AnswerModelFlight list = gson.fromJson(body, AnswerModelFlight.class );
            list.toString();
            for (int i = 0; i <list.getQuotes().size() ; i++) {
                for (int j = 0; j < list.getPlaces().size(); j++) {
                    if(list.getQuotes().get(i).getOutboundLeg().getDestinationId().equals(list.getPlaces().get(j).getPlaceId())){
                        list.getQuotes().get(i).getOutboundLeg().setDestinationPlace(list.getPlaces().get(j));
                    }
                    if(list.getQuotes().get(i).getOutboundLeg().getOriginId().equals(list.getPlaces().get(j).getPlaceId())){
                        list.getQuotes().get(i).getOutboundLeg().setOriginPlace(list.getPlaces().get(j));
                    }
                }
            }
         //   List<Flight> flights = flightMapper.
        }
        return null;
    }


}
