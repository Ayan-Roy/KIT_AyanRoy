package com.ayanicsoft.kit_ayanroy.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.ayanicsoft.kit_ayanroy.R;
import com.ayanicsoft.kit_ayanroy.adapter.ViewPagerAdapter;
import com.ayanicsoft.kit_ayanroy.fragment.FragmentNomineeInfo;
import com.ayanicsoft.kit_ayanroy.fragment.FragmentPersonalInfo;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    LinearLayout btnNext, btnPrevious;
    MaterialButton btnClearAll;
    ViewPager2 mainViewPager;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnNext = findViewById(R.id.btn_next);
        btnPrevious = findViewById(R.id.btn_previous);
        btnClearAll = findViewById(R.id.btn_clear_all);
        mainViewPager = findViewById(R.id.main_viewPager);

        FragmentManager fragmentManager = getSupportFragmentManager();
        adapter = new ViewPagerAdapter(fragmentManager, getLifecycle());
        mainViewPager.setAdapter(adapter);

        mainViewPager.setCurrentItem(0);
        mainViewPager.setUserInputEnabled(false);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mainViewPager.getCurrentItem() == 0) {
                    mainViewPager.setCurrentItem(1);
                    btnPrevious.setVisibility(View.VISIBLE);
                } else {
                    if (FragmentNomineeInfo.getHasNominee()) {
                        int numOfNominee = FragmentNomineeInfo.getNumOfNominee();
                        if (numOfNominee < 2) {
                            Toast.makeText(MainActivity.this, "You must add minimum 2 Nominees", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "Everything is ok. Ready for fetch all Data..", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "Everything is ok. Ready for fetch all Data..", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainViewPager.setCurrentItem(0);
                btnPrevious.setVisibility(View.INVISIBLE);
            }
        });

        mainViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }
        });


        btnClearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentPersonalInfo.clearAllData();
            }
        });

    }
}