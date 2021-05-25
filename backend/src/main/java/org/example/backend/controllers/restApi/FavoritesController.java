package org.example.backend.controllers.restApi;

import org.example.backend.services.FavoritesService;
import org.example.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/favorites")
public class FavoritesController {
    private final FavoritesService favoritesService;
    private final UserService userService;

    @Autowired
    public FavoritesController(FavoritesService favoritesService, UserService userService) {
        this.favoritesService = favoritesService;
        this.userService = userService;
    }

    @RequestMapping(path = "/add",method = RequestMethod.POST)
    public void addFavorite(){
        favoritesService.addFavorite();
    }

    @RequestMapping(path = "/get",method = RequestMethod.POST)
    public void getFavorites(){
        favoritesService.addFavorite();
    }
}
