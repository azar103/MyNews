package com.zarrouk.anis.mynews.Controllers.Fragments;


import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.zarrouk.anis.mynews.Adapters.GeneralAdapter;
import com.zarrouk.anis.mynews.Models.Article;
import com.zarrouk.anis.mynews.Models.ResponseModel;
import com.zarrouk.anis.mynews.R;
import com.zarrouk.anis.mynews.Utils.NewsCalls;
import com.zarrouk.anis.mynews.Utils.NewsService;
import com.zarrouk.anis.mynews.Utils.NewsStreams;

import java.util.List;

import butterknife.BindView;
import io.reactivex.disposables.Disposable;
/**
 * A simple {@link Fragment} subclass.
 */

public class GeneralNewsFragment extends BaseFragment implements NewsCalls.CallBacks {
    @BindView(R.id.progress) ProgressBar mProgressBar;
    @BindView(R.id.list) RecyclerView  mRecyclerView;
    private Disposable mDisposable;
    public static Fragment newInstance() { return (new GeneralNewsFragment()); }
    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_general_news;
    }

    @Override
    protected void configureDesign() {
        this.executeHttpConnectionWithRetrofit();
    }

   private void executeHttpConnectionWithRetrofit(){
        updateUIBeforeHttpConnection();
        NewsCalls.fetchGeneralNews(this,"fr");
   }

    private void updateUIBeforeHttpConnection() { mProgressBar.setVisibility(View.VISIBLE);
    }
    private void updateUIAfterHttpConnection() {
        mProgressBar.setVisibility(View.GONE);
    }

    private void configureRecyclerView(List<Article> posts){
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(new GeneralAdapter(posts));
    }

    @Override
    public void onResponse(List<Article> posts) {

        this.configureRecyclerView(posts);
        this.updateUIAfterHttpConnection();

    }

    @Override
    public void onFailure() {
        Log.d("TAG","Error in on Failure");
        this.updateUIAfterHttpConnection();
    }
}
