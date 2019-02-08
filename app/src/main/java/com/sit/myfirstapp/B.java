package com.sit.myfirstapp;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class B implements View.OnClickListener {

    static {

    }

    {
        int i = 1;
    }

    public static void main(String[] args) {
        OuterClass.Builder outer = new OuterClass.Builder();

        OuterClass.Builder2 outerClass2 = new OuterClass().new Builder2();

        List<String> arr = new ArrayList<String>() {
            {
                add("asd");
            }
        };



    }

    @Override
    public void onClick(View v) {

    }
}
