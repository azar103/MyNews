package com.zarrouk.anis.mynews.Adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.zarrouk.anis.mynews.Controllers.Fragments.MostPopularFragment;
import com.zarrouk.anis.mynews.Controllers.Fragments.TopStoriesFragment;
import com.zarrouk.anis.mynews.Controllers.Fragments.WorldFragment;

/**
 * Created by Anis Zarrouk on 17/06/2019
 */
public class PageAdapter extends FragmentPagerAdapter {
    public PageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return TopStoriesFragment.newInstance();
            case 1:
                return MostPopularFragment.newInstance();
            case 2:
                return WorldFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return (3);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Top Stories";
            case 1:
                return  "Most Popular";
            case 2:
                return  "World";
            default:
                return  null;
        }
    }
}
