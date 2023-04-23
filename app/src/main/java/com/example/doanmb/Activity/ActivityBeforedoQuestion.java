package com.example.doanmb.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.doanmb.DataBase.DBHelper;
import com.example.doanmb.MultipleChoice;
import com.example.doanmb.R;

import java.io.Serializable;
import java.util.List;

public class ActivityBeforedoQuestion extends AppCompatActivity {

    List<MultipleChoice> choiceListDe;
    List<MultipleChoice> choiceListTB;
    List<MultipleChoice> choiceListK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beforedoquestion);

        DBHelper dbHelper = new DBHelper(this);
        choiceListDe = dbHelper.getMultipleChoiceDe();
        choiceListTB = dbHelper.getMultipleChoiceTrungBinh();
        choiceListK = dbHelper.getMultipleChoiceKho();


        Intent intent = getIntent();
        int listDe = intent.getIntExtra("De", 0);
        int listTB = intent.getIntExtra("Trung Binh", 0);
        int listK = intent.getIntExtra("Kho", 0);


        Button btnStartTN = findViewById(R.id.btn_starttn);
        btnStartTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ActivityBeforedoQuestion.this, ActivityThongBaoTracNghiem.class);


                if (listDe == 1) {
                    intent.putExtra("DeT", (Serializable) choiceListDe);
                }

                else if (listTB == 1) {
                    intent.putExtra("Trung BinhT", (Serializable) choiceListTB);
                }

                else if (listK == 1) {
                    intent.putExtra("KhoT", (Serializable) choiceListK);
                }

                startActivity(intent);
            }
        });
    }
}
