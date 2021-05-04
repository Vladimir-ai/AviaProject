package service.models.city;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.immutables.value.Value;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class City {
    String PlaceId;

    String PlaceName;

    String CountryId;

    String RegionId;

    String CityId;

    String CountryName;
}
