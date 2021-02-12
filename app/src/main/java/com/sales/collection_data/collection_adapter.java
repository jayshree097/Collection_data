package com.sales.collection_data;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class collection_adapter extends RecyclerView.Adapter<collection_adapter.HeroViewHolder>{

    Context mCtx;
    List<collectionModel> heroList;

    public collection_adapter(Context mCtx, List<collectionModel> heroList) {
        this.mCtx = mCtx;
        this.heroList = heroList;
    }



    @NonNull
    @Override
    public HeroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.single_collection_data, parent, false);
        return new HeroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroViewHolder holder, int position) {
//        final collectionModel hero = heroList.get(position);
        holder.text_userId.setText(heroList.get(position).userId);
        holder.text_id.setText(heroList.get(position).getId());
        holder.text_title.setText(heroList.get(position).getTitle());
        holder.text_body.setText(heroList.get(position).getBody());


    }
    @Override
    public int getItemCount() {
        return heroList.size();
    }

   public class HeroViewHolder extends RecyclerView.ViewHolder {


        TextView text_userId;
        TextView text_id;
        TextView text_title;
        TextView text_body;

        public HeroViewHolder(View itemView) {
            super(itemView);
            text_userId = itemView.findViewById(R.id.txt_userid);
            text_id = itemView.findViewById(R.id.txt_id);
            text_title = itemView.findViewById(R.id.txt_title);
            text_body = itemView.findViewById(R.id.txt_body);
        }
    }

}




//

