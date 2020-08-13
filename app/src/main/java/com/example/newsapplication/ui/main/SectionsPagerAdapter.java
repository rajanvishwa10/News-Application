package com.example.newsapplication.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.newsapplication.Fragment.BitCoinFragment;
import com.example.newsapplication.Fragment.BusinessFragment;
import com.example.newsapplication.Fragment.AppleFragment;
import com.example.newsapplication.Fragment.TechCrunchFragment;
import com.example.newsapplication.Fragment.EntertainmentFragment;
import com.example.newsapplication.Fragment.HealthFragment;
import com.example.newsapplication.Fragment.MainFragment;
import com.example.newsapplication.Fragment.ScienceFragment;
import com.example.newsapplication.Fragment.SportsFragment;
import com.example.newsapplication.Fragment.TechnologyFragment;
import com.example.newsapplication.Fragment.GlobalnewsFragment;
import com.example.newsapplication.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_0,R.string.tab_text_1, R.string.tab_text_2,R.string.tab_text_3,R.string.tab_text_4,R.string.tab_text_5,
            R.string.tab_text_6,R.string.tab_text_7,R.string.tab_text_8,R.string.tab_text_9,R.string.tab_text_10};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new MainFragment();
                break;
            case 1:
                fragment = new GlobalnewsFragment();
                break;
            case 2:
                fragment = new BusinessFragment();
                break;
            case 3:
                fragment = new SportsFragment();
                break;
            case 4:
                fragment = new EntertainmentFragment();
                break;
            case 5:
                fragment = new ScienceFragment();
                break;
            case 6:
                fragment = new TechnologyFragment();
                break;
            case 7:
                fragment = new HealthFragment();
                break;
            case 8:
                fragment = new TechCrunchFragment();
                break;
            case 9:
                fragment = new AppleFragment();
                break;
            case 10:
                fragment = new BitCoinFragment();
                break;
        }
        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 11;
    }
}