package com.haiwell.android.mobileplayer.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.haiwell.android.mobileplayer.R;
import com.haiwell.android.mobileplayer.base.BasePager;
import com.haiwell.android.mobileplayer.base.ReplaceFragment;
import com.haiwell.android.mobileplayer.pagers.AudioPager;
import com.haiwell.android.mobileplayer.pagers.NetAudioPager;
import com.haiwell.android.mobileplayer.pagers.NetVideoPager;
import com.haiwell.android.mobileplayer.pagers.VideoPager;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/10/22.
 */

public class MainActivity extends FragmentActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private FrameLayout flMainContent;
    private RadioGroup rgBottomTag;

    /*页面的集合*/
    private ArrayList<BasePager> basePagers;
    /*位置*/
    private int position;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flMainContent = (FrameLayout) findViewById(R.id.fl_main_content);
        rgBottomTag = (RadioGroup) findViewById(R.id.rg_bottom_tag);


        /*添加页面到arraylist*/
        basePagers = new ArrayList<>();
        basePagers.add(new VideoPager(this));//0
        basePagers.add(new AudioPager(this));//1
        basePagers.add(new NetVideoPager(this));//2
        basePagers.add(new NetAudioPager(this));//3

        /*设置RadioGroup监听*/
        rgBottomTag.setOnCheckedChangeListener(new MyOnCheckedChangeListener());
        rgBottomTag.check(R.id.rb_video);//设置默认项
    }

    class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
            switch (i) {
                case R.id.rb_video:
                    position = 0;
                    break;
                case R.id.rb_audio:
                    position = 1;
                    break;
                case R.id.rb_netvideo:
                    position = 2;
                    break;
                case R.id.rb_netaudio:
                    position = 3;
                    break;
            }
            setFragment();
        }
    }

    /*把页面添加到fragment*/
    private void setFragment() {
        //1.得到FragmentManage
        FragmentManager fm = getSupportFragmentManager();
        //2.开启事务
        FragmentTransaction ft = fm.beginTransaction();
        //3.替换
        BasePager basePager = getBasePager();
        ft.replace(R.id.fl_main_content,new ReplaceFragment(basePager));
        //4.提交事务
        ft.commit();
    }

    private BasePager getBasePager() {
        BasePager basePager = basePagers.get(position);
        if (basePager != null && !basePager.isInitData) {
            basePager.initData();
            basePager.isInitData = true;
        }
        return basePager;
    }
}
