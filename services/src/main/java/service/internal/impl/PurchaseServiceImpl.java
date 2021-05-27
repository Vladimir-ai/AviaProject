package service.internal.impl;

import avia.models.PurchaseModel;
import avia.repositories.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import service.internal.PurchaseService;
import service.mapper.PurchaseMapper;
import service.models.Purchase;

import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    private final PurchaseMapper purchaseMapper;
    private final PurchaseRepository purchaseRepository;

    @Autowired
    public PurchaseServiceImpl(PurchaseMapper purchaseMapper, PurchaseRepository purchaseRepository) {
        this.purchaseMapper = purchaseMapper;
        this.purchaseRepository = purchaseRepository;
    }

    @Override
    public void takePurchase(Purchase purchase) {
        PurchaseModel model = purchaseMapper.toPurchaseModel(purchase);
        try {
            purchaseRepository.save(model);
        } catch (Exception ignored) {
        }
    }

    @Override
    public List<Purchase> getPurchases(String userId) {
        List<PurchaseModel> models = purchaseRepository.findAllByUserId(userId);
        return purchaseMapper.toListPurchase(models);
    }
}
