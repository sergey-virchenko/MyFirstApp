package com.sit.myfirstapp.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sit.myfirstapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChildFragment extends Fragment {

    final String LOG_TAG = ChildFragment.class.getSimpleName();

    public ChildFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(LOG_TAG, "onCreateView");
        return inflater.inflate(R.layout.fragment_child, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(LOG_TAG, "onAttach");
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOG_TAG, "onCreate");
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(LOG_TAG, "onActivityCreated");
    }

    public void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }

    public void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume");
    }

    public void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }

    public void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }

    public void onDestroyView() {
        super.onDestroyView();
        Log.d(LOG_TAG, "onDestroyView");
    }

    public void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }

    public void onDetach() {
        super.onDetach();
        Log.d(LOG_TAG, "onDetach");
    }

}
