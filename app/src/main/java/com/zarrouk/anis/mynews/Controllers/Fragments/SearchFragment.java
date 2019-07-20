package com.zarrouk.anis.mynews.Controllers.Fragments;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.zarrouk.anis.mynews.Controllers.Activities.Results_Search;
import com.zarrouk.anis.mynews.R;
import com.zarrouk.anis.mynews.Utils.ItemClickSupport;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends BaseFragment implements  View.OnClickListener{

   @BindView(R.id.editText) EditText mEditText;
    @BindView(R.id.checkBox_sports) CheckBox mSportsCheck;
    @BindView(R.id.checkBox_business) CheckBox mBusinessCheck;
    @BindView(R.id.checkBox_technology) CheckBox mTechnologyCheck;
    @BindView(R.id.checkBox_health) CheckBox mHealthCheck;
    @BindView(R.id.checkBox_science) CheckBox mScienceCheck;
    String S;
    private String text="";
    @Override
    protected int getFragmentLayout() { return R.layout.fragment_search; }
    @Override
    protected void configureDesign() {



    }
    public static Fragment newInstance() { return (new SearchFragment()); }





    @OnClick(R.id.search_btn)
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getActivity(), Results_Search.class);
        String query = mEditText.getText().toString();
        if(mSportsCheck.isChecked())
            text = mSportsCheck.getText().toString();
        if(mBusinessCheck.isChecked())
            text = mBusinessCheck.getText().toString();
        if(mHealthCheck.isChecked())
            text = mHealthCheck.getText().toString();
        if(mScienceCheck.isChecked())
            text = mScienceCheck.getText().toString();
        if(mTechnologyCheck.isChecked())
            text = mTechnologyCheck.getText().toString();


        intent.putExtra("CATEGORY", text);
        intent.putExtra("QUERY", query);
        if (query.matches("") ) {
            Toast.makeText(getContext(), "this field is empty", Toast.LENGTH_LONG).show();
        }
        else if(text.matches("")){
            Toast.makeText(getContext(), "check a category", Toast.LENGTH_LONG).show();
        }
        else{
            startActivity(intent);
        }

    }


}
