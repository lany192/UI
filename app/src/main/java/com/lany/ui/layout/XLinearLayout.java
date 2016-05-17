package com.lany.ui.layout;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;

/**
 * 点击空白区域收起输入法控件
 */
public class XLinearLayout extends LinearLayout {
    private Context mContext;

    public XLinearLayout(Context context) {
        super(context);
        this.mContext = context;
    }

    public XLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public XLinearLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mContext = context;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if (mContext instanceof Activity) {
                //点击空白区域收起输入法
                if (((Activity) mContext).getCurrentFocus() != null && ((Activity) mContext).getCurrentFocus().getWindowToken() != null) {
                    InputMethodManager manager = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
                    manager.hideSoftInputFromWindow(((Activity) mContext).getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                }
            }
        }
        return super.onTouchEvent(event);
    }
}
