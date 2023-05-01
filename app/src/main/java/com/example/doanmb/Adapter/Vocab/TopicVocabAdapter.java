package com.example.doanmb.Adapter.Vocab;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanmb.Activity.Admin.Vocab.ActivityShowListVocab;
import com.example.doanmb.Activity.User.Vocab.ActivityShowVocab;
import com.example.doanmb.R;
import com.example.doanmb.Model.Vocab;

import java.util.ArrayList;

public class TopicVocabAdapter extends RecyclerView.Adapter<TopicVocabAdapter.VocabVH> implements Filterable {
    Context context;
    ArrayList<Vocab> vocabs;
    ArrayList<Vocab> vocabsFilter;

    Listener listener;

    public TopicVocabAdapter(Context context, ArrayList<Vocab> vocabs, Listener listener) {
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_rowbuttonchudevocab, parent,false);
        return new VocabVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VocabVH holder, int position) {
        Vocab vocab = vocabsFilter.get(position);
        holder.btnshowchude.setText(vocab.getChu_De());
        holder.btnshowchude.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ActivityShowVocab.class);
                intent.putExtra("Chu_De", vocab.getChu_De());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return vocabsFilter.size();
    }




    public class VocabVH extends RecyclerView.ViewHolder{
        Button btnshowchude;
        public VocabVH(@NonNull View itemView) {
            super(itemView);
            btnshowchude= itemView.findViewById(R.id.btn_showchude);
        }


    }

    public interface Listener{

        void OnItemListener(int pos, Vocab contact);
    }
}
