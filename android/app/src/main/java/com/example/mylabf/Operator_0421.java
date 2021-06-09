package com.example.mylabf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Operator_0421 extends AppCompatActivity {

    private EditText editText,editText1;
    private TextView result;
    private int numresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operator_0421);

        int [] btn_id = {R.id.btnadd,R.id.btnsub,R.id.btnmul,R.id.btndiv,R.id.btnrem,R.id.clearNumber};
        Button[] btn_ope = new Button[6];
        for(int i=0; i<6;i++){
            btn_ope[i] = findViewById(btn_id[i]);
        }

        editText = findViewById(R.id.inputNumber1);
        editText1 = findViewById(R.id.inputNumber2);
        result = findViewById(R.id.result);

        for (int i=0; i<6;i++){
            btn_ope[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Button button = (Button)v;
                    String num1 = editText.getText().toString();
                    String num2 = editText1.getText().toString();

                    if (num1.equals("") || num2.equals("")){
                        result.setText("숫자를 입력하시오");
                    }
                   if(button.getText().toString().equals("+")){
                       if(!num1.equals("") && !num2.equals("")) {
                            numresult = Integer.parseInt(num1) + Integer.parseInt(num2);
                            result.setText(Integer.toString(numresult));
                        }
                    }
                   if(button.getText().toString().equals("-")){
                        if(!num1.equals("") && !num2.equals("")) {
                            numresult = Integer.parseInt(num1) - Integer.parseInt(num2);
                            result.setText(Integer.toString(numresult));
                        }
                   }
                   if(button.getText().toString().equals("*")) {
                       if (!num1.equals("") && !num2.equals("")) {
                           numresult = Integer.parseInt(num1) * Integer.parseInt(num2);
                           result.setText(Integer.toString(numresult));
                       }
                   }
                   if(button.getText().toString().equals("/")){
                       if(!num1.equals("") && !num2.equals("")) {
                           numresult = Integer.parseInt(num1) / Integer.parseInt(num2);
                           result.setText(Integer.toString(numresult));
                       }
                   }
                   if(button.getText().toString().equals("%")){
                       if(!num1.equals("") && !num2.equals("")) {
                           numresult = Integer.parseInt(num1) % Integer.parseInt(num2);
                           result.setText(Integer.toString(numresult));
                       }
                   }
                   if(button.getText().toString().equals("Clear")){
                       if(!num1.equals("") && !num2.equals("")) {
                           editText.setText("");
                           editText1.setText("");
                       }
                   }

                }
            });
        }
    }
}