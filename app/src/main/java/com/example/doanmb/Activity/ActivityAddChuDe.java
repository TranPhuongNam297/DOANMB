package com.example.doanmb.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanmb.Adapter.AddAdapter;
import com.example.doanmb.Adapter.AddTheoChuDeAdapter;
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
        setContentView(R.layout.activity_listadd);
        imgAddChuDe = findViewById(R.id.imgAddChuDe);
        DBHelper dbHelper = new DBHelper(ActivityAddChuDe.this);
        recyclerView = findViewById(R.id.rc_add);
        vocabs = dbHelper.getChuDe();
        addTheoChuDeAdapter = new AddTheoChuDeAdapter(ActivityAddChuDe.this, vocabs, this);
        recyclerView.setAdapter(addTheoChuDeAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(ActivityAddChuDe.this, LinearLayoutManager.VERTICAL, false));

    }

    @Override
    public void OnItemListener(int pos, Vocab contact) {

    }
}
