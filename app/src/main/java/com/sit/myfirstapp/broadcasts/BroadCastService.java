package com.sit.myfirstapp.broadcasts;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;

import java.util.Random;

public class BroadCastService extends Service {
    public BroadCastService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread(() -> {
            Random r = new Random();
            while (true) {
                Intent i = new Intent(BroadCastReceiverActivity.CUSTOM_ACTION);
                i.putExtra(BroadCastReceiverActivity.CUSTOM_EXTRA, r.nextInt(100));
                LocalBroadcastManager.getInstance(this).sendBroadcast(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        return super.onStartCommand(intent, flags, startId);
    }
}
