package com.example.administrator.ak.okHttpGet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.administrator.ak.R;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;



public class OkHttpGetActivity extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http_get);

        button = (Button) findViewById(R.id.okhttp_btn11);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



        OkHttpClient client=new OkHttpClient();
         Request request=new Request.Builder()

                .url("https://www.baidu.com")
                .build();


         client.newCall(request).enqueue(new Callback() {
             @Override
             public void onFailure(Call call, IOException e) {

             }

             @Override
             public void onResponse(Call call, Response response) throws IOException {
                 Log.e("---", "onResponse: "+response.body().string()+"响应码：==="+response.code());
             }
         });


            }
        });
    }
}