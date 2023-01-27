package com.example.new_mobile_project.Adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.new_mobile_project.Fragments.MobileFragment;
import com.example.new_mobile_project.Fragments.PerfumesFragment;
import com.example.new_mobile_project.Fragments.SunblockFragment;

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    private int numoftabs;
    public SimpleFragmentPagerAdapter(FragmentManager fm, int numoftabs) {
        super(fm);
        this.numoftabs = numoftabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0 :
                return new MobileFragment();
            case 1:
                return new SunblockFragment();
            case 2:
                return new PerfumesFragment();

        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        switch (position){
            case 0:
                return "Mobile";
            case 1:
                return "Sunblock";
            case 2:
                return "Perfumes";
        }
        return super.getPageTitle(position);
    }
}
