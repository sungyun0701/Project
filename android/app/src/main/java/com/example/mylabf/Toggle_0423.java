package com.example.mylabf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Toggle_0423 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle_0423);
    }

    public void oNToggleClicked(View view) {
        boolean toggleCheck = ((ToggleButton)view).isChecked();
        String str;
        if(toggleCheck){
            str = "토글 Checked";
        }
        else{
            str = "토글 Not Checked";
        }
        Toast.makeText(getApplicationContext(),str,Toast.LENGTH_SHORT).show();
    }
}