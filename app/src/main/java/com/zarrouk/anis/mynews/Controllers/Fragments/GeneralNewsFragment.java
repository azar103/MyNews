package com.zarrouk.anis.mynews.Controllers.Fragments;


import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.zarrouk.anis.mynews.Models.Article;
import com.zarrouk.anis.mynews.Models.ResponseModel;
import com.zarrouk.anis.mynews.R;
import com.zarrouk.anis.mynews.Utils.NewsStreams;
import com.zarrouk.anis.mynews.Views.GeneralAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;

/**
 * A simple {@link Fragment} subclass.
 */

public class GeneralNewsFragment extends BaseFragment  {
    @BindView(R.id.progress) ProgressBar mProgressBar;
    @BindView(R.id.list) RecyclerView  mRecyclerView;
    private Disposable mDisposable;
    private List<Article> mArticles;
    private GeneralAdapter mGeneralAdapter;
    public static Fragment newInstance() { return (new GeneralNewsFragment()); }
    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_general_news;
    }

    @Override
    protected void configureDesign()
    {
        this.configureRecyclerView();
        this.executeHttpRequest();
    }



    private void updateUIBeforeHttpConnection() { mProgressBar.setVisibility(View.VISIBLE);
    }
    private void updateUIAfterHttpConnection() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.disposeWhenDestroy();
    }

    private void executeHttpRequest(){
        this.updateUIBeforeHttpConnection();
        this.mDisposable = NewsStreams.streamFetchGeneralNews("fr").subscribeWith(
                new DisposableObserver<ResponseModel>(){
                    @Override
                    public void onNext(ResponseModel responseModel) {
                        List<Article> articles = responseModel.getArticles();
                        updateUI(articles);
                    }

                    @Override
                    public void onError(Throwable e) { }

                    @Override
                    public void onComplete() { }
                });

    }
    private void configureRecyclerView(){
        mArticles = new ArrayList<>();
        mGeneralAdapter = new GeneralAdapter(mArticles);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mGeneralAdapter);
    }
    private void updateUI(List<Article> articles) {
       mArticles.addAll(articles);
       mGeneralAdapter.notifyDataSetChanged();
       this.updateUIAfterHttpConnection();
    }
    private void disposeWhenDestroy(){
        if (this.mDisposable !=null && !this.mDisposable.isDisposed()) this.mDisposable.dispose();
    }

}
