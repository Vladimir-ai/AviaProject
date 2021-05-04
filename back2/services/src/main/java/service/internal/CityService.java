package service.internal;


import service.models.City;

import java.io.IOException;
import java.util.List;


public interface CityService {
    List<City> getRecentCities();
    void addRecentCity();
    List<City> searchPlaceByName(String name) throws IOException;
}
