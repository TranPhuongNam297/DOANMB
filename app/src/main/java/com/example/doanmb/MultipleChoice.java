package com.example.doanmb;

import java.io.Serializable;

public class MultipleChoice implements Serializable {
    private int id;
    private String Cau_Hoi;
    private String Dap_An_1;
    private String Dap_An_2;
    private String Dap_An_3;
    private String Dap_An_4;
    private String Dap_An_Dung;
    private String Muc_Do;

    public MultipleChoice(int id, String cau_Hoi, String dap_An_1, String dap_An_2, String dap_An_3, String dap_An_4, String dap_An_Dung, String muc_Do) {
        this.id = id;
        Cau_Hoi = cau_Hoi;
        Dap_An_1 = dap_An_1;
        Dap_An_2 = dap_An_2;
        Dap_An_3 = dap_An_3;
        Dap_An_4 = dap_An_4;
        Dap_An_Dung = dap_An_Dung;
        Muc_Do = muc_Do;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCau_Hoi() {
        return Cau_Hoi;
    }

    public void setCau_Hoi(String cau_Hoi) {
        Cau_Hoi = cau_Hoi;
    }

    public String getDap_An_1() {
        return Dap_An_1;
    }

    public void setDap_An_1(String dap_An_1) {
        Dap_An_1 = dap_An_1;
    }

    public String getDap_An_2() {
        return Dap_An_2;
    }

    public void setDap_An_2(String dap_An_2) {
        Dap_An_2 = dap_An_2;
    }

    public String getDap_An_3() {
        return Dap_An_3;
    }

    public void setDap_An_3(String dap_An_3) {
        Dap_An_3 = dap_An_3;
    }

    public String getDap_An_4() {
        return Dap_An_4;
    }

    public void setDap_An_4(String dap_An_4) {
        Dap_An_4 = dap_An_4;
    }

    public String getDap_An_Dung() {
        return Dap_An_Dung;
    }

    public void setDap_An_Dung(String dap_An_Dung) {
        Dap_An_Dung = dap_An_Dung;
    }

    public String getMuc_Do() {
        return Muc_Do;
    }

    public void setMuc_Do(String muc_Do) {
        Muc_Do = muc_Do;
    }
}
