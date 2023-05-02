package com.example.doanmb.Activity.User.Vocab;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanmb.Activity.Admin.Vocab.ActivityShowListVocab;
import com.example.doanmb.Adapter.Vocab.NoteAdapter;
import com.example.doanmb.Adapter.Vocab.TopicVocabAdapter;
import com.example.doanmb.DataBase.DBHelper;
import com.example.doanmb.Model.Note;
import com.example.doanmb.Model.Vocab;
import com.example.doanmb.R;

import java.io.InputStream;
import java.util.ArrayList;

public class ActivityNote extends AppCompatActivity implements NoteAdapter.Listener {
    RecyclerView recyclerView;

    ArrayList<Note> notes;

    public NoteAdapter noteAdapter;

    DBHelper dbHelper;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        dbHelper = new DBHelper(ActivityNote.this);
        recyclerView = findViewById(R.id.rv_note);
        notes = dbHelper.getNote();
        noteAdapter = new NoteAdapter(ActivityNote.this, notes, this);
        recyclerView.setAdapter(noteAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(ActivityNote.this, LinearLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(new DividerItemDecoration(ActivityNote.this, LinearLayoutManager.VERTICAL));
        ImageView img_add = findViewById(R.id.imgAddNote);
        img_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityNote.this, ActivityAddNote.class);
                intent.putExtra("flag", 1);
                startActivity(intent);
            }
        });
    }


    @Override
    public void OnDeleteListener(Note note) {
        Intent intent = getIntent();
        AlertDialog.Builder builder = new AlertDialog.Builder(ActivityNote.this);
        builder.setTitle("Note");
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dbHelper.deleteNote(note);
                notes.clear();
                notes.addAll(dbHelper.getNote());
                noteAdapter.notifyDataSetChanged();
                dialogInterface.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}

