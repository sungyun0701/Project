package com.example.mylabf;

import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder>{

    private ArrayList<ItemData> itemData;

    // 생성자를 만듦
    public MyRecyclerAdapter(ArrayList<ItemData> itemData) {
        this.itemData = itemData;
    }

    @NonNull
    @Override
    public MyRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    // 리스너 인터페이스 만들기
    public interface MyRecylerViewClickListener{
        void onItemClicked(int position);
    }
    private MyRecylerViewClickListener mListener;
    public void setOnClicklistener(MyRecylerViewClickListener listener){
        this.mListener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerAdapter.ViewHolder holder, int position) {
        ItemData item = itemData.get(position);
        holder.title_text.setText(item.getTitle());
        holder.content_text.setText(item.getContents());
        holder.imageView.setImageResource(item.getImage());

        if(mListener != null){
            final int pos = position;
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onItemClicked(pos);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        // 아이템이 몇개 인가?
        return itemData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title_text;
        TextView content_text;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title_text = itemView.findViewById(R.id.title_text);
            content_text = itemView.findViewById(R.id.contents_text);
            imageView = itemView.findViewById(R.id.imageView_launcher);
            imageView.setBackground(new ShapeDrawable(new OvalShape()));
            imageView.setClipToOutline(true);

        }
    }
}
