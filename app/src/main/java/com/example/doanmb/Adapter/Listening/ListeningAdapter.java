package com.example.doanmb.Adapter.Listening;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanmb.Activity.User.Listening.ActivityListening;
import com.example.doanmb.Model.Listening;
import com.example.doanmb.R;

import java.util.ArrayList;

public class ListeningAdapter extends RecyclerView.Adapter<ListeningAdapter.ListeningVH> implements Filterable {
    Context context;

    ArrayList<Listening> listenings;
    ArrayList<Listening> listeningsFilter;


    public ListeningAdapter(Context context, ArrayList<Listening> listenings) {
        this.context = context;
        this.listenings = listenings;
        this.listeningsFilter = listenings;
    }

    @Override
    public Filter getFilter() {
        return null;
    }

    @NonNull
    @Override
    public ListeningVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_rowlistlistening, parent,false);
        return new ListeningVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListeningVH holder, int position) {
        Listening listening = listeningsFilter.get(position);
        holder.btn_listeningpractice.setText(listening.getTitle());
        holder.btn_listeningpractice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ActivityListening.class);
                Bundle bundle = new Bundle();
                bundle.putString("Title", listening.getTitle());
                bundle.putString("FilePath", listening.getFilePath());
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
            return listeningsFilter.size();
    }


    public class ListeningVH extends RecyclerView.ViewHolder{
        Button btn_listeningpractice;
        public ListeningVH(@NonNull View itemView) {
            super(itemView);
            btn_listeningpractice = itemView.findViewById(R.id.btn_listeningpractice);
        }
    }

}
