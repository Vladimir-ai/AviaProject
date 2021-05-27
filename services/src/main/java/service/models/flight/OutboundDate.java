package service.models.flight;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
public class OutboundDate {
    Integer  OriginId;
    Integer DestinationId;
    Place originPlace;
    Place destinationPlace;
    Date DepartureDate;
}
