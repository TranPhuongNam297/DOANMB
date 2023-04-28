package com.example.doanmb.Model;

public class FillBlanks {
    int Id;
    String Cau_Hoi;
    String Dap_An;
    String Muc_Do;

    public FillBlanks(int id, String cau_Hoi, String dap_An, String muc_Do) {
        Id = id;
        Cau_Hoi = cau_Hoi;
        Dap_An = dap_An;
        Muc_Do = muc_Do;
    }

    public FillBlanks(String muc_Do){
        Muc_Do = muc_Do;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getCau_Hoi() {
        return Cau_Hoi;
    }

    public void setCau_Hoi(String cau_Hoi) {
        Cau_Hoi = cau_Hoi;
    }

    public String getDap_An() {
        return Dap_An;
    }

    public void setDap_An(String dap_An) {
        Dap_An = dap_An;
    }

    public String getMuc_Do() {
        return Muc_Do;
    }

    public void setMuc_Do(String muc_Do) {
        Muc_Do = muc_Do;
    }
}
