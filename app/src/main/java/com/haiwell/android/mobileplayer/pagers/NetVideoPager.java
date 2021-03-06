package com.haiwell.android.mobileplayer.pagers;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.haiwell.android.mobileplayer.base.BasePager;

/**
 * Created by Administrator on 2017/11/2.
 * 网络视频页面
 */

public class NetVideoPager extends BasePager {
    private static final String TAG = NetVideoPager.class.getSimpleName();

    private TextView mTextView;

    public NetVideoPager(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        Log.i(TAG, "initView: 网络视频页面初始化");
        mTextView = new TextView(context);
        mTextView.setTextSize(25);
        mTextView.setTextColor(Color.RED);
        mTextView.setGravity(Gravity.CENTER);
        return mTextView;
    }

    @Override
    public void initData() {
        super.initData();
        Log.i(TAG, "initData: 网络视频页面数据初始化");
        mTextView.setText("网络视频页面");
    }
}
