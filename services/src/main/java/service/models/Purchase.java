package service.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Purchase {

    Integer id;
    String userId;

    Flight flight;

    Integer countPassengers;

    Double flightCost;
}
