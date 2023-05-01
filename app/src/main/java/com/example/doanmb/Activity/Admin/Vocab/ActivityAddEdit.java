package com.example.doanmb.Activity.Admin.Vocab;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.doanmb.Activity.Admin.ActivityAdmin;
import com.example.doanmb.DataBase.DBHelper;
import com.example.doanmb.Model.Vocab;
import com.example.doanmb.R;
import com.google.android.material.textfield.TextInputEditText;

public class ActivityAddEdit extends AppCompatActivity {
    TextInputEditText edID, edEnglish, edTiengViet, edPhatAm, edChuDe, edVi_du1, edVi_du2;
    Button btn_Okay;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addvocab);
        edEnglish = findViewById(R.id.edEnglish);
        edTiengViet = findViewById(R.id.edTiengViet);
        edPhatAm = findViewById(R.id.edPhatAm);
        edVi_du1 = findViewById(R.id.edVi_Du);
        edVi_du2 = findViewById(R.id.edVi_Du2);
        btn_Okay = findViewById(R.id.btn_Okay);
        DBHelper dbHelper = new DBHelper(ActivityAddEdit.this);
        String chude =  getIntent().getExtras().getString("CHUDE");
        Intent intent = getIntent();
        int flag = intent.getIntExtra("flag",0);
        if(flag!=1){
            int ID  = getIntent().getExtras().getInt("ID");
            String TiengViet = getIntent().getExtras().getString("Tieng Viet");
            String English = getIntent().getExtras().getString("English");
            String PhatAm = getIntent().getExtras().getString("Phat Am");
            String Vd1 = getIntent().getExtras().getString("Vi Du");
            String Vd2 = getIntent().getExtras().getString("Vi Du2");

            edEnglish.setText(English);
            edTiengViet.setText(TiengViet);
            edPhatAm.setText(PhatAm);
            edVi_du1.setText(Vd1);
            edVi_du2.setText(Vd2);
        }
//        int finalID = ID;
        btn_Okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag==1){
                    String TiengAnh = edEnglish.getText().toString().trim();
                    String TiengViet = edTiengViet.getText().toString().trim();
                    String PhatAm = edPhatAm.getText().toString().trim();
                    String Vd1 = edVi_du1.getText().toString().trim();
                    String Vd2 = edVi_du2.getText().toString().trim();
                    Vocab vocab = new Vocab(TiengAnh,TiengViet,PhatAm,chude,Vd1,Vd2);
                    dbHelper.insert(vocab);
                    BackActivity();
                }
                else {
                    int ID  = getIntent().getExtras().getInt("ID");
                    String ChuDene = getIntent().getExtras().getString("Chu_De");
                    String English = getIntent().getExtras().getString("English");
                    String TiengAnh = edEnglish.getText().toString().trim();
                    String TiengViet = edTiengViet.getText().toString().trim();
                    String PhatAm = edPhatAm.getText().toString().trim();
                    String Vd1 = edVi_du1.getText().toString().trim();
                    String Vd2 = edVi_du2.getText().toString().trim();
                    Vocab vocab = new Vocab(ID,TiengAnh,TiengViet,PhatAm,ChuDene,Vd1,Vd2);
                    dbHelper.update(vocab);
                    BackActivity();
                }
            }
        });

    }

//    private void checkFlag() {
//        Intent intent = getIntent();
//        int flag = intent.getIntExtra("flag",0);
//        if(flag!=1){
//            int ID  = getIntent().getExtras().getInt("ID");
//            String TiengViet = getIntent().getExtras().getString("Tieng Viet");
//            String English = getIntent().getExtras().getString("English");
//            String PhatAm = getIntent().getExtras().getString("Phat Am");
//            String ChuDe = getIntent().getExtras().getString("Chu_De");
//            String Vd1 = getIntent().getExtras().getString("Vi Du");
//            String Vd2 = getIntent().getExtras().getString("Vi Du2");
//
//        }
//    }

    private void BackActivity() {
        Intent intent = new Intent(ActivityAddEdit.this, ActivityAddChuDe.class);
        startActivity(intent);
    }

}
