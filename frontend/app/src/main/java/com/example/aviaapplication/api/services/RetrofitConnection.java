package com.example.aviaapplication.api.services;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConnection {
    private static Retrofit retrofitConnect = null;

    private static Retrofit getRetrofitConnect() {
        if (retrofitConnect == null) {

            retrofitConnect = new Retrofit.Builder()
                     .baseUrl("http://10.0.2.2:8080/api/")
                    .addConverterFactory(GsonConverterFactory.create( ))
                    .build();
        }
        return retrofitConnect;
    }
    public static <S> S createRetrofitConnection(Class<S> serviceClass) {
        getRetrofitConnect();
        return  retrofitConnect.create(serviceClass);
    }
}
