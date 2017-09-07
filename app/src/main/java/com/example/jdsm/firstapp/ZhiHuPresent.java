package com.example.jdsm.firstapp;

import android.content.Context;
import android.util.Log;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;

/**
 * Created by jdsm on 2017/7/24.
 */

public class ZhiHuPresent {
    public ZhihuFragment fragment;
    public ZhiHuPresent(ZhihuFragment fragment){
        this.fragment=fragment;
    }
    public void getZhihuData(final List<ZhiHu> head, final List<ZhiHu> item) {
        OkHttpUtils.get().url(API.url).build().execute(new ZhihuCallback(){
            @Override
            public void onError(Call call, Exception e, int id) {
                super.onError(call, e, id);
                Log.d("MainActivity", e.getMessage());
            }

            @Override
            public void onResponse(final List<ZhiHu> response,int id) {
                super.onResponse(response, id);
                getUrl(head,item,response);
              // for (ZhiHu z:response){
               //    data.add(z);
               //}
              //adapter.notifyDataSetChanged();
            }
        });
    }

    private void getUrl(final List<ZhiHu> head,final List<ZhiHu> item, List<ZhiHu> response) {
        for (final ZhiHu zhihu:response){
            String id=zhihu.getId();
            OkHttpUtils.get().url(API.ZHIHU_DETAIL+"/"+id).build().execute(new StringCallback() {
                @Override
                public void onError(Call call, Exception e, int id) {

                }

                @Override
                public void onResponse(String response, int id) {
                    try {
                        JSONObject object=new JSONObject(response);
                        zhihu.setWebUrl(object.getString("share_url"));
                        if (zhihu.getType()==0){
                            head.add(zhihu);
                           //Log.d("MainActivity",zhihu.getType()+zhihu.getTitle()+zhihu.getImageUrl());
                        }else {
                            item.add(zhihu);
                            //Log.d("MainActivity",zhihu.getType()+zhihu.getTitle()+zhihu.getImageUrl());
                        }
                        fragment.notifyDataChanged();
                    }catch (JSONException e){
                        e.printStackTrace();
                    }
                }
            });
        }
        Log.d("MainActivity","kl");
    }
}
