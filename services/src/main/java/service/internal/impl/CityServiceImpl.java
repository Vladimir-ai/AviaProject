package service.internal.impl;

import avia.models.RecentCityModel;
import avia.repositories.CityRepository;
import avia.repositories.RecentCityRepository;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.internal.CityService;
import service.mapper.CityMapper;
import service.models.RecentCity;
import service.models.city.City;
import service.models.city.AnswerModelCity;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;
    private final RecentCityRepository recentCityRepository;
    private final CityMapper cityMapper;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository, RecentCityRepository recentCityRepository, CityMapper cityMapper ) {
        this.cityRepository = cityRepository;
        this.recentCityRepository = recentCityRepository;
        this.cityMapper = cityMapper;
     }

    @Override
    public List<RecentCity> getRecentCities(String userId) {
        List<RecentCityModel> cityModels = recentCityRepository.findAllByUserId(userId);
        return cityMapper.toListRecentCity(cityModels);
    }


    @Override
    public List<City> searchPlaceByName(String name) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/autosuggest/v1.0/RU/RUB/ru/?query=" + name)
                .get()
                .addHeader("x-rapidapi-key", "d8d5172365mshc2a2a837164b027p106993jsn2410bc2e15de")
                .addHeader("x-rapidapi-host", "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com")
                .build();

        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            String body = Objects.requireNonNull(response.body()).string();
            AnswerModelCity list = new Gson().fromJson(body, AnswerModelCity.class);
            return list.getPlaces();
        }
        return null;
    }

    @Override
    public void addRecentCity(RecentCity recentCity)   {
        //get city
        RecentCityModel model = cityMapper.toRecentCityModel(recentCity);
        recentCityRepository.save(model);
    }

    @Override
    public void addRecentCity(City city, String userId) {
        //get city
        RecentCityModel model = cityMapper.toRecentCityModel(city, userId);
        recentCityRepository.save(model);
    }
}
