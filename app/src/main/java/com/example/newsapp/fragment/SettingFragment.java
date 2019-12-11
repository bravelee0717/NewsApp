package com.example.newsapp.fragment;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.newsapp.R;
import com.example.newsapp.adapters.BaseAdapter;
import com.example.newsapp.adapters.BaseViewHolder;
import com.example.newsapp.model.Hero;
import com.example.newsapp.utils.QRCodeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 设置
 */
public class SettingFragment extends BaseFragment {

    private ImageView imageView;
    private Button bt_qr;
    private EditText editText;
    private RecyclerView recyclerView;
    private BaseAdapter baseAdapter;
    private List<Hero> data;

    public static SettingFragment getInstance() {
        return new SettingFragment();
    }

    @Override
    public int viewById() {
        return R.layout.fragment_setting;
    }


    @Override
    public void bindView(View rootView) {
        imageView = $(rootView, R.id.my_qrcode);
        bt_qr = $(rootView, R.id.bt_qr);
        editText = $(rootView, R.id.my_qrcode_et);
        recyclerView = $(rootView, R.id.listView);
    }

    @Override
    public void afterView() {
        initdata();
        initAdapter();
        bt_qr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(editText.getText().toString().trim())) {
                    return;
                }
                Bitmap bitmaplogo = BitmapFactory.decodeResource(getResources(), R.mipmap.qr_code, null);
                Bitmap bitmap = QRCodeUtil.createQRImage(editText.getText().toString().trim(), 300, 300, bitmaplogo, null);
                imageView.setImageBitmap(bitmap);
            }
        });
    }

    private void initdata() {
        data = new ArrayList<>();
        data.add(new Hero("上官婉儿", R.mipmap.text_xiuer));
        data.add(new Hero("李白", R.mipmap.libai));
        data.add(new Hero("伽罗", R.mipmap.text_jialuo));
        data.add(new Hero("赵云", R.mipmap.text_zhaoyun));
        data.add(new Hero("鲁班七号", R.mipmap.text_luban));
        data.add(new Hero("诸葛亮", R.mipmap.text_zhugeliang));
        data.add(new Hero("橘右京", R.mipmap.text_juzi));
    }

    private void initAdapter() {
        if (baseAdapter == null) {
            baseAdapter = new BaseAdapter() {
                @Override
                public void onBindView(BaseViewHolder viewHolder, int position) {
                    ImageView imageView = viewHolder.getView(R.id.image);
                    TextView textView = viewHolder.getView(R.id.name);
                    imageView.setBackgroundResource(data.get(position).getRes_id());
                    textView.setText(data.get(position).getName());
                }

                @Override
                public int getLayoutId(int position) {
                    return R.layout.item_honor_layout;
                }

                @Override
                public int getItemCount() {
                    return data.size();
                }
            };

            GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 4);
            recyclerView.setLayoutManager(gridLayoutManager);
            recyclerView.setAdapter(baseAdapter);
        } else {
            baseAdapter.notifyDataSetChanged();
        }
    }


}
