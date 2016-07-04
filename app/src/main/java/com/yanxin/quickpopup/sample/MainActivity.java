package com.yanxin.quickpopup.sample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.yanxin.quickpopup.library.QuickPopup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void popup(View view) {
        TextView textView = new TextView(this);
        textView.setText("HelloWorld!");
        textView.setBackgroundColor(Color.GREEN);
        new QuickPopup()
                .with(view)
                .offsetX(100)
                .offsetY(100)
                .location(QuickPopup.Location.BOTTOM)
                .setContentView(textView)
                .show();
    }

}
