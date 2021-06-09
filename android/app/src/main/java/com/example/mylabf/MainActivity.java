package com.example.mylabf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button1, button2, button3, button4, button5, button6,button7,button8,button9,button10,button11, button12,button13,button14,button15,button16,button17,button18,button19,button20,button21,button22,button23,button24;
//    private Button[] buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButtonOnClickListener onClickListener = new ButtonOnClickListener();

//        int[] button_ids={R.id.basebutton,}
//        int arrSize = button_ids.length;
//        for (int i=0; i<10; i++){
//            buttons[i] = findViewById(button_ids[i]);
//            buttons[i].setOnClickListener(onClickListener);
//        }

        button1 = findViewById(R.id.basebutton);
        button1.setOnClickListener(onClickListener);

        button2 = findViewById(R.id.Layout1);
        button2.setOnClickListener(onClickListener);

        button3 = findViewById(R.id.Layout2);
        button3.setOnClickListener(onClickListener);

        button4 = findViewById(R.id.intent1);
        button4.setOnClickListener(onClickListener);

        button5 = findViewById(R.id.button_0420);
        button5.setOnClickListener(onClickListener);

        button6 = findViewById(R.id.button_0421_1);
        button6.setOnClickListener(onClickListener);

        button7 = findViewById(R.id.button_0421_2);
        button7.setOnClickListener(onClickListener);

        button8 = findViewById(R.id.button_0422_1);
        button8.setOnClickListener(onClickListener);

        button9 = findViewById(R.id.button_0423_1);
        button9.setOnClickListener(onClickListener);

        button10 = findViewById(R.id.button_0423_2);
        button10.setOnClickListener(onClickListener);

        button11 = findViewById(R.id.button_0423_3);
        button11.setOnClickListener(onClickListener);

        button12 = findViewById(R.id.button_0423_4);
        button12.setOnClickListener(onClickListener);
        button13 = findViewById(R.id.button_0423_5);
        button13.setOnClickListener(onClickListener);
        button14 = findViewById(R.id.button_0423_6);
        button14.setOnClickListener(onClickListener);
        button15 = findViewById(R.id.button_0423_7);
        button15.setOnClickListener(onClickListener);
        button16 = findViewById(R.id.button_0423_8);
        button16.setOnClickListener(onClickListener);
        button17 = findViewById(R.id.button_0426_1);
        button17.setOnClickListener(onClickListener);
        button18 = findViewById(R.id.button_0426_2);
        button18.setOnClickListener(onClickListener);
        button19 = findViewById(R.id.button_0426_3);
        button19.setOnClickListener(onClickListener);
        button20 = findViewById(R.id.button_0426_4);
        button20.setOnClickListener(onClickListener);
        button21 = findViewById(R.id.button_0426_5);
        button21.setOnClickListener(onClickListener);
        button22 = findViewById(R.id.button_0426_6);
        button22.setOnClickListener(onClickListener);
        button23 = findViewById(R.id.button_0426_7);
        button23.setOnClickListener(onClickListener);
        button24 = findViewById(R.id.button_0428_1);
        button24.setOnClickListener(onClickListener);
    }

    class ButtonOnClickListener implements View.OnClickListener{
        @Override
        public  void onClick(View view){
            switch (view.getId()){
                case R.id.basebutton:
                    startActivity(new Intent(MainActivity.this, BaseButton.class));
                    break;
                case R.id.Layout1:
                    startActivity(new Intent(MainActivity.this, Layout1.class));
                    break;
                case R.id.Layout2:
                    startActivity(new Intent(MainActivity.this, Layout2.class));
                    break;
                case R.id.intent1:
                    startActivity(new Intent(MainActivity.this, Intent_P.class));
                    break;
                case R.id.button_0420:
                    startActivity(new Intent(MainActivity.this, Number_0420.class));
                    break;
                case R.id.button_0421_1:
                    startActivity(new Intent(MainActivity.this, Operator_0421.class));
                    break;
                case R.id.button_0421_2:
                    startActivity(new Intent(MainActivity.this,ImageChange_0421.class));
                    break;
                case R.id.button_0422_1:
                    startActivity(new Intent(MainActivity.this,Radio_0422.class));
                    break;
                case R.id.button_0423_1:
                    startActivity(new Intent(MainActivity.this,Date_0423.class));
                    break;
                case R.id.button_0423_2:
                    startActivity(new Intent(MainActivity.this,Temperature.class));
                    break;
                case R.id.button_0423_3:
                    startActivity(new Intent(MainActivity.this,Event1_0423.class));
                    break;
                case R.id.button_0423_4:
                    startActivity(new Intent(MainActivity.this,CheckEvent_0423.class));
                    break;
                case R.id.button_0423_5:
                    startActivity(new Intent(MainActivity.this,Toggle_0423.class));
                    break;
                case R.id.button_0423_6:
                    startActivity(new Intent(MainActivity.this,Rating_0423.class));
                    break;
                case R.id.button_0423_7:
                    startActivity(new Intent(MainActivity.this,Switch_0423.class));
                    break;
                case R.id.button_0423_8:
                    startActivity(new Intent(MainActivity.this,SeekBar_0423.class));
                    break;
                case R.id.button_0426_1:
                    startActivity(new Intent(MainActivity.this,OptionMenu_0426.class));
                    break;
                case R.id.button_0426_2:
                    startActivity(new Intent(MainActivity.this,ActionBar_0426.class));
                    break;
                case R.id.button_0426_3:
                    startActivity(new Intent(MainActivity.this,PopupMenu_0426.class));
                    break;
                case R.id.button_0426_4:
                    startActivity(new Intent(MainActivity.this,Alert_0426.class));
                    break;
                case R.id.button_0426_5:
                    startActivity(new Intent(MainActivity.this,DatePicker_0426.class));
                    break;
                case R.id.button_0426_6:
                    startActivity(new Intent(MainActivity.this,CustomDialog_0426.class));
                    break;
                case R.id.button_0426_7:
                    startActivity(new Intent(MainActivity.this,RecycleView_0426.class));
                    break;
                case R.id.button_0428_1:
                    startActivity(new Intent(MainActivity.this,JoyStick_0428.class));
                    break;
            }
        }
    }
}