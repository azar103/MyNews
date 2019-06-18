package com.zarrouk.anis.mynews.Controllers.Activities;

import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.zarrouk.anis.mynews.Adapters.PageAdapter;
import com.zarrouk.anis.mynews.R;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabs;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.configureAndShowToolBar();
        this.configureAndShowTabsAndViewPager();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_item_search:
                Toast.makeText(this, "il n'y a rien à rechercher....", Toast.LENGTH_LONG).show();
                return true;
            case R.id.menu_item_params:
                Toast.makeText(this, "pas de paramétres...", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private void configureAndShowToolBar() {
        Toolbar toolbar =(Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("My News");
        setSupportActionBar(toolbar);
    }
    private void configureAndShowTabsAndViewPager() {
        ViewPager pager = (ViewPager)findViewById(R.id.activity_main_viewpager);
        pager.setAdapter(new PageAdapter(getSupportFragmentManager()));
        tabs = (TabLayout)findViewById(R.id.activity_main_tabs);
        tabs.setupWithViewPager(pager);
        tabs.setTabMode(TabLayout.MODE_FIXED);
        tabs.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
              if(tab.getPosition() == 0){
                  tabs.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.firstTabColor));
                  toolbar =(Toolbar)findViewById(R.id.toolbar);
                  toolbar.setBackgroundColor(ContextCompat.getColor(getBaseContext(), R.color.firstTabColor));
                  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                      getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,
                                                                           R.color.firstTabColor));
                  }
              }else if(tab.getPosition() == 1){
                  tabs.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.secondTabColor));
                  toolbar =(Toolbar)findViewById(R.id.toolbar);
                  toolbar.setBackgroundColor(ContextCompat.getColor(getBaseContext(), R.color.secondTabColor));
                  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                      getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,
                                                                           R.color.secondTabColor));
                  }
              }else{
                  tabs.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.thirdTabColor));
                  toolbar =(Toolbar)findViewById(R.id.toolbar);
                  toolbar.setBackgroundColor(ContextCompat.getColor(getBaseContext(), R.color.thirdTabColor));
                  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                      getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,
                                                                           R.color.thirdTabColor));
                  }
              }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

}
