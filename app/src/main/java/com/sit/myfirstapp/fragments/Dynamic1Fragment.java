package com.sit.myfirstapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sit.myfirstapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Dynamic1Fragment extends Fragment {


    public Dynamic1Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dynamic1, container, false);
    }

}
