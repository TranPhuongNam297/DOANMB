package com.example.doanmb;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ActivityTracnghiem extends AppCompatActivity implements View.OnClickListener {
    TextView tvQuestion, tvContentQues;
    Button btnAns1, btnAns2, btnAns3, btnAns4;

    public List<Question> listQues;
    public int Quesnow = 0;

    public Question rquestion;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracnghiem);
        FindID();
        listQues = getListQuention();
        if (listQues.isEmpty()){
            return;
        }
        setDataQuestion(listQues.get(Quesnow));
    }

    private void setDataQuestion(Question question) {
        if(question == null){
            return;
        }
        rquestion = question;

        btnAns1.setBackgroundResource(R.drawable.bg_button_custom);
        btnAns2.setBackgroundResource(R.drawable.bg_button_custom);
        btnAns3.setBackgroundResource(R.drawable.bg_button_custom);
        btnAns4.setBackgroundResource(R.drawable.bg_button_custom);

        String TieuDeQues = "Question " + question.getNumber();
        tvQuestion.setText(TieuDeQues);
        tvContentQues.setText(question.getContent());
        btnAns1.setText(question.getListAnswer().get(0).getContent());
        btnAns2.setText(question.getListAnswer().get(1).getContent());
        btnAns3.setText(question.getListAnswer().get(2).getContent());
        btnAns4.setText(question.getListAnswer().get(3).getContent());

        btnAns1.setOnClickListener(this);
        btnAns2.setOnClickListener(this);
        btnAns3.setOnClickListener(this);
        btnAns4.setOnClickListener(this);
    }

    public List<Question> getListQuention(){
        List<Question> list = new ArrayList<>();
        List<Answer> answerList1 = new ArrayList<>();
        answerList1.add(new Answer("What your name?", true));
        answerList1.add(new Answer("Where do you live?", false));
        answerList1.add(new Answer("How old are you?", false));
        answerList1.add(new Answer("Good Morning", false));

        List<Answer> answerList2 = new ArrayList<>();
        answerList2.add(new Answer("What your name?", false));
        answerList2.add(new Answer("Where do you live?", true));
        answerList2.add(new Answer("How old are you?", false));
        answerList2.add(new Answer("Good Morning", false));

        List<Answer> answerList3 = new ArrayList<>();
        answerList3.add(new Answer("What your name?", false));
        answerList3.add(new Answer("Where do you live?", false));
        answerList3.add(new Answer("How old are you?", true));
        answerList3.add(new Answer("Good Morning", false));

        List<Answer> answerList4 = new ArrayList<>();
        answerList4.add(new Answer("What your name?", false));
        answerList4.add(new Answer("Where do you live?", false));
        answerList4.add(new Answer("How old are you?", false));
        answerList4.add(new Answer("Good Morning", true));

        List<Answer> answerList5 = new ArrayList<>();
        answerList5.add(new Answer("I want to drink water", true));
        answerList5.add(new Answer("I want to buy a car", false));
        answerList5.add(new Answer("I want to buy a bottle of water", false));
        answerList5.add(new Answer("Good Bye", false));

        list.add(new Question("Làm sao để hỏi tên bạn là gì?", 1, answerList1));
        list.add(new Question("Làm sao để hỏi bạn sống ở đâu?", 2, answerList2));
        list.add(new Question("Làm sao để hỏi bạn bao nhiêu tuổi?", 3, answerList3));
        list.add(new Question("Làm sao để nói chào buổi sáng", 4, answerList4));
        list.add(new Question("Câu tôi muốn uống nước nói ra sao", 5, answerList5));

        return list;
    }
    public void FindID(){
        tvQuestion = findViewById(R.id.tvQuestion);
        tvContentQues = findViewById(R.id.tvQues);
        btnAns1 = findViewById(R.id.btnAns1);
        btnAns2 = findViewById(R.id.btnAns2);
        btnAns3 = findViewById(R.id.btnAns3);
        btnAns4 = findViewById(R.id.btnAns4);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAns1:
                btnAns1.setBackgroundResource(R.drawable.bg_orange);
                CheckAnswer(btnAns1, rquestion, rquestion.getListAnswer().get(0));
                break;
            case R.id.btnAns2:
                btnAns2.setBackgroundResource(R.drawable.bg_orange);
                CheckAnswer(btnAns2, rquestion, rquestion.getListAnswer().get(1));
                break;
            case R.id.btnAns3:
                btnAns3.setBackgroundResource(R.drawable.bg_orange);
                CheckAnswer(btnAns3, rquestion, rquestion.getListAnswer().get(2));
                break;
            case R.id.btnAns4:
                btnAns4.setBackgroundResource(R.drawable.bg_orange);
                CheckAnswer(btnAns4, rquestion, rquestion.getListAnswer().get(3));
                break;
        }
    }
    public void CheckAnswer(Button button, Question question, Answer answer){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (answer.correct){
                    button.setBackgroundResource(R.drawable.bg_green);
                    nextQues();
                } else {
                    button.setBackgroundResource(R.drawable.bg_red);
                    showAnsCorrect(question);
                    wrongCorrect();
                }
            }
        }, 1000);
    }

    private void wrongCorrect() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                showDialog("The answer is not correct");
            }
        }, 1000);
    }

    private void showAnsCorrect(Question question) {
        if (question == null || question.getListAnswer() == null || question.getListAnswer().isEmpty()){
            return;
        }
        if (question.getListAnswer().get(0).correct){
            btnAns1.setBackgroundResource(R.drawable.bg_green);
        }else if (question.getListAnswer().get(1).correct) {
            btnAns2.setBackgroundResource(R.drawable.bg_green);
        }else if (question.getListAnswer().get(2).correct) {
            btnAns3.setBackgroundResource(R.drawable.bg_green);
        }else if (question.getListAnswer().get(3).correct) {
            btnAns4.setBackgroundResource(R.drawable.bg_green);
        }
    }

    private void nextQues() {
        if (Quesnow == listQues.size() - 1){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run(){
                    Intent intent = new Intent(ActivityTracnghiem.this, ActivityCongra.class);
                    startActivity(intent);
                }
            }, 1000);
        } else {
            Quesnow ++;
            setDataQuestion(listQues.get(Quesnow));
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
                setDataQuestion(listQues.get(Quesnow));
                dialog.dismiss();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
