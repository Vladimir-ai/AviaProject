package org.example.backend.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class CityDto {
    private String cityCode;
    private String cityName;
    private String airportCode;
    private String airportName;
    private String countryCode;

    public CityDto(String cityCode, String cityName, String airportCode, String airportName, String countryCode) {
        this.cityCode = cityCode;
        this.cityName = cityName;
        this.airportCode = airportCode;
        this.airportName = airportName;
        this.countryCode = countryCode;
    }

    @JsonProperty("country_code")
    public String getCountryCode() {
        return countryCode;
    }

    @JsonProperty("country_code")
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @JsonProperty("name")
    public String getAirportName() {
        return airportName;
    }

    @JsonProperty("name")
    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    @JsonProperty("city_code")
    public String getCityCode() {
        return cityCode;
    }

    @JsonProperty("city_code")
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    @JsonProperty("city")
    public String getCityName() {
        return cityName;
    }

    @JsonProperty("city")
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @JsonProperty("code")
    public String getAirportCode() {
        return airportCode;
    }

    @JsonProperty("code")
    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }
}
