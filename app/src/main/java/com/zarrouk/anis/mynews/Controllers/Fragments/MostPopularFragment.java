package com.zarrouk.anis.mynews.Controllers.Fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;


import com.zarrouk.anis.mynews.Adapters.MostPopularAdapter;
import com.zarrouk.anis.mynews.Models.News;
import com.zarrouk.anis.mynews.R;
import com.zarrouk.anis.mynews.Utils.MyAsyncTask;

import java.util.ArrayList;
import java.util.List;



/**
 * A simple {@link Fragment} subclass.
 */
public class MostPopularFragment extends BaseFragment implements MyAsyncTask.Listeners {

    List<News> myNews;


    public static Fragment newInstance() { return (new MostPopularFragment()); }

    @Override
    protected int getFragmentLayout() { return R.layout.fragment_most_popular; }

    @Override
    protected void configureDesign() {
        this.addNews();
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(new MostPopularAdapter(myNews));
        this.startAsyncTask();
    }





    private void addNews(){
        this.myNews = new ArrayList<News>();
        myNews.add(new News("World", "Jims Mattis says He And Trump Never"));
        myNews.add(new News("Style", "24 Hours in America"));
        myNews.add(new News("Style", "A Dark Screen about Screens And Kids"));
        myNews.add(new News("World", "Jims Mattis says He And Trump Never"));
        myNews.add(new News("Style", "24 Hours in America"));
        myNews.add(new News("Style", "A Dark Screen about Screens And Kids"));
        myNews.add(new News("World", "Jims Mattis says He And Trump Never"));
        myNews.add(new News("Style", "24 Hours in America"));
        myNews.add(new News("Style", "A Dark Screen about Screens And Kids"));
    }
    private void startAsyncTask(){
        new MyAsyncTask(this).execute();
    }
    @Override
    public void onPostExecute(Long success) {
           this.updateUIAfterTask();
    }
    @Override
    public void onPreExecute() {
        this.updateUIBeforeTask();

    }

    @Override
    public void doInBackground() { }
    private void updateUIBeforeTask(){
        mProgressBar.setVisibility(View.VISIBLE);
    }

    private void updateUIAfterTask(){
        mProgressBar.setVisibility(View.GONE);
    }
}
