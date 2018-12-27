package com.example.a1.lab3_4fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends FragmentActivity implements MainFragment.OnMainTitleListener, SubFragment.OnAssignTitle{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void getTitle(String title) {//Defined in MainFragment interface
        if(title.length()>0){
            setTitle(title);
        }else
            Log.d("Main", "title is empty.");
    }

    @Override
    public void setTitle(String title) { //Defined in SubFragment interface
        SubFragment fragment = (SubFragment)getSupportFragmentManager().findFragmentById(R.id.fragmentSub);
        fragment.assignTitle(title);
    }
}