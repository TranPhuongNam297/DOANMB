package com.example.doanmb.Activity.User.Vocab;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.doanmb.R;

public class ActivityVocab extends AppCompatActivity {
    Button btn_di1,btn_di2,btn_di3,btn_di4,btn_di5;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocab);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Tra từ điển");
        btn_di1 = findViewById(R.id.btn_di1);
        btn_di2 = findViewById(R.id.btn_di2);
        btn_di3 = findViewById(R.id.btn_di3);
        btn_di4 = findViewById(R.id.btn_di4);
        btn_di5 = findViewById(R.id.btn_di5);

        btn_di1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityVocab.this, ActivityShowVocab.class);
                intent.putExtra("chu_de","ANIMAL");
                startActivity(intent);
            }
        });
        btn_di2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityVocab.this, ActivityShowVocab.class);
                intent.putExtra("chu_de","FOOD");
                startActivity(intent);
            }
        });
        btn_di3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityVocab.this, ActivityShowVocab.class);
                intent.putExtra("chu_de","FAMILY");
                startActivity(intent);
            }
        });
        btn_di4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityVocab.this, ActivityShowVocab.class);
                intent.putExtra("chu_de","FLOWER");
                startActivity(intent);
            }
        });
        btn_di5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityVocab.this, ActivityShowVocab.class);
                intent.putExtra("chu_de","TOURISM");
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
