package com.example.doanmb.Activity.User.Vocab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

        setTitle("Option");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);

    }
}