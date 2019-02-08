package com.sit.myfirstapp;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Scroller;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

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

        class A implements View.OnClickListener {

            @Override
            public void onClick(View v) {

            }
        }

        new A();

        View.OnClickListener clickListener = v -> {

        };

        ObjectAnimator objectAnimator = new ObjectAnimator();

        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

            }
        });
        objectAnimator.addListener(new AnimatorListenerAdapter() {


            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
            }


        });

        Switch swit4 = null;

        swit4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        swit4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });

        btnChangeColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnChangeColor.setOnClickListener(new B());

        btnChangeColor.setOnClickListener(v -> {
            changeBtnColor(btnChangeColor);
            changeBtnColor(btnChangeColor2);
            changeBtnColor(btnChangeColor3);
        });

        btnChangeColor.setOnClickListener(this);

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

    @Override
    public void onClick(View v) {

    }
}
