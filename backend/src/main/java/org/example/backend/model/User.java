package org.example.backend.model;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "passanger_user", schema = "course")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long id;

    @Column(name = "email", unique = true)
    private String email;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "buyer")
    private Set<Purchase> flightHistory;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    private Set<FlightTicket> favorites;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "airportCode")
    private Set<City> recentCities;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    private Set<FlightTicket> recentSearch;


}
