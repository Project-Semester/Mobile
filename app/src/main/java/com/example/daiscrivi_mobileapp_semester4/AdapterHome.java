package com.example.daiscrivi_mobileapp_semester4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

public class AdapterHome extends RecyclerView.Adapter<AdapterHome.MyViewHolder> {

    Context context;
    ArrayList<News> newsArrayList;

    public AdapterHome(Context context, ArrayList<News> newsArrayList) {

        this.context = context;
        this.newsArrayList = newsArrayList;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.card_imageslider, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        News news = newsArrayList.get(position);
        holder.tvHeading.setText(news.heading);
        holder.titleImage.setImageResource(news.titleImage);

    }

    @Override
    public int getItemCount() {
        return newsArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ShapeableImageView titleImage;
        TextView tvHeading;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titleImage = itemView.findViewById(R.id.rvImage);
            tvHeading = itemView.findViewById(R.id.rvText);
        }

    }

}
