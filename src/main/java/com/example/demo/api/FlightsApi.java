package com.example.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.internal.FavoriteFlightsService;
import service.internal.FlightService;
import service.models.Flight;
import service.models.RecentFlight;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(
        value = "/flight",
        produces = "application/json"
)
public class FlightsApi {


    private final FlightService flightService;

    @Autowired
    public FlightsApi(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping(value = "/{userId}")
    public List<RecentFlight> getRecentFlights(@PathVariable String userId) {
        return flightService.getRecentFlights(userId);
    }

    @PostMapping(value = "/search", consumes = "application/json")
    public List<Flight> searchFlight(@RequestBody RecentFlight flight) throws IOException {
        return flightService.searchFlight(flight);
    }

    @PostMapping(consumes = "application/json")
    public void addToRecent(@RequestBody RecentFlight recentFlight) {
        flightService.addToRecent(recentFlight);
    }
}
