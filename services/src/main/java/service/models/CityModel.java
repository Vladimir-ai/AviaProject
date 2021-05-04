package service.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.immutables.value.Value;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityModel {
  List<City> Places ;
}
