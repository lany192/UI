package com.lany.ui.image;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;

import com.lany.ui.BaseActivity;
import com.lany.ui.R;

public class ImageViewActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_image_view;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        EditText editText1 = (EditText) findViewById(R.id.img_edittext_1);
        final Drawable originalDrawable = editText1.getBackground();
        final Drawable wrappedDrawable = tintDrawable(originalDrawable, ColorStateList.valueOf(Color.RED));
        editText1.setBackgroundDrawable(wrappedDrawable);

        EditText editText2 = (EditText) findViewById(R.id.img_edittext_2);
        editText2.setBackgroundDrawable(tintDrawable(editText2.getBackground(),
                ColorStateList.valueOf(Color.parseColor("#03A9F4"))));

        ImageView imageView = (ImageView) findViewById(R.id.img_111);
        final Drawable originalBitmapDrawable = getResources().getDrawable(R.drawable.ico_home).mutate();
        imageView.setImageDrawable(tintDrawable(originalBitmapDrawable, ColorStateList.valueOf(Color.GREEN)));
    }

    /**
     * 找色器
     *
     * @param drawable
     * @param colors
     * @return
     */
    public static Drawable tintDrawable(Drawable drawable, ColorStateList colors) {
        final Drawable wrappedDrawable = DrawableCompat.wrap(drawable);
        DrawableCompat.setTintList(wrappedDrawable, colors);
        return wrappedDrawable;
    }

}
