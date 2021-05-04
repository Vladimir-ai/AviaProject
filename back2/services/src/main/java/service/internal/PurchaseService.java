package service.internal;

import service.models.Purchase;

import java.util.List;

public interface PurchaseService {

    boolean takePurchase(Purchase purchase);

    List<Purchase> getPurchases(String userId);
}
