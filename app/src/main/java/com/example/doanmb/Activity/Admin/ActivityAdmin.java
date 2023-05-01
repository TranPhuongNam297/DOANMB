package com.example.doanmb.Activity.Admin;

import android.content.Intent;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.doanmb.Activity.Admin.DienTu.ActivityAddMucDoDienTu;
import com.example.doanmb.Activity.Admin.TracNghiem.ActivityAddMucDoTracNghiem;
import com.example.doanmb.Activity.Admin.Vocab.ActivityAddChuDe;
import com.example.doanmb.R;

public class ActivityAdmin extends AppCompatActivity {
    Button btnAdd, btnLogOut, btnaddtn, btnadddt;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView textview2 = findViewById(R.id.textView4);
        setTextViewColor(textview2, getResources().getColor(R.color.threecl), getResources().getColor(R.color.threecl1), getResources().getColor(R.color.threecl2));
        btnAdd = findViewById(R.id.btnAdd);
        btnLogOut = findViewById(R.id.btnLogout);
        btnaddtn = findViewById(R.id.btn_addtn);
        btnadddt = findViewById(R.id.btn_listening);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityAdmin.this, ActivityAddChuDe.class);
                startActivity(intent);
            }
        });
        btnaddtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityAdmin.this, ActivityAddMucDoTracNghiem.class);
                startActivity(intent);
            }
        });

        btnadddt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityAdmin.this, ActivityAddMucDoDienTu.class);
                startActivity(intent);
            }
        });



        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityAdmin.this, ActivityLogin.class );
                startActivity(intent);
                finish();
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


    private void setTextViewColor(TextView textView,int ...color){
        TextPaint paint = textView.getPaint();
        float width = paint.measureText(textView.getText().toString());
        Shader shader = new LinearGradient(0,0,width,textView.getTextSize(),color,null,Shader.TileMode.CLAMP);
        textView.getPaint().setShader(shader);
        textView.setTextColor(color[0]);
    }
}
