package com.zarrouk.anis.mynews.Controllers.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zarrouk.anis.mynews.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class WorldFragment extends BaseFragment {

    public static Fragment newInstance() { return (new WorldFragment());
    }


    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_world;
    }

    @Override
    protected void configureDesign() {}



}
