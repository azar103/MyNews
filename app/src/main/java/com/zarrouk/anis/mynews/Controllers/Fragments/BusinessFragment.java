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
 * Created by Anis Zarrouk on 11/07/2019
 */
public class BusinessFragment extends BaseFragment {
    @BindView(R.id.progress) ProgressBar mProgressBar;
    @BindView(R.id.list)  RecyclerView mRecyclerView;
    @BindView(R.id.swipe_layout) SwipeRefreshLayout mSwipeRefreshLayout;
    private List<Article> articles;
    private NewsAdapter mAdapter;
    private Disposable mDisposable;

    public static Fragment newInstance() { return (new BusinessFragment()); }
    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_business;
    }

    @Override
    protected void configureDesign() {
        this.configureSwipAndRefreshLayout();
        this.configureRecyclerView();
        this.executeHttpRequest();
        this.configureOnClickRecyclerView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.disposeWhenDestroyed();
    }

    private void executeHttpRequest() {
        this.updateUIBeforeHttpConnection();
        this.mDisposable = NewsStreams.streamFetchSectionNews("fr", "business").subscribeWith(new DisposableObserver<ResponseModel>() {
            @Override
            public void onNext(ResponseModel responseModel) {
                List<Article> articles = responseModel.getArticles();
                updateUI(articles);
            }

            @Override
            public void onComplete() {
            }

            @Override
            public void onError(Throwable e) {
            }
        });
    }

    private void updateUIBeforeHttpConnection() { mProgressBar.setVisibility(View.VISIBLE);
    }
    private void updateUIAfterHttpConnection() {
        mProgressBar.setVisibility(View.GONE);
    }

    private void configureRecyclerView(){
        this.articles = new ArrayList<>();
        this.mAdapter = new NewsAdapter(this.articles, Glide.with(this));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(this.mAdapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.recylcerview_divider));
        mRecyclerView.addItemDecoration(dividerItemDecoration);
    }
    private void updateUI(List<Article> articles){
        this.mSwipeRefreshLayout.setRefreshing(false);
        this.articles.clear();
        this.articles.addAll(articles);
        this.mAdapter.notifyDataSetChanged();
        this.updateUIAfterHttpConnection();
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
