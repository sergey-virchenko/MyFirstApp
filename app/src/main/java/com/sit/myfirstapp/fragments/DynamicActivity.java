package com.sit.myfirstapp.fragments;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import com.sit.myfirstapp.R;

public class DynamicActivity extends AppCompatActivity {


    Dynamic1Fragment frag1;
    Dynamic2Fragment frag2;
    FragmentTransaction fTrans;
    CheckBox chbStack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic);

        frag1 = new Dynamic1Fragment();
        frag2 = new Dynamic2Fragment();

        chbStack = findViewById(R.id.chbStack);
    }

    public void onClick(View v) {
        fTrans = getSupportFragmentManager().beginTransaction();
        switch (v.getId()) {
            case R.id.btnAdd:
                fTrans.add(R.id.frgmCont, frag1);
                break;
            case R.id.btnRemove:
                fTrans.remove(frag1);
                break;
            case R.id.btnReplace:
                fTrans.replace(R.id.frgmCont, frag2);
            default:
                break;
        }
        if (chbStack.isChecked()) fTrans.addToBackStack(null);
        fTrans.commit();
    }
}
