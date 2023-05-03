package com.example.doanmb.Activity.User.Vocab;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanmb.Activity.Admin.Vocab.ActivityShowListVocab;
import com.example.doanmb.Adapter.Vocab.AddAdapter;
import com.example.doanmb.Adapter.Vocab.TopicVocabAdapter;
import com.example.doanmb.DataBase.DBHelper;
import com.example.doanmb.Model.Vocab;
import com.example.doanmb.R;

import java.util.ArrayList;

public class ActivityVocab extends AppCompatActivity implements TopicVocabAdapter.Listener {
    RecyclerView recyclerView;
    ArrayList<Vocab> vocabs;

    public TopicVocabAdapter topicVocabAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showlistchudeuser);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#A770EF")));
        setTitle("Tra từ điển");
        DBHelper dbHelper = new DBHelper(ActivityVocab.this);
        recyclerView = findViewById(R.id.rc_vocabuser);
        vocabs = dbHelper.getChuDe();
        topicVocabAdapter = new TopicVocabAdapter(ActivityVocab.this, vocabs, this);
        recyclerView.setAdapter(topicVocabAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(ActivityVocab.this, LinearLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(new DividerItemDecoration(ActivityVocab.this, LinearLayoutManager.VERTICAL));

    }


    @Override
    public void OnItemListener(int pos, Vocab contact) {

    }
}
