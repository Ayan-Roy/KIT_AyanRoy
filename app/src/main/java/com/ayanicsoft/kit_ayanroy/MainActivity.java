package com.ayanicsoft.kit_ayanroy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout btnNext;
    ViewPager2 mainViewPager;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnNext = findViewById(R.id.btn_next);
        mainViewPager = findViewById(R.id.main_viewPager);

        FragmentManager fragmentManager = getSupportFragmentManager();
        adapter = new ViewPagerAdapter(fragmentManager, getLifecycle());
        mainViewPager.setAdapter(adapter);

        mainViewPager.setCurrentItem(1);


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentFragment = mainViewPager.getCurrentItem();
                if(currentFragment == 1){
                    mainViewPager.setCurrentItem(0);
                }else{
                    mainViewPager.setCurrentItem(1);
                }
            }
        });


        mainViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }
        });


    }
}