package com.example.doanmb.Activity.User.TracNghiem;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.doanmb.R;

public class ActivityBeforedoQuestion extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beforedoquestion);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        setTitle("Notification");
        Button btn_starttn = findViewById(R.id.btn_starttn);
        btn_starttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityBeforedoQuestion.this, ActivityThongBaoTracNghiem.class);
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
