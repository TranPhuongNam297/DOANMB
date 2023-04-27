package com.example.doanmb.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanmb.Adapter.AddAdapter;
import com.example.doanmb.Adapter.VocabAdapter;
import com.example.doanmb.DataBase.DBHelper;
import com.example.doanmb.Model.Vocab;
import com.example.doanmb.R;

import java.util.ArrayList;

public class ActivityAddList extends AppCompatActivity implements AddAdapter.Listener {
    RecyclerView recyclerView;
    ArrayList<Vocab> vocabs;
    public AddAdapter addAdapter;
    int position;
    DBHelper dbHelper;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showlistedit);
        Intent intent = getIntent();
        dbHelper = new DBHelper(this);
        recyclerView = findViewById(R.id.rc_addshowlist);
        vocabs = dbHelper.getVocab(intent.getStringExtra("Chu_De"));
        addAdapter = new AddAdapter(ActivityAddList.this, vocabs, this);
        recyclerView.setAdapter(addAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(ActivityAddList.this, LinearLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(new DividerItemDecoration(ActivityAddList.this, LinearLayoutManager.VERTICAL));

        ImageView img_add = findViewById(R.id.img_add);
        img_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityAddList.this, ActivityAddEdit.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void OnItemListener(int pos, Vocab contact) {

    }

}
