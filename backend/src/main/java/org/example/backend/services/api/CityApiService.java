package org.example.backend.services.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.backend.configurations.ProjectConfiguration;
import org.example.backend.model.City;
import org.example.backend.model.dto.CityDto;
import org.example.backend.repositories.CityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

@Service
public class CityApiService {
    private final CityRepo cityRepo;
    private final ObjectMapper objectMapper;
    private final ProjectConfiguration localConfiguration;

    @Autowired
    public CityApiService(CityRepo cityRepo, ObjectMapper objectMapper, ProjectConfiguration localConfiguration) {
        this.cityRepo = cityRepo;
        this.objectMapper = objectMapper;
        this.localConfiguration = localConfiguration;
    }

//    @PostConstruct
//    private void init() {
//        try {
//            List<CityDto> cities = objectMapper.readValue(Paths.get(localConfiguration.citiesDestination).toFile(),objectMapper.getTypeFactory().constructCollectionType(List.class, CityDto.class));
//            cities.forEach(cityDto -> {
//                City city=new City(cityDto.getCityCode(), cityDto.getCityName(), cityDto.getAirportCode(), cityDto.getAirportName(), cityDto.getCountryCode());
//                cityRepo.save(city);});
//
//        } catch (IOException exception) {
//            exception.printStackTrace();
//        }
//    }
}
