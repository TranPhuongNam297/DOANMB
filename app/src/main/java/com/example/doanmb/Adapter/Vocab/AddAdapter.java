package com.example.doanmb.Adapter.Vocab;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanmb.Activity.Admin.Vocab.ActivityAddEdit;
import com.example.doanmb.Activity.User.Vocab.ActivityShowInfoWord;
import com.example.doanmb.DataBase.DBHelper;
import com.example.doanmb.R;
import com.example.doanmb.Model.Vocab;

import java.util.ArrayList;

public class AddAdapter extends RecyclerView.Adapter<AddAdapter.VocabVH> implements Filterable {
    Context context;
    ArrayList<Vocab> vocabs;
    ArrayList<Vocab> vocabsFilter;

    Listener listener;

    public AddAdapter(Context context, ArrayList<Vocab> vocabs, Listener listener) {
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_rowinfovocab, parent,false);
        return new VocabVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VocabVH holder, int position) {
        Vocab vocab = vocabsFilter.get(position);
        holder.word.setText(vocab.getEnglish());
        holder.wordV.setText(vocab.getTieng_Viet());
        holder.phatam.setText(vocab.getPhat_Am());
        holder.chude.setText(vocab.getChu_De());
        holder.vidu1.setText(vocab.getVi_Du());
        holder.vidu2.setText(vocab.getVi_Du2());
        holder.btnEditVocab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ActivityAddEdit.class);
                Bundle bundle = new Bundle();
                bundle.putInt("ID", vocab.getId());
                bundle.putString("Tieng Viet", vocab.getTieng_Viet());
                bundle.putString("English", vocab.getEnglish());
                bundle.putString("Phat Am", vocab.getPhat_Am());
                bundle.putString("Chu_De", vocab.getChu_De());
                bundle.putString("Vi Du", vocab.getVi_Du());
                bundle.putString("Vi Du2", vocab.getVi_Du2());
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
        holder.btnDeleteVocab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.OnDeleteListener(vocab);
            }
        });


    }

    @Override
    public int getItemCount() {
        return vocabsFilter.size();
    }




    public class VocabVH extends RecyclerView.ViewHolder{
        TextView word, wordV, chude, phatam, vidu1, vidu2;
        ImageView btnDeleteVocab,btnEditVocab;
        public VocabVH(@NonNull View itemView) {
            super(itemView);
            word = itemView.findViewById(R.id.tv_Englishvc);
            wordV = itemView.findViewById(R.id.tv_tieng_vietvc);
            phatam = itemView.findViewById(R.id.tv_PhatAmvc);
            chude = itemView.findViewById(R.id.tv_chudevc);
            vidu1 = itemView.findViewById(R.id.tv_viduvc);
            vidu2 = itemView.findViewById(R.id.tv_vidu2vc);
            btnDeleteVocab = itemView.findViewById(R.id.btnDeleteVocab);
            btnEditVocab =itemView.findViewById(R.id.btnEditVocab);
        }
    }

    public interface Listener{

        void OnDeleteListener(Vocab vocab);
    }
}
