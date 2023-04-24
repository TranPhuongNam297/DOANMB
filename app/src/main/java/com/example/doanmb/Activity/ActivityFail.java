package com.example.doanmb.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.doanmb.R;

public class ActivityFail extends AppCompatActivity {
    Button btnBack1, btnBackAgain1;
    TextView tvScore1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fail);
        FindID();

        btnBack1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityFail.this, ActivityDanhsach.class);
                startActivity(intent);
            }
        });
        int score = getIntent().getExtras().getInt("Dung1");
        tvScore1.setText(score + "/10");

    }
    private void FindID(){
        btnBack1 = findViewById(R.id.btnBack1);
        tvScore1 = findViewById(R.id.tvScore1);
    }
}
