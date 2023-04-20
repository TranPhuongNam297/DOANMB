package com.example.doanmb.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.doanmb.R;


public class MainActivity extends AppCompatActivity {
    TextView tvNPT;
    Button btnStart;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = findViewById(R.id.btnStart);
        TextView textview2 = findViewById(R.id.tv);
        setTextViewColor(textview2, getResources().getColor(R.color.threecl), getResources().getColor(R.color.threecl1), getResources().getColor(R.color.threecl2));

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityDanhsach.class);
                startActivity(intent);
            }
        });
    }
    private void setTextViewColor(TextView textView,int ...color){
        TextPaint paint = textView.getPaint();
        float width = paint.measureText(textView.getText().toString());
        Shader shader = new LinearGradient(0,0,width,textView.getTextSize(),color,null,Shader.TileMode.CLAMP);
        textView.getPaint().setShader(shader);
        textView.setTextColor(color[0]);
    }
}