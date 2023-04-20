package com.example.staggeredgrid02;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RecAdapter extends RecyclerView.Adapter<RecAdapter.ViewHolder>{
    private List<City> list;

    public RecAdapter(List<City> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public RecAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecAdapter.ViewHolder holder, int position) {
        City listItem = list.get(position);
        //todo
        holder.tv.setText(listItem.getName());
        Glide.with(holder.iv.getContext())
                .load(listItem.getUrl())
                .into(holder.iv);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv;
        private TextView tv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            iv = itemView.findViewById(R.id.iv);
            iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
            int height = ThreadLocalRandom.current().nextInt(250, 600);
            iv.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, height));

            tv = itemView.findViewById(R.id.tv);
        }
    }
}
