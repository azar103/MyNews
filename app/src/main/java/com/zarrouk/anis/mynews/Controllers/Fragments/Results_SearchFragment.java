package com.zarrouk.anis.mynews.Controllers.Fragments;


import android.content.Intent;
import android.support.v4.app.Fragment;
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
import com.zarrouk.anis.mynews.Views.NewsAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;

/**
 * A simple {@link Fragment} subclass.
 */
public class Results_SearchFragment extends BaseFragment {

   Disposable mDisposable;
   NewsAdapter mAdapter;
   List<Article> mArticles;
   @BindView(R.id.list) RecyclerView mRecyclerView;
   @BindView(R.id.progress) ProgressBar mProgressBar;


    @Override
    protected int getFragmentLayout() { return R.layout.fragment_results__search; }

    @Override
    protected void configureDesign() {
        this.configureRecyclerView();
        this.executeHttpRequest();
        this.configureRecyclerViewItemClicked();
    }


    private void executeHttpRequest(){
        String queryString = getActivity().getIntent().getStringExtra("QUERY");
        String categoryString = getActivity().getIntent().getStringExtra("CATEGORY");
        this.mDisposable = NewsStreams.streamFetchSectionNewsBySearch("fr", categoryString,queryString).subscribeWith(new DisposableObserver<ResponseModel>(){
            @Override
            public void onNext(ResponseModel responseModel) {
                updateUIBeforeHttpConnection();
                 updateUI(responseModel.getArticles());
            }
            @Override
            public void onError(Throwable e) { }

            @Override
            public void onComplete() { }
        });
    }
    private void configureRecyclerView(){
       mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
       mArticles = new ArrayList<>();
       mAdapter = new NewsAdapter(mArticles, Glide.with(this));
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.disposeWhenDestroy();
    }

    private void updateUI(List<Article> articles){
        mArticles.addAll(articles);
        mAdapter.notifyDataSetChanged();
        if(articles.size() == 0)
            Toast.makeText(getContext(), "No results", Toast.LENGTH_LONG).show();
        updateUIAfterHttpConnection();

    }
    private void updateUIBeforeHttpConnection() { mProgressBar.setVisibility(View.VISIBLE);
    }
    private void updateUIAfterHttpConnection() {
        mProgressBar.setVisibility(View.GONE);
    }
    private void configureRecyclerViewItemClicked(){
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
    private void disposeWhenDestroy(){
        if (this.mDisposable !=null && !this.mDisposable.isDisposed()) this.mDisposable.dispose();
    }

}
