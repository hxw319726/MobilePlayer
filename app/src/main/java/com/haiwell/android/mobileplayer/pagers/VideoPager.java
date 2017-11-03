package com.haiwell.android.mobileplayer.pagers;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.media.MediaMetadata;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.haiwell.android.mobileplayer.R;
import com.haiwell.android.mobileplayer.base.BasePager;
import com.haiwell.android.mobileplayer.domain.MediaItem;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/11/2.
 * 本地视频页面
 */

public class VideoPager extends BasePager {
    private static final String TAG = VideoPager.class.getSimpleName();

    private ListView lv_video;
    private ProgressBar pb_loading;
    private TextView tv_nomedia;
    /**
     * 存放本地视频列表
     * */
    private ArrayList<MediaItem> mMediaItems;

    public VideoPager(Context context) {
        super(context);
    }

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (mMediaItems != null && mMediaItems.size() > 0) {
                //有数据，隐藏text
            } else {
                //没有数据，显示text
            }

            //把progressBar隐藏
        }
    };

    @Override
    public View initView() {
        Log.i(TAG, "initView: 本地视频页面初始化");
        View view = View.inflate(context, R.layout.video_pager, null);

        lv_video = ((ListView) view.findViewById(R.id.lv_video));
        pb_loading = ((ProgressBar) view.findViewById(R.id.pb_loading));
        tv_nomedia = ((TextView) view.findViewById(R.id.tv_nomedia));

        return view;
    }

    @Override
    public void initData() {
        super.initData();
        Log.i(TAG, "initData: 本地视频页面数据初始化");
        //加载本地视频数据
        getDataFromLocal();
    }

    /**
     * 从本地的sdcard中加载视频
     * 1.遍历sdcard
     * 2.从内容提供者里面获取视频
     */
    private void getDataFromLocal() {
        new Thread(){
            @Override
            public void run() {
                super.run();

                mMediaItems = new ArrayList<MediaItem>();
                ContentResolver resolver = context.getContentResolver();
                Uri uri= MediaStore.Video.Media.EXTERNAL_CONTENT_URI;

                String[] objs = {
                        MediaStore.Video.Media.DISPLAY_NAME,//视频名称
                        MediaStore.Video.Media.DURATION,//总时长
                        MediaStore.Video.Media.SIZE,//大小
                        MediaStore.Video.Media.ARTIST,//演唱者等
                        MediaStore.Video.Media.DATA,//视频绝对路径
                };
                Cursor cursor = resolver.query(uri, objs, null, null, null);
                if (cursor != null) {
                    while (cursor.moveToNext()) {

                        MediaItem item = new MediaItem();

                        String name = cursor.getString(0);//视频名称
                        item.setName(name);

                        long duration = cursor.getLong(1);//总时长
                        item.setDuration(duration);

                        long size = cursor.getLong(2);//大小
                        item.setSize(size);

                        String artist = cursor.getString(3);//艺术家
                        item.setArtist(artist);

                        String data = cursor.getString(4);//绝对路径
                        item.setData(data);

                        mMediaItems.add(item);

                    }
                    cursor.close();
                }

                //发消息给ui
                mHandler.sendEmptyMessage(1);

            }
        }.start();
    }
}
