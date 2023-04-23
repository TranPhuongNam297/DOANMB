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

        // Kh?i t?o c�c bi?n v� l?y d? li?u t? database
        DBHelper dbHelper = new DBHelper(this);
        choiceListDe = dbHelper.getMultipleChoiceDe();
        choiceListTB = dbHelper.getMultipleChoiceTrungBinh();
        choiceListK = dbHelper.getMultipleChoiceKho();

        // L?y d? li?u Intent truy?n t? Activity tr??c ?�
        Intent intent = getIntent();
        int listDe = intent.getIntExtra("De", 0);
        int listTB = intent.getIntExtra("Trung Binh", 0);
        int listK = intent.getIntExtra("Kho", 0);

        // X? l� s? ki?n khi ng??i d�ng click v�o button "B?t ??u l�m b�i tr?c nghi?m"
        Button btnStartTN = findViewById(R.id.btn_starttn);
        btnStartTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Kh?i t?o Intent m?i ?? chuy?n sang Activity Tr?c nghi?m
                Intent intent = new Intent(ActivityBeforedoQuestion.this, ActivityThongBaoTracNghiem.class);

                // N?u ng??i d�ng ?� ch?n lo?i c�u h?i ?? th� g?i danh s�ch c�u h?i ?? cho Activity Tr?c nghi?m
                if (listDe == 1) {
                    intent.putExtra("DeT", (Serializable) choiceListDe);
                }
                // N?u ng??i d�ng ?� ch?n lo?i c�u h?i Trung b�nh th� g?i danh s�ch c�u h?i Trung b�nh cho Activity Tr?c nghi?m
                else if (listTB == 1) {
                    intent.putExtra("Trung BinhT", (Serializable) choiceListTB);
                }
                // N?u ng??i d�ng ?� ch?n lo?i c�u h?i Kh� th� g?i danh s�ch c�u h?i Kh� cho Activity Tr?c nghi?m
                else if (listK == 1) {
                    intent.putExtra("KhoT", (Serializable) choiceListK);
                }

                startActivity(intent); // Chuy?n sang Activity Tr?c nghi?m
            }
        });
    }
}
