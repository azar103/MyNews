package com.zarrouk.anis.mynews.Controllers.Activities;

import android.os.Build;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.zarrouk.anis.mynews.Views.PageAdapter;

import com.zarrouk.anis.mynews.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    @BindView(R.id.activity_main_tabs)
    TabLayout tabs;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.activity_main_navigation_view)
    NavigationView navigationView;
    @BindView(R.id.activity_main_drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.activity_main_viewpager)
    ViewPager pager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        this.configureAndShowToolBar();
        this.configureAndShowTabsAndViewPager();
        this.configureDrawerLayout();
        this.configureNavigationView();
        this.getDefaultTab();
        this.getDefaultCheckedMenu();
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
                Toast.makeText(this, "pas de paramètres...", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private void configureAndShowToolBar() {
        toolbar.setTitle("My News");
        setSupportActionBar(toolbar);
    }
    private void configureAndShowTabsAndViewPager() {
        pager.setAdapter(new PageAdapter(getSupportFragmentManager()));
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

    @Override
    public void onBackPressed() {
        if(this.drawerLayout.isDrawerOpen(GravityCompat.START)){
            this.drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {

        switch (menuItem.getItemId()){
            case R.id.activity_main_drawer_most_popular:
                pager.setCurrentItem(1);
                break;
            case R.id.activity_main_drawer_topStories:
                pager.setCurrentItem(0);

                break;
            case R.id.activity_main_drawer_world:
                pager.setCurrentItem(2);
                break;
            default:
                break;
        }
        this.drawerLayout.closeDrawer(GravityCompat.START);
        return  true;
    }

    public void configureDrawerLayout(){
        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(this, drawerLayout,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toogle);
        toogle.syncState();
    }
    private  void configureNavigationView(){
        navigationView.setNavigationItemSelectedListener(this);
    }
    private void getDefaultTab(){
        pager.setCurrentItem(0);
    }
    private void getDefaultCheckedMenu(){
        this.navigationView.getMenu().getItem(0).setChecked(true);
    }


}
