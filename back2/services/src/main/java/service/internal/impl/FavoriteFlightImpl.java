package service.internal.impl;

import org.springframework.stereotype.Service;
import service.internal.FavoriteFlightsService;
import service.models.Flight;

import java.util.List;
@Service
public class FavoriteFlightImpl  implements FavoriteFlightsService {
    @Override
    public List<Flight> getAllFavorite(String userId)  {
        return null;
    }

    @Override
    public void addToFavorite(String userId, String flightId) {

    }

    @Override
    public void deleteFromFavorite(String userId, String flightId) {

    }
}
