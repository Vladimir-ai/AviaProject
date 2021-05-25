package org.example.backend.services;

import org.example.backend.model.User;
import org.example.backend.repositories.FlightTicketsRepo;
import org.example.backend.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavoritesService {
    private final UserRepo userRepo;
    private final FlightTicketsRepo ticketsRepo;

    @Autowired
    public FavoritesService(UserRepo userRepo, FlightTicketsRepo ticketsRepo) {
        this.userRepo = userRepo;
        this.ticketsRepo = ticketsRepo;
    }

    public boolean addFavorite(){

        return true;
    }
}
