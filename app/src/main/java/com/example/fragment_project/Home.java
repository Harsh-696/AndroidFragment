package com.example.fragment_project;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class Home extends Fragment {


    public Home() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);

//        TextView textView = view.findViewById(R.id.txt);
//        String text = getArguments().getString("Home");
//        ImageView imageView = view.findViewById(R.id.img1);
//        ImageView imageView1 = view.findViewById(R.id.img2);

//        Integer i = getArguments().getInt("Home");
//        imageView.setImageResource(i);

//        textView.setText(text);

//    }
}