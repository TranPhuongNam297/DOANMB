package com.example.doanmb.DataBase;

import android.app.Application;

import com.example.doanmb.DataBase.DBHelper;

public class App extends Application {

    DBHelper dbHelper;

    @Override
    public void onCreate() {
        super.onCreate();
        dbHelper = new DBHelper(this);
        dbHelper.CopydatabaseFromAssets();
    }
}
