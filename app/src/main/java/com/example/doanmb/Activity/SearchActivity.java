package com.example.doanmb.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanmb.Adapter.VocabAdapter;
import com.example.doanmb.DataBase.DBHelper;
import com.example.doanmb.Model.Vocab;
import com.example.doanmb.R;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity implements VocabAdapter.Listener {
    DBHelper dbHelper;
    ArrayList<Vocab> vocabs;
    VocabAdapter vocabAdapter;
    RecyclerView rvContact;
    TextView tv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        getActionBar().setTitle("");
        tv = findViewById(R.id.tvSearch);
        rvContact = (RecyclerView) findViewById(R.id.rvContactSearch);


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

                vocabs.clear();
                vocabs.addAll(dbHelper.search(query));
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

                vocabs.clear();
                vocabs.addAll(dbHelper.search(newText));
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
    public void OnItemListener(int pos, Vocab contact) {
        Intent intent = new Intent(SearchActivity.this, ActivityShowInfoWord.class);
        intent.putExtra("idContact", contact.getId());
        startActivity(intent);
    }

}
