package com.example.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.internal.PurchaseService;
import service.models.Purchase;

import java.util.List;

@RestController
@RequestMapping(
        value = "/purchase",
        produces = "application/json"
)
public class PurchaseFlights {
    private final PurchaseService purchaseService;

    @Autowired
    public PurchaseFlights(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @PostMapping(consumes = "application/json")
    public boolean takePurchase(Purchase purchase) {
        return purchaseService.takePurchase(purchase);
    }

    @GetMapping(value = "/{userId}")
    public List<Purchase> getPurchases(@PathVariable String userId) {
        return purchaseService.getPurchases(userId);
    }
}
