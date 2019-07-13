package com.zarrouk.anis.mynews.Controllers.Fragments;

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.zarrouk.anis.mynews.Models.ResponseModel;
import com.zarrouk.anis.mynews.Utils.NewsStreams;
import com.zarrouk.anis.mynews.Views.BusinessAdapter;
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
    private List<Article> articles;
    private BusinessAdapter mBusinessAdapter;
    private Disposable mDisposable;

    public static Fragment newInstance() { return (new BusinessFragment()); }
    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_business;
    }

    @Override
    protected void configureDesign() {
        this.configureRecyclerView();
        this.executeHttpRequest();
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
        this.mBusinessAdapter = new BusinessAdapter(this.articles);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(this.mBusinessAdapter);
    }
    private void updateUI(List<Article> articles){
        this.articles.addAll(articles);
        this.mBusinessAdapter.notifyDataSetChanged();
        this.updateUIAfterHttpConnection();
    }


}
