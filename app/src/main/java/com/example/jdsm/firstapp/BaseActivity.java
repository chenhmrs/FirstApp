package com.example.jdsm.firstapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.ButterKnife;
import io.realm.Realm;

/**
 * Created by jdsm on 2017/7/30.
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected int layoutId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initLayoutId();
        initViews();
    }
    protected abstract void initLayoutId();

    protected void initViews() {
        setContentView(layoutId);
        ButterKnife.bind(this);
    }
}