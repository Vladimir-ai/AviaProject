package service.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import service.models.city.City;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flight {
    Integer id;
    City originPlace;
    City destinationPlace;
    LocalDate outboundDate;
    LocalDate inboundDate;
    Double cost;
}
