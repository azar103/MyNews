package com.zarrouk.anis.mynews.Controllers.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.zarrouk.anis.mynews.R;
import com.zarrouk.anis.mynews.Utils.MyAsyncTask;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseFragment  extends Fragment   {


    protected @BindView(R.id.progress)
    ProgressBar mProgressBar;
    protected @BindView(R.id.list)
    RecyclerView rv;

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
