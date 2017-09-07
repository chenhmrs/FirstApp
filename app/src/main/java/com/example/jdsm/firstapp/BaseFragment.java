package com.example.jdsm.firstapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by jdsm on 2017/7/27.
 */

public abstract class BaseFragment extends Fragment{
    public View view;
    protected int layoutId;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setLayoutId();
        view=inflater.inflate(layoutId,container,false);
       ButterKnife.bind(this,view);
        initView();
        return view;
    }

    protected abstract void initView();

    protected abstract void setLayoutId();
}
