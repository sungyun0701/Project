package com.example.mylabf;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class Switch_0423 extends AppCompatActivity {

    private TextView textView;
    private Switch switch_visible,switch_bold,switch_color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch_0423);

        textView = findViewById(R.id.text_switch);
        switch_visible = findViewById(R.id.switch_visibility);
        switch_visible.setChecked(true);
        switch_visible.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    textView.setVisibility(View.VISIBLE);
                else
                    textView.setVisibility(View.INVISIBLE);
            }
        });
        switch_bold = findViewById(R.id.switch_bold);
        switch_bold.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    textView.setTypeface(null, Typeface.BOLD);
                else
                    textView.setTypeface(null, Typeface.NORMAL);
            }
        });
        switch_color = findViewById(R.id.switch_color);
        switch_color.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    textView.setTextColor(Color.RED);
                else
                    textView.setTextColor(Color.BLACK);
            }
        });
    }
}