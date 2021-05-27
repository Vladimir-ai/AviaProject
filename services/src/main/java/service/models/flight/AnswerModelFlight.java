package service.models.flight;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import service.models.city.AnswerModelCity;

import java.util.List;

@Data
public class AnswerModelFlight {
    List<Quote> Quotes;
    List<Place> Places;
}
