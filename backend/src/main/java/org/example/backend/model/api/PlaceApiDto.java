package org.example.backend.model.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlaceApiDto {
    private String name;
    private String cityName;
    private String iataCode;
    private int id;

    @JsonProperty("PlaceId")
    public int getId() {
        return id;
    }

    @JsonProperty("PlaceId")
    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    @JsonProperty("Name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("IataCode")
    public String getIataCode() {
        return iataCode;
    }

    @JsonProperty("IataCode")
    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
    }

    @JsonProperty("CityName")
    public String getCityName() {
        return cityName;
    }
    @JsonProperty("CityName")
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
