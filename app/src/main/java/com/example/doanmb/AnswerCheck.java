package com.example.doanmb;

public class AnswerCheck {
    public String ques;
    public boolean right;

    public AnswerCheck(String ques, boolean right) {
        this.ques = ques;
        this.right = right;
    }

    public String getQues() {
        return ques;
    }

    public void setQues(String ques) {
        this.ques = ques;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }
}
