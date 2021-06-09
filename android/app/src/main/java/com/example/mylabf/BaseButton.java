package com.example.mylabf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class BaseButton extends AppCompatActivity {

    private Button testButton;
    private TextView textView;
    private TextView editView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_button);

        // UI에 있는 버튼 연결
        testButton = findViewById(R.id.testbutton);
        textView = findViewById(R.id.textView);
        editView = findViewById(R.id.editText);

        testButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // 여기에 원하는 코드 작성
                String tmpText = "";

                if (testButton.getText().equals("Button")) {
                    String text = editView.getText().toString();
                    testButton.setText("Clicked");
                    tmpText = "클릭됨";
                    textView.setText(text);
                }
                else {
                    String text = editView.getText().toString();
                    testButton.setText("Button");
                    tmpText = "Go Back";
                    editView.setText("");
                    editView.setHint("What is your name?");
                    textView.setHint(text+" clicked!!");
                }

                Toast.makeText(getApplicationContext(), tmpText, Toast.LENGTH_SHORT).show();
            }
        });
    }
}