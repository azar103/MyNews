package com.zarrouk.anis.mynews.Controllers.Activities;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.zarrouk.anis.mynews.Controllers.Fragments.SearchFragment;
import com.zarrouk.anis.mynews.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchActivity extends AppCompatActivity {
    private SearchFragment mSearchFragment;
    @BindView(R.id.toolbar) Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        this.configureAndShowSearchFragment();
        this.configureAndShowToolbar();
    }
    private void configureAndShowSearchFragment(){
        mSearchFragment =(SearchFragment)getSupportFragmentManager().findFragmentById(R.id.frame_layout_search);
        if(mSearchFragment == null){
            mSearchFragment = new SearchFragment();
            getSupportFragmentManager().beginTransaction()
                                       .add(R.id.frame_layout_search, mSearchFragment)
                                       .commit();
        }

    }
    private void configureAndShowToolbar(){
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        setTitle("Search Articles");

    }
}
