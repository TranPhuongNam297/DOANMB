package com.example.doanmb.Activity.Admin.Vocab;

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

import com.example.doanmb.DataBase.DBHelper;
import com.example.doanmb.R;
import com.google.android.material.textfield.TextInputEditText;

public class ActivityLayOutAddChuDe extends AppCompatActivity {
    TextInputEditText etAddChuDe;
    Button btnSave;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivy_taobuttonchude);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#A770EF")));

        DBHelper dbHelper = new DBHelper(ActivityLayOutAddChuDe.this);
        etAddChuDe = findViewById(R.id.etAddChuDe);
        btnSave = findViewById(R.id.btnSave);
        Intent intent = getIntent();
        int flag = intent.getIntExtra("flag", 0);
        if(flag == 1){
            getSupportActionBar().setTitle("Them Tu Vung Moi");
        }
        else {

        }

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newChuDe = etAddChuDe.getText().toString().trim();
                dbHelper.AddChuDe(newChuDe);
                BackVeMain();
            }
        });


    }

    private void BackVeMain() {
        Intent intent = new Intent(ActivityLayOutAddChuDe.this,ActivityAddChuDe.class);
        startActivity(intent);
    }


}
