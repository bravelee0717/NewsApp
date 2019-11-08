package com.example.newsapp.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by weihuajian on 16/2/19.
 */
public class IconTextView extends TextView {
    public IconTextView(Context context) {
        this(context, null);
    }

    public IconTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public IconTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initTypeFace();

    }

    private void initTypeFace() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "iconfont/fontello.ttf");
        setTypeface(tf);
    }

}
