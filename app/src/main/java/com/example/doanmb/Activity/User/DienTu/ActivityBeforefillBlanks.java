package com.example.doanmb.Activity.User.DienTu;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.doanmb.R;

public class ActivityBeforefillBlanks extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beforefillblanks);
        Button btn_startdt = findViewById(R.id.btn_startdt);
        setTitle("Nofication");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btn_startdt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityBeforefillBlanks.this, ActivityThongBaoDienTu.class);
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
