package service.internal.impl;

import avia.repositories.CityRepository;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.internal.CityService;
import service.models.city.City;
import service.models.city.AnswerModelCity;

import java.io.IOException;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public List<City> getRecentCities(String userId) {
        //database
        return null;
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
            String bodyy = response.body().string();
            System.out.println(bodyy);
            AnswerModelCity list = new Gson().fromJson(bodyy, AnswerModelCity.class);
            return list.getPlaces();
        }
        return null;
    }

    @Override
    public void addRecentCity(String userId, String cityId) {
        System.out.println("sssdds");
    }
}
