package com.example.mylabf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Event1_0423 extends AppCompatActivity {

    private Button button02, button03;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event1_0423);

        Button.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.button02:
                        Toast.makeText(getApplicationContext(),"버튼2 클릭됨",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.button03:
                        Toast.makeText(getApplicationContext(),"버튼3 클릭됨",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        };
        button02 = findViewById(R.id.button02);
        button02.setOnClickListener(onClickListener);
        button03 = findViewById(R.id.button03);
        button03.setOnClickListener(onClickListener);
    }

    public void button1Click(View view) {
        Toast.makeText(getApplicationContext(),"버튼1",Toast.LENGTH_SHORT).show();
    }
}