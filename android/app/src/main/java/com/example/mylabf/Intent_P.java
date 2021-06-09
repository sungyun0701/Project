package com.example.mylabf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Intent_P extends AppCompatActivity {

    private Button btn_move;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent__p);

        btn_move = findViewById(R.id.btn_move);
        editText = findViewById(R.id.editText1);
        btn_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 이동 버튼을 클릭 했을때 동작
                String str = editText.getText().toString();
                Intent intent = new Intent(Intent_P.this, Intent_C.class);
                intent.putExtra("str",str);
                startActivity(intent);
                editText.setText("");
                editText.setHint("글자를 입력하세요");
            }
        });
    }
}