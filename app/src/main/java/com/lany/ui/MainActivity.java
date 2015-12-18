package com.lany.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.lany.ui.btn.ButtonActivity;
import com.lany.ui.edittext.EditTextActivity;
import com.lany.ui.image.ImageViewActivity;
import com.lany.ui.textview.TextViewActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {
    @Bind(R.id.main_button_btn)
    Button buttonBtn;
    @Bind(R.id.main_text_btn)
    Button textViewBtn;
    @Bind(R.id.main_edittext_btn)
    Button edittextBtn;

    @Override
    protected boolean hasBackBtn() {
        return false;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init(Bundle savedInstanceState) {

    }

    @OnClick(R.id.main_button_btn)
    void gotoButton() {
        startActivity(new Intent(this, ButtonActivity.class));
    }

    @OnClick(R.id.main_text_btn)
    void gotoTextView() {
        startActivity(new Intent(this, TextViewActivity.class));
    }

    @OnClick(R.id.main_edittext_btn)
    void gotoEditText() {
        startActivity(new Intent(this, EditTextActivity.class));
    }


    @OnClick(R.id.main_imageview_btn)
    void gotoImageView() {
        startActivity(new Intent(this, ImageViewActivity.class));
    }

}
