package com.zarrouk.anis.mynews.Controllers.Fragments;


import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.zarrouk.anis.mynews.Adapters.GeneralAdapter;
import com.zarrouk.anis.mynews.Adapters.SportsAdapter;
import com.zarrouk.anis.mynews.Models.Article;
import com.zarrouk.anis.mynews.R;
import com.zarrouk.anis.mynews.Utils.NewsCalls;

import java.util.List;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class SportsFragment extends BaseFragment implements NewsCalls.CallBacks{
    @BindView(R.id.progress) ProgressBar mProgressBar;
    @BindView(R.id.list) RecyclerView mRecyclerView;

    public static Fragment newInstance() { return (new SportsFragment()); }
    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_sports;
    }

    @Override
    protected void configureDesign() {
        this.executeHttpConnectionWithRetrofit();
    }

    private void executeHttpConnectionWithRetrofit(){
        updateUIBeforeHttpConnection();
        NewsCalls.fetchSectionNews(this, "fr","sports");
    }

    private void updateUIBeforeHttpConnection() { mProgressBar.setVisibility(View.VISIBLE);
    }
    private void updateUIAfterHttpConnection() {
        mProgressBar.setVisibility(View.GONE);
    }

    private void configureRecyclerView(List<Article> posts){
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(new SportsAdapter(posts));
    }

    @Override
    public void onResponse(List<Article> posts) {

        this.configureRecyclerView(posts);
        this.updateUIAfterHttpConnection();

    }

    @Override
    public void onFailure() {
        Log.d("TAG", "Error in on Failure");
        this.updateUIAfterHttpConnection();
    }

}
