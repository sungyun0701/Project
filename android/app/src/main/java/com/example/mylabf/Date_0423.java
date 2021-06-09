package com.example.mylabf;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

public class Date_0423 extends AppCompatActivity {

    private Button showdate;
    private EditText dateTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_0423);

        dateTxt = findViewById(R.id.dateTxt);
        showdate = findViewById(R.id.showDate);
        showdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                1번째 방법
//                String str = String.format("오늘 날짜는 %s.", new Date());
//                dateTxt.setText(str);
//                2번째 방법
                Date day = new Date();
                String patternDate = "yyyy-MM-dd";
                SimpleDateFormat p1 = new SimpleDateFormat(patternDate);
                String str = String.format("오늘 날짜는 %s", p1.format(day));
                dateTxt.setText(str);
                Toast.makeText(getBaseContext(),str,Toast.LENGTH_LONG).show();
            }
        });
    }
}