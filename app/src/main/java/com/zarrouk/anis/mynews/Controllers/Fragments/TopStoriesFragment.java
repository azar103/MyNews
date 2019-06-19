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
public class TopStoriesFragment extends Fragment {


    public TopStoriesFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance() {

        return (new TopStoriesFragment());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_top_stories, container, false);
    }

}
