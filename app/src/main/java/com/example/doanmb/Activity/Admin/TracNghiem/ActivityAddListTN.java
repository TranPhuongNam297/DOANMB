package com.example.doanmb.Activity.Admin.TracNghiem;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanmb.Activity.Admin.Vocab.ActivityShowListVocab;
import com.example.doanmb.Adapter.TracNghiem.AddTNAdapter;
import com.example.doanmb.DataBase.DBHelper;
import com.example.doanmb.Model.MultipleChoice;
import com.example.doanmb.Model.Vocab;
import com.example.doanmb.R;

import java.util.ArrayList;

public class ActivityAddListTN extends AppCompatActivity implements AddTNAdapter.Listener {
    RecyclerView recyclerView;
    ArrayList<MultipleChoice> multipleChoices;
    public AddTNAdapter addTNAdapter;
    DBHelper dbHelper;
    ImageView btn_addCauHoi;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showlistaddtnmd);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#A770EF")));
        setTitle("List");

        btn_addCauHoi = findViewById(R.id.btn_addCauHoi);
        Intent intent = getIntent();
        dbHelper = new DBHelper(this);
        recyclerView = findViewById(R.id.rc_listtn);
        String Muc_do = intent.getStringExtra("Muc_Do");
        multipleChoices = dbHelper.getQuestion(Muc_do);
        addTNAdapter = new AddTNAdapter(ActivityAddListTN.this, multipleChoices, this);
        recyclerView.setAdapter(addTNAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(ActivityAddListTN.this, LinearLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(new DividerItemDecoration(ActivityAddListTN.this, LinearLayoutManager.VERTICAL));
        btn_addCauHoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(ActivityAddListTN.this,ActivityFormTN.class);
                intent1.putExtra("Muc_Do",Muc_do);
                intent1.putExtra("flag",1);
                startActivity(intent1);
            }
        });
    }


    @Override
    public void OnItemListener(int pos, MultipleChoice multipleChoice) {
    }
    @Override
    public void OnDeleteListener(MultipleChoice multipleChoice) {
        Intent intent = getIntent();
        String Muc_do = intent.getStringExtra("Muc_Do");
        AlertDialog.Builder builder = new AlertDialog.Builder(ActivityAddListTN.this);
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
                dbHelper.deleteTN(multipleChoice);
                multipleChoices.clear();
                multipleChoices.addAll(dbHelper.getQuestion(Muc_do));
                addTNAdapter.notifyDataSetChanged();
                dialogInterface.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }


}
