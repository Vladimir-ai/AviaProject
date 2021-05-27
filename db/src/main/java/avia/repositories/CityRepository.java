package avia.repositories;

import avia.models.CityModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;


public interface CityRepository extends CrudRepository<CityModel, Integer> {
}
