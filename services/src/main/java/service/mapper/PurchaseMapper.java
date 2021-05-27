package service.mapper;

import avia.models.PurchaseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import service.models.Purchase;

@Mapper
public interface PurchaseMapper {
    @Mapping(target = "flightModel", source = "flight")
    @Mapping(target = "countPassengers", source = "countPassengers")
    @Mapping(target = "flightCost", source = "flightCost")
    PurchaseModel toPurchaseModel(Purchase purchase);

    @Mapping(target = "flight", source = "flightModel")
    @Mapping(target = "countPassengers", source = "countPassengers")
    @Mapping(target = "flightCost", source = "flightCost")
    Purchase toPurchase(PurchaseModel purchase);
}
