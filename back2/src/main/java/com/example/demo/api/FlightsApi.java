package com.example.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.internal.FavoriteFlightsService;
import service.internal.FlightService;
import service.models.Flight;

import java.util.List;

@RestController
@RequestMapping(
        value = "/flight",
        produces = "application/json"
)
public class FlightsApi {

    //recent flights
    //add recent
    //searchFlight
    private final FlightService flightService;

    @Autowired
    public FlightsApi(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping(value = "/{userId}/{flightId}")
    public List<Flight> getRecentFlights(@PathVariable String userId, @PathVariable String flightId) {
        return flightService.getRecentFlights(userId, flightId);
    }

    @PostMapping(consumes = "application/json")
    public List<Flight> searchFlight(@RequestBody Flight flight) {
        return flightService.searchFlight(flight);
    }

    @PostMapping(value = "/{userId}/{flightId}")
    public void addToRecent(@PathVariable String userId, @PathVariable String flightId) {
        flightService.addToRecent(userId, flightId);
    }
}
