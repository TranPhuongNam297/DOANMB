package com.example.doanmb.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanmb.Adapter.VocabAdapter;
import com.example.doanmb.DataBase.DBHelper;
import com.example.doanmb.R;
import com.example.doanmb.Vocab;

import java.util.ArrayList;

public class ActivityShowVocab extends AppCompatActivity implements VocabAdapter.Listener{
    RecyclerView recyclerView;
    ArrayList<Vocab> vocabs;
    public VocabAdapter vocabAdapter;
    int position;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directory);
        dbHelper = new DBHelper(this);
        recyclerView = (RecyclerView) findViewById(R.id.view_rc);
        vocabs = dbHelper.getVocab();
        vocabAdapter = new VocabAdapter(ActivityShowVocab.this, vocabs, this);
        recyclerView.setAdapter(vocabAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(ActivityShowVocab.this, LinearLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(new DividerItemDecoration(ActivityShowVocab.this, LinearLayoutManager.VERTICAL));

    }
}
