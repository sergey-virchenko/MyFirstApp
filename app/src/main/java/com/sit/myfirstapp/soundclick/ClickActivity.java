package com.sit.myfirstapp.soundclick;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.sit.myfirstapp.R;

public class ClickActivity extends AppCompatActivity {

    private Button btn;
    private MediaPlayer mp;

    private MediaPlayer bgMp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click);
        btn = findViewById(R.id.btn);
        mp = MediaPlayer.create(this, R.raw.click);
        bgMp = MediaPlayer.create(this, R.raw.faradenza);
        bgMp.setLooping(true);
        bgMp.start();

        btn.setOnClickListener(v -> {
            if (mp.isPlaying()) {
                mp.stop();
                mp.release();
//                mp.setLooping(true);
                mp = MediaPlayer.create(this, R.raw.click);
            }
            mp.start();
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (bgMp.isPlaying()) {
            bgMp.setVolume(0.2f, 0.2f);
            bgMp.stop();
            bgMp.release();
        }
    }
}
