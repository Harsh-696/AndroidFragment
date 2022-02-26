package com.example.fragment_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    TabLayout layout;
    ViewPager2 viewPager;
    Bridge bridge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        layout.addTab(layout.newTab().setText("Home"));
        layout.addTab(layout.newTab().setText("Blog"));
        layout.addTab(layout.newTab().setText("Login/Register"));

        layout.setTabGravity(TabLayout.GRAVITY_FILL);

        bridge = new Bridge(getSupportFragmentManager(), getLifecycle());
        viewPager.setAdapter(bridge);

        layout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                layout.selectTab(layout.getTabAt(position));
            }
        });

//        new TabLayoutMediator(layout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
//            @Override
//            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
//                tab.setText(bridge.values.get(position));
//            }
//        });
    }
}