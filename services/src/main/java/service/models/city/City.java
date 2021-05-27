package service.models.city;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class City {
    Integer id;
    //код аэропорта
    String PlaceId;
    //город  аэропорт
    String PlaceName;

    String CityId;
    //название страны
    String CountryName;
}
