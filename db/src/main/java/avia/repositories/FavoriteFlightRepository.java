package avia.repositories;

import avia.models.FavoriteFlightModel;
import org.springframework.data.repository.CrudRepository;

public interface FavoriteFlightRepository extends CrudRepository<FavoriteFlightModel, Integer> {
}
