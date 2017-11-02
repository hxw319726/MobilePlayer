package com.haiwell.android.mobileplayer.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

import com.haiwell.android.mobileplayer.R;

public class SplashActivity extends Activity {

    private static final String TAG = SplashActivity.class.getSimpleName();
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //两秒后跳转主页面
                startMainActivity();
                //打印当前线程名称
                Log.e(TAG, "当前线程的名称==" + Thread.currentThread().getName());
            }
        },2000);
    }

    @Override
    protected void onDestroy() {
        handler.removeCallbacksAndMessages(null);
        super.onDestroy();
    }

    /*
    * 跳转主页面，并把当前页面关闭
    * */
    private void startMainActivity() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        //关闭当前页面
        finish();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG, "onTouchEvent==Action" + event.getAction());
        startMainActivity();
        return super.onTouchEvent(event);
    }
}
