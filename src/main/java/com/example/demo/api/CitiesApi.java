package com.example.demo.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import service.internal.CityService;
import service.models.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
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

    //recent cities
    List<City> getRecentCities() {
        return null;
    }

    //add recent cities
    void addRecentCity() {
    }

    @GetMapping(value = "/{name}")
    List<City> getAllCities(@PathVariable("name") String name) throws IOException {
        return cityService.searchPlaceByName(  name);
    }

}
