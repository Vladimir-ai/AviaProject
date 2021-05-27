package avia.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "favorite_flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_id")
    Integer id;

    @ManyToOne
    @JoinColumn(columnDefinition = "city_id")
    City originPlace;

    @ManyToOne
    @JoinColumn(columnDefinition = "city_id")
    City destinationPlace;

    Date outboundDate;

    Date inboundDate;

    Double cost;
}
