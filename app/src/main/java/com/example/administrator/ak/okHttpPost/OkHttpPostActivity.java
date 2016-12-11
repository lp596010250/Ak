package com.example.administrator.ak.okHttpPost;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.example.administrator.ak.R;
import com.example.administrator.ak.okHttpGet01.OkHttpNetClient;
import com.example.administrator.ak.okHttpGet01.UserApi;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class OkHttpPostActivity extends AppCompatActivity {

    @BindView(R.id.activity_ok_http_post_username)
    EditText mUsername;
    @BindView(R.id.activity_ok_http_post_password)
    EditText mPassword;
    @BindView(R.id.activity_ok_http_post_register)
    Button mRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http_post);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.activity_ok_http_post_register)
    public void onClick() {
        User user = new User(mPassword.getText().toString(), mUsername.getText().toString());

        OkHttpNetClient.getInstance().register(UserApi.URL_POST, user).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("---", "onFailure: " + e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                Log.e("---", "onResponse: " + response.body().string() + "响应码===" + response.code());

            }
        });
    }
}
