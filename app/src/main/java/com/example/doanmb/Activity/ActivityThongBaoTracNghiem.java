package com.example.doanmb.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.doanmb.DataBase.DBHelper;
import com.example.doanmb.MultipleChoice;
import com.example.doanmb.R;

import java.io.Serializable;
import java.util.List;

public class ActivityThongBaoTracNghiem extends AppCompatActivity {

    Button btn_de, btn_tb, btn_kho;
    public List<MultipleChoice> choiceListd;
    public List<MultipleChoice> choiceListtb;
    public List<MultipleChoice> choiceListk;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tbtracnghiem);
        btn_de = findViewById(R.id.btn_dedt);
        btn_tb = findViewById(R.id.btn_trungbinhdt);
        btn_kho = findViewById(R.id.btn_khodt);

        DBHelper dbHelper = new DBHelper(ActivityThongBaoTracNghiem.this);
        choiceListd = dbHelper.getMultipleChoiceDe();
        choiceListtb = dbHelper.getMultipleChoiceTrungBinh();
        choiceListk = dbHelper.getMultipleChoiceKho();
        btn_de.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityThongBaoTracNghiem.this, ActivityTracnghiem.class);
                intent.putExtra("Do_Kho","D");
                startActivity(intent);
            }
        });
        btn_tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityThongBaoTracNghiem.this, ActivityTracnghiem.class);
                intent.putExtra("Do_Kho","TB");
                startActivity(intent);
            }
        });
        btn_kho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityThongBaoTracNghiem.this, ActivityTracnghiem.class);
                intent.putExtra("Do_Kho","K");
                startActivity(intent);
            }
        });
    }
}
