package com.example.mylabf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Radio_0422 extends AppCompatActivity {

    private TextView textView;
    private RadioButton radio_man, radio_woman, radio_robot;
    private Button radio_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_0422);

        textView = findViewById(R.id.textTitle);
        radio_man = findViewById(R.id.radio_man);
        radio_man.setChecked(true);
        radio_woman = findViewById(R.id.radio_woman);
        radio_robot = findViewById(R.id.radio_robot);
        textView.setText("남자가 체크되었습니다.");
        radio_man.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (radio_woman.isChecked())
                    textView.setText("여자가 체크 되었습니다.");
                else
                    textView.setText("로봇이 체크 되었습니다.");
            }
        });
        radio_woman.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (radio_man.isChecked())
                    textView.setText("남자가 체크 되었습니다.");
                else
                    textView.setText("로봇이 체크 되었습니다.");
            }
        });
        radio_robot.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (radio_man.isChecked())
                    textView.setText("남자가 체크 되었습니다.");
                else
                    textView.setText("여자가 체크 되었습니다.");
            }
        });
        radio_button = findViewById(R.id.radio_button);
        radio_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str;
                if(radio_man.isChecked() )
                    str = "남자";
                else if(radio_woman.isChecked() )
                    str = "여자";
                else
                    str = "로봇";
                Toast.makeText(getApplicationContext(),str,Toast.LENGTH_SHORT).show();
                String me = v.getContext().toString();
                String me1= getApplicationContext().toString();
                System.out.println(me);
                System.out.println("me1:"+me1);
            }
        });
    }
}