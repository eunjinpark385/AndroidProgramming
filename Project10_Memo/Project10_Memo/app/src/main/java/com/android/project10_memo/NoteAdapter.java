package com.android.project10_memo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.project10_memo.databinding.NoteItemBinding;

import java.util.Vector;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHoler>{

    Context context;
    Vector<Note> items;

    NoteAdapter(Context context, Vector<Note> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        NoteItemBinding binding = NoteItemBinding.inflate(layoutInflater, parent, false);
        return new ViewHoler(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoler holder, int position) {
        Note item = items.get(position);
        holder.binding.tvCategory.setText(item.category);
        holder.binding.tvTitle.setText(item.title);
        holder.binding.tvContent.setText(item.contents);
        holder.binding.tvDate.setText(item.createDateStr);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHoler extends RecyclerView.ViewHolder {

        NoteItemBinding binding;

        public ViewHoler(@NonNull NoteItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
