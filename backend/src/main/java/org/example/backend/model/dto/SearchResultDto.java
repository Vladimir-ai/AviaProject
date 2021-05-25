package org.example.backend.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import java.time.LocalDateTime;


public class SearchResultDto {
    private int id;
    private String fromCity;
    private String fromCode;
    private String toCity;
    private String toCode;
    private int ecoPrice;
    private int busPrice;
    private LocalDateTime departureDate;
    private LocalDateTime arrivingDate;

    public SearchResultDto(int id, String fromCity, String fromCode, String toCity, String toCode, int ecoPrice, int busPrice, LocalDateTime departureDate, LocalDateTime arrivingDate) {
        this.id = id;
        this.fromCity = fromCity;
        this.fromCode = fromCode;
        this.toCity = toCity;
        this.toCode = toCode;
        this.ecoPrice = ecoPrice;
        this.busPrice = busPrice;
        this.departureDate = departureDate;
        this.arrivingDate = arrivingDate;
    }
    @JsonProperty("id")
    public int getId() {
        return id;
    }
    @JsonProperty("id")
    public void setId(int id) {
        this.id = id;
    }
    @JsonProperty("fromCity")
    public String getFromCity() {
        return fromCity;
    }
    @JsonProperty("fromCity")
    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }
    @JsonProperty("fromCode")
    public String getFromCode() {
        return fromCode;
    }
    @JsonProperty("fromCode")
    public void setFromCode(String fromCode) {
        this.fromCode = fromCode;
    }
    @JsonProperty("toCity")
    public String getToCity() {
        return toCity;
    }
@JsonProperty("toCity")
    public void setToCity(String toCity) {
        this.toCity = toCity;
    }
    @JsonProperty("toCode")
    public String getToCode() {
        return toCode;
    }
    @JsonProperty("toCode")
    public void setToCode(String toCode) {
        this.toCode = toCode;
    }
    @JsonProperty("economyPrice")
    public int getEcoPrice() {
        return ecoPrice;
    }
    @JsonProperty("economyPrice")
    public void setEcoPrice(int ecoPrice) {
        this.ecoPrice = ecoPrice;
    }
    @JsonProperty("businessPrice")
    public int getBusPrice() {
        return busPrice;
    }
    @JsonProperty("businessPrice")
    public void setBusPrice(int busPrice) {
        this.busPrice = busPrice;
    }
    @JsonProperty("departureDate")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    public LocalDateTime getDepartureDate() {
        return departureDate;
    }
    @JsonProperty("departureDate")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    public void setDepartureDate(LocalDateTime departureDate) {
        this.departureDate = departureDate;
    }
    @JsonProperty("arrivingDate")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    public LocalDateTime getArrivingDate() {
        return arrivingDate;
    }
    @JsonProperty("arrivingDate")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    public void setArrivingDate(LocalDateTime arrivingDate) {
        this.arrivingDate = arrivingDate;
    }
}
