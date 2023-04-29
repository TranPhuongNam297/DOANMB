package com.example.doanmb.Activity.User.DienTu;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.doanmb.R;

public class ActivityThongBaoDienTu extends AppCompatActivity {
    Button btn_dedt, btn_tbdt, btn_khodt;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tbdientu);
        btn_dedt= findViewById(R.id.btn_dedtt);
        btn_tbdt = findViewById(R.id.btn_trungbinhdtt);
        btn_khodt = findViewById(R.id.btn_khodtt);
        btn_dedt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityThongBaoDienTu.this, ActivityCheck.class);
                intent.putExtra("Do_Kho","D");
                startActivity(intent);
            }
        });
        btn_tbdt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityThongBaoDienTu.this, ActivityCheck.class);
                intent.putExtra("Do_Kho","TB");
                startActivity(intent);
            }
        });
        btn_khodt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityThongBaoDienTu.this, ActivityCheck.class);
                intent.putExtra("Do_Kho","K");
                startActivity(intent);
            }
        });
    }
}
