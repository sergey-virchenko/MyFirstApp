package com.sit.myfirstapp.broadcasts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.sit.myfirstapp.R;

public class BroadCastReceiverActivity extends AppCompatActivity {

    public static final String CUSTOM_ACTION = "com.sit.myfirstapp.CUSTOM_ACTION";
    public static final String CUSTOM_EXTRA = "com.sit.myfirstapp.CUSTOM_EXTRA";

    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_cast_receiver);

        text = findViewById(R.id.text);
        startService(new Intent(this, BroadCastService.class));
    }

    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter filter = new IntentFilter(CUSTOM_ACTION);
        LocalBroadcastManager.getInstance(this).registerReceiver(receiver, filter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(receiver);
    }

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            text.setText(intent.getIntExtra(CUSTOM_EXTRA, -1));
        }
    };
}
