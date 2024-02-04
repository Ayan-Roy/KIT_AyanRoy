package com.ayanicsoft.kit_ayanroy.adapter;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.ayanicsoft.kit_ayanroy.fragment.FragmentNomineeInfo;
import com.ayanicsoft.kit_ayanroy.fragment.FragmentPersonalInfo;

public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0){
            return new FragmentPersonalInfo();
        }
        return new FragmentNomineeInfo();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}