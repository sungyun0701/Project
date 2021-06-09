package com.example.mylabf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class CheckEvent_0423 extends AppCompatActivity {

    CheckBox checkBox_meat, checkBox_cheese, checkBox_wine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_event_0423);

        checkBox_meat = findViewById(R.id.checkbox_meat);
        checkBox_cheese = findViewById(R.id.checkbox_cheese);
        checkBox_wine = findViewById(R.id.checkbox_wine);

        checkBox_meat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str;
                boolean checked = ((CheckBox)v).isChecked();
                if(checked){
                    str = "고기선택";
                }
                else {
                    str = "고기선택 해제";
                }
                Toast.makeText(getApplicationContext(),str,Toast.LENGTH_SHORT).show();
            }
        });
        checkBox_cheese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str;
                boolean checked = ((CheckBox)v).isChecked();
                if(checked){
                    str = "치즈선택";
                }
                else {
                    str = "치즈선택 해제";
                }
                Toast.makeText(getApplicationContext(),str,Toast.LENGTH_SHORT).show();
            }
        });
        checkBox_wine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str;
                boolean checked = ((CheckBox)v).isChecked();
                if(checked){
                    str = "와인선택";
                }
                else {
                    str = "와인선택 해제";
                }
                Toast.makeText(getApplicationContext(),str,Toast.LENGTH_SHORT).show();
            }
        });
    }

//    public void onCheckboxClicked(View view) {
//
//    }
}