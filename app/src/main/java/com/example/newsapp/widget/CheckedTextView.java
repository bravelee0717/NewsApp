package com.example.newsapp.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.example.newsapp.R;

public class CheckedTextView extends TextView {

    private boolean isChecked;

    public CheckedTextView(Context context) {
        super(context);
    }

    public CheckedTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CheckedTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
        if (isChecked) {
            setTextColor(getResources().getColor(R.color._ff3b30));
        } else {
            setTextColor(getResources().getColor(R.color._444444));
        }
    }
}
