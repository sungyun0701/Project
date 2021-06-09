package com.example.mylabf;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CustomDialog_0426 extends AppCompatActivity {

    Button btn_login, btn_cancel;
    EditText et_username, et_password;
    int cnt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog_0426);
    }

    public void onClick(View view) {
        final Dialog logingDialog = new Dialog(CustomDialog_0426.this);
        logingDialog.setContentView(R.layout.custom_dialog);
        logingDialog.setTitle("로그인 화면");

        btn_login = logingDialog.findViewById(R.id.btn_login);
        btn_cancel = logingDialog.findViewById(R.id.btn_cancel);
        et_username = logingDialog.findViewById(R.id.et_username);
        et_password = logingDialog.findViewById(R.id.et_password);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et_username.getText().toString().trim().length() > 0 && et_password.getText().toString().trim().length() > 0){
                    if(et_username.getText().toString().trim().equals("sy")&&et_password.getText().toString().trim().equals("sy1234")){
                        cnt = 0;
                        Toast.makeText(getApplicationContext(), "로그인 성공!", Toast.LENGTH_SHORT).show();
                        //다이어로그 없애는 것
                        logingDialog.dismiss();
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "다시 입력하세요", Toast.LENGTH_SHORT).show();
                        cnt++;
                        if(cnt>4){
                            logingDialog.dismiss();
                        }
                    }

                }
                else {
                    Toast.makeText(getApplicationContext(), "다시 입력하세요", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logingDialog.dismiss();
            }
        });
        logingDialog.show();
    }
}