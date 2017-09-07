package com.example.jdsm.firstapp;

import android.app.Application;
import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by jdsm on 2017/7/24.
 */

public class FirstApp extends Application {
    public Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        // 设置Realm默认配置
        Realm.init(this);
//在高版本的Realm中Builder（）里不填，填了报错
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder().schemaVersion(0).build();
        Realm.setDefaultConfiguration(realmConfiguration);

    }
}
