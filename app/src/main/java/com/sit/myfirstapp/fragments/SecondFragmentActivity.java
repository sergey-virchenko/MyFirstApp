package com.sit.myfirstapp.fragments;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sit.myfirstapp.R;

public class SecondFragmentActivity extends AppCompatActivity {

    public static void launch(Context context, String evaluatedText) {
        Intent i = new Intent(context, SecondFragmentActivity.class);
        i.putExtra(Test2Fragment.KEY_EVALUATED_TEXT, evaluatedText);
        context.startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_fragment);

        String evaluated = getIntent().getStringExtra(Test2Fragment.KEY_EVALUATED_TEXT);

        getSupportFragmentManager().beginTransaction().add(R.id.container, Test2Fragment.getFragment(evaluated)).commit();
    }
}
