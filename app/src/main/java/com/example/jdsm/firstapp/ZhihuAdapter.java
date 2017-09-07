package com.example.jdsm.firstapp;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.security.Guard;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jdsm on 2017/7/27.
 */

public class ZhihuAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;

    private LayoutInflater inflater;

    private List<ZhiHu> items;

    private List<ZhiHu> header;

    private OnItemClickListener listener;


    public interface OnItemClickListener {
        public void onItemClick(String url);
    }


    public  ZhihuAdapter(Context context, List<ZhiHu> items, List<ZhiHu> header) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.items = items;
        this.header = header;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ZhiHu.TYPE_HEADER) {
            View view = inflater.inflate(R.layout.head_view, parent, false);
            return new TopViewHolder(view);
        } else {
            View view = inflater.inflate(R.layout.item_view, parent, false);
            return new ItemViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position == 0) {
            onBindHeader(holder);
        } else {
            onBindItems(holder, position);
        }
    }

    private void onBindHeader(RecyclerView.ViewHolder holder) {
        //这里的viewPager用的是TopViewHolder的实例，TopViewHolder继承RecyclerView.ViewHolder
        //RecyclerView.ViewHolder的实例holder，直接用pager用不了这是在另一个类中的东西，在一
        // 般的RecyclerView中用的是holder.pager,且holder也是MyViewHolder extends RecyclerView.ViewHolder
        //MyViewHolder holder，这里的holder是父类的，不是直接的，好像是把父类的holder强制变成了他的子类TopViewHolder
        //这样就能用TopViewHolder的pager了
        ViewPager viewPager = ((TopViewHolder) holder).pager;
        ViewPagerAdapter adapter=new ViewPagerAdapter();
        viewPager.setAdapter(adapter);
        // 不设置总会出现空白页，因为header总是5个，所以设置4个，
        // 这里还好不多，但是如果很多怎么办？
        // 都缓存就可能OOM
        viewPager.setOffscreenPageLimit(4);
    }

    private void onBindItems(RecyclerView.ViewHolder holder, int position) {
        Glide.with(context).load(items.get(position - 1).getImageUrl())
                .diskCacheStrategy(DiskCacheStrategy.ALL).into(((ItemViewHolder) holder).imageView);
        ((ItemViewHolder) holder).textView.setText(items.get(position - 1).getTitle());
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return ZhiHu.TYPE_HEADER;
        } else {
            return ZhiHu.TYPE_ITEM;
        }
    }

    @Override
    public int getItemCount() {
        // 加上header
        return items.size() + 1;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.image_view)
        public ImageView imageView;

        @BindView(R.id.text_voew)
        public TextView textView;

        public ItemViewHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onItemClick(items.get(getLayoutPosition() - 1).getWebUrl());
                    }
                }
            });
        }
    }

    public class TopViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.view_pager1)
        public ViewPager pager;

        public TopViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class ViewPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return header.size();
        }

        //判断一个页面是否和object对象的key是否相等，可以return view == object;相同则为true，这个key
        // 是instantiateItem函数返回的view
        //判断传入的页面和当前页是否是相同的，如果直接返回true，就滑不动了。
        @Override
        public boolean isViewFromObject(View view, Object object) {
            //Log.d("MainActivity","a");
            return view == object;
        }
        //这个函数的作用是在容器中（ViewGroup container）的指定位置（position）添加view，
        //实现container.addView(view);且这个函数和destroyItem都是在 finishUpdate(viewGroup)执行完后，
        // 有两个操作，一个是原视图的移除（不再显示的视图），另一个是新增显示视图（即将显示的视图）
        @Override
        public Object instantiateItem(ViewGroup container, final int position) {
            View view = inflater.inflate(R.layout.head_item, container, false);
            ImageView imageView = (ImageView) view.findViewById(R.id.image_view2);
            TextView textView = (TextView) view.findViewById(R.id.text_voew2);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onItemClick(header.get(position).getWebUrl());
                    }
                }
            });
            Glide.with(context).load(header.get(position).getImageUrl())
                    .diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
            textView.setText(header.get(position).getTitle());
            container.addView(view);
            //  Log.d("MainActivity","b");
            return view;
        }
        //该方法实现的功能是移除一个给定位置的页面。
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(container.getChildAt(position));
        }
    }
}

