package com.example.aviaapplication.api.services;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConnection {
    private static Retrofit retrofitConnect = null;

    private static Retrofit getRetrofitConnect() {
        if (retrofitConnect == null) {

            retrofitConnect = new Retrofit.Builder()
                     .baseUrl("http://192.168.1.64:8080/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(new OkHttpClient.Builder().addInterceptor(new okhttp3.logging.HttpLoggingInterceptor()).build())
                    .build();
        }
        return retrofitConnect;
    }
    public static <S> S createRetrofitConnection(Class<S> serviceClass) {
        getRetrofitConnect();
        return  retrofitConnect.create(serviceClass);
    }
}
