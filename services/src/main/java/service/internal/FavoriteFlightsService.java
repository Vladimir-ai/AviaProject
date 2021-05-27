package service.internal;

import service.models.FavoriteFlight;
import service.models.Flight;

import java.util.List;

public interface FavoriteFlightsService {

    List<FavoriteFlight> getAllFavorite(String userId)  ;

    void addToFavorite(FavoriteFlight flight);

    void deleteFromFavorite(Integer flightId);

    List<FavoriteFlight> updateCosts();
}
