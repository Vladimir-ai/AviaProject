package service.mapper;

import avia.models.FlightModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import service.models.Flight;
import service.models.flight.Quote;

import java.util.Date;

@Mapper
public interface FlightMapper {
/*    @Mapping(target = "id", source = "id")
    @Mapping(target = "originPlace", source = "originPlace")
    @Mapping(target = "destinationPlace", source = "destinationPlace")
    @Mapping(target = "outboundDate", source = "outboundDate")
    @Mapping(target = "inboundDate", source = "inboundDate")
    @Mapping(target = "cost", source = "cost")
    FlightModel toFlightModel(Flight flight);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "originPlace", source = "originPlace")
    @Mapping(target = "destinationPlace", source = "destinationPlace")
    @Mapping(target = "outboundDate", source = "outboundDate")
    @Mapping(target = "inboundDate", source = "inboundDate")
    @Mapping(target = "cost", source = "cost")
    Flight toFlight(FlightModel flight);


    @Mapping(target = "cost", source = "quote.MinPrice")
    @Mapping(target = "inboundDate", source = "inbound")
    @Mapping(target = "outboundDate", source = "quote.OutboundLeg.DepartureDate")
    @Mapping(target = "originPlace", source = "quote.OutboundLeg.originPlace")
    @Mapping(target = "destinationPlace", source = "quote.OutboundLeg.destinationPlace")
    Flight toFlight(Quote quote, Date inbound);*/

}
