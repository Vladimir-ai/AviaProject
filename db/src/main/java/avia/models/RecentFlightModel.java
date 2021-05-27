package avia.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "recent_flights", uniqueConstraints = {  @UniqueConstraint(columnNames = {"user_id", "flight_id" })})
public class RecentFlightModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recent_flights_id")
    Integer id;

    @Column(name = "user_id")
    String userId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "flight_id")
    FlightModel flightModel;
}
