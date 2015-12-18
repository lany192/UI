package com.lany.ui;

import java.lang.reflect.Field;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {
    protected final String TAG = this.getClass().getSimpleName();
    protected LayoutInflater mInflater;
    protected Context self;
    private Toolbar mToolbar;
    private RelativeLayout mViewContainer;
    private TextView mTitleText;

    protected void onBeforeSetContentView() {

    }

    protected abstract int getLayoutId();

    protected abstract void init(Bundle savedInstanceState);

    protected boolean hasToolbar() {
        return true;
    }

    protected boolean hasBackBtn() {
        return true;
    }

    protected int getToolbarLayoutId() {
        return R.layout.custom_default_toolbar_layout;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");
        self = this;
        mInflater = LayoutInflater.from(this);
        onBeforeSetContentView();
        setContentView(R.layout.activity_base);
        mViewContainer = (RelativeLayout) findViewById(R.id.base_layout);
        if (hasToolbar()) {
            initToolBar();
        }
        initContentView();
        ButterKnife.bind(this);
        setBarTitle(getTitle() + "");
        init(savedInstanceState);
    }

    private void initToolBar() {
        mToolbar = (Toolbar) mInflater.inflate(R.layout.toolbar, null);
        int actionBarHeight = getResources().getDimensionPixelSize(
                R.dimen.actionbar_height);
        LayoutParams toolbarParams = new LayoutParams(
                LayoutParams.MATCH_PARENT, actionBarHeight);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            int statusHeight = getStatusHeight();
            toolbarParams.height = actionBarHeight + statusHeight;
            mToolbar.setPadding(0, statusHeight, 0, 0);
        }
        mViewContainer.addView(mToolbar, toolbarParams);
        setSupportActionBar(mToolbar);
        View toolbarView = mInflater.inflate(getToolbarLayoutId(), null);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(
                toolbarView,
                new ActionBar.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT,
                        ActionBar.LayoutParams.MATCH_PARENT));
        View backBtn = null;
        try {
            backBtn = toolbarView.findViewById(R.id.custom_toolbar_back_btn);
        } catch (Exception e) {
            Log.e(TAG,
                    "Please use the 'R.id.custom_toolbar_back_btn' field to back in custom toolbar layout.");
        }
        try {
            mTitleText = (TextView) toolbarView
                    .findViewById(R.id.custom_toolbar_title_text);
        } catch (Exception e) {
            Log.e(TAG,
                    "Please use the 'R.id.custom_toolbar_title_text' field to set title in custom toolbar layout.");
        }
        if (hasBackBtn()) {
            backBtn.setVisibility(View.VISIBLE);
            backBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onCustomBackPressed();
                }
            });
        } else {
            backBtn.setVisibility(View.GONE);
        }
    }

    protected int getStatusHeight() {
        try {
            Class<?> c = Class.forName("com.android.internal.R$dimen");
            Object obj = c.newInstance();
            Field field = c.getField("status_bar_height");
            int x = Integer.parseInt(field.get(obj).toString());
            return getResources().getDimensionPixelSize(x);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return 0;
    }

    private void initContentView() {
        if (getLayoutId() != 0) {
            View contentView = mInflater.inflate(getLayoutId(), null);
            LayoutParams contentParams = new LayoutParams(
                    LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
            if (hasToolbar()) {
                contentParams.addRule(RelativeLayout.BELOW, mToolbar.getId());
            }
            mViewContainer.addView(contentView, contentParams);
        } else {
            new Exception(
                    "getLayoutId() return 0 , you need a layout file resources");
        }
    }

    public void setBarTitle(int resId) {
        if (hasToolbar()) {
            if (resId != 0) {
                mTitleText.setText(getString(resId));
            }
        } else {
            new Exception("No actionbar, can't call this method.");
        }
    }

    public void setBarTitle(String title) {
        if (hasToolbar()) {
            if (!TextUtils.isEmpty(title)) {
                mTitleText.setText(title);
            }
        } else {
            new Exception("No actionbar, can't call this method.");
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onCustomBackPressed();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            onCustomBackPressed();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    protected void onCustomBackPressed() {
        onBackPressed();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }
}