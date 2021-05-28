package service.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import service.models.city.City;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flight {

    City originPlace;

    City destinationPlace;

    Date outboundDate;

    Date inboundDate;

    Double cost;
}
