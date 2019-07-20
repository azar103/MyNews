package com.zarrouk.anis.mynews.Controllers.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.zarrouk.anis.mynews.Controllers.Activities.DetailActivity;
import com.zarrouk.anis.mynews.Models.Article;
import com.zarrouk.anis.mynews.Models.ResponseModel;
import com.zarrouk.anis.mynews.R;
import com.zarrouk.anis.mynews.Utils.ItemClickSupport;
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
    @BindView(R.id.swipe_layout) SwipeRefreshLayout mSwipeRefreshLayout;
    private Disposable mDisposable;
    private List<Article> mArticles;
    private GeneralAdapter mGeneralAdapter;

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_general_news;
    }

    @Override
    protected void configureDesign()
    {
        this.configureSwipAndRefreshLayout();
        this.configureRecyclerView();
        this.executeHttpRequest();
        this.configureOnClickRecyclerView();
    }

    public static Fragment newInstance() { return (new GeneralNewsFragment()); }


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
        mGeneralAdapter = new GeneralAdapter(mArticles, Glide.with(this));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.recylcerview_divider));
        mRecyclerView.addItemDecoration(dividerItemDecoration);
        mRecyclerView.setAdapter(mGeneralAdapter);
    }

    private void updateUI(List<Article> articles) {
       this.mSwipeRefreshLayout.setRefreshing(false);
       mArticles.clear();
       mArticles.addAll(articles);
       mGeneralAdapter.notifyDataSetChanged();
       this.updateUIAfterHttpConnection();

    }
    private void disposeWhenDestroy(){
        if (this.mDisposable !=null && !this.mDisposable.isDisposed()) this.mDisposable.dispose();
    }
  private void configureSwipAndRefreshLayout(){
        this.mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                executeHttpRequest();
                updateUIAfterHttpConnection();
            }
        });
  }
    private void configureOnClickRecyclerView(){
        ItemClickSupport.addTo(mRecyclerView, R.layout.list_item)
                .setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                    @Override
                    public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                        Article article = mGeneralAdapter.getArticle(position);
                        Intent myIntent = new Intent(getActivity(), DetailActivity.class);
                        myIntent.putExtra("URL", article.getUrl());
                        myIntent.putExtra("SOURCE_NAME", article.getSource().getName());
                        startActivity(myIntent);
                    }
                });

    }
}
