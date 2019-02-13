package com.sit.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.sit.myfirstapp.sensors.CompassActivity;
import com.sit.myfirstapp.sensors.SensorTestActivity;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        startService(new Intent(this, MyService.class));

        findViewById(R.id.compass).setOnClickListener(v -> startActivity(new Intent(this, CompassActivity.class)));
        findViewById(R.id.sensors).setOnClickListener(v -> startActivity(new Intent(this, SensorTestActivity.class)));

    }
}
