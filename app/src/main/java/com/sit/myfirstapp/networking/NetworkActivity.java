package com.sit.myfirstapp.networking;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.sit.myfirstapp.R;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class NetworkActivity extends AppCompatActivity {

    private TextView update;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);
        update = findViewById(R.id.progress);
        result = findViewById(R.id.result);
        // plain thread
//        new Thread(this::doRequest).start();

        // async task
//        new RequestTask().execute("http://www.android.com/");

        RetrofitHelper.getInstance().getService().listRepos("square").enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                result.setText(String.valueOf(response.body().get(0).id));
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {

            }
        });

    }

    private void doRequest() {
        URL url = null;
        try {
            url = new URL("http://www.android.com/");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        HttpURLConnection urlConnection = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null)
                System.out.println(inputLine);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
    }

    @SuppressLint("StaticFieldLeak")
    private class RequestTask extends AsyncTask<String, Integer, String> {

        //"http://www.android.com/"
        @Override
        protected String doInBackground(String... strings) {
            URL url = null;
            try {
                url = new URL(strings[0]);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            HttpURLConnection urlConnection = null;
            StringBuilder builder = new StringBuilder();
            try {
                urlConnection = (HttpURLConnection) url.openConnection();
                BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                String inputLine;
                int i = 0;
                while ((inputLine = in.readLine()) != null) {
                    builder.append(inputLine);
                    publishProgress(i);
                    i++;
                    Thread.sleep(2000);
                }
                in.close();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }

            return builder.toString();
        }


        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            update.setText(String.valueOf(values[0]));
        }

        @Override
        protected void onPostExecute(String string) {
            super.onPostExecute(string);
            result.setText(string);
        }

    }
}
