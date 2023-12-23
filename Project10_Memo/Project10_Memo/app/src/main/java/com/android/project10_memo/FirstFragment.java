package com.android.project10_memo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.project10_memo.databinding.FragmentFirstBinding;

import java.util.Vector;

public class FirstFragment extends Fragment {

    FragmentFirstBinding binding;
    NoteAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);

        Vector<Note> list = new Vector<>();

        Note item1 = new Note("일상", "점심 약속","동기들과 점심 먹기 :)");
        Note item2 = new Note("수업","모바일 프로그래밍 과제", "프래그먼트 추가하기");

        list.add(item1);
        list.add(item2);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        binding.recyclerView.setLayoutManager(layoutManager);

        adapter = new NoteAdapter(getContext(), list);
        binding.recyclerView.setAdapter(adapter);

        return binding.getRoot();
    }

    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}