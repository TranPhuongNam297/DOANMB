package com.example.doanmb.Activity.Admin;

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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.doanmb.R;


public class ActivityLogin extends AppCompatActivity {
    EditText etPassWord, etLogin;
    Button btnDangKy, btnDangNhap;
    TextView tvChangePass;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#A770EF")));
        setTitle("Login");

        TextView textview2 = findViewById(R.id.tv_settitle);
        setTextViewColor(textview2, getResources().getColor(R.color.threecl), getResources().getColor(R.color.threecl1), getResources().getColor(R.color.threecl2));

        etPassWord = findViewById(R.id.etPassWord);
        etLogin = findViewById(R.id.etLogin);
        btnDangNhap = findViewById(R.id.btnDangKy);
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etLogin.getText().length() != 0 && etPassWord.getText().length() != 0){
                    if (etLogin.getText().toString().equals("1") && etPassWord.getText().toString().equals("1")){
                        Toast.makeText(ActivityLogin.this,"Bạn đã đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ActivityLogin.this, ActivityAdmin.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(ActivityLogin.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(ActivityLogin.this, "Bạn hãy nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }
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
