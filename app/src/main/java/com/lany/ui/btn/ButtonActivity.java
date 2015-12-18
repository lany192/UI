package com.lany.ui.btn;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.lany.ui.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ButtonActivity extends AppCompatActivity {
    @Bind(R.id.blue_btn)
    Button blueBtn;
    @Bind(R.id.red_btn)
    Button redBtn;
    @Bind(R.id.white_btn)
    Button whiteBtn;
    @Bind(R.id.yellow)
    Button yellow;
    @Bind(R.id.red_half_round_btn)
    Button redHalfRoundBtn;
    @Bind(R.id.white_dotted_line_btn)
    Button whiteDottedLineBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.circle_btn)
    void circleBtnClick(){
        Toast.makeText(this,"点击签到",Toast.LENGTH_SHORT).show();
    }

}
