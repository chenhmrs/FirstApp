package com.example.jdsm.firstapp;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;

/**
 * Created by jdsm on 2017/7/27.
 */

public abstract class RecyclerViewFragment extends BaseFragment{

    @BindView(R.id.recycler_view)
    public RecyclerView recyclerView;
    @Override
    protected void setLayoutId() {
        layoutId=R.layout.recyclerview_main;
    }

    @Override
    protected void initView() {
      //  recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
    }
}
