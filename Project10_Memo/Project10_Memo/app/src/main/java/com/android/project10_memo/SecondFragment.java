package com.android.project10_memo;


import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.project10_memo.databinding.FragmentSecondBinding;

import java.util.ArrayList;

public class SecondFragment extends Fragment {

    FragmentSecondBinding binding;
    ImageAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);


        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 4);
        binding.recyclerView2.setLayoutManager(layoutManager);
        adapter = new ImageAdapter();
        binding.recyclerView2.setAdapter(adapter);

        ArrayList<String> ImageInfo = new ArrayList<>();
        Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        String[] projection = { MediaStore.MediaColumns.DATA };

        Cursor cursor = getContext().getContentResolver().query(uri, projection, null, null,
                MediaStore.MediaColumns.DATE_ADDED + " desc");
        int columnDataIndex = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);

        while (cursor.moveToNext()) {
            String path = cursor.getString(columnDataIndex);

            if (!TextUtils.isEmpty(path)) {
                ImageInfo.add(path);
            }
        }

        adapter.setItems(ImageInfo);


        return binding.getRoot();
    }

    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}