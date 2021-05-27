package com.example.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.internal.FavoriteFlightsService;
import service.models.FavoriteFlight;
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
    List<FavoriteFlight> getFavoriteFlights(@PathVariable("user_id") String userId) {
        return favoriteFlightsService.getAllFavorite(userId);
    }

    @PostMapping(consumes = "application/json")
    void addToFavorite(@RequestBody FavoriteFlight flight) {
        favoriteFlightsService.addToFavorite(flight);
    }

    @DeleteMapping(value = "/{flight_id}" )
    void deleteFromFavorite(@PathVariable( "flight_id") Integer flightId) {
        favoriteFlightsService.deleteFromFavorite(flightId);
    }

}
