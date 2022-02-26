package com.example.fragment_project;

import android.content.Context;
import android.os.Bundle;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class Bridge extends FragmentStateAdapter {

    ArrayList<String> values;
//    ArrayList<Integer> images;
//    String header;
    private Context context;
    int totalTabs;


    public Bridge(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public Bridge(@NonNull Fragment fragment) {
        super(fragment);

    }

    public Bridge(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
        values = new ArrayList<>();
//        images = new ArrayList<>();

        values.add("Home");
        values.add("Blog");
        values.add("Login/Register");

//        images.add(R.id.img1);
//        images.add(R.id.img2);



    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
//        Home home = new Home();
//        Bundle bundle = new Bundle();
//        bundle.putString("Home", values.get(position));
//        home.setArguments(bundle);
//        return home;\

        switch (position) {
            case 0:
                Home home = new Home();
                return home;
            case 1:
                Blog blog = new Blog();
                return blog;
            case 2 :
                LoginRegister loginRegister = new LoginRegister();
                return loginRegister;
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return values.size();
    }


}
