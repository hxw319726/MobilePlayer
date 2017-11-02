package com.haiwell.android.mobileplayer.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2017/11/2.
 */

public class ReplaceFragment extends Fragment {
    private static final String TAG = ReplaceFragment.class.getSimpleName();

    private BasePager currentPager;

    public ReplaceFragment(BasePager basePager) {
        this.currentPager = basePager;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (currentPager != null) {
            return currentPager.rootView;
        }
        return null;
    }
}
