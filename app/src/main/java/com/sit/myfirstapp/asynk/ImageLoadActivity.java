package com.sit.myfirstapp.asynk;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.sit.myfirstapp.R;

import java.io.InputStream;
import java.net.URL;

public class ImageLoadActivity extends AppCompatActivity {

    Button button;
    ProgressBar progressBar;
    ImageView imageView;
    EditText editText;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_load);

        button = findViewById(R.id.button);
        progressBar = findViewById(R.id.progressBar);
        imageView = findViewById(R.id.imageView);
        editText = findViewById(R.id.editText);

        button.setOnClickListener(v -> new DownloadImageTask().execute(editText.getText().toString()));
    }


    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap bmp = null;
            try (InputStream in = new URL(urldisplay).openStream()) {
                bmp = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return bmp;
        }

        protected void onPostExecute(Bitmap result) {
            progressBar.setVisibility(View.GONE);
            imageView.setImageBitmap(result);
        }
    }

}
