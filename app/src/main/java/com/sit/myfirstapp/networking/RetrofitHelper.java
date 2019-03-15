package com.sit.myfirstapp.networking;

import android.view.textclassifier.TextLinks;

import com.bumptech.glide.RequestBuilder;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {

    private static RetrofitHelper instance;

    private final GithubService service;

    private RetrofitHelper() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        OkHttpClient.Builder client = new OkHttpClient.Builder();

        client.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();

                Request.Builder builder = request.newBuilder();

                builder.addHeader("Authorization", "adadasd");

                return chain.proceed(builder.build());
            }
        });

        service = retrofit.create(GithubService.class);
    }

    public static RetrofitHelper getInstance() {
        if (instance == null) {
            synchronized (RetrofitHelper.class) {
                if (instance == null) {
                    instance = new RetrofitHelper();
                }
            }
        }
        return instance;
    }

    public GithubService getService() {
        return service;
    }


}
