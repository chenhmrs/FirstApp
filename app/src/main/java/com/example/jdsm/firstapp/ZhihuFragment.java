package com.example.jdsm.firstapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by jdsm on 2017/7/27.
 */

public class ZhihuFragment extends RecyclerViewFragment implements ZhihuJiekou{
    public List<ZhiHu> head;
    public List<ZhiHu> item;
    public ZhihuAdapter adapter;
    public ZhiHuPresent present;

    public static ZhihuFragment newInstance(){
        return new ZhihuFragment();
    }
    @Override
    protected void initView() {
        super.initView();
        initRecycler();
        present = new ZhiHuPresent(this);
        initData();
    }

    private void initRecycler() {
        item = new ArrayList<ZhiHu>();
        head = new ArrayList<ZhiHu>();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new ZhihuAdapter(getContext(), item, head);
        adapter.setOnItemClickListener(new ZhihuAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String url) {
                Intent intent = new Intent(getActivity(), UrlActivity.class);
                intent.putExtra("url", url);
                getActivity().startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);
    }

    private void initData() {
        present.getZhihuData(head, item);
    }

    @Override
    public void notifyDataChanged() {
        Log.d("MainActivity", "notify");
        Log.d("MainActivity", head.size() + " " + item.size());
        adapter.notifyDataSetChanged();
    }


}
