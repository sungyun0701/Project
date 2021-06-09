package com.example.mylabf;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class RecycleView_0426 extends AppCompatActivity implements MyRecyclerAdapter.MyRecylerViewClickListener {

    private int[] dog; //imageView
    private String[] dogname;
    private ArrayList<ItemData> dataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view_0426);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(RecycleView_0426.this);
        recyclerView.setLayoutManager(layoutManager);

        dog = new int[]{R.drawable.dog1,R.drawable.dog2,R.drawable.dog3,R.drawable.dog4,R.drawable.dog5,
                        R.drawable.dog6,R.drawable.dog7,R.drawable.dog8,R.drawable.dog9,R.drawable.dog10,
                        R.drawable.dog11,R.drawable.dog12,R.drawable.dog13,R.drawable.dog14,R.drawable.dog15,
                        R.drawable.dog16,R.drawable.dog17,R.drawable.dog18,R.drawable.dog19,R.drawable.dog20};
        dogname = new String[]{"R.drawable.dog1","R.drawable.dog2","R.drawable.dog3","R.drawable.dog4","R.drawable.dog5",
                                "R.drawable.dog6","R.drawable.dog7","R.drawable.dog8","R.drawable.dog9","R.drawable.dog10",
                                "R.drawable.dog11","R.drawable.dog12","R.drawable.dog13","R.drawable.dog14","R.drawable.dog15",
                                "R.drawable.dog16","R.drawable.dog17","R.drawable.dog18","R.drawable.dog19","R.drawable.dog20"};

        for(int i = 0; i<20; i++){
            dataList.add(new ItemData(dog[i],String.format("DOG %02d",i+1), String.format("강아지 리뷰 %03d", i+1)));
        }

        MyRecyclerAdapter adapter = new MyRecyclerAdapter(dataList);
        recyclerView.setAdapter(adapter);

        adapter.setOnClicklistener(this);
    }

    @Override
    public void onItemClicked(int position) {
        Toast.makeText(getApplicationContext(),""+position,Toast.LENGTH_SHORT).show();
    }
}