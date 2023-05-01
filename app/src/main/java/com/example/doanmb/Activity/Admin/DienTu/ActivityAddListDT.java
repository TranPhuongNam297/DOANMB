package com.example.doanmb.Activity.Admin.DienTu;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanmb.Activity.Admin.Vocab.ActivityShowListVocab;
import com.example.doanmb.Adapter.DienTu.AddDTAdapter;
import com.example.doanmb.DataBase.DBHelper;
import com.example.doanmb.Model.FillBlanks;
import com.example.doanmb.Model.Vocab;
import com.example.doanmb.R;

import java.util.ArrayList;

public class ActivityAddListDT extends AppCompatActivity implements AddDTAdapter.Listener {
    RecyclerView recyclerView;
    ArrayList<FillBlanks> fillBlanks;
    ImageView Add_Dt;
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
        String Muc_Do = intent.getStringExtra("Muc_DoDT");
        fillBlanks = dbHelper.getQuestionFillBlanks(Muc_Do);
        addDTAdapter = new AddDTAdapter(ActivityAddListDT.this, fillBlanks, this);
        recyclerView.setAdapter(addDTAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(ActivityAddListDT.this, LinearLayoutManager.VERTICAL, false));
        recyclerView.addItemDecoration(new DividerItemDecoration(ActivityAddListDT.this, LinearLayoutManager.VERTICAL));
        Add_Dt = findViewById(R.id.Add_Dt);
        Add_Dt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(ActivityAddListDT.this,ActivityFormDt.class);
                intent1.putExtra("Muc_Do",Muc_Do);
                intent1.putExtra("flag",1);
                startActivity(intent1);
            }
        });
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
    public void OnItemListener(int pos, FillBlanks fillBlanks) {

    }

    @Override
    public void OnDeleteListener(FillBlanks fillBlank) {
        Intent intent = getIntent();
        String Muc_Do = intent.getStringExtra("Muc_DoDT");
        AlertDialog.Builder builder = new AlertDialog.Builder(ActivityAddListDT.this);
        builder.setTitle("Xoa");
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dbHelper.deleleDT(fillBlank);
                fillBlanks.clear();
                fillBlanks.addAll(dbHelper.getQuestionFillBlanks(Muc_Do));
                addDTAdapter.notifyDataSetChanged();
                dialogInterface.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}
