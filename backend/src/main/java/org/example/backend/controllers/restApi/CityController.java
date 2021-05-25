package org.example.backend.controllers.restApi;

import org.example.backend.model.City;
import org.example.backend.model.dto.CityDto;
import org.example.backend.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {
    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @RequestMapping(method = RequestMethod.GET,path = "/getAll")
    public List<CityDto> getAllCities(){
        return cityService.getAll();
    }
}
