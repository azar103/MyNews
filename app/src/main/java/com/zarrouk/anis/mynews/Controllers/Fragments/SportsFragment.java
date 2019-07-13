package com.zarrouk.anis.mynews.Controllers.Fragments;


import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.zarrouk.anis.mynews.Models.ResponseModel;
import com.zarrouk.anis.mynews.Utils.NewsStreams;
import com.zarrouk.anis.mynews.Views.SportsAdapter;
import com.zarrouk.anis.mynews.Models.Article;
import com.zarrouk.anis.mynews.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;

/**
 * A simple {@link Fragment} subclass.
 */
public class SportsFragment extends BaseFragment {
    @BindView(R.id.progress) ProgressBar mProgressBar;
    @BindView(R.id.list) RecyclerView mRecyclerView;
    private Disposable mDisposable;
    private SportsAdapter mSportsAdapter;
    private List<Article> mArticles;
    public static Fragment newInstance() { return (new SportsFragment()); }
    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_sports;
    }

    @Override
    protected void configureDesign() {
        this.configureRecyclerView();
        this.executeHttpConnection();
    }

    private void executeHttpConnection(){
        updateUIBeforeHttpConnection();
        this.mDisposable = NewsStreams.streamFetchSectionNews("fr","sports").subscribeWith(new DisposableObserver<ResponseModel>(){
            @Override
            public void onNext(ResponseModel responseModel) {
                List<Article> mArticles = responseModel.getArticles();
                updateUI(mArticles);
            }


            @Override
            public void onError(Throwable e) { }

            @Override
            public void onComplete() { }
        });

    }

    private void updateUIBeforeHttpConnection() { mProgressBar.setVisibility(View.VISIBLE);
    }
    private void updateUIAfterHttpConnection() {
        mProgressBar.setVisibility(View.GONE);
    }

    private void configureRecyclerView(){
        mArticles = new ArrayList<>();
        mSportsAdapter = new SportsAdapter(mArticles);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.mRecyclerView.setAdapter(mSportsAdapter);
    }
    private void updateUI(List<Article> articles){
        mArticles.addAll(articles);
        mSportsAdapter.notifyDataSetChanged();
        this.updateUIAfterHttpConnection();

    }
}
