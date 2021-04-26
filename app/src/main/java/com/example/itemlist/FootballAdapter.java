package com.example.itemlist;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class FootballAdapter extends RecyclerView.Adapter<FootballAdapter.ViewHolder> {

    private Context context;
    private ArrayList<FootballModel> footballModels;

    public FootballAdapter(ArrayList<FootballModel> listData, Context context) {
        this.context = context;
    }

    public ArrayList<FootballModel> getFootballModels() {
        return footballModels;
    }

    public void setFootballModels(ArrayList<FootballModel> footballModels) {
        this.footballModels = footballModels;
    }

    @NonNull
    @Override
    public FootballAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_player,viewGroup,false);
        return new ViewHolder(itRow);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Glide.with(context).load(getFootballModels().get(i).getPhoto()).into(viewHolder.ivPhotoPlayer);
        viewHolder.tvNamePlayer.setText(getFootballModels().get(i).getPlayer_name());

        viewHolder.visit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);

                intent.putExtra("photo", getFootballModels().get(i).getPhoto());
                intent.putExtra("name", getFootballModels().get(i).getPlayer_name());
                intent.putExtra("preview", getFootballModels().get(i).getPreview());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getFootballModels().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView ivPhotoPlayer;
        private TextView tvNamePlayer;
        private Button visit;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            ivPhotoPlayer = itemView.findViewById(R.id.pic_photo);
            tvNamePlayer = itemView.findViewById(R.id.tx_name);
            visit = itemView.findViewById(R.id.btn_detail);
        }
    }
}
