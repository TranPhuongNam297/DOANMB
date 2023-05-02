package com.example.doanmb.Activity.User.Vocab;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanmb.Activity.ActivitySearch;
import com.example.doanmb.Activity.MainActivity;
import com.example.doanmb.Adapter.Vocab.VocabAdapter;
import com.example.doanmb.DataBase.DBHelper;
import com.example.doanmb.R;
import com.example.doanmb.Model.Vocab;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class ActivityShowVocab extends AppCompatActivity implements VocabAdapter.Listener{
    RecyclerView recyclerView;
    ArrayList<Vocab> vocabs;
    public VocabAdapter vocabAdapter;
    DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showlistvocab);
        Intent intent = getIntent();
        dbHelper = new DBHelper(this);
        recyclerView = findViewById(R.id.view_rc);
        String Chu_De = intent.getStringExtra("Chu_De");
        vocabs = dbHelper.getVocab(Chu_De);
        vocabAdapter = new VocabAdapter(ActivityShowVocab.this, vocabs, this);
        recyclerView.setAdapter(vocabAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(ActivityShowVocab.this, LinearLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(new DividerItemDecoration(ActivityShowVocab.this, LinearLayoutManager.VERTICAL));

    }

    @Override
    public void OnItemListener(int pos, Vocab contact) {

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.mnuSearch) {
            Intent intent = getIntent();
            String Chu_De = intent.getStringExtra("Chu_De");
            Intent searchIntent = new Intent(ActivityShowVocab.this, ActivitySearch.class);
            searchIntent.putExtra("Chu_De", Chu_De);
            Log.d("Chu_De", Chu_De);
            startActivity(searchIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
