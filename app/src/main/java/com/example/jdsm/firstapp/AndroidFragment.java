package com.example.jdsm.firstapp;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jdsm on 2017/7/27.
 */

public class AndroidFragment extends RecyclerViewFragment implements AndroidJiekou{
    public AndroidAdapter adapter1;
    public List<Android> data1;
    public static AndroidFragment newInstance(){
        return new AndroidFragment();
    }
    @Override
    protected void initView() {
        data1=new ArrayList<>();
       // for(int i=0;i<10;i++) {
     //      Android android = new Android();
        //    android.setId("" + i);
         //   android.setTitle("" + i);
         //   data1.add(android);
    //    }
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter1=new AndroidAdapter(getContext(),data1);
        recyclerView.setAdapter(adapter1);
        AndroidPresent present=new AndroidPresent(this);
        Log.d("MainActivity",""+"z");
        present.getData(data1);
        adapter1.setOnClickf(new AndroidAdapter.OnClickListen() {
            @Override
            public void OnClickf(String url) {
                Intent intent=new Intent(getContext(),UrlActivity.class);
                intent.putExtra("url",url);
                getActivity().startActivity(intent);
            }
        });
    }

    @Override
    public void notifyDataChanged() {
        adapter1.notifyDataSetChanged();
    }
}
