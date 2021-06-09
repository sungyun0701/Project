package com.example.mylabf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ImageChange_0421 extends AppCompatActivity {

    private Button btn_front,btn_back;
    private ImageView[] images;
    private int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_change_0421);
        images = new ImageView[10];
        int[] image_id = {R.id.imageView0,R.id.imageView1,R.id.imageView2,R.id.imageView3,R.id.imageView4,R.id.imageView5,R.id.imageView6,R.id.imageView7,R.id.imageView8,R.id.imageView9};
        for(int i=0; i<10; i++){
            images[i] = findViewById(image_id[i]);
        }

        btn_front = findViewById(R.id.button_front);
        btn_front.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count += 1;
                if (count>9){
                    count = 0;
                }
                for(int i=0; i<10;i++){
                    images[i].setVisibility(View.INVISIBLE);
                }
                images[count].setVisibility(View.VISIBLE);
            }
        });

        btn_back = findViewById(R.id.button_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count -= 1;
                if (count<0){
                    count = 9;
                }
                for(int i=0; i<10;i++){
                    images[i].setVisibility(View.INVISIBLE);
                }
                images[count].setVisibility(View.VISIBLE);
            }
        });
    }
}