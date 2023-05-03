package com.example.doanmb.Activity.Admin.Vocab;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanmb.Adapter.Vocab.AddTheoChuDeAdapter;
import com.example.doanmb.DataBase.DBHelper;
import com.example.doanmb.Model.Vocab;
import com.example.doanmb.R;

import java.util.ArrayList;

public class ActivityAddChuDe extends AppCompatActivity implements AddTheoChuDeAdapter.Listener {
    ImageView imgAddChuDe;
    RecyclerView recyclerView;

    ArrayList<Vocab> vocabs;

    public AddTheoChuDeAdapter addTheoChuDeAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listaddchudevocab);
        setTitle("Add and Edit Vocab");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        imgAddChuDe = findViewById(R.id.imgAddChuDe);
        DBHelper dbHelper = new DBHelper(ActivityAddChuDe.this);
        recyclerView = findViewById(R.id.rc_add);
        vocabs = dbHelper.getChuDe();
        addTheoChuDeAdapter = new AddTheoChuDeAdapter(ActivityAddChuDe.this, vocabs, this);
        recyclerView.setAdapter(addTheoChuDeAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(ActivityAddChuDe.this, LinearLayoutManager.VERTICAL, false));

        imgAddChuDe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityAddChuDe.this,LayOutAddChuDe.class);
                intent.putExtra("flag", 1);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);

    }
    @Override
    public void OnItemListener(int pos, Vocab contact) {

    }
}
