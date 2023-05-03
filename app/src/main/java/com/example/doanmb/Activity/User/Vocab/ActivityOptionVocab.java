package com.example.doanmb.Activity.User.Vocab;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.doanmb.R;

public class ActivityOptionVocab extends AppCompatActivity {
    Button btnGhiChu,btntuDien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_optionvocab);
        btnGhiChu = findViewById(R.id.btnGhiChu);
        btntuDien  = findViewById(R.id.btntuDien);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#A770EF")));
        setTitle("Option");


        btntuDien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityOptionVocab.this,ActivityVocab.class);
                startActivity(intent);
            }
        });
        btnGhiChu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityOptionVocab.this,ActivityNote.class);
                startActivity(intent);
            }
        });
    }

}