package com.example.fragment1_2;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment1 newInstance(String param1, String param2) {
        Fragment1 fragment = new Fragment1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public Fragment1() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // onCreate Log
        Log.i("life-F", "onCreate()");
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_1, container, false);
        // onCreateView Log
        Log.i("life-F", "onCreateView()");

        EditText edtInput = rootView.findViewById(R.id.edtInput);
        Button btnInput = rootView.findViewById(R.id.btnInput);

        btnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = edtInput.getText().toString();

                Bundle bundle = new Bundle();
                bundle.putString("key", s);

                Fragment2 fragment2 = new Fragment2();
                fragment2.setArguments(bundle);
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.rootlayout, fragment2);
                fragmentTransaction.commit();
            }
        });

        return rootView;
    }

    // Fragment1 Log
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i("life-F", "onAttach()");
    }

    @Override
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        Log.i("life-F", "onViewCreated()");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("life-F", "onStart()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("life-F", "onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("life-F", "onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("life-F", "onStop()");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("life-F", "onDestroyView()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("life-F", "onDestroy()");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("life-F", "onDetach()");
    }
}