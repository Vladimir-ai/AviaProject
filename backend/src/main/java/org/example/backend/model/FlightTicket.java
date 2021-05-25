package org.example.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "flight_ticket",schema = "course")
public class FlightTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private long id;
    @OneToOne
    @JoinColumn(name = "city_code",insertable = false,updatable = false)
    private City from;
    @OneToOne
    @JoinColumn(name = "city_code",insertable = false,updatable = false)
    private City to;
    @Column(name = "price")
    private long price;
    @Column(name = "date")
    private Timestamp date;
    @Column(name = "people_count")
    private int peopleCount;

}
