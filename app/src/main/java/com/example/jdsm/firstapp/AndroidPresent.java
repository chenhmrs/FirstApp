package com.example.jdsm.firstapp;

import android.util.Log;

import com.zhy.http.okhttp.OkHttpUtils;

import java.util.List;

import okhttp3.Call;

/**
 * Created by jdsm on 2017/7/27.
 */

public class AndroidPresent {
    public AndroidAdapter adapter;
    public AndroidFragment fragment;
    public AndroidPresent(AndroidFragment fragment){
        this.fragment=fragment;
    }
    public void getData(final List<Android> data1) {
        OkHttpUtils.get().url(API.Android).build().execute(new AndroidCallback(){
            @Override
            public void onError(Call call, Exception e, int id) {
                super.onError(call, e, id);
            }

            @Override
            public void onResponse(List<Android> response, int id) {
                Log.d("MainActivity",""+"ssd");
                for (Android a:response){
                    data1.add(a);
                }
                fragment.notifyDataChanged();
            }
        });
    }
}
