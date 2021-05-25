package org.example.backend.model.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OutboundLeg {
    private List<Integer> carriersId;
    private int originId;
    private int destinationId;
    private LocalDateTime departureDate;

    @JsonProperty("CarrierIds")
    public List<Integer> getCarriersId() {
        return carriersId;
    }

    @JsonProperty("CarrierIds")
    public void setCarriersId(List<Integer> carriersId) {
        this.carriersId = carriersId;
    }

    @JsonProperty("OriginId")
    public int getOriginId() {
        return originId;
    }

    @JsonProperty("OriginId")
    public void setOriginId(int originId) {
        this.originId = originId;
    }

    @JsonProperty("DestinationId")
    public int getDestinationId() {
        return destinationId;
    }

    @JsonProperty("DestinationId")
    public void setDestinationId(int destinationId) {
        this.destinationId = destinationId;
    }

    @JsonProperty("DepartureDate")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    @JsonProperty("DepartureDate")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    public void setDepartureDate(LocalDateTime departureDate) {
        this.departureDate = departureDate;
    }
}
