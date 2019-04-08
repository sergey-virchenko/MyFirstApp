package com.sit.myfirstapp.fragmentpager;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.sit.myfirstapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PagerFragment extends Fragment {


    public static PagerFragment getInstance(String text, String color) {
        PagerFragment fragment = new PagerFragment();
        Bundle b = new Bundle();
        b.putString("text", text);
        b.putString("color", color);
        fragment.setArguments(b);
        return fragment;
    }

    public PagerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_pager, container, false);

        TextView text = v.findViewById(R.id.text);
        FrameLayout root = v.findViewById(R.id.root);

        text.setText(getArguments().getString("text"));
        root.setBackgroundColor(Color.parseColor(getArguments().getString("color")));

        return v;
    }

}
