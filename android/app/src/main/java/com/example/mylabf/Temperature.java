package com.example.mylabf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class Temperature extends AppCompatActivity {

    EditText editCent, editFha;
    RadioButton radio_Fha,radio_Cent;
    Button btn_convert, btn_clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);

        editCent = findViewById(R.id.editCent);
        editFha = findViewById(R.id.editFha);
        radio_Cent = findViewById(R.id.radio_Cent);
        radio_Fha = findViewById(R.id.radio_Fha);
        radio_Fha.setChecked(true);
        btn_convert = findViewById(R.id.btn_convert);
        btn_clear = findViewById(R.id.btn_clear);
        btn_convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(radio_Fha.isChecked()){
                    double val = Double.parseDouble(editCent.getText().toString());
                    double change_value = 9.0/5.0*val+32.0;
                    editFha.setText(String.format("%.2f", change_value));
                }
                else{
                    double val = Double.parseDouble(editFha.getText().toString());
                    double change_value = 5.0/9.0*(val-32);
                    editCent.setText(String.format("%.2f", change_value));
                }
            }
        });
        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editCent.setText("0.0");
                editFha.setText("0.0");
            }
        });
    }
}