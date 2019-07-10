package com.zarrouk.anis.mynews.Controllers.Fragments;


import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.zarrouk.anis.mynews.Adapters.SportsAdapter;
import com.zarrouk.anis.mynews.Models.TopStoriesStream.Article;
import com.zarrouk.anis.mynews.R;

import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class SportsFragment extends BaseFragment implements NewsCalls.CallBacksTopStories{
    @BindView(R.id.progress) ProgressBar mProgressBar;
    @BindView(R.id.list) RecyclerView rv;

    public static Fragment newInstance() { return (new SportsFragment()); }


    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_world;
    }

    @Override
    protected void configureDesign() {
      this.executeHttpRequest();
    }

   private void executeHttpRequest(){
        this.updateUIBeforeTask();
    // NewsCalls.fetchSports(this);
   }
    private void updateUIBeforeTask(){
        mProgressBar.setVisibility(View.VISIBLE);
    }

    private void updateUIAfterTask(){
        mProgressBar.setVisibility(View.GONE);
    }


    @Override
    public void onResponse(List<Article> posts) {
        rv.setAdapter(new SportsAdapter(posts));
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        this.updateUIAfterTask();
    }

    @Override
    public void onFailure() {
        this.updateUIAfterTask();

    }
}
