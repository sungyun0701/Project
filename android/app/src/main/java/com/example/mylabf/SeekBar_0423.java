package com.example.mylabf;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class SeekBar_0423 extends AppCompatActivity {
    SeekBar seekbar_r,seekbar_b,seekbar_g;
    TextView textview_r, textview_g, textview_b,textView;
    int red=128,green=128,blue=128;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_bar_0423);

        textView = findViewById(R.id.textView_seek);
        textView.setTextColor(Color.rgb(red,green,blue));
        textview_r = findViewById(R.id.textView_r);
        textview_g = findViewById(R.id.textView_g);
        textview_b = findViewById(R.id.textView_b);

        seekbar_r = findViewById(R.id.seekBar_r);
        seekbar_r.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textview_r.setText(String.format("R(%03d)",progress));
                red = progress;
                textView.setTextColor(Color.rgb(red,green,blue));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        seekbar_g = findViewById(R.id.seekBar_g);
        seekbar_g.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textview_g.setText(String.format("G(%03d)",progress));
                green = progress;
                textView.setTextColor(Color.rgb(red,green,blue));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekbar_b = findViewById(R.id.seekBar_b);
        seekbar_b.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textview_b.setText(String.format("B(%03d)",progress));
                blue = progress;
                textView.setTextColor(Color.rgb(red,green,blue));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}