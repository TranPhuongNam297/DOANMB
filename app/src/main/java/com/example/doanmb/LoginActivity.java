package com.example.doanmb;

import android.content.Intent;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class LoginActivity extends AppCompatActivity {
    EditText etPassWord, etLogin;
    Button btnDangKy, btnDangNhap;
    TextView tvChangePass;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TextView textview2 = findViewById(R.id.textView);
        setTextViewColor(textview2, getResources().getColor(R.color.threecl), getResources().getColor(R.color.threecl1), getResources().getColor(R.color.threecl2));

        etPassWord = findViewById(R.id.etPassWord);
        etLogin = findViewById(R.id.etLogin);
        btnDangKy = findViewById(R.id.btnDangNhap);
        btnDangNhap = findViewById(R.id.btnDangKy);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etLogin.getText().length() != 0 && etPassWord.getText().length() != 0){
                    if (etLogin.getText().toString().equals("admin123") && etPassWord.getText().toString().equals("Admin123@")){
                        Toast.makeText(LoginActivity.this,"Bạn đã đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, ActivityAdmin.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(LoginActivity.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(LoginActivity.this, "Bạn hãy nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }
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
