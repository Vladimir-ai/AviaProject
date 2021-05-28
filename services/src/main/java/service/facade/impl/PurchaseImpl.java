package service.facade.impl;

import org.springframework.stereotype.Service;
import service.facade.PurchaseFacade;
import service.internal.PurchaseService;
import service.models.Purchase;

import java.util.List;
@Service
public class PurchaseImpl implements PurchaseFacade {

    private final PurchaseService purchaseService;

    public PurchaseImpl(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @Override
    public void takePurchase(Purchase purchase) {
        purchaseService.takePurchase(purchase);
    }

    @Override
    public List<Purchase> getPurchases(String userId) {
        return purchaseService.getPurchases(userId);
    }
}
