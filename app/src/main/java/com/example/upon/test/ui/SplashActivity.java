package com.example.upon.test.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.example.upon.test.R;


import cn.bmob.v3.Bmob;

/**
 * 作者：Created by UPON
 * 邮箱：upon_88@163.com
 * 时间： 2016/10/11
 */
public class SplashActivity extends Activity {
    private static final String APPID = "a6f9359b22b214295b1fc5d19a2e264a";
    private static final int GO_HOME = 100;
    private static final int GO_LOGIN = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bmob.initialize(this, APPID);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mHandler.sendEmptyMessageDelayed(GO_LOGIN, 3000);
    }

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case GO_HOME:
                    break;
                case GO_LOGIN:
                    Intent intent = new Intent(SplashActivity.this,LoginActivity.class);
                    startActivity(intent);
                    finish();
                    break;
            }
        }
    };


}
