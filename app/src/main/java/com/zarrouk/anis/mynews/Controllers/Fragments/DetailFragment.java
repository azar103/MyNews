package com.zarrouk.anis.mynews.Controllers.Fragments;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.zarrouk.anis.mynews.R;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {


   Toolbar mToolbar;
    ProgressBar mProgressBar;
   WebView mWebView;

    public DetailFragment() { }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false );
        mToolbar = (Toolbar)view.findViewById(R.id.toolbar);
        mProgressBar = (ProgressBar)view.findViewById(R.id.progress);
        mWebView = (WebView)view.findViewById(R.id.webView);
        this.configureWebView();
        this.configureToolBar();
        return  view;
    }

    public static Fragment newInstance() { return (new BusinessFragment()); }

    private void configureWebView(){
        String url = getActivity().getIntent().getStringExtra("URL");
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                mProgressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                mProgressBar.setVisibility(View.GONE);
            }
        });
        mWebView.loadUrl(url);

    }
    private void configureToolBar(){
        ((AppCompatActivity)getActivity()).setSupportActionBar(mToolbar);
        String source = getActivity().getIntent().getStringExtra("SOURCE_NAME");
        ((AppCompatActivity)getActivity()).setTitle(source);
        ActionBar ab = ((AppCompatActivity)getActivity()).getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
    }


}
