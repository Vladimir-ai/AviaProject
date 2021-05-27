package avia.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "recent_flights")
public class RecentFlightModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @Column(name = "user_id")
    String userId;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    FlightModel flightModel;
}
