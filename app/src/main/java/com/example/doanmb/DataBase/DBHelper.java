package com.example.doanmb.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.doanmb.Model.FillBlanks;
import com.example.doanmb.Model.MultipleChoice;
import com.example.doanmb.Model.Vocab;

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

    public SQLiteDatabase openDB() {
        return context.openOrCreateDatabase(DB_NAME, Context.MODE_PRIVATE, null);
    }

    public void CopydatabaseFromAssets() {
        File dbFile = context.getDatabasePath(DB_NAME);

        if (!dbFile.exists()) {
            try {
                InputStream is = context.getAssets().open(DB_NAME);
                OutputStream os = new FileOutputStream(dbFile);
                byte[] buffer = new byte[1024];
                while (is.read(buffer) > 0) {
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

    public ArrayList<Vocab> getVocab(String chude) {
        ArrayList<Vocab> tmp = new ArrayList<>();
        db = openDB();
        String sql = "SELECT * FROM Vocab WHERE Chu_De LIKE '%" + chude + "%'";

        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
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
    public ArrayList<MultipleChoice> getQuestion(String mucdo){
        ArrayList<MultipleChoice> tmp = new ArrayList<>();
        db = openDB();
        String sql = "SELECT * FROM TracNghiem WHERE Muc_Do LIKE '%" + mucdo + "%'";
        Cursor cursor = db.rawQuery(sql,null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String Cau_Hoi = cursor.getString(1);
            String Dap_An_1 = cursor.getString(2);
            String Dap_An_2 = cursor.getString(3);
            String Dap_An_3 = cursor.getString(4);
            String Dap_An_4 = cursor.getString(5);
            String Dap_An_Dung = cursor.getString(6);
            String Muc_Do = cursor.getString(7);
            MultipleChoice multipleChoice = new MultipleChoice(id,Cau_Hoi,Dap_An_1,Dap_An_2,Dap_An_3,Dap_An_4,Dap_An_Dung,Muc_Do);
            tmp.add(multipleChoice);
        }

        db.close();
        return tmp;
    }

    public ArrayList<FillBlanks> getQuestionFillBlanks(String mucdo){
        ArrayList<FillBlanks> tmp = new ArrayList<>();
        db = openDB();
        String sql = "SELECT * FROM DienTu WHERE Muc_Do LIKE '%" + mucdo + "%'";
        Cursor cursor = db.rawQuery(sql,null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String Cau_Hoi = cursor.getString(1);
            String Dap_An = cursor.getString(2);
            String Muc_Do = cursor.getString(3);
            FillBlanks fillBlanks = new FillBlanks(id,Cau_Hoi,Dap_An,Muc_Do);
            tmp.add(fillBlanks);
        }
        db.close();
        return tmp;
    }
    public ArrayList<Vocab> search(String query){
        ArrayList<Vocab> tmp = new ArrayList<>();
        db = openDB();
        String sql = "SELECT * FROM Contact WHERE FNAME LIKE '%" + query + "%' " +
                "UNION " +
                "SELECT * FROM Contact WHERE LNAME LIKE '%" + query + "%' ";
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

    public long insert(Vocab vocab){
        db = openDB();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ID", vocab.getId());
        contentValues.put("English", vocab.getEnglish());
        contentValues.put("Tieng_Viet", vocab.getTieng_Viet());
        contentValues.put("Phat_Am", vocab.getPhat_Am());
        contentValues.put("Vi_Du", vocab.getVi_Du());
        contentValues.put("Vi_Du2", vocab.getVi_Du2());
        long tmp = db.insert("Vocab", "", contentValues);
        db.close();
        return tmp;
    }

//    public long update(Contact contact){
//        db = openDB();
//        ContentValues contentValues = new ContentValues();
//        contentValues.put("FNAME", contact.getFname());
//        contentValues.put("LNAME", contact.getLname());
//        contentValues.put("PHONE", contact.getPhone());
//        contentValues.put("EMAIL", contact.getMail());
//        contentValues.put("IMAGE", contact.getImage());
//        contentValues.put("BIRTHDAY", contact.getBirthDay());
//        long tmp = db.update("Contact", contentValues, "ID="+ contact.getId(), null);
//        db.close();
//        return tmp;
//    }
//
//    public long delete(Contact contact){
//        db = openDB();
//        long tmp = db.delete("Contact", "ID="+ contact.getId(), null);
//        db.close();
//        return tmp;
//    }

    public ArrayList<Vocab> getChuDe() {
        ArrayList<Vocab> tmp = new ArrayList<>();
        db = openDB();
        String sql = "SELECT DISTINCT Chu_De FROM Vocab ";

        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            String Chu_De = cursor.getString(0);
            Vocab vocab = new Vocab(Chu_De);
            tmp.add(vocab);
        }
        db.close();
        return tmp;
    }
}