package avia.repositories;

import avia.models.Flight;
import org.springframework.data.repository.CrudRepository;

public interface FlightRepository extends CrudRepository<Flight, Integer> {
}