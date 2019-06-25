package com.zarrouk.anis.mynews.Controllers.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zarrouk.anis.mynews.Adapters.TopStoriesAdapter;
import com.zarrouk.anis.mynews.Models.News;
import com.zarrouk.anis.mynews.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopStoriesFragment extends BaseFragment {
    @BindView(R.id.list)
    RecyclerView rv;
    List<News> myNews;

    public static Fragment newInstance() { return (new TopStoriesFragment()); }

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_top_stories;
    }

    @Override
    protected void configureDesign() {
        this.myNews = new ArrayList<News>();
        myNews.add(new News("World", "Jims Mattis says He And Trump Never"));
        myNews.add(new News("Style", "24 Hours in America"));
        myNews.add(new News("Style", "A Dark Screen about Screens And Kids"));
        myNews.add(new News("World", "Jims Mattis says He And Trump Never"));
        myNews.add(new News("Style", "24 Hours in America"));
        myNews.add(new News("Style", "A Dark Screen about Screens And Kids"));
        myNews.add(new News("World", "Jims Mattis says He And Trump Never"));
        myNews.add(new News("Style", "24 Hours in America"));
        myNews.add(new News("Style", "A Dark Screen about Screens And Kids"));
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(new TopStoriesAdapter(myNews));
    }



}
