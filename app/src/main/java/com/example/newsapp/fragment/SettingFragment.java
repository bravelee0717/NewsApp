package com.example.newsapp.fragment;


import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.newsapp.R;
import com.example.newsapp.utils.QRCodeUtil;

/**
 * 设置
 */
public class SettingFragment extends BaseFragment {

    private ImageView imageView;
    private Button bt_qr;
    private EditText editText;

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
    }

    @Override
    public void afterView() {
        bt_qr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(editText.getText().toString().trim())) {
                    return;
                }
                Bitmap bitmap = QRCodeUtil.createQRImage(editText.getText().toString().trim(), 300, 300, null, null);
                imageView.setImageBitmap(bitmap);
            }
        });
    }


}
