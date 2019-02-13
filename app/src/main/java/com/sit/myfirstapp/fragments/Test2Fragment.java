package com.sit.myfirstapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sit.myfirstapp.R;

public class Test2Fragment extends Fragment {

    public static final String KEY_EVALUATED_TEXT = "KEY_EVALUATED_TEXT";

    private SwitchCompat switchCompat;
    private TextView evaluatedText;

    public Test2Fragment() {
    }

    public static Test2Fragment getFragment(String evaluatedText) {
        Test2Fragment fragment = new Test2Fragment();
        Bundle b = new Bundle();
        b.putString(KEY_EVALUATED_TEXT, evaluatedText);
        fragment.setArguments(b);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_test2, container, false);
        switchCompat = v.findViewById(R.id.switch_show_fragment);
        evaluatedText = v.findViewById(R.id.evaluated_text);
        switchCompat.setOnClickListener(this::onSwitchClick);

        if (getArguments() != null && getArguments().containsKey(KEY_EVALUATED_TEXT)) {
            evaluatedText.setText(getArguments().getString(KEY_EVALUATED_TEXT));
        }
        return v;
    }

    private void onSwitchClick(View v) {
        if (switchCompat.isChecked()) {
            getChildFragmentManager().beginTransaction().add(R.id.inner_container, new ChildFragment(), "child").commit();
        } else {
            Fragment fragment = getChildFragmentManager().findFragmentByTag("child");
            if (fragment != null) {
                getChildFragmentManager().beginTransaction().remove(fragment).commit();
            }
        }
    }

    public void setEvaluated(String s) {
        evaluatedText.setText(s);
    }

}
