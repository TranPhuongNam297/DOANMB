package com.example.doanmb.Activity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.doanmb.AnswerCheck;
import com.example.doanmb.QuesCheck;
import com.example.doanmb.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class ActivityCheck extends AppCompatActivity implements View.OnClickListener{
    Button btnCheck;
    TextInputEditText edCheck;
    TextView tvQues;

    public List<QuesCheck> listQues;
    public int Quesnow = 0;

    public QuesCheck rquestion;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);

        btnCheck = findViewById(R.id.btnCheck);
        edCheck = findViewById(R.id.edCheck);
        tvQues = findViewById(R.id.tvQues);

        listQues = getListQues();
        if (listQues.isEmpty()){
            return;
        }
        setData(listQues.get(Quesnow));

    }
    public void setData(QuesCheck quesCheck){
        if (quesCheck == null){
            return;
        }
        rquestion = quesCheck;
        tvQues.setText(quesCheck.getQues());

        btnCheck.setOnClickListener(this);

    }

    public List<QuesCheck> getListQues(){
        List<QuesCheck> list = new ArrayList<>();
        List<AnswerCheck> answerList1 = new ArrayList<>();
        answerList1.add(new AnswerCheck("your", true));

        List<AnswerCheck> answerList2 = new ArrayList<>();
        answerList2.add(new AnswerCheck("do", true));

        List<AnswerCheck> answerList3 = new ArrayList<>();
        answerList3.add(new AnswerCheck("are", true));

        List<AnswerCheck> answerList4 = new ArrayList<>();
        answerList4.add(new AnswerCheck("to", true));

        List<AnswerCheck> answerList5 = new ArrayList<>();
        answerList5.add(new AnswerCheck("I want to drink water", true));

        list.add(new QuesCheck("What ... name?", answerList1, 1));
        list.add(new QuesCheck("Where ... you live?", answerList2, 2));
        list.add(new QuesCheck("How old ... you?", answerList3, 3));
        list.add(new QuesCheck("I want ... buy a new car?", answerList4, 4));
        list.add(new QuesCheck("Làm sao để nói tôi muốn uống nước?", answerList5, 5));
        return list;
    }


    private void wrongCorrect() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                showDialog("The answer is not correct");
            }
        }, 1000);
    }

    private void nextQues() {
        if (Quesnow == listQues.size() - 1){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run(){
                    Intent intent = new Intent(ActivityCheck.this, ActivityCongra.class);
                    startActivity(intent);
                }
            }, 1000);
        } else {
            Quesnow ++;
            setData(listQues.get(Quesnow));
        }
    }

    private void showDialog(String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message);
        builder.setCancelable(false);


        builder.setPositiveButton("Oke", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Quesnow = 0;
                setData(listQues.get(Quesnow));
                dialog.dismiss();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    @Override
    public void onClick(View v) {
        String userAnswer = edCheck.getText().toString().trim();
        if (rquestion == null) {
            return;
        }
        List<AnswerCheck> correctAnswers = rquestion.getListanswerCheck();
        boolean isCorrect = false;
        for (AnswerCheck answer : correctAnswers) {
            if (answer.getQues().equalsIgnoreCase(userAnswer)) {
                isCorrect = true;
                break;
            }
        }
        if (isCorrect) {
            Toast.makeText(ActivityCheck.this, "The answer is correct", Toast.LENGTH_SHORT).show();
            nextQues();
        } else {
            wrongCorrect();
        }
    }
}
