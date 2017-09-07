package com.example.jdsm.firstapp;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by jdsm on 2017/7/27.
 */

public class Android extends RealmObject {
    @PrimaryKey
    public String id;

    public String title;

    public String who;

    public String createdAt;

    public String url;

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getWho() {
        return who;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
