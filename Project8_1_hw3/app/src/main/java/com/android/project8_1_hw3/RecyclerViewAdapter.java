package com.android.project8_1_hw3;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    Context context;
    Integer[] posterID;
    String[] posterTitle;

    // Receive data from constructor
    RecyclerViewAdapter(Context context, Integer[] posterID, String[] posterTitle) {
        this.context = context;
        this.posterID = posterID;
        this.posterTitle = posterTitle;
    }

    // Create ViewHolder Object and Return
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // onCreateViewHolder Log
        Log.i("Log-Adapter", "onCreateViewHolder()");
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_recyclerview, parent, false);
        return new ViewHolder(v);
    }

    // Set the data corresponding to the position in the ViewHolder
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // onBindViewHolder Log
        Log.i("Log-Adapter", "onBindViewHolder()");
        holder.imageView.setImageResource(posterID[position]);
        holder.textView.setText(posterTitle[position]);
    }

    // Return total item count
    @Override
    public int getItemCount() {
        // getItemCount Log
        Log.i("Log-Adapter", "getItemCount()");
        return posterID.length;
    }

    // ViewHolder Class
    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ivPoster1);
            textView = itemView.findViewById(R.id.tvTitle);
        }
    }
}
