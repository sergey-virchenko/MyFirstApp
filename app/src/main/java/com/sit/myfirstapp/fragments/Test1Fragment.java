package com.sit.myfirstapp.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.sit.myfirstapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Test1Fragment extends Fragment {

    private EditText input;
    private Button evaluateBtn;
    private OnEvaluateListener onEvaluateListener;

    public Test1Fragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            onEvaluateListener = (OnEvaluateListener) context;
        } catch (ClassCastException e) {
            Log.e(Test1Fragment.class.getSimpleName(), context.getClass().getSimpleName() + " must implement Test1Fragment.OnEvaluateListener");
        }
    }

    @Override
    public View
    onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_test1, container, false);
        input = v.findViewById(R.id.input);
        evaluateBtn = v.findViewById(R.id.btn_evaluate);
        evaluateBtn.setOnClickListener(this::evaluate);
        return v;
    }

    private void evaluate(View v) {
        if (onEvaluateListener != null) {
            String data = input.getText().toString();
            onEvaluateListener.onEvaluate(data);
        }
    }

    public interface OnEvaluateListener {
        void onEvaluate(String s);
    }

}
