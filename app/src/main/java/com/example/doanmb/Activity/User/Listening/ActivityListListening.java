package com.example.doanmb.Activity.User.Listening;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;


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

        setTitle("Listening Practice");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dbHelper = new DBHelper(ActivityListListening.this);
        recyclerView = findViewById(R.id.rc_showlistlisten);
        listenings = dbHelper.getListening();
        listeningAdapter = new ListeningAdapter(ActivityListListening.this, listenings);
        recyclerView.setAdapter(listeningAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(ActivityListListening.this, LinearLayoutManager.VERTICAL, false));
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
}
