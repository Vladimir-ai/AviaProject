package com.example.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.internal.FavoriteFlightsService;
import service.models.Flight;

import java.util.List;

@RestController
@RequestMapping(
        value = "/favorite",
        produces = "application/json"
)
public class FavoriteFlightsApi {

    private final FavoriteFlightsService favoriteFlightsService;

    @Autowired
    public FavoriteFlightsApi(FavoriteFlightsService favoriteFlightsService) {
        this.favoriteFlightsService = favoriteFlightsService;
    }

    @GetMapping(value = "/{user_id}")
    List<Flight> getRecentCities(@PathVariable("user_id") String userId) {
        return favoriteFlightsService.getAllFavorite(userId);
    }

    @PostMapping(value = "/{user_id}/{flightId}")
    void addToFavorite(@PathVariable("user_id") String userId, @PathVariable("flightId") String flightId) {
        favoriteFlightsService.addToFavorite(userId, flightId);
    }

    @DeleteMapping(value = "/{user_id}/{flightId}")
    void deleteFromFavorite(@PathVariable("user_id") String userId, @PathVariable("flightId") String flightId) {
        favoriteFlightsService.addToFavorite(userId, flightId);
    }

}
