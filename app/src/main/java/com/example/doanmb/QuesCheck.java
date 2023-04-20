package com.example.doanmb;

import java.util.List;

public class QuesCheck {
    public String ques;
    public int Number;
    public List<AnswerCheck> listanswerCheck;

    public QuesCheck(String ques, List<AnswerCheck> listanswerCheck, int Number) {
        this.ques = ques;
        this.listanswerCheck = listanswerCheck;
        this.Number = Number;
    }

    public String getQues() {
        return ques;
    }

    public void setQues(String ques) {
        this.ques = ques;
    }

    public List<AnswerCheck> getListanswerCheck() {
        return listanswerCheck;
    }

    public void setListanswerCheck(List<AnswerCheck> listanswerCheck) {
        this.listanswerCheck = listanswerCheck;
    }
    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }
}
