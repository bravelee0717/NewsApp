package com.example.newsapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by LiYong on 2019-09-09.
 */
public abstract class BaseAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        BaseViewHolder viewHolder = new BaseViewHolder(LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder viewHolder, final int position) {
        viewHolder.getConvertView().setClickable(true);
        viewHolder.getConvertView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClick(position);
            }
        });
        viewHolder.getConvertView().setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                onItemLongClick(position);
                return true;
            }
        });
        onBindView(viewHolder, position);
    }

    @Override
    public int getItemViewType(int position) {
        return getLayoutId(position);
    }

    //点击事件供外部重写
    public void onItemClick(int position) {
    }

    //提供抽象方法供外部调用长按事件
    public void onItemLongClick(int position) {

    }

    //提供接口向外部提供视图管理器和pos
    public abstract void onBindView(BaseViewHolder viewHolder, int position);

    //RecyclerView item布局
    public abstract int getLayoutId(int position);

}
