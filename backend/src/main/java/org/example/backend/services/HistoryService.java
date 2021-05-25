package org.example.backend.services;

import org.example.backend.repositories.FlightTicketsRepo;
import org.example.backend.repositories.PurchaseRepo;
import org.example.backend.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryService {
    private final UserRepo userRepo;
    private final FlightTicketsRepo ticketsRepo;
    private final PurchaseRepo purchaseRepo;

    @Autowired
    public HistoryService(UserRepo userRepo, FlightTicketsRepo ticketsRepo, PurchaseRepo purchaseRepo) {
        this.userRepo = userRepo;
        this.ticketsRepo = ticketsRepo;
        this.purchaseRepo = purchaseRepo;
    }
}
