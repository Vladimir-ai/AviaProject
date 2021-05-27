package com.example.demo.api;

import org.springframework.web.bind.annotation.*;
import service.internal.CityService;
import service.models.RecentCity;
import service.models.city.City;
import org.springframework.beans.factory.annotation.Autowired;

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
    List<RecentCity> getRecentCities(@PathVariable("user_id") String userId) {
        return cityService.getRecentCities(userId);
    }

    @PostMapping(value = "/user")
    void addRecentCity(@RequestBody RecentCity city) {
        cityService.addRecentCity(city);

    }

    @GetMapping(value = "/{name}")
    List<City> getAllCities(@PathVariable("name") String name) throws IOException {
        return cityService.searchPlaceByName(  name);
    }

}
