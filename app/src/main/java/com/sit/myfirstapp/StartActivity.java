package com.sit.myfirstapp;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.sit.myfirstapp.broadcasts.BroadCastReceiverActivity;
import com.sit.myfirstapp.broadcasts.MapsActivity;
import com.sit.myfirstapp.fragmentpager.BottomNavigationActivity;
import com.sit.myfirstapp.fragments.DynamicActivity;
import com.sit.myfirstapp.fragments.FragmentActivity;
import com.sit.myfirstapp.lists.ListActivity;
import com.sit.myfirstapp.networking.NetworkActivity;
import com.sit.myfirstapp.sensors.CompassActivity;
import com.sit.myfirstapp.sensors.SensorTestActivity;

public class StartActivity extends AppCompatActivity {

    private static final int[] ids = {
            R.id.compass,
            R.id.sensors,
            R.id.fragments,
            R.id.dynamic_fragments,
            R.id.broadcasts,
            R.id.map,
            R.id.net,
            R.id.list,
            R.id.navigation
    };

    private static final Class[] names = {
            CompassActivity.class,
            SensorTestActivity.class,
            FragmentActivity.class,
            DynamicActivity.class,
            BroadCastReceiverActivity.class,
            MapsActivity.class,
            NetworkActivity.class,
            ListActivity.class,
            BottomNavigationActivity.class
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        for (int i = 0; i < ids.length; i++) {
            int finalI = i;
            findViewById(ids[i]).setOnClickListener(v -> startActivity(new Intent(this, names[finalI])));
        }
    }

}
