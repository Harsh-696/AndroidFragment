package com.example.fragment_project;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class Blog extends Fragment {

    private RecyclerView recyclerView;
    private List<String> comments;
    private List<Integer> images;
    Details_Adapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_blog, container, false);
        recyclerView = view.findViewById(R.id.content);
        comments = new ArrayList<>();
        images = new ArrayList<>();

        images.add(R.drawable.one);
        images.add(R.drawable.three);
        images.add(R.drawable.four);
        images.add(R.drawable.five);
        images.add(R.drawable.six);
        images.add(R.drawable.baryon);

        comments.add("Sharingan");
        comments.add("Feel the pain");
        comments.add("One Eye");
        comments.add("Greatest Shinobi's");
        comments.add("Immortal");
        comments.add("God Mode");

        adapter = new Details_Adapter(getContext(), comments, images);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


        return view;
    }
}