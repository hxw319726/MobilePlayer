package com.haiwell.android.mobileplayer.base;

import android.content.Context;
import android.view.View;

/**
 * Created by Administrator on 2017/11/2.
 */

public abstract class BasePager {
    private static final String TAG = BasePager.class.getSimpleName();

    public final Context context;
    public View rootView;
    public boolean isInitData = false;


    public BasePager(Context context) {
        this.context = context;
        rootView = initView();
    }

    public abstract View initView();

    public void initData() {

    }
}
