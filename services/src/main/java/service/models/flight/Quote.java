package service.models.flight;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
public class Quote {
    Integer QuoteId;
    Double MinPrice;
    OutboundDate OutboundLeg;
    Date QuoteDateTime;
}
