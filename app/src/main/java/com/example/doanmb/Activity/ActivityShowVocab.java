package com.example.doanmb.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanmb.Adapter.VocabAdapter;
import com.example.doanmb.DataBase.DBHelper;
import com.example.doanmb.R;
import com.example.doanmb.Model.Vocab;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class ActivityShowVocab extends AppCompatActivity implements VocabAdapter.Listener{
    RecyclerView recyclerView;
    ArrayList<Vocab> vocabs;
    public VocabAdapter vocabAdapter;
    int position;
    DBHelper dbHelper;
    TextInputEditText ed_search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directory);
        ed_search = findViewById(R.id.ed_search);
        Intent intent = getIntent();
        dbHelper = new DBHelper(this);
        recyclerView = (RecyclerView) findViewById(R.id.view_rc);
        vocabs = dbHelper.getVocab(intent.getStringExtra("chu_de"));
//        Log.d("MANG NEEEEE", String.valueOf(vocabs));
        vocabAdapter = new VocabAdapter(ActivityShowVocab.this, vocabs, this);
        recyclerView.setAdapter(vocabAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(ActivityShowVocab.this, LinearLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(new DividerItemDecoration(ActivityShowVocab.this, LinearLayoutManager.VERTICAL));

        ed_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(ActivityShowVocab.this,SearchActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void OnItemListener(int pos, Vocab contact) {

    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater menuInflater = getMenuInflater();
//        menuInflater.inflate(R.menu.ActivityShowVocab, menu);
//        return super.onCreateOptionsMenu(menu);
//    }
}
