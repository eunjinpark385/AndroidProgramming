package com.android.project10_memo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.project10_memo.databinding.ImageItemBinding;

import java.util.ArrayList;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {

    ArrayList<String> items = new ArrayList<>();
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ImageItemBinding binding = ImageItemBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String path = items.get(position);
        Bitmap bitmap = BitmapFactory.decodeFile(path);
        holder.binding.ivImage.setImageBitmap(bitmap);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(ArrayList<String> items){
        this.items = items;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageItemBinding binding;

        public ViewHolder(@NonNull ImageItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
