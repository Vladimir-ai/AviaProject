package avia.repositories;

import avia.models.FlightModel;
import org.springframework.data.repository.CrudRepository;

public interface FlightRepository extends CrudRepository<FlightModel, Integer> {
}
