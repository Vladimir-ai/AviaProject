package avia.repositories;

import avia.models.RecentFlightModel;
import org.springframework.data.repository.CrudRepository;

public interface RecentFlightRepository extends CrudRepository<RecentFlightModel, Integer> {
}
