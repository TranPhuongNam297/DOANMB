package com.example.doanmb.Adapter.Vocab;

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

import com.example.doanmb.Activity.Admin.Vocab.ActivityAddEdit;
import com.example.doanmb.Activity.Admin.Vocab.ActivityShowListVocab;
import com.example.doanmb.Activity.User.Vocab.ActivityAddNote;
import com.example.doanmb.Activity.User.Vocab.ActivityShowVocab;
import com.example.doanmb.Model.Note;
import com.example.doanmb.R;
import com.example.doanmb.Model.Vocab;

import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteVH> implements Filterable {
    Context context;
    ArrayList<Note> notes;
    ArrayList<Note> notesFilter;

    Listener listener;

    public NoteAdapter(Context context, ArrayList<Note> notes, Listener listener) {
        this.context = context;
        this.notes = notes;
        this.notesFilter = notes;
        this.listener = listener;
    }

    @Override
    public Filter getFilter() {
        return null;
    }

    @NonNull
    @Override
    public NoteVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_rownote, parent,false);
        return new NoteVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteVH holder, int position) {
        Note note = notesFilter.get(position);
        holder.tv_eng.setText(note.getTieng_Anh());
        holder.tv_vnese.setText(note.getTieng_Viet());
        holder.edit_note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ActivityAddNote.class);
                Bundle bundle = new Bundle();
                bundle.putInt("ID", note.getID());
                bundle.putString("TiengViet", note.getTieng_Viet());
                bundle.putString("English", note.getTieng_Anh());
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
        holder.delete_note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.OnDeleteListener(note);
            }
        });

    }

    @Override
    public int getItemCount() {
        return notesFilter.size();
    }




    public class NoteVH extends RecyclerView.ViewHolder{
        TextView tv_eng, tv_vnese;
        ImageView delete_note, edit_note;
        public NoteVH(@NonNull View itemView) {
            super(itemView);
            tv_eng = itemView.findViewById(R.id.tv_eng);
            tv_vnese = itemView.findViewById(R.id.tv_vnese);
            delete_note = itemView.findViewById(R.id.delete_note);
            edit_note = itemView.findViewById(R.id.edit_note);
        }


    }

    public interface Listener{

        void OnDeleteListener(Note note);
    }
}
