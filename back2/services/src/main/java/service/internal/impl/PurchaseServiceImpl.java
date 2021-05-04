package service.internal.impl;

import org.springframework.stereotype.Service;
import service.internal.PurchaseService;
import service.models.Purchase;

import java.util.List;
@Service
public class PurchaseServiceImpl implements PurchaseService {
    @Override
    public boolean takePurchase(Purchase purchase) {
        return false;
    }

    @Override
    public List<Purchase> getPurchases(String userId) {
        return null;
    }
}
