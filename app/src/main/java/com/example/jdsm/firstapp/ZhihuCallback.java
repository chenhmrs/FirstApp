package com.example.jdsm.firstapp;

import android.util.Log;

import com.zhy.http.okhttp.callback.Callback;
import com.zhy.http.okhttp.utils.Exceptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by jdsm on 2017/7/24.
 */

public class ZhihuCallback extends Callback<List<ZhiHu>> {
    public static  int HEAD=0;
    public static  int ITEM=1;
    private String date;
    @Override
    public List<ZhiHu> parseNetworkResponse(Response response, int id) throws Exception {
        List<ZhiHu> data2=new ArrayList<>();
        JSONObject object=new JSONObject(response.body().string());
        date=object.getString("date");
        //JSONArray stoty=object.getJSONArray(object.getString("stories"));
        JSONArray stoty=object.getJSONArray("stories");
        JSONArray top_stories=object.getJSONArray("top_stories");
        for (int i=0;i!=stoty.length();i++){
            JSONObject object1=stoty.getJSONObject(i);
            //getData(data2,object1);
            data2.add(getData(object1,ITEM));
        }
        for (int j=0;j!=top_stories.length();j++){
            JSONObject object1=top_stories.getJSONObject(j);
            //getData(data2,object1);
            data2.add(getData(object1,HEAD));
        }
        Log.d("MainActivity","kkll");
        return data2;
    }

    private ZhiHu getData( JSONObject object1,int type) throws JSONException {
        ZhiHu zhihu=new ZhiHu();
        zhihu.setType(type);
        try{
        //get是不确定的，getString直接转换为String类型
        zhihu.setId(object1.getString("id"));
        zhihu.set_id(zhihu.getId()+type);
        zhihu.setTitle(object1.getString("title"));
         if (type==ITEM){
        JSONArray image=object1.getJSONArray("images");
        String imageurl=image.getString(0);
        zhihu.setImageUrl(imageurl);
         }else if (type==HEAD){
             zhihu.setImageUrl(object1.getString("image"));
         }
        }catch (JSONException e){
            e.printStackTrace();
        }
        return zhihu;

    }


    @Override
    public void onError(Call call, Exception e, int id) {

    }

    @Override
    public void onResponse(List<ZhiHu> response, int id) {

    }
}
