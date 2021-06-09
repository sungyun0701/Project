package com.example.mylabf;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class DatePicker_0426 extends AppCompatActivity {

    Button btn_date, btn_time;
    DatePickerDialog datePickerDialog;
    TimePickerDialog timePickerDialog;
    TextClock tClock;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker_0426);

        BtnOnClickListener onClickListener = new BtnOnClickListener();

        btn_date = findViewById(R.id.btn_date);
        btn_date.setOnClickListener(onClickListener);
        btn_time = findViewById(R.id.btn_time);
        btn_time.setOnClickListener(onClickListener);
        tClock = findViewById(R.id.textClock);
        textView = findViewById(R.id.textView_date);

    }

    private class BtnOnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            if(v.getId() == R.id.btn_date){
//                Toast.makeText(getApplicationContext(),"data", Toast.LENGTH_SHORT).show();
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(DatePicker_0426.this, new DatePickerDialog.OnDateSetListener(){

                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        btn_date.setText(year + "/" + (month+1) + "/" + dayOfMonth);
                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
            if(v.getId() == R.id.btn_time){
//                Toast.makeText(getApplicationContext(),"time", Toast.LENGTH_SHORT).show();
                final Calendar c = Calendar.getInstance();
                int mHour = c.get(Calendar.HOUR_OF_DAY);
                int mMinute = c.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(DatePicker_0426.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        btn_time.setText(String.format("%02d:%02d",hourOfDay,minute));
                        textView.setText("클릭 시간 : " + tClock.getText());
                    }
                }, mHour, mMinute, false);
                timePickerDialog.show();
            }
        }
    }
}