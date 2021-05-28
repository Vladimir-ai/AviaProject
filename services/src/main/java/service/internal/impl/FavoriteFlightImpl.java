package service.internal.impl;

import avia.models.FavoriteFlightModel;
import avia.models.FlightModel;
import avia.repositories.FavoriteFlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.internal.FavoriteFlightsService;
import service.internal.FlightService;
import service.mapper.FavoriteFlightMapper;
import service.models.FavoriteFlight;

import java.util.List;

@Service
public class FavoriteFlightImpl implements FavoriteFlightsService {

    private final FavoriteFlightRepository flightRepository;
    private final FavoriteFlightMapper flightMapper;
    private final FlightService flightService;

    @Autowired
    public FavoriteFlightImpl(FavoriteFlightRepository flightRepository, FavoriteFlightMapper flightMapper, FlightService flightService) {
        this.flightRepository = flightRepository;
        this.flightMapper = flightMapper;
        this.flightService = flightService;
    }

    @Override
    public List<FavoriteFlight> getAllFavorite(String userId) {
        List<FavoriteFlightModel> models = flightRepository.findAllByUserId(userId);
        return flightMapper.toListFavoriteFlight(models);
    }

    @Override
    public void addToFavorite(FavoriteFlight flight) {
        FavoriteFlightModel model = flightMapper.toFavoriteFlightModel(flight);
        Integer flightId = flightService.addFlight(flight.getFlight());
        model.getFlightModel().setId(flightId);

        try {
            flightRepository.save(model);
        } catch (Exception ignored) {
        }
    }

    @Override
    public boolean deleteFromFavorite(Integer flightId) {
        FavoriteFlightModel favoriteFlightModel = flightRepository.findFirstById(flightId);
        if (favoriteFlightModel != null) {
            flightRepository.delete(favoriteFlightModel);
            return true;
        }
        return false;
    }


}
