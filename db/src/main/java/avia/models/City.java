package avia.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "city")

public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    Integer id;

    @Column(name = "place_id")
    String PlaceId;

    @Column(name = "place_name")
    String PlaceName;

    @Column(name = "city_code")
    String CityId;

    @Column(name = "country_name")
    String CountryName;

}
