package com.zarrouk.anis.mynews.Controllers.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zarrouk.anis.mynews.R;

import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseFragment extends Fragment {




    protected  abstract int getFragmentLayout();
    protected  abstract void configureDesign();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(getFragmentLayout(), container, false );
        // Binding Views
        ButterKnife.bind(this, view);
        this.configureDesign();
        return(view);
    }

}
