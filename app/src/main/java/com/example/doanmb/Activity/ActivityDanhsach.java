package com.example.doanmb.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.doanmb.Activity.User.DienTu.ActivityBeforefillBlanks;
import com.example.doanmb.Activity.User.Listening.ActivityListListening;
import com.example.doanmb.Activity.User.Listening.ActivityListening;
import com.example.doanmb.Activity.User.TracNghiem.ActivityBeforedoQuestion;
import com.example.doanmb.Activity.User.Vocab.ActivityOptionVocab;
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
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#A770EF")));



        setTitle("Let's go");

        TextView textview2 = findViewById(R.id.textView4);
        setTextViewColor(textview2, getResources().getColor(R.color.threecl), getResources().getColor(R.color.threecl1), getResources().getColor(R.color.threecl2));
        btnYoutube = findViewById(R.id.btn_addDT);
        btnYoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityDanhsach.this, ActivityListListening.class);
                startActivity(intent);
            }
        });
        btnVocab = findViewById(R.id.btnLogout);
        btnVocab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityDanhsach.this, ActivityOptionVocab.class);
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


    private void setTextViewColor(TextView textView, int ...color){
        TextPaint paint = textView.getPaint();
        float width = paint.measureText(textView.getText().toString());
        Shader shader = new LinearGradient(0,0,width,textView.getTextSize(),color,null,Shader.TileMode.CLAMP);
        textView.getPaint().setShader(shader);
        textView.setTextColor(color[0]);
    }
}
