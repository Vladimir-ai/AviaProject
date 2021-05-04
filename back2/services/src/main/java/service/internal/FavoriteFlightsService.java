package service.internal;

import service.models.Flight;

import java.util.List;

public interface FavoriteFlightsService {

    List<Flight> getAllFavorite(String userId)  ;

    void addToFavorite(String userId, String flightId);

    void deleteFromFavorite(String userId, String flightId);
}
