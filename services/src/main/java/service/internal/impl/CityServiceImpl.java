package service.internal.impl;

import avia.models.RecentCityModel;
import avia.repositories.RecentCityRepository;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
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

    @Value("${x-rapidapi-key}")
    private String rapid;
    @Value("${x-rapidapi-host}")
    private String host;

    private final RecentCityRepository recentCityRepository;
    private final CityMapper cityMapper;
    private OkHttpClient client = new OkHttpClient();

    @Autowired
    public CityServiceImpl(RecentCityRepository recentCityRepository, CityMapper cityMapper) {
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
        Request request = new Request.Builder()
                .url("https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/autosuggest/v1.0/RU/RUB/ru/?query=" + name)
                .get()
                .addHeader("x-rapidapi-key", rapid)
                .addHeader("x-rapidapi-host", host)
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
    public void addRecentCity(RecentCity recentCity) {
        RecentCityModel model = cityMapper.toRecentCityModel(recentCity);
        try {
            recentCityRepository.save(model);
        } catch (Exception ignored) {
        }

    }

    @Override
    public void addRecentCity(City city, String userId) {
        RecentCityModel model = cityMapper.toRecentCityModel(city, userId);
        try {
            recentCityRepository.save(model);
        } catch (Exception ignored) {
        }
    }
}
