package service.models.flight;

import lombok.Data;

import java.util.List;

@Data
public class AnswerModelFlight {
    List<Quote> Quotes;
    List<Place> Places;
}
