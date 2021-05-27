package service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import service.models.Flight;
import service.models.flight.Quote;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(uses = {CityMapper.class})
public interface FlightMapper {

    @Mapping(target = "cost", source = "minPrice")
    @Mapping(target = "inboundDate", source = "outboundLeg.landingDate")
    @Mapping(target = "outboundDate", source = "outboundLeg.departureDate")
    @Mapping(target = "originPlace", source = "outboundLeg.originPlace")
    @Mapping(target = "destinationPlace", source = "outboundLeg.destinationPlace")
    Flight toFlight(Quote quote);

    default List<Flight> toListPurchase(List<Quote> list) {
        return list
                .stream()
                .map(this::toFlight)
                .collect(Collectors.toList());
    }

}
