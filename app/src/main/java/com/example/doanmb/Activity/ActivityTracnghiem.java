package com.example.doanmb.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.doanmb.DataBase.DBHelper;
import com.example.doanmb.Model.MultipleChoice;
import com.example.doanmb.R;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class ActivityTracnghiem extends AppCompatActivity {
    TextView tvQuestion, tvContentQues, tvCountDown;
    Button btnAns1, btnAns2, btnAns3, btnAns4;

    private int choiceSize, choiceCounter;
    private long timedown;

    private int countTrue;
    private int countFalse;

    private boolean answer;

    private int Quesnow = 0;

    private CountDownTimer countDownTimer;

    public List<MultipleChoice> choiceList;

    public MultipleChoice currentQues;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracnghiem);
        setTitle("Testing");
        FindID();

        Intent intent = getIntent();
        DBHelper dbHelper = new DBHelper(ActivityTracnghiem.this);

        choiceList = dbHelper.getQuestion(intent.getStringExtra("Do_Kho"));
        choiceSize = 10;
        Collections.shuffle(choiceList);
        showNextQuestion();

        btnAns1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnAns1.getText().toString().equals(currentQues.getDap_An_Dung())){
                    countTrue++;
                    showNextQuestion();
                }else {
                    countFalse++;
                    showNextQuestion();
                }
            }
        });

        btnAns2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnAns2.getText().toString().equals(currentQues.getDap_An_Dung())){
                    countTrue++;
                    showNextQuestion();
                }else {
                    countFalse++;
                    showNextQuestion();
                }
            }
        });
        btnAns3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnAns3.getText().toString().equals(currentQues.getDap_An_Dung())){
                    countTrue++;
                    showNextQuestion();
                }else {
                    countFalse++;
                    showNextQuestion();
                }
            }
        });
        btnAns4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btnAns4.getText().toString().equals(currentQues.getDap_An_Dung())){
                    countTrue++;
                    showNextQuestion();
                }else {
                    countFalse++;
                    showNextQuestion();
                }
            }
        });

    }

    private void showNextQuestion() {
        if (choiceCounter < choiceSize) {
            currentQues = choiceList.get(choiceCounter);
            tvContentQues.setText(currentQues.getCau_Hoi());
            btnAns1.setText(currentQues.getDap_An_1());
            btnAns2.setText(currentQues.getDap_An_2());
            btnAns3.setText(currentQues.getDap_An_3());
            btnAns4.setText(currentQues.getDap_An_4());

            choiceCounter++;

            tvQuestion.setText("Question" + choiceCounter);

            answer = false;
            timedown = 30000;

            startCountDown();


        } else {
            if (countTrue > countFalse){
                Intent intent = new Intent(ActivityTracnghiem.this, ActivityCongra.class);
                intent.putExtra("Diem",countTrue);
                intent.putExtra("flag", 1);
                startActivity(intent);
            }
            if (countTrue < countFalse){
                Intent intent = new Intent(ActivityTracnghiem.this, ActivityFail.class);
                intent.putExtra("Diem", countTrue);
                intent.putExtra("flag", 1);
                startActivity(intent);
            }
        }
    }

    private void startCountDown() {
        countDownTimer = new CountDownTimer(timedown, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timedown = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timedown = 0;
                updateCountDownText();
            }
        }.start();
    }

    private void updateCountDownText() {
        int second = (int) ((timedown / 1000) % 60);
        String timeFormatted = String.format(Locale.getDefault(), "%02d", second);
        tvCountDown.setText(timeFormatted);

        if (timedown < 10000) {
            tvCountDown.setTextColor(Color.RED);
        } else {
            tvCountDown.setTextColor(Color.BLACK);
        }
    }

    public void FindID() {
        tvQuestion = findViewById(R.id.tvQuestion);
        tvContentQues = findViewById(R.id.tvQues);
        tvCountDown = findViewById(R.id.countdown);
        btnAns1 = findViewById(R.id.btnAns1);
        btnAns2 = findViewById(R.id.btnAns2);
        btnAns3 = findViewById(R.id.btnAns3);
        btnAns4 = findViewById(R.id.btnAns4);
    }
}

