package com.example.jdsm.firstapp;

import android.os.Bundle;

/**
 * Created by jdsm on 2017/7/27.
 */

public class PictureFragment extends BaseFragment {
    public static final int TYPE_GANK = 0;

    public static final int TYPE_BREAST = 1;

    public static final int TYPE_BUTT = 2;

    public static final int TYPE_SILK = 3;

    public static final int TYPE_LEG = 4;

    public static final int TYPE_RANK = 5;
    public static PictureFragment newInstance(int tpye){
        PictureFragment fragment=new PictureFragment();
        Bundle arg=new Bundle();
        arg.putInt("type",tpye);
        fragment.setArguments(arg);
        return fragment;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void setLayoutId() {

    }
}
