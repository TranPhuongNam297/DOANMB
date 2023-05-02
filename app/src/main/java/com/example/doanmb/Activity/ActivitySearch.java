package com.example.doanmb.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanmb.Activity.User.Vocab.ActivityShowInfoWord;
import com.example.doanmb.Adapter.Vocab.VocabAdapter;
import com.example.doanmb.DataBase.DBHelper;
import com.example.doanmb.Model.Vocab;
import com.example.doanmb.R;

import java.util.ArrayList;

public class ActivitySearch extends AppCompatActivity implements VocabAdapter.Listener {
    DBHelper dbHelper;
    ArrayList<Vocab> vocabs;
    VocabAdapter vocabAdapter;
    RecyclerView rvContact;
    TextView tv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("My Title");
        }
//        Intent intent = getIntent();
//        String Chu_De = intent.getStringExtra("Chu_De");
        dbHelper =new DBHelper(this);
        tv = findViewById(R.id.tvSearch);
        rvContact = (RecyclerView) findViewById(R.id.rvContactSearch);
        vocabs = dbHelper.getAllVocab();
        vocabAdapter =new VocabAdapter(ActivitySearch.this,vocabs,this);
        rvContact.setAdapter(vocabAdapter);
        rvContact.setLayoutManager(new LinearLayoutManager(ActivitySearch.this, LinearLayoutManager.VERTICAL, false));
        rvContact.addItemDecoration(new DividerItemDecoration(ActivitySearch.this, DividerItemDecoration.VERTICAL));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_search, menu);
        menu.findItem(R.id.mnuSearch).expandActionView();

        SearchView searchView  = (SearchView) menu.findItem(R.id.mnuSearch).getActionView();
        searchView.setIconified(true);
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setIconifiedByDefault(false);
        searchView.requestFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Intent intent = getIntent();
                String Chu_De = intent.getStringExtra("Chu_De");


                vocabs.clear();
                vocabs.addAll(dbHelper.search(query,Chu_De));
                vocabAdapter.notifyDataSetChanged();

                if(vocabAdapter.getItemCount() > 0){
                    tv.setVisibility(View.GONE);
                }else {
                    tv.setVisibility(View.VISIBLE);
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Intent intent = getIntent();
                String Chu_De = intent.getStringExtra("Chu_De");
                vocabs.clear();
                vocabs.addAll(dbHelper.search(newText,Chu_De));
                vocabAdapter.notifyDataSetChanged();

                if(vocabAdapter.getItemCount() > 0){
                    tv.setVisibility(View.GONE);
                } else if (newText.isEmpty()) {
                    tv.setVisibility(View.VISIBLE);
                }else {
                    tv.setVisibility(View.GONE);
                }


                return false;
            }
        });

        return true;
    }

    @Override
    public void OnItemListener(int pos, Vocab vocab) {
        Intent intent = new Intent(ActivitySearch.this, ActivityShowInfoWord.class);
        intent.putExtra("idContact", vocab.getId());
        intent.putExtra("flag",1);
        startActivity(intent);
    }

}
