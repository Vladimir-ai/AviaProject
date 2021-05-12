package com.example.aviaapplication.api.services.purchase;

import com.example.aviaapplication.api.models.Purchase;

import java.util.List;

import retrofit2.Call;

public interface UserPurchase {

    Call<List<Purchase>> getListPurchase(String login);

    Call<Purchase> buyTickets();
}
