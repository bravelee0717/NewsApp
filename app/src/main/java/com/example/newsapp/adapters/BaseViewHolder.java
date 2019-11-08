package com.example.newsapp.adapters;


import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

/**
 * Created by LiYong on 2019-09-09.
 */
public class BaseViewHolder extends RecyclerView.ViewHolder {
    protected View convertView;

    public View getConvertView() {
        return convertView;
    }

    public void setConvertView(View convertView) {
        this.convertView = convertView;
    }

    protected SparseArray<View> mViews = new SparseArray<>();//保存子视图，不必每次都去寻找

    public BaseViewHolder(View itemView) {
        super(itemView);
        convertView = itemView;
    }

    public <T extends View> T getView(@IdRes int id) {
        View view = mViews.get(id);
        if (view == null) {
            view = convertView.findViewById(id);
            mViews.put(id, view);
        }
        return (T) view;
    }
}
