package com.android.uas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class FootballAdapter extends RecyclerView.Adapter<FootballAdapter.ListViewHolder> {
    private ArrayList<Football> listFootball;

    public FootballAdapter(ArrayList<Football> listFootball) {
        this.listFootball = listFootball;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Football football = listFootball.get(position);

        holder.txtClub.setText(football.getStrEvent());
        holder.txtPlace.setText(football.getStrVenue());
        holder.txtTime.setText(football.getStrTime());
        holder.txtDate.setText(football.getDateEvent());
        holder.txtScoreHome.setText(football.getIntHomeScore().toString());
        holder.txtScoreAway.setText(football.getIntAwayScore().toString());

        Glide.with(holder.itemView)
                .load("https://www.thesportsdb.com/images/media/league/badge/i6o0kh1549879062.png")
                .into(holder.imgPoster);
    }

    @Override
    public int getItemCount() {
        return listFootball.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        TextView txtClub;
        TextView txtTime;
        TextView txtPlace;
        TextView txtDate;
        TextView txtScoreHome;
        TextView txtScoreAway;
        ImageView imgPoster;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            txtClub = itemView.findViewById(R.id.txtClub);
            txtTime = itemView.findViewById(R.id.txtTime);
            txtPlace = itemView.findViewById(R.id.txtPlace);
            txtDate = itemView.findViewById(R.id.txtDate);
            txtScoreHome = itemView.findViewById(R.id.txtScoreHome);
            txtScoreAway = itemView.findViewById(R.id.txtScoreAway);
            imgPoster = itemView.findViewById(R.id.imgPoster);
        }
    }
}
