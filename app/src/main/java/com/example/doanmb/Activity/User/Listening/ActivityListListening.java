package com.example.doanmb.Activity.User.Listening;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.doanmb.Adapter.Listening.ListeningAdapter;
import com.example.doanmb.DataBase.DBHelper;
import com.example.doanmb.Model.Listening;
import com.example.doanmb.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class ActivityListListening extends AppCompatActivity{
    RecyclerView recyclerView;
    ArrayList<Listening> listenings;
    public ListeningAdapter listeningAdapter;
    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showlistlistening);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#A770EF")));
        setTitle("Listening Practice");



        dbHelper = new DBHelper(ActivityListListening.this);
        recyclerView = findViewById(R.id.rc_showlistlisten);
        listenings = dbHelper.getListening();
        listeningAdapter = new ListeningAdapter(ActivityListListening.this, listenings);
        recyclerView.setAdapter(listeningAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(ActivityListListening.this, LinearLayoutManager.VERTICAL, false));
    }

}
