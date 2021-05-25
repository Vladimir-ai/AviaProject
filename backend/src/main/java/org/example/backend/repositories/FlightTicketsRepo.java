package org.example.backend.repositories;

import org.example.backend.model.FlightTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightTicketsRepo extends JpaRepository<FlightTicket,Long> {
}
