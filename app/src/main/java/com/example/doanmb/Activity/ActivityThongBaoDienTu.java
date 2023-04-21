package com.example.doanmb.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.doanmb.R;

public class ActivityThongBaoDienTu extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tbdientu);
        Button btn_dedt = findViewById(R.id.btn_dedt);
        btn_dedt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityThongBaoDienTu.this, ActivityBeforefillBlanks.class);
                startActivity(intent);
            }
        });
    }
}
