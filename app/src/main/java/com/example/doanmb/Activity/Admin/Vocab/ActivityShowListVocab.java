package com.example.doanmb.Activity.Admin.Vocab;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanmb.Activity.MainActivity;
import com.example.doanmb.Adapter.Vocab.AddAdapter;
import com.example.doanmb.DataBase.DBHelper;
import com.example.doanmb.Model.Vocab;
import com.example.doanmb.R;

import java.util.ArrayList;

public class ActivityShowListVocab extends AppCompatActivity implements AddAdapter.Listener {
    RecyclerView recyclerView;
    ArrayList<Vocab> vocabs;
    public AddAdapter addAdapter;
    int position;
    DBHelper dbHelper;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showlisteditvocab);

        setTitle("List vocab");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        dbHelper = new DBHelper(this);
        recyclerView = findViewById(R.id.rc_addshowlist);
        String ChuDeTruyen = intent.getStringExtra("Chu_De");
        vocabs = dbHelper.getVocab(ChuDeTruyen);
        addAdapter = new AddAdapter(ActivityShowListVocab.this, vocabs, this);
        recyclerView.setAdapter(addAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(ActivityShowListVocab.this, LinearLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(new DividerItemDecoration(ActivityShowListVocab.this, LinearLayoutManager.VERTICAL));

        ImageView img_add = findViewById(R.id.img_add);
        img_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityShowListVocab.this, ActivityAddEdit.class);
                intent.putExtra("CHUDE",ChuDeTruyen);
                intent.putExtra("flag",1);
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
    public void OnDeleteListener(Vocab vocab) {
        Intent intent = getIntent();
        String ChuDeTruyen = intent.getStringExtra("Chu_De");
        AlertDialog.Builder builder = new AlertDialog.Builder(ActivityShowListVocab.this);
        builder.setTitle("Vocab");
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dbHelper.delete(vocab);
                vocabs.clear();
                vocabs.addAll(dbHelper.getVocab(ChuDeTruyen));
                addAdapter.notifyDataSetChanged();
                dialogInterface.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
