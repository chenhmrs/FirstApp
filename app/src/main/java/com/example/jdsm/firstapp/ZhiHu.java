package com.example.jdsm.firstapp;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by jdsm on 2017/7/24.
 */

public class ZhiHu extends RealmObject{
    public  static final int TYPE_HEADER=0;
    public static final  int TYPE_ITEM=1;
    @PrimaryKey
    public String _id;

    public String id;

    public String date;

    public String title;

    public String imageUrl;

    public String webUrl;

    //自己设置的属性，topstories就设为0，story就设为1
    public int type;
    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String get_id() {
        return _id;
    }
}
