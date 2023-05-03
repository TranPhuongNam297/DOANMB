package com.example.doanmb.Activity.User.TracNghiem;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.doanmb.R;

public class ActivityThongBaoTracNghiem extends AppCompatActivity {

    Button btn_de, btn_tb, btn_kho;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tbtracnghiem);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#A770EF")));

        setTitle("Before test");

        btn_de = findViewById(R.id.btn_dedtt);
        btn_tb = findViewById(R.id.btn_trungbinhdtt);
        btn_kho = findViewById(R.id.btn_khodtt);
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
