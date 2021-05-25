package org.example.backend.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class SearchRQ {
    private String from;
    private String to;
    private boolean isBusiness;
    private LocalDate departureDate;
    private int passengerNumber;

    @JsonProperty("from")
    public String getFrom() {
        return from;
    }
    @JsonProperty("from")
    public void setFrom(String from) {
        this.from = from;
    }
    @JsonProperty("to")
    public String getTo() {
        return to;
    }
    @JsonProperty("to")
    public void setTo(String to) {
        this.to = to;
    }
    @JsonProperty("isBusiness")
    public boolean isBusiness() {
        return isBusiness;
    }
    @JsonProperty("isBusiness")
    public void setBusiness(boolean business) {
        isBusiness = business;
    }
    @JsonProperty("departureDate")
    public LocalDate getDepartureDate() {
        return departureDate;
    }
    @JsonProperty("departureDate")
    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }
    @JsonProperty("passengerNumber")
    public int getPassengerNumber() {
        return passengerNumber;
    }
    @JsonProperty("passengerNumber")
    public void setPassengerNumber(int passengerNumber) {
        this.passengerNumber = passengerNumber;
    }
}
