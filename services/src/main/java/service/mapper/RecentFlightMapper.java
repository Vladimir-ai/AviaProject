package service.mapper;

import avia.models.RecentFlightModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import service.models.RecentFlight;

@Mapper
public interface RecentFlightMapper {
    @Mapping(target = "userId", source = "userId")
    @Mapping(target = "flightModel", source = "flight")
    RecentFlightModel toRecentFlightModel(RecentFlight purchase);

    @Mapping(target = "userId", source = "userId")
    @Mapping(target = "flight", source = "flightModel")
    RecentFlight toRecentFlight(RecentFlightModel purchase);
}
