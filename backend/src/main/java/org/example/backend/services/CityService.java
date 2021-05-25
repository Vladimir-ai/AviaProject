package org.example.backend.services;

import org.example.backend.model.dto.CityDto;
import org.example.backend.repositories.CityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityService {
    private final CityRepo cityRepo;

    @Autowired
    public CityService(CityRepo cityRepo) {
        this.cityRepo = cityRepo;
    }

    public List<CityDto> getAll(){
        List<CityDto> result = new ArrayList<>();
        cityRepo.findAll().forEach(item->{result.add(new CityDto(item.getCityCode(),item.getName(),item.getAirportCode(),item.getAirportName(),item.getCountryCode()));});
        return result;
    }
}
