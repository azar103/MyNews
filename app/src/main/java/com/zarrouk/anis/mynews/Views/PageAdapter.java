package com.zarrouk.anis.mynews.Views;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.zarrouk.anis.mynews.Controllers.Fragments.BusinessFragment;
import com.zarrouk.anis.mynews.Controllers.Fragments.GeneralNewsFragment;
import com.zarrouk.anis.mynews.Controllers.Fragments.SportsFragment;



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
                return GeneralNewsFragment.newInstance();
            case 1:
                return SportsFragment.newInstance();
            case 2:
                return BusinessFragment.newInstance();
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
                return "General";
            case 1:
                return  "Sports";
            case 2:
                return  "business";
            default:
                return  null;
        }
    }
}
