package com.example.demo.api;

import org.springframework.web.bind.annotation.PathVariable;
import service.internal.CityService;
import service.models.city.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(
        value = "/city",
        produces = "application/json"
)
public class CitiesApi {

    private final CityService cityService;

    @Autowired
    public CitiesApi(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping(value = "/user/{user_id}")
    List<City> getRecentCities(@PathVariable("user_id") String userId) {
        return cityService.getRecentCities(userId);
    }

    @GetMapping(value = "/user/{user_id}/{city_id}")
    void addRecentCity(@PathVariable("user_id") String userId, @PathVariable("city_id") String CityId) {
        cityService.addRecentCity(userId, CityId);

    }

    @GetMapping(value = "/{name}")
    List<City> getAllCities(@PathVariable("name") String name) throws IOException {
        return cityService.searchPlaceByName(  name);
    }

}
