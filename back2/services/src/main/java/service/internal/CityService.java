package service.internal;


import service.models.city.City;

import java.io.IOException;
import java.util.List;


public interface CityService {
    List<City> getRecentCities(String userId);

    List<City> searchPlaceByName(String name) throws IOException;

    void addRecentCity(String userId, String cityId);
}
