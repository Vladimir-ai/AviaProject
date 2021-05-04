package service.internal.impl;

import org.springframework.stereotype.Service;
import service.internal.FlightService;
import service.models.Flight;

import java.util.List;
@Service
public class FlightServiceImpl implements FlightService {
    @Override
    public List<Flight> getRecentFlights(String userId, String flightId) {
        return null;
    }

    @Override
    public List<Flight> searchFlight(Flight flight) {
        return null;
    }

    @Override
    public void addToRecent(String userId, String flightId) {

    }
}
