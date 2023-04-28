package com.example.doanmb.Activity;

import android.annotation.SuppressLint;
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
import com.example.doanmb.Adapter.AddTNAdapter;
import com.example.doanmb.Adapter.VocabAdapter;
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
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showlistaddtnmd);
        Intent intent = getIntent();
        dbHelper = new DBHelper(this);
        recyclerView = findViewById(R.id.rc_listtn);
        multipleChoices = dbHelper.getQuestion(intent.getStringExtra("Muc_Do"));
        addTNAdapter = new AddTNAdapter(ActivityAddListTN.this, multipleChoices, this);
        recyclerView.setAdapter(addTNAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(ActivityAddListTN.this, LinearLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(new DividerItemDecoration(ActivityAddListTN.this, LinearLayoutManager.VERTICAL));

//        ImageView img_add = findViewById(R.id.img_add);
//        img_add.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(ActivityAddListTN.this, ActivityAddEdit.class);
//                startActivity(intent);
//            }
//        });
    }

    @Override
    public void OnItemListener(int pos, Vocab contact) {

    }

}
