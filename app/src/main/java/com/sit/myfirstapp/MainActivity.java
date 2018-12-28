package com.sit.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnChangeColor;

    private final boolean red = true;
    private final boolean black = false;

    private boolean isRed = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn).setOnClickListener((view) -> startActivity(new Intent(MainActivity.this, AnotherActivity.class)));

        btnChangeColor = findViewById(R.id.btn_change_color);

        btnChangeColor.setOnClickListener(v -> {
            if (isRed(btnChangeColor)) {
                btnChangeColor.setBackgroundResource(R.color.red);
                btnChangeColor.setTag(red);
            } else {
                btnChangeColor.setBackgroundResource(R.color.black);
                btnChangeColor.setTag(black);
            }
        });
    }


    private boolean isRed(View v) {
        return (boolean) v.getTag();
    }

}
