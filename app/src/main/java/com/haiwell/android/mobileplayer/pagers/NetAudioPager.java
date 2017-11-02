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
 * 网络音频页面
 */

public class NetAudioPager extends BasePager {
    private static final String TAG = NetAudioPager.class.getSimpleName();

    private TextView mTextView;

    public NetAudioPager(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        Log.i(TAG, "initView: 网络音频页面初始化");
        mTextView = new TextView(context);
        mTextView.setTextSize(25);
        mTextView.setTextColor(Color.RED);
        mTextView.setGravity(Gravity.CENTER);
        return mTextView;
    }

    @Override
    public void initData() {
        super.initData();
        Log.i(TAG, "initData: 网络音频页面数据初始化");
        mTextView.setText("网络音频页面");
    }
}
