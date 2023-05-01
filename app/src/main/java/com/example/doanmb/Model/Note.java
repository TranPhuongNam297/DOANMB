package com.example.doanmb.Model;

public class Note {
    public int ID;
    public String Tieng_Viet;
    public String Tieng_Anh;
    public String Tu_Loai;

    public Note(int ID, String tieng_Viet, String tieng_Anh, String tu_Loai) {
        this.ID = ID;
        Tieng_Viet = tieng_Viet;
        Tieng_Anh = tieng_Anh;
        Tu_Loai = tu_Loai;
    }

    public Note(String tieng_Viet, String tieng_Anh) {
        Tieng_Viet = tieng_Viet;
        Tieng_Anh = tieng_Anh;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTieng_Viet() {
        return Tieng_Viet;
    }

    public void setTieng_Viet(String tieng_Viet) {
        Tieng_Viet = tieng_Viet;
    }

    public String getTieng_Anh() {
        return Tieng_Anh;
    }

    public void setTieng_Anh(String tieng_Anh) {
        Tieng_Anh = tieng_Anh;
    }

    public String getTu_Loai() {
        return Tu_Loai;
    }

    public void setTu_Loai(String tu_Loai) {
        Tu_Loai = tu_Loai;
    }
}
