package com.sit.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnChangeColor;
    Button btnChangeColor2;
    Button btnChangeColor3;
    private final boolean red = true;
    private final boolean black = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnChangeColor = findViewById(R.id.btn_change_color);

        btnChangeColor.setOnClickListener(v -> {
            changeBtnColor(btnChangeColor);
            changeBtnColor(btnChangeColor2);
            changeBtnColor(btnChangeColor3);
        });
    }
    private void changeBtnColor(Button btnChangeColor) {
        if (isRed(btnChangeColor)) {
            btnChangeColor.setBackgroundResource(R.color.black);
            btnChangeColor.setTag(black);
        } else {
            btnChangeColor.setBackgroundResource(R.color.red);
            btnChangeColor.setTag(red);
        }
    }
    private boolean isRed(View v) {
        return (boolean) v.getTag();
    }

}
