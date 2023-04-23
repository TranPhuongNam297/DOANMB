package com.example.doanmb.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanmb.Activity.ActivityShowInfoWord;
import com.example.doanmb.Activity.ActivityShowVocab;
import com.example.doanmb.Activity.ActivityVocab;
import com.example.doanmb.R;
import com.example.doanmb.Vocab;

import java.util.ArrayList;
import java.util.List;

public class VocabAdapter extends RecyclerView.Adapter<VocabAdapter.VocabVH> implements Filterable {
    Context context;
    ArrayList<Vocab> vocabs;
    ArrayList<Vocab> vocabsFilter;

    Listener listener;

    public VocabAdapter(Context context, ArrayList<Vocab> vocabs, Listener listener) {
        this.context = context;
        this.vocabs = vocabs;
        this.vocabsFilter = vocabs;
        this.listener = listener;
    }

    @Override
    public Filter getFilter() {
        return null;
    }

    @NonNull
    @Override
    public VocabVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_row, parent,false);
        return new VocabVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VocabVH holder, int position) {
        Vocab vocab = vocabsFilter.get(position);
        holder.word.setText(vocab.getEnglish());
        holder.wordV.setText(vocab.getTieng_Viet());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, ActivityShowInfoWord.class);
                Bundle bundle = new Bundle();
                bundle.putString("Tieng Viet", vocab.getTieng_Viet());
                bundle.putString("English", vocab.getEnglish());
                bundle.putString("Phat Am", vocab.getPhat_Am());
                bundle.putString("Vi Du", vocab.getVi_Du());
                bundle.putString("Vi Du2", vocab.getVi_Du2());
                i.putExtras(bundle);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return vocabsFilter.size();
    }




    public class VocabVH extends RecyclerView.ViewHolder{
        TextView word, wordV;
        public VocabVH(@NonNull View itemView) {
            super(itemView);
            word = itemView.findViewById(R.id.word);
            wordV = itemView.findViewById(R.id.wordV);
        }
    }

    public interface Listener{

    }
}
