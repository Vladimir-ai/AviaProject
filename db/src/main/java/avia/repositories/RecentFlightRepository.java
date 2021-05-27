package avia.repositories;

import avia.models.RecentCity;
import avia.models.RecentFlight;
import org.springframework.data.repository.CrudRepository;

public interface RecentFlightRepository extends CrudRepository<RecentFlight, Integer> {
}
