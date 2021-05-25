package org.example.backend.model.api;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.backend.model.dto.CityDto;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class Countries {

    private List<CityDto> airports;
//    @JsonProperty("Countries")
    public List<CityDto> getCountries() {
        return airports;
    }
//    @JsonProperty("Countries")
    public void setCountries(List<CityDto> airports) {
        this.airports = airports;
    }
}
