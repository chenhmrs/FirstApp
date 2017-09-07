package com.example.jdsm.firstapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jdsm on 2017/7/23.
 */

public class MainActivity extends BaseActivity {
    public TabFragment fragment;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Log.d("MainActivity",""+"c");
       // setContentView(R.layout.activity_main);
       // Log.d("MainActivity",""+"d");
       // ButterKnife.bind(this);
       // button.setText("d");
        fragment=TabFragment.newInstance(TabFragment.ZHU_YE);
        replaceFragment(TabFragment.newInstance(TabFragment.ZHU_YE));
    }

    @Override
    protected void initLayoutId() {
        layoutId=R.layout.activity_main;
    }

    private void replaceFragment(TabFragment tabFragment) {
        android.support.v4.app.FragmentManager manager=getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction tr=manager.beginTransaction();
        tr.replace(R.id.contain,tabFragment);
        tr.commit();
    }
}