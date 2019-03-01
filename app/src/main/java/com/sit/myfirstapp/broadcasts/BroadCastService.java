package com.sit.myfirstapp.broadcasts;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;

import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sit.myfirstapp.B;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Random;

public class BroadCastService extends Service {

    ArrayList<LatLng> arrayList = new ArrayList<>();

    public BroadCastService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        switch (intent.getStringExtra(BroadCastReceiverActivity.COMMAND)) {
            case BroadCastReceiverActivity.START:

                break;
            case BroadCastReceiverActivity.STOP:
                stopSelf();
                break;
        }

        stopSelf();
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
        Thread t = new Thread(() -> {
            Random r = new Random();
            while (true) {
                Intent i = new Intent(BroadCastReceiverActivity.CUSTOM_ACTION);
                i.putExtra(BroadCastReceiverActivity.COMMAND, r.nextInt(100));

                LocalBroadcastManager.getInstance(this).sendBroadcast(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        if (!t.isAlive()) {
            t.start();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    private void parseCords() {
        Gson gson = new Gson();

        String cords = B.getCords();
        Type fooType = new TypeToken<ArrayList<LatLng>>() {
        }.getType();
        arrayList = gson.fromJson(cords, fooType);

        try {
            JSONArray array = new JSONArray(cords);
            for (int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);
                double valLat = object.getDouble("latitude");
                double valLong = object.getDouble("longitude");
                object.optDouble("latitude", 10d);
                arrayList.add(new LatLng(valLat, valLong));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
