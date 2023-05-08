package com.example.doanmb.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.doanmb.Model.FillBlanks;
import com.example.doanmb.Model.Listening;
import com.example.doanmb.Model.MultipleChoice;
import com.example.doanmb.Model.Note;
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
    public Vocab info(int id ){
        Vocab vocab = new Vocab();
        db = openDB();
        String sql = "SELECT * FROM Vocab WHERE ID=" + id ;
        Cursor cursor = db.rawQuery(sql, null);

        if (cursor != null) {
            cursor.moveToFirst();
            int Id = cursor.getInt(0);
            String English = cursor.getString(1);
            String Tieng_Viet = cursor.getString(2);
            String Phat_Am = cursor.getString(3);
            String Chu_De = cursor.getString(4);
            String Vi_Du = cursor.getString(5);
            String Vi_Du2 = cursor.getString(6);
            vocab = new Vocab(Id, English, Tieng_Viet, Phat_Am, Chu_De, Vi_Du, Vi_Du2);
        }
        db.close();

        return vocab;
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
    public ArrayList<Vocab> getAllVocab(){
        ArrayList<Vocab> tmp = new ArrayList<>();
        db = openDB();
        String sql = "SELECT * FROM Vocab";

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
    public ArrayList<Vocab> search(String query, String chuDe1) {
        ArrayList<Vocab> tmp = new ArrayList<>();
        db = openDB();
        String sql ="SELECT * FROM Vocab WHERE (EngLish LIKE '%" + query + "%' OR Tieng_Viet LIKE '%" + query + "%') " +
                "AND Chu_DE = '" + chuDe1 + "'";
        System.out.println(sql);
//        Log.d("CHUDE", chuDe1);
        System.out.println(chuDe1);
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

    public long insert(Vocab vocab){
        db = openDB();
        ContentValues contentValues = new ContentValues();
        contentValues.put("English", vocab.getEnglish());
        contentValues.put("Tieng_Viet", vocab.getTieng_Viet());
        contentValues.put("Phat_Am", vocab.getPhat_Am());
        contentValues.put("Chu_De",vocab.getChu_De());
        contentValues.put("Vi_Du", vocab.getVi_Du());
        contentValues.put("Vi_Du2", vocab.getVi_Du2());
        long tmp = db.insert("Vocab", "", contentValues);
        db.close();
        return tmp;
    }
    public long insertTN(MultipleChoice multipleChoice){
        db = openDB();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Cau_Hoi",multipleChoice.getCau_Hoi());
        contentValues.put("Dap_An_1",multipleChoice.getDap_An_1());
        contentValues.put("Dap_An_2",multipleChoice.getDap_An_2());
        contentValues.put("Dap_An_3",multipleChoice.getDap_An_3());
        contentValues.put("Dap_An_4",multipleChoice.getDap_An_4());
        contentValues.put("Dap_An_Dung",multipleChoice.getDap_An_Dung());
        contentValues.put("Muc_Do",multipleChoice.getMuc_Do());
        long tmp = db.insert("TracNghiem","",contentValues);
        db.close();
        return tmp;
    }
    public long insertDT(FillBlanks fillBlanks){
        db = openDB();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Cau_Hoi",fillBlanks.getCau_Hoi());
        contentValues.put("Dap_An",fillBlanks.getDap_An());
        contentValues.put("Muc_Do",fillBlanks.getMuc_Do());
        long tmp = db.insert("DienTu","",contentValues);
        db.close();
        return tmp;
    }


    public long update(Vocab vocab){
        db = openDB();
        ContentValues contentValues = new ContentValues();
        contentValues.put("English", vocab.getEnglish());
        contentValues.put("Tieng_Viet", vocab.getTieng_Viet());
        contentValues.put("Phat_Am", vocab.getPhat_Am());
        contentValues.put("Chu_De", vocab.getChu_De());
        contentValues.put("Vi_Du", vocab.getVi_Du());
        contentValues.put("Vi_Du2", vocab.getVi_Du2());

        long tmp = db.update("Vocab", contentValues, "ID="+ vocab.getId(), null);
        db.close();
        return tmp;
    }
    public long updateDT(FillBlanks fillBlanks){
        db = openDB();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Cau_Hoi",fillBlanks.getCau_Hoi());
        contentValues.put("Dap_An",fillBlanks.getDap_An());
        contentValues.put("Muc_Do",fillBlanks.getMuc_Do());
        long tmp = db.update("DienTu", contentValues, "ID="+ fillBlanks.getId(), null);
        db.close();
        return tmp;
    }
    public long updateTN(MultipleChoice multipleChoice){
        db = openDB();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Cau_Hoi",multipleChoice.getCau_Hoi());
        contentValues.put("Dap_An_1",multipleChoice.getDap_An_1());
        contentValues.put("Dap_An_2",multipleChoice.getDap_An_2());
        contentValues.put("Dap_An_3",multipleChoice.getDap_An_3());
        contentValues.put("Dap_An_4",multipleChoice.getDap_An_4());
        contentValues.put("Dap_An_Dung",multipleChoice.getDap_An_Dung());
        contentValues.put("Muc_Do",multipleChoice.getMuc_Do());
        long tmp = db.update("TracNghiem",contentValues,"ID="+ multipleChoice.getId(), null);
        db.close();
        return tmp;
    }
//
    public long delete(Vocab vocab){
        db = openDB();
        long tmp = db.delete("Vocab", "ID="+ vocab.getId(), null);
        db.close();
        return tmp;
    }
    public long deleleDT(FillBlanks fillBlanks){
        db = openDB();
        long tmp = db.delete("DienTu", "ID="+ fillBlanks.getId(), null);
        db.close();
        return tmp;
    }
    public long deleteTN(MultipleChoice multipleChoice){
        db = openDB();
        long tmp = db.delete("TracNghiem", "ID="+ multipleChoice.getId(), null);
        db.close();
        return tmp;
    }

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

    public ArrayList<MultipleChoice> getMucDo() {
        ArrayList<MultipleChoice> tmp = new ArrayList<>();
        db = openDB();
        String sql = "SELECT DISTINCT Muc_Do FROM TracNghiem ";
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            String Muc_Do = cursor.getString(0);
            MultipleChoice multipleChoice = new MultipleChoice(Muc_Do);
            tmp.add(multipleChoice);
        }
        db.close();
        return tmp;
    }

    public ArrayList<FillBlanks> getMucDoDT() {
        ArrayList<FillBlanks> tmp = new ArrayList<>();
        db = openDB();
        String sql = "SELECT DISTINCT Muc_Do FROM DienTu ";
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            String Muc_Do = cursor.getString(0);
            FillBlanks fillBlanks = new FillBlanks(Muc_Do);
            tmp.add(fillBlanks);
        }
        db.close();
        return tmp;
    }
    public long AddChuDe(String ChuDe){
        db = openDB();
        ContentValues values = new ContentValues();
        values.put("Chu_De", ChuDe);
        long result = db.insert("Vocab", null, values);
        db.close();
        return result;
    }


    public ArrayList<Note> getNote() {
        ArrayList<Note> tmp = new ArrayList<>();
        db = openDB();
        String sql = "SELECT * FROM Note ";
        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
             int ID = cursor.getInt(0);
            String Tieng_Viet = cursor.getString(1);
            String Tieng_Anh = cursor.getString(2);
            String Tu_Loai = cursor.getString(3);
            Note note = new Note (ID, Tieng_Viet, Tieng_Anh, Tu_Loai);
            tmp.add(note);
        }
        db.close();
        return tmp;
    }

    public long insertNote(Note note){
        db = openDB();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Tieng_Anh",note.getTieng_Anh());
        contentValues.put("Tieng_Viet", note.getTieng_Viet());
        long tmp = db.insert("Note","",contentValues);
        db.close();
        return tmp;
    }

    public long deleteNote(Note note){
        db = openDB();
        long tmp = db.delete("Note", "ID="+ note.getID(), null);
        db.close();
        return tmp;
    }

    public long updateNote(Note note){
        db = openDB();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Tieng_Anh",note.getTieng_Anh());
        contentValues.put("Tieng_Viet", note.getTieng_Viet());
        long tmp = db.update("Note",contentValues,"ID="+ note.getID(), null);
        db.close();
        return tmp;
    }
    public ArrayList<Listening> getListening() {
        ArrayList<Listening> tmp = new ArrayList<>();
        db = openDB();
        String sql = "SELECT * FROM Listening";

        Cursor cursor = db.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String Title = cursor.getString(1);
            String FilePath = cursor.getString(2);
            Listening listening = new Listening(id, Title, FilePath);
            tmp.add(listening);
        }
        db.close();
        return tmp;
    }
    public long updateAllChuDe(String oldChuDe, String newChuDe) {
        db = openDB();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Chu_De", newChuDe);
        long tmp = db.update("Vocab", contentValues, "Chu_De=?", new String[]{oldChuDe});
        db.close();
        return tmp;
    }

    public long deleteCHUDE(Vocab vocab){
        db = openDB();
        long tmp = db.delete("Vocab", "ID="+ vocab.getId(), null);
        db.close();
        return tmp;
    }
}