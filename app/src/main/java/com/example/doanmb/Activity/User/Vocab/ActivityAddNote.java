package com.example.doanmb.Activity.User.Vocab;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.doanmb.Activity.Admin.Vocab.ActivityAddChuDe;
import com.example.doanmb.Activity.Admin.Vocab.ActivityAddEdit;
import com.example.doanmb.DataBase.DBHelper;
import com.example.doanmb.Model.Note;
import com.example.doanmb.Model.Vocab;
import com.example.doanmb.R;
import com.google.android.material.textfield.TextInputEditText;

public class ActivityAddNote extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addnote);
        TextInputEditText ed_engaddnote = findViewById(R.id.ed_engaddnote);
        TextInputEditText ed_vneseaddnote = findViewById(R.id.ed_vneseaddnote);
        Button btn_savenote = findViewById(R.id.btn_savenote);

        DBHelper dbHelper = new DBHelper(ActivityAddNote.this);
        Intent intent = getIntent();
        int flag = intent.getIntExtra("flag",0);
        if (flag != 1){
            String TiengAnh = getIntent().getExtras().getString("English");
            String TiengViet = getIntent().getExtras().getString("TiengViet");

            ed_engaddnote.setText(TiengAnh);
            ed_vneseaddnote.setText(TiengViet);
        }
        btn_savenote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag==1){
                    String TiengAnh = ed_engaddnote.getText().toString().trim();
                    String TiengViet = ed_vneseaddnote.getText().toString().trim();
                    Note note = new Note(TiengViet, TiengAnh);
                    dbHelper.insertNote(note);
                    BackActivity();
                }
                else {
                    String TiengAnh = ed_engaddnote.getText().toString().trim();
                    String TiengViet = ed_vneseaddnote.getText().toString().trim();
                    Note note = new Note(TiengAnh, TiengViet);
                    dbHelper.updateNote(note);
                    BackActivity();
                }

            }
        });

    }
    private void BackActivity() {
        Intent intent = new Intent(ActivityAddNote.this, ActivityNote.class);
        startActivity(intent);
    }
}
