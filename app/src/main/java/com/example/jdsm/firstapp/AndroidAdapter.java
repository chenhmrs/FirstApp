package com.example.jdsm.firstapp;

import android.content.Context;
import android.net.LinkAddress;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jdsm on 2017/7/27.
 */

public class AndroidAdapter extends RecyclerView.Adapter<AndroidAdapter.ViewHolder> {
    public Context context;
    private List<Android> data3;
    public LayoutInflater layoutInflater;
    public AndroidAdapter(Context context,List<Android> data3){
        this.context=context;
        this.data3=data3;
        layoutInflater=LayoutInflater.from(context);
    }


    public interface OnClickListen{
        public void OnClickf(String url);
    }
    public OnClickListen listen;
    public void setOnClickf(OnClickListen listen){
        this.listen=listen;
    }
    @Override
    public AndroidAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=layoutInflater.inflate(R.layout.android_main,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AndroidAdapter.ViewHolder holder, int position) {
        String who=data3.get(position).getWho();
        String title=data3.get(position).getTitle();
        holder.textView.setText("Title:"+title + "\nFrom:"+(who==null?"unkenow":who));
     //   holder.textView.setText("Title:" + title + "\nFrom:" + (from == null ? "unknow" : from));

    }

    @Override
    public int getItemCount() {
        return data3.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.text_voew3)
        public TextView textView;
        public ViewHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listen!=null){
                        int pos=getLayoutPosition();
                        listen.OnClickf(data3.get(pos).getUrl());
                    }
                }
            });
        }
    }
}
