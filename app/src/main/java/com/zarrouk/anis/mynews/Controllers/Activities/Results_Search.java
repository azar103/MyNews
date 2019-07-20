package com.zarrouk.anis.mynews.Controllers.Activities;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.zarrouk.anis.mynews.Controllers.Fragments.Results_SearchFragment;
import com.zarrouk.anis.mynews.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Results_Search extends AppCompatActivity {
    @BindView(R.id.toolbar) Toolbar mToolbar;
    private Results_SearchFragment mResults_searchFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results__search);
        ButterKnife.bind(this);
        this.configureAndShowToolbar();
        this.configureAndShowResultsSearchFragment();
    }
    private void configureAndShowToolbar() {
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        setTitle("Results Search");
    }
    private void configureAndShowResultsSearchFragment(){
         mResults_searchFragment = (Results_SearchFragment)getSupportFragmentManager().findFragmentById(R.id.frame_layout_search_results);
         if(mResults_searchFragment == null){
             mResults_searchFragment = new Results_SearchFragment();
             getSupportFragmentManager().beginTransaction()
                                        .add(R.id.frame_layout_search_results, mResults_searchFragment)
                                        .commit();
         }

    }
}
