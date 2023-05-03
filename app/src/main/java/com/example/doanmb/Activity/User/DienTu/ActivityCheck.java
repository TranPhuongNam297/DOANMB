package com.example.doanmb.Activity.User.DienTu;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.doanmb.Activity.ActivityCongra;
import com.example.doanmb.Activity.ActivityFail;
import com.example.doanmb.DataBase.DBHelper;
import com.example.doanmb.Model.FillBlanks;

import com.example.doanmb.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Collections;
import java.util.List;

public class ActivityCheck extends AppCompatActivity{
    Button btnCheck;
    TextInputEditText edCheck;
    TextView tvQues;
    private int Size, Counter, countTrue, countFalse;

    List<FillBlanks> fillBlanksList;

    public FillBlanks fillBlanks;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#A770EF")));
        setTitle("Testing");



        FindID();
        DBHelper dbHelper = new DBHelper(ActivityCheck.this);
        Intent intent = getIntent();
        fillBlanksList = dbHelper.getQuestionFillBlanks(intent.getStringExtra("Do_Kho"));
        Size = 10;
        Collections.shuffle(fillBlanksList);
        showNextQuestion();
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edCheck.getText().toString().trim().equalsIgnoreCase(fillBlanks.getDap_An().trim())){
                    countTrue++;
                    showNextQuestion();

                } else {
                    countFalse++;
                    showNextQuestion();

                }
            }
        });
    }



    public void showNextQuestion() {
        if (Counter == Size - 1){
                btnCheck.setText("Xác Nhận");
        }
        if (Counter < Size) {
            fillBlanks = fillBlanksList.get(Counter);
            tvQues.setText(fillBlanks.getCau_Hoi());
            edCheck.setText("");
            // kiểm tra trạng thái của bàn phím
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            boolean isKeyboardOpen = imm.isActive();
            if (isKeyboardOpen) {
                // nếu đang mở thì mới đóng bàn phím
                imm.hideSoftInputFromWindow(edCheck.getWindowToken(), 0);
            }
            Counter++;
        } else {
            if (countTrue > countFalse) {
                Intent intent = new Intent(ActivityCheck.this, ActivityCongra.class);
                intent.putExtra("Diem", countTrue);
                startActivity(intent);
            } else if (countTrue < countFalse) {
                Intent intent = new Intent(ActivityCheck.this, ActivityFail.class);
                intent.putExtra("Diem", countTrue);
                startActivity(intent);
            }
        }
    }
    private void FindID(){
        btnCheck = findViewById(R.id.btnCheck);
        edCheck = findViewById(R.id.edCheck);
        tvQues = findViewById(R.id.tvQues);
    }
}
