package com.vnibin.retrofit;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by vnibin on 6/7/18.
 */

public class ApiClient {



    public static final String BASE_URL="http://www.androidbegin.com/tutorial/";

    public static Retrofit retrofit=null;
    public static Retrofit getApiClient()
    {

        HttpLoggingInterceptor.Level logLevel = HttpLoggingInterceptor.Level.BODY;
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(logLevel);

        OkHttpClient okHttpClient = new OkHttpClient()
                .newBuilder()
                .connectTimeout(30000, TimeUnit.MILLISECONDS)
                .readTimeout(30000, TimeUnit.MILLISECONDS)
                .writeTimeout(50000, TimeUnit.MILLISECONDS)

                .addInterceptor(interceptor).build();
        if(retrofit==null)
        {
            retrofit=new Retrofit.Builder().baseUrl(BASE_URL).
                    addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient).build();
        }
        return retrofit;
    }
}
