package com.example.jdsm.firstapp;

import android.content.pm.LauncherApps;
import android.util.Log;

import com.zhy.http.okhttp.callback.Callback;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by jdsm on 2017/7/27.
 */

public class AndroidCallback extends Callback<List<Android>> {
    @Override
    public List<Android> parseNetworkResponse(Response response, int id) throws Exception {
        List<Android> data4=new ArrayList<>();
        JSONObject object=new JSONObject(response.body().string());
        JSONArray results=object.getJSONArray("results");
         for (int i=0;i!=results.length();i++) {
        Android android=new Android();
        JSONObject object1=results.getJSONObject(i);
        android.setId(object1.getString("_id"));
        android.setTitle(object1.getString("desc"));
        android.setCreatedAt(object1.getString("createdAt"));
        android.setWho(object1.getString("who"));
        android.setUrl(object1.getString("url"));
        data4.add(android);
    }
    return data4;
    }

    @Override
    public void onError(Call call, Exception e, int id) {

    }

    @Override
    public void onResponse(List<Android> response, int id) {

    }
}
