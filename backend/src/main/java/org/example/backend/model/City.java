package org.example.backend.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@NoArgsConstructor
@Data
@Table(name = "city", schema = "course")
public class City {
    @Id
    @Column(name = "aiport_code")
    private String airportCode;
    @Column(name = "aiport_name")
    private String airportName;

    @Column(name = "city_code")
    private String cityCode;

    @Column(name = "city_name")
    private String name;

    @Column(name = "country")
    private String countryCode;

    public City(String cityCode, String name, String airportCode, String airportName, String countryCode) {
        this.airportCode = airportCode;
        this.airportName = airportName;
        this.cityCode = cityCode;
        this.name = name;
        this.countryCode = countryCode;
    }
}
