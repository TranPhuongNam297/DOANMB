package com.example.doanmb.Model;

public class Listening {
    private int ID;
    private String Title;
    private String FilePath;

    public Listening(int ID, String title, String filePath) {
        this.ID = ID;
        Title = title;
        FilePath = filePath;
    }

    public Listening(String title) {
        Title = title;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getFilePath() {
        return FilePath;
    }

    public void setFilePath(String filePath) {
        FilePath = filePath;
    }
}
