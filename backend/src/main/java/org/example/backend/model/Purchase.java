package org.example.backend.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ticket_purchase",schema = "course")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_id")
    private long id;
    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private User buyer;
    @OneToMany(mappedBy = "id")
    private List<Passenger> passengers;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ticket_id", referencedColumnName = "ticket_id")
    private FlightTicket flightTicket;
}
