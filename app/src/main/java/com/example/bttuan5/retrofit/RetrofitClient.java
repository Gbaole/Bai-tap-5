package com.example.bttuan5.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    // Base URL
    private static final String BASE_URL = "http://app.iotstar.vn:8081/";
    private static Retrofit retrofit;

    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            // Khởi tạo Retrofit nếu chưa có
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    // Sử dụng GsonConverterFactory để chuyển đổi JSON sang Java object
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}