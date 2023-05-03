package com.example.doanmb.Activity.Admin.DienTu;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.doanmb.DataBase.DBHelper;
import com.example.doanmb.Model.FillBlanks;
import com.example.doanmb.R;
import com.google.android.material.textfield.TextInputEditText;

public class ActivityFormDt extends AppCompatActivity {
    TextInputEditText Add_CauHoi,Add_DapAn;
    Button btn_OKELA;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formadddt);


        setTitle("Form");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Add_CauHoi = findViewById(R.id.Add_CauHoi);
        Add_DapAn = findViewById(R.id.Add_DapAn);
        btn_OKELA = findViewById(R.id.btn_OKELA);
        Intent intent = getIntent();
        DBHelper dbHelper = new DBHelper(this);
        String Muc_Do = intent.getStringExtra("Muc_Do");
        int flag = intent.getIntExtra("flag",0);
        if(flag !=1){
            Add_CauHoi.setText(getIntent().getExtras().getString("Cau_Hoi"));
            Add_DapAn.setText(getIntent().getExtras().getString("Dap_An"));
        }
        btn_OKELA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String CauHoi = Add_CauHoi.getText().toString();
                String DapAn = Add_DapAn.getText().toString();
                if(flag == 1){
                    FillBlanks fillBlanks = new FillBlanks(CauHoi,DapAn,Muc_Do);
                    dbHelper.insertDT(fillBlanks);
                    Intent intent1 = new Intent(ActivityFormDt.this,ActivityAddListDT.class);
                    intent1.putExtra("Muc_DoDT",Muc_Do);
                    startActivity(intent1);
                }
                else {
                    int id = getIntent().getExtras().getInt("ID");
                    FillBlanks fillBlanks = new FillBlanks(id,CauHoi,DapAn,Muc_Do);
                    dbHelper.updateDT(fillBlanks);
                    Intent intent1 = new Intent(ActivityFormDt.this,ActivityAddListDT.class);
                    intent1.putExtra("Muc_DoDT",Muc_Do);
                    startActivity(intent1);
                }
            }
        });



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);

    }
}
