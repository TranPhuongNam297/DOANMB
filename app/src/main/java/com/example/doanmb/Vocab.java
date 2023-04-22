package com.example.doanmb;

import java.io.Serializable;

public class Vocab implements Serializable {
    private Integer Id;
    private String English;
    private String Tieng_Viet;
    private String Phat_Am;

    public Vocab(Integer id, String english, String tieng_Viet, String phat_Am) {
        Id = id;
        English = english;
        Tieng_Viet = tieng_Viet;
        Phat_Am = phat_Am;
    }

    public Vocab() {
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
