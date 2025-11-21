package com.example.bttuan5.retrofit;

import com.example.bttuan5.model.Category;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {


    @GET("appfoods/categories.php")
    Call<List<Category>> getCategoryAll();
}