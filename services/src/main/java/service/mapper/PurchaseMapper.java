package service.mapper;

import avia.models.PurchaseModel;
import avia.models.RecentCityModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import service.models.Purchase;
import service.models.RecentCity;

import java.util.List;
import java.util.stream.Collectors;

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


    default List<Purchase> toListPurchase(List<PurchaseModel> list) {
        return list
                .stream()
                .map(this::toPurchase)
                .collect(Collectors.toList());
    }
}
