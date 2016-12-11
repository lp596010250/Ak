package com.example.administrator.ak.okHttpGet01;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by Administrator on 2016/12/11.
 */

public class OkHttpNetClient {


    private static OkHttpNetClient mOkHttpNetClient;
    private OkHttpNetClient(){

        HttpLoggingInterceptor interceptor=new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client=new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

    }

    public static synchronized OkHttpNetClient getInstance(){


        if (mOkHttpNetClient==null) {
            mOkHttpNetClient=new OkHttpNetClient();
        }

        return mOkHttpNetClient;
    }

}
