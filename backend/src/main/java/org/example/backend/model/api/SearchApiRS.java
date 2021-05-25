package org.example.backend.model.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchApiRS {

    private List<Quote> quotes;

    private List<PlaceApiDto> places;

    private List<CarrierApiDto> carriers;

    @JsonProperty("Quotes")
    public List<Quote> getQuotes() {
        return quotes;
    }

    @JsonProperty("Quotes")
    public void setQuotes(List<Quote> quotes) {
        this.quotes = quotes;
    }

    @JsonProperty("Places")
    public List<PlaceApiDto> getPlaces() {
        return places;
    }

    @JsonProperty("Places")
    public void setPlaces(List<PlaceApiDto> places) {
        this.places = places;
    }

    @JsonProperty("Carriers")
    public List<CarrierApiDto> getCarriers() {
        return carriers;
    }

    @JsonProperty("Carriers")
    public void setCarriers(List<CarrierApiDto> carriers) {
        this.carriers = carriers;
    }

    public String getCarrierById(int id) {
        for (CarrierApiDto item :
                carriers) {
            if (item.getId() == id) {
                return item.getName();
            }
        }
        return null;


    }

    public PlaceApiDto getPlaceById(int id) {
        for (PlaceApiDto item :
                places) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;

    }
}
