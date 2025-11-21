package com.example.bttuan5.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bttuan5.R;
import com.example.bttuan5.model.Category;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {

    private Context context;
    private List<Category> array;

    public CategoryAdapter(Context context, List<Category> array) {
        this.context = context;
        this.array = array;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_category, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Category category = array.get(position);

        // Hiển thị tên danh mục
        holder.tenSp.setText(category.getName());

        // Load ảnh với Glide
        Glide.with(context)
                .load(category.getImages())
                .placeholder(R.drawable.ic_launcher_background) // Placeholder khi đang tải
                .error(R.drawable.ic_launcher_background) // Ảnh hiển thị khi lỗi
                .into(holder.images);
    }

    @Override
    public int getItemCount() {
        return array == null ? 0 : array.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView images;
        TextView tenSp;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            // Ánh xạ View
            images = itemView.findViewById(R.id.image_cate);
            tenSp = itemView.findViewById(R.id.tvNameCategory);

            // Bắt sự kiện click cho item
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            // Xử lý khi click vào item category
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                Category clickedCategory = array.get(position);
                Toast.makeText(context, "Bạn đã chọn category: " + clickedCategory.getName(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}