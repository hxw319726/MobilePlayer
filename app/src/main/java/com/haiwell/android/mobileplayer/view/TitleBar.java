package com.haiwell.android.mobileplayer.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.haiwell.android.mobileplayer.R;

/**
 * Created by Administrator on 2017/11/2.
 * 自定义标题栏
 */

public class TitleBar extends LinearLayout implements View.OnClickListener {
    private static final String TAG = TitleBar.class.getSimpleName();

    private View tv_search;
    private View tv_game;
    private View rl_game;
    private View iv_record;
    private Context mContext;
    /**
     * 在代码中实例化该类的时候使用该构造器
     *
     * @param context
     * */
    public TitleBar(Context context) {
        this(context, null);
    }

    /**
     * 当在布局文件使用该类时，android系统自动通过该构造器实例化对象
     * @param context
     * @param attrs
     */
    public TitleBar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
        mContext = context;
    }

    /**
     * 当需要设置样式的时候，使用该构造器
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public TitleBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        /*得到实例对象*/
        tv_search = getChildAt(1);
        rl_game = getChildAt(2);
        iv_record = getChildAt(3);
        /*设置点击事件*/
        tv_search.setOnClickListener(this);
        rl_game.setOnClickListener(this);
        iv_record.setOnClickListener(this);
    }

    /**
     * @param view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_search://搜索
                Toast.makeText(mContext,"搜索",Toast.LENGTH_SHORT).show();
                break;
            case R.id.rl_game://游戏
                Toast.makeText(mContext,"游戏",Toast.LENGTH_SHORT).show();
                break;
            case R.id.iv_record://历史
                Toast.makeText(mContext,"历史",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
