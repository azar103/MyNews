package com.zarrouk.anis.mynews.Controllers.Fragments;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.zarrouk.anis.mynews.Controllers.Activities.DetailActivity;
import com.zarrouk.anis.mynews.Models.ResponseModel;
import com.zarrouk.anis.mynews.Utils.ItemClickSupport;
import com.zarrouk.anis.mynews.Utils.NewsStreams;
import com.zarrouk.anis.mynews.Views.NewsAdapter;
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
    @BindView(R.id.swipe_layout) SwipeRefreshLayout mSwipeRefreshLayout;
    private Disposable mDisposable;
    private NewsAdapter mAdapter;
    private List<Article> mArticles;
    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_sports;
    }

    @Override
    protected void configureDesign() {
        this.configureSwipAndRefreshLayout();
        this.configureRecyclerView();
        this.executeHttpConnection();
        this.configureOnClickRecyclerView();
    }

    public static Fragment newInstance() { return (new SportsFragment()); }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.disposeWhenDestroyed();
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
        mAdapter = new NewsAdapter(mArticles, Glide.with(this));
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.mRecyclerView.setAdapter(mAdapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.recylcerview_divider));
        mRecyclerView.addItemDecoration(dividerItemDecoration);
    }
    private void updateUI(List<Article> articles){
        this.mSwipeRefreshLayout.setRefreshing(false);
        this.mArticles.clear();

        mArticles.addAll(articles);
        mAdapter.notifyDataSetChanged();
        this.updateUIAfterHttpConnection();


    }
    private void configureSwipAndRefreshLayout(){
        this.mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                executeHttpConnection();
                updateUIAfterHttpConnection();
            }
        });
    }
    private void disposeWhenDestroyed(){
        if (this.mDisposable!=null && !this.mDisposable.isDisposed()) this.mDisposable.dispose();
    }
    private void configureOnClickRecyclerView(){
        ItemClickSupport.addTo(mRecyclerView, R.layout.list_item)
                .setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                    @Override
                    public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                        Article article = mAdapter.getArticle(position);
                        Intent myIntent = new Intent(getActivity(), DetailActivity.class);
                        myIntent.putExtra("URL", article.getUrl());
                        myIntent.putExtra("SOURCE_NAME", article.getSource().getName());
                        startActivity(myIntent);
                    }
                });

    }
}
