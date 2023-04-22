package com.example.doanmb;

import java.io.Serializable;

public class Vocab implements Serializable {
    private Integer Id;
    private String English;
    private String Tieng_Viet;
    private String Phat_Am;

    private String Chu_De;

    private String Vi_Du;

    private String Vi_Du2;

    public Vocab(Integer id, String english, String tieng_Viet, String phat_Am, String Chu_de, String Vi_Du, String Vi_Du2) {
        Id = id;
        English = english;
        Tieng_Viet = tieng_Viet;
        Phat_Am = phat_Am;
        Chu_De = Chu_de;
        Vi_Du = Vi_Du;
        Vi_Du2 = Vi_Du2;
    }

    public Vocab() {
    }

    public String getVi_Du() {
        return Vi_Du;
    }

    public void setVi_Du(String vi_Du) {
        Vi_Du = vi_Du;
    }

    public String getVi_Du2() {
        return Vi_Du2;
    }

    public void setVi_Du2(String vi_Du2) {
        Vi_Du2 = vi_Du2;
    }

    public String getChu_De() {
        return Chu_De;
    }

    public void setChu_De(String chu_De) {
        Chu_De = chu_De;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getEnglish() {
        return English;
    }

    public void setEnglish(String english) {
        English = english;
    }

    public String getTieng_Viet() {
        return Tieng_Viet;
    }

    public void setTieng_Viet(String tieng_Viet) {
        Tieng_Viet = tieng_Viet;
    }

    public String getPhat_Am() {
        return Phat_Am;
    }

    public void setPhat_Am(String phat_Am) {
        Phat_Am = phat_Am;
    }
}
