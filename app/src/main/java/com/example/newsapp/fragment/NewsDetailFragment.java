package com.example.newsapp.fragment;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.newsapp.R;
import com.example.newsapp.adapters.BaseAdapter;
import com.example.newsapp.adapters.BaseViewHolder;
import com.example.newsapp.model.NewsModel;

import java.util.ArrayList;
import java.util.List;

/**
 * 新闻消息fragment
 */
public class NewsDetailFragment extends BaseFragment {

    private RecyclerView news_ry;
    private BaseAdapter baseAdapter;
    private List<NewsModel> list;

    public static NewsDetailFragment newInstance(int position) {
        NewsDetailFragment fragment = new NewsDetailFragment();
        Bundle args = new Bundle();
        args.putInt("position", position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void bindView(View rootView) {
        news_ry = $(rootView, R.id.news_ry);
    }

    @Override
    public int viewById() {
        return R.layout.fragment_news_detail;
    }

    @Override
    public void afterView() {
        int position = getArguments().getInt("position");
        if (position == 0) {
            getKejiNews();
        } else if (position == 1) {
            getyuleNews();
        } else if (position == 2) {
            gettiyuNews();
        } else if (position == 3) {
            getjunshiNews();
        } else if (position == 4) {
            getKejiNews();
        }
        initAdapter();
    }

    private void getKejiNews() {
        list = new ArrayList<>();
        list.add(new NewsModel("iphone设计停滞不前 安卓手机则变得越来越酷", R.mipmap.iphone, "2019-02-23 07:05"));
        list.add(new NewsModel("iphone设计停滞不前 安卓手机则变得越来越酷", R.mipmap.iphone, "2019-02-23 07:05"));
        list.add(new NewsModel("iphone设计停滞不前 安卓手机则变得越来越酷", R.mipmap.iphone, "2019-02-23 07:05"));
        list.add(new NewsModel("iphone设计停滞不前 安卓手机则变得越来越酷", R.mipmap.iphone, "2019-02-23 07:05"));
        list.add(new NewsModel("iphone设计停滞不前 安卓手机则变得越来越酷", R.mipmap.iphone, "2019-02-23 07:05"));
        list.add(new NewsModel("iphone设计停滞不前 安卓手机则变得越来越酷", R.mipmap.iphone, "2019-02-23 07:05"));
        list.add(new NewsModel("iphone设计停滞不前 安卓手机则变得越来越酷", R.mipmap.iphone, "2019-02-23 07:05"));
    }
    private void getyuleNews() {
        list = new ArrayList<>();
        list.add(new NewsModel("吴亦凡演唱会门票是真的难搞啊，有毒吧大碗宽面", R.mipmap.huangzitao, "2019-02-22 18:05"));
        list.add(new NewsModel("吴亦凡演唱会门票是真的难搞啊，有毒吧大碗宽面", R.mipmap.huangzitao, "2019-02-23 07:05"));
        list.add(new NewsModel("吴亦凡演唱会门票是真的难搞啊，有毒吧大碗宽面", R.mipmap.huangzitao, "2019-02-23 07:05"));
        list.add(new NewsModel("吴亦凡演唱会门票是真的难搞啊，有毒吧大碗宽面", R.mipmap.huangzitao, "2019-02-23 07:05"));
        list.add(new NewsModel("吴亦凡演唱会门票是真的难搞啊，有毒吧大碗宽面", R.mipmap.huangzitao, "2019-02-23 07:05"));
        list.add(new NewsModel("吴亦凡演唱会门票是真的难搞啊，有毒吧大碗宽面", R.mipmap.huangzitao, "2019-02-23 07:05"));
        list.add(new NewsModel("吴亦凡演唱会门票是真的难搞啊，有毒吧大碗宽面", R.mipmap.huangzitao, "2019-02-23 07:05"));
    }
    private void gettiyuNews() {
        list = new ArrayList<>();
        list.add(new NewsModel("科比布莱恩特宣布退役，神话将不再延续", R.mipmap.kebi, "2019-02-22 18:05"));
        list.add(new NewsModel("科比布莱恩特宣布退役，神话将不再延续", R.mipmap.kebi, "2019-02-23 07:05"));
        list.add(new NewsModel("科比布莱恩特宣布退役，神话将不再延续", R.mipmap.kebi, "2019-02-23 07:05"));
        list.add(new NewsModel("科比布莱恩特宣布退役，神话将不再延续", R.mipmap.kebi, "2019-02-23 07:05"));
        list.add(new NewsModel("科比布莱恩特宣布退役，神话将不再延续", R.mipmap.kebi, "2019-02-23 07:05"));
        list.add(new NewsModel("科比布莱恩特宣布退役，神话将不再延续", R.mipmap.kebi, "2019-02-23 07:05"));
        list.add(new NewsModel("科比布莱恩特宣布退役，神话将不再延续", R.mipmap.kebi, "2019-02-23 07:05"));
    }
    private void getjunshiNews() {
        list = new ArrayList<>();
        list.add(new NewsModel("逆了苍天，踏破碧落黄泉。邂逅你是生生世世的宿命", R.mipmap.kebi, "2019-02-22 18:05"));
        list.add(new NewsModel("逆了苍天，踏破碧落黄泉。邂逅你是生生世世的宿命", R.mipmap.kebi, "2019-02-23 07:05"));
        list.add(new NewsModel("逆了苍天，踏破碧落黄泉。邂逅你是生生世世的宿命", R.mipmap.kebi, "2019-02-23 07:05"));
        list.add(new NewsModel("逆了苍天，踏破碧落黄泉。邂逅你是生生世世的宿命", R.mipmap.kebi, "2019-02-23 07:05"));
        list.add(new NewsModel("逆了苍天，踏破碧落黄泉。邂逅你是生生世世的宿命", R.mipmap.kebi, "2019-02-23 07:05"));
        list.add(new NewsModel("逆了苍天，踏破碧落黄泉。邂逅你是生生世世的宿命", R.mipmap.kebi, "2019-02-23 07:05"));
        list.add(new NewsModel("逆了苍天，踏破碧落黄泉。邂逅你是生生世世的宿命", R.mipmap.kebi, "2019-02-23 07:05"));
    }

    private void initAdapter() {
        if (baseAdapter == null) {
            baseAdapter = new BaseAdapter() {
                @Override
                public void onBindView(BaseViewHolder viewHolder, int position) {
                    TextView title = viewHolder.getView(R.id.title);
                    TextView time = viewHolder.getView(R.id.time);
                    ImageView imageView = viewHolder.getView(R.id.image);
                    title.setText(list.get(position).getTitle());
                    imageView.setBackgroundResource(list.get(position).getResId());
                    time.setText(list.get(position).getTime());
                }

                @Override
                public int getLayoutId(int position) {
                    return R.layout.item_news;
                }

                @Override
                public int getItemCount() {
                    return list.size();
                }
            };
            LinearLayoutManager layout = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
            news_ry.setLayoutManager(layout);
            news_ry.setAdapter(baseAdapter);
        } else {
            baseAdapter.notifyDataSetChanged();
        }
    }
}
