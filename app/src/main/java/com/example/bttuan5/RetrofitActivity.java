package com.example.bttuan5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.bttuan5.adapter.CategoryAdapter;
import com.example.bttuan5.model.Category;
import com.example.bttuan5.retrofit.APIService;
import com.example.bttuan5.retrofit.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitActivity extends AppCompatActivity {

    RecyclerView rcCate;
    // Khai báo Adapter
    CategoryAdapter categoryAdapter;
    APIService apiService;
    List<Category> categoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        AnhXa(); // Ánh xạ View
        GetCategory(); // Load dữ liệu cho category
    }

    private void AnhXa() {
        // ánh xạ
        rcCate = findViewById(R.id.rc_category);

        // Khởi tạo danh sách rỗng và Adapter trước
        categoryList = new ArrayList<>();
        categoryAdapter = new CategoryAdapter(this, categoryList);

        // Cấu hình RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false);
        rcCate.setLayoutManager(layoutManager);
        rcCate.setHasFixedSize(true);
        rcCate.setAdapter(categoryAdapter);
    }

    private void GetCategory() {
        // Gán APIService bằng RetrofitClient
        apiService = RetrofitClient.getRetrofit().create(APIService.class);

        // Thực hiện async request
        apiService.getCategoryAll().enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                if (response.isSuccessful()) {
                    categoryList.clear(); // Xóa dữ liệu cũ
                    categoryList.addAll(response.body());

                    categoryAdapter.notifyDataSetChanged();

                    Toast.makeText(RetrofitActivity.this, "Tải danh mục thành công", Toast.LENGTH_SHORT).show();
                } else {
                    int statusCode = response.code();
                    // Xử lý lỗi request
                    Toast.makeText(RetrofitActivity.this, "Lỗi API: " + statusCode, Toast.LENGTH_SHORT).show();
                    Log.e("Retrofit", "Lỗi API, Status Code: " + statusCode);
                }
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                // Xử lý lỗi kết nối
                Log.d("logg", t.getMessage());
                Toast.makeText(RetrofitActivity.this, "Lỗi kết nối: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}