package service.internal;

import service.models.Flight;

import java.util.List;

public interface FlightService {

    List<Flight> getRecentFlights(String userId, String flightId);

    List<Flight> searchFlight(Flight flight);

    void addToRecent(String userId, String flightId);

}
