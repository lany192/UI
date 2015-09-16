package com.lany.ui.textview;

/**
 * Created by user on 2015/9/16.
 */
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class MyTextView extends TextView{
    public MyTextView(Context context) {
        super(context);
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean isFocused() {
        return true;
    }
}