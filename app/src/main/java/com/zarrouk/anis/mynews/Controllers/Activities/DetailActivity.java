package com.zarrouk.anis.mynews.Controllers.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zarrouk.anis.mynews.Controllers.Fragments.DetailFragment;
import com.zarrouk.anis.mynews.R;

public class DetailActivity extends AppCompatActivity {
    private DetailFragment mDetailFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        this.configureAndShowDetailFragment();
    }
   private void configureAndShowDetailFragment(){
        if(mDetailFragment == null){
            mDetailFragment = new DetailFragment();
            getSupportFragmentManager().beginTransaction()
                                       .add(R.id.frame_detail, mDetailFragment)
                                       .commit();
        }

   }

}
