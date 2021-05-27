package service.models.city;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class City {
    Integer id;

    String PlaceId;

    String PlaceName;

    String CityId;

    String CountryName;
}
