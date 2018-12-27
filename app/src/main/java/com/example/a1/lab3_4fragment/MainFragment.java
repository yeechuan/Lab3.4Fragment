package com.example.a1.lab3_4fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class MainFragment extends Fragment implements OnClickListener{
    private OnMainTitleListener mCallback;
    Button buttonFirst, buttonSecond;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        buttonFirst = (Button) view.findViewById(R.id.buttonFirst);
        buttonFirst.setOnClickListener(this);
        buttonSecond = (Button) view.findViewById(R.id.buttonSecond);
        buttonSecond.setOnClickListener(this);
        return view;
    }
    public interface OnMainTitleListener{
        public void getTitle(String title);
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            mCallback = (OnMainTitleListener) activity;
        }catch(ClassCastException e){
            throw new ClassCastException(activity.toString()
                    + " must implement OnMainTitleListener");
        }
    }
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.buttonFirst:
                mCallback.getTitle("First");
                break;
            case R.id.buttonSecond:
                mCallback.getTitle("Second");
                break;
        }
    }
}
