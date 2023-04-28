package com.example.doanmb.Activity;

import android.annotation.SuppressLint;
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

import com.example.doanmb.R;

public class ActivityDanhsach extends AppCompatActivity {

    Button btnTracNghiem;
    Button btnKiemTra,btnYoutube;
    Button btnVocab;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danhsach);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView textview2 = findViewById(R.id.textView4);
        setTextViewColor(textview2, getResources().getColor(R.color.threecl), getResources().getColor(R.color.threecl1), getResources().getColor(R.color.threecl2));
        btnYoutube = findViewById(R.id.btn_addDT);
        btnYoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityDanhsach.this, ActivityListening.class);
                startActivity(intent);
            }
        });
        btnVocab = findViewById(R.id.btnLogout);
        btnVocab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityDanhsach.this,ActivityOptionVocab.class);
                startActivity(intent);
            }
        });
        btnTracNghiem = findViewById(R.id.btnAdd);
        btnKiemTra = findViewById(R.id.btnKiemTra);
        btnTracNghiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityDanhsach.this, ActivityBeforedoQuestion.class );
                startActivity(intent);
            }
        });

        btnKiemTra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityDanhsach.this, ActivityBeforefillBlanks.class);
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

    private void setTextViewColor(TextView textView, int ...color){
        TextPaint paint = textView.getPaint();
        float width = paint.measureText(textView.getText().toString());
        Shader shader = new LinearGradient(0,0,width,textView.getTextSize(),color,null,Shader.TileMode.CLAMP);
        textView.getPaint().setShader(shader);
        textView.setTextColor(color[0]);
    }
}
