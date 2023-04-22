package com.example.doanmb;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class DBHelper {
    String DB_NAME = "DataBase_DoAn.db";
    SQLiteDatabase db;
    Context context;

    public DBHelper(Context context) {
        this.context = context;
    }

    public SQLiteDatabase openDB(){
        return context.openOrCreateDatabase(DB_NAME, Context.MODE_PRIVATE, null);
    }

    public void CopydatabaseFromAssets(){
        File dbFile = context.getDatabasePath(DB_NAME);

        if(!dbFile.exists()){
            try {
                InputStream is = context.getAssets().open(DB_NAME);
                OutputStream os = new FileOutputStream(dbFile);
                byte[] buffer = new byte[1024];
                while (is.read(buffer) > 0){
                    os.write(buffer);
                }
                os.flush();
                os.close();
                is.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public ArrayList<Vocab> getVocab(){
        ArrayList<Vocab> tmp = new ArrayList<>();
        db = openDB();
        String sql = "SELECT * FROM Vocab";
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String English = cursor.getString(1);
            String Tieng_Viet = cursor.getString(2);
            String Phat_Am = cursor.getString(3);
            String Chu_De = cursor.getString(4);
            String Vi_Du = cursor.getString(5);
            String Vi_Du2 = cursor.getString(6);
            Vocab vocab = new Vocab(id, English, Tieng_Viet, Phat_Am, Chu_De, Vi_Du, Vi_Du2);
            tmp.add(vocab);
        }
        db.close();
        return tmp;
    }


}
