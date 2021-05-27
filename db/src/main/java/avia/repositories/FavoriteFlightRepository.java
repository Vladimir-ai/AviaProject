package avia.repositories;

import avia.models.FavoriteFlight;
import org.springframework.data.repository.CrudRepository;

public interface FavoriteFlightRepository extends CrudRepository<FavoriteFlight, Integer> {
}
