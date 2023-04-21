package com.example.doanmb.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.doanmb.R;

public class ActivityThongBaoTracNghiem extends AppCompatActivity {

    Button btn_de, btn_tb, btn_kho;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tbtracnghiem);
        btn_de = findViewById(R.id.btn_dedt);
        btn_tb = findViewById(R.id.btn_trungbinhdt);
        btn_kho = findViewById(R.id.btn_khodt);
        btn_de.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityThongBaoTracNghiem.this, ActivityBeforedoQuestion.class);
                startActivity(intent);
            }
        });
    }
}
