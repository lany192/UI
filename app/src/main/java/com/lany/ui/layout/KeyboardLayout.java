package com.lany.ui.layout;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * 用于监听输入法是否弹出，做为布局的根节点时，当软键盘弹出或隐藏时会调用
 */
public class KeyboardLayout extends RelativeLayout {
    private OnKeyboardChangedListener mListener;

    public KeyboardLayout(Context context) {
        super(context);
    }

    public KeyboardLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public KeyboardLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int height = MeasureSpec.getSize(heightMeasureSpec);
        Activity activity = (Activity) getContext();
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int statusBarHeight = rect.top;
        int screenHeight = activity.getResources().getDisplayMetrics().heightPixels;
        int diff = (screenHeight - statusBarHeight) - height;
        if (mListener != null) {
            mListener.onKeyboardStateChanged(diff > 128); // assume all soft keyboards are at least 128 pixels high
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public void setOnKeyboardChangedListener(OnKeyboardChangedListener listener) {
        mListener = listener;
    }

    public interface OnKeyboardChangedListener {
        void onKeyboardStateChanged(boolean show);
    }
}
