package com.example.doanmb.Activity.Admin.DienTu;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanmb.Adapter.DienTu.AddDTAdapter;
import com.example.doanmb.DataBase.DBHelper;
import com.example.doanmb.Model.FillBlanks;
import com.example.doanmb.Model.Vocab;
import com.example.doanmb.R;

import java.util.ArrayList;

public class ActivityAddListDT extends AppCompatActivity implements AddDTAdapter.Listener {
    RecyclerView recyclerView;
    ArrayList<FillBlanks> fillBlanks;
    public AddDTAdapter addDTAdapter;
    DBHelper dbHelper;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showlistadddt);
        Intent intent = getIntent();
        dbHelper = new DBHelper(this);
        recyclerView = findViewById(R.id.rc_listadddt);
        fillBlanks = dbHelper.getQuestionFillBlanks(intent.getStringExtra("Muc_DoDT"));
        addDTAdapter = new AddDTAdapter(ActivityAddListDT.this, fillBlanks, this);
        recyclerView.setAdapter(addDTAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(ActivityAddListDT.this, LinearLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(new DividerItemDecoration(ActivityAddListDT.this, LinearLayoutManager.VERTICAL));

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
