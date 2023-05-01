package com.example.doanmb.Activity.Admin.TracNghiem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.doanmb.Activity.MainActivity;
import com.example.doanmb.DataBase.DBHelper;
import com.example.doanmb.Model.MultipleChoice;
import com.example.doanmb.R;

public class ActivityFormTN extends AppCompatActivity {
    TextView Add_CauHoi,Add_Da1,Add_Da2,Add_Da3,Add_Da4,Add_Da;
    Button btn_OK;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addedittracnghiem);
        Add_CauHoi = findViewById(R.id.Add_CauHoi);
        Add_Da1 = findViewById(R.id.Add_Da1);
        Add_Da2 = findViewById(R.id.Add_Da2);
        Add_Da3 = findViewById(R.id.Add_Da3);
        Add_Da4 = findViewById(R.id.Add_Da4);
        Add_Da = findViewById(R.id.Add_Da);
        btn_OK = findViewById(R.id.btn_OK);
        DBHelper dbHelper = new DBHelper(ActivityFormTN.this);
        String Muc_Do = getIntent().getExtras().getString("Muc_Do");
        Intent intent1 = getIntent();
        int flag = intent1.getIntExtra("flag",0);

        if (flag==0){
            Add_CauHoi.setText(getIntent().getExtras().getString("Cau_Hoi"));
            Add_Da1.setText(getIntent().getExtras().getString("Dap_An_1"));
            Add_Da2.setText(getIntent().getExtras().getString("Dap_An_2"));
            Add_Da3.setText(getIntent().getExtras().getString("Dap_An_3"));
            Add_Da4.setText(getIntent().getExtras().getString("Dap_An_4"));
            Add_Da.setText(getIntent().getExtras().getString("Dap_An_Dung"));
        }

        btn_OK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Cau_Hoi = Add_CauHoi.getText().toString();
                String Da_A = Add_Da1.getText().toString().trim();
                String Da_B = Add_Da2.getText().toString().trim();
                String Da_C = Add_Da3.getText().toString().trim();
                String Da_D = Add_Da4.getText().toString().trim();
                String Da_Dung = Add_Da.getText().toString().trim();
                if(flag==1){
                    MultipleChoice multipleChoice = new MultipleChoice(Cau_Hoi,Da_A,Da_B,Da_C,Da_D,Da_Dung,Muc_Do);
                    dbHelper.insertTN(multipleChoice);
                    Intent intent = new Intent(ActivityFormTN.this,ActivityAddListTN.class);
                    intent.putExtra("Muc_Do",Muc_Do);
                    startActivity(intent);
                }else {
                    int INTracNghiem = getIntent().getExtras().getInt("ID");
                    MultipleChoice multipleChoice = new MultipleChoice(INTracNghiem,Cau_Hoi,Da_A,Da_B,Da_C,Da_D,Da_Dung,Muc_Do);
                    dbHelper.updateTN(multipleChoice);
                    Intent intent = new Intent(ActivityFormTN.this,ActivityAddListTN.class);
                    intent.putExtra("Muc_Do",Muc_Do);
                    startActivity(intent);
                }
            }
        });
    }
}
