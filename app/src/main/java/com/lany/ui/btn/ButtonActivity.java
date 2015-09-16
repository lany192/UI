package com.lany.ui.btn;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.lany.ui.R;

import butterknife.Bind;
import butterknife.ButterKnife;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_button, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
