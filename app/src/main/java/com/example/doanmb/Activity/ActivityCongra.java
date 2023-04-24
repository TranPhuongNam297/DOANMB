package com.example.doanmb.Activity;

import android.content.Intent;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.doanmb.R;

public class ActivityCongra extends AppCompatActivity {
    Button btnBack, btnBackAgain;
    TextView tvScore;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congra);

        TextView textview2 = findViewById(R.id.textView5);
        setTextViewColor(textview2, getResources().getColor(R.color.threecl), getResources().getColor(R.color.threecl1), getResources().getColor(R.color.threecl2));

        btnBack = findViewById(R.id.btnBack);
        btnBackAgain = findViewById(R.id.btnBackAgain);
        tvScore = findViewById(R.id.tvScore);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityCongra.this, ActivityDanhsach.class);
                startActivity(intent);
            }
        });

        btnBackAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityCongra.this, ActivityThongBaoTracNghiem.class);
                startActivity(intent);
            }
        });

        int score = getIntent().getExtras().getInt("Dung");
        tvScore.setText(score +"/10");
    }
    private void setTextViewColor(TextView textView, int ...color){
        TextPaint paint = textView.getPaint();
        float width = paint.measureText(textView.getText().toString());
        Shader shader = new LinearGradient(0,0,width,textView.getTextSize(),color,null,Shader.TileMode.CLAMP);
        textView.getPaint().setShader(shader);
        textView.setTextColor(color[0]);
    }
}
