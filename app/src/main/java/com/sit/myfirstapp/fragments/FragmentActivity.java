package com.sit.myfirstapp.fragments;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sit.myfirstapp.R;

public class FragmentActivity extends AppCompatActivity implements Test1Fragment.OnEvaluateListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
    }

    @Override
    public void onEvaluate(String evaluated) {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag("test2");
        if (fragment != null) {
            ((Test2Fragment) fragment).setEvaluated(evaluated);
        } else {
            SecondFragmentActivity.launch(this, evaluated);
        }
    }
}
