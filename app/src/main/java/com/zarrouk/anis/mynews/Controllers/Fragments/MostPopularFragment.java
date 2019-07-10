package com.zarrouk.anis.mynews.Controllers.Fragments;

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;


import com.zarrouk.anis.mynews.Adapters.MostPopularAdapter;
import com.zarrouk.anis.mynews.Models.MostPopularStream.ArticleMostPopular;
import com.zarrouk.anis.mynews.R;

import java.util.List;

import butterknife.BindView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MostPopularFragment extends BaseFragment implements NewsCalls.CallBacksMostPopular {
    @BindView(R.id.progress) ProgressBar mProgressBar;
    @BindView(R.id.list) RecyclerView  mRecyclerView;
    public static Fragment newInstance() { return (new MostPopularFragment()); }
    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_top_stories;
    }

    @Override
    protected void configureDesign() { this.executeHttpConnectionWithRetrofit(); }

    private void executeHttpConnectionWithRetrofit(){
        this.updateUIBeforeHttpConnection();
        NewsCalls.fetchMostPopular(this);
    }
    @Override
    public void onResponse(List<ArticleMostPopular> posts) {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(new MostPopularAdapter(posts));
        this.updateUIAfterHttpConnection();

    }

    @Override
    public void onFailure() {
        this.updateUIAfterHttpConnection();
        Log.e("TAG","error in onFailure!!");
    }

    private void updateUIBeforeHttpConnection() { mProgressBar.setVisibility(View.VISIBLE);
    }
    private void updateUIAfterHttpConnection() {
        mProgressBar.setVisibility(View.GONE);
    }
}
