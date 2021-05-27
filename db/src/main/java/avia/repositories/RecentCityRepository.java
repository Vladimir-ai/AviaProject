package avia.repositories;

import avia.models.Flight;
import avia.models.RecentCity;
import org.springframework.data.repository.CrudRepository;

public interface RecentCityRepository extends CrudRepository<RecentCity, Integer> {
}
