package com.lany.ui.textview;

import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.TextView;

import com.lany.ui.R;

public class RainbowTextView extends TextView {
    public RainbowTextView(Context context) {
        super(context);
    }

    public RainbowTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RainbowTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public RainbowTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        int[] rainbow = getRainbowColors();
        Shader shader = new LinearGradient(0, 0, 0, w, rainbow,
                null, Shader.TileMode.MIRROR);
        Matrix matrix = new Matrix();
        matrix.setRotate(90);
        shader.setLocalMatrix(matrix);
        getPaint().setShader(shader);
    }

    private int[] getRainbowColors() {
        return new int[]{
                getResources().getColor(R.color.holo_red_light),
                getResources().getColor(R.color.holo_orange_light),
                getResources().getColor(R.color.holo_green_light),
                getResources().getColor(R.color.holo_blue_bright),
                getResources().getColor(R.color.holo_orange_light)
        };
    }
}