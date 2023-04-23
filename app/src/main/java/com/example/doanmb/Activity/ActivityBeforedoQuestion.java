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

        // Kh?i t?o các bi?n và l?y d? li?u t? database
        DBHelper dbHelper = new DBHelper(this);
        choiceListDe = dbHelper.getMultipleChoiceDe();
        choiceListTB = dbHelper.getMultipleChoiceTrungBinh();
        choiceListK = dbHelper.getMultipleChoiceKho();

        // L?y d? li?u Intent truy?n t? Activity tr??c ?ó
        Intent intent = getIntent();
        int listDe = intent.getIntExtra("De", 0);
        int listTB = intent.getIntExtra("Trung Binh", 0);
        int listK = intent.getIntExtra("Kho", 0);

        // X? lý s? ki?n khi ng??i dùng click vào button "B?t ??u làm bài tr?c nghi?m"
        Button btnStartTN = findViewById(R.id.btn_starttn);
        btnStartTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Kh?i t?o Intent m?i ?? chuy?n sang Activity Tr?c nghi?m
                Intent intent = new Intent(ActivityBeforedoQuestion.this, ActivityThongBaoTracNghiem.class);

                // N?u ng??i dùng ?ã ch?n lo?i câu h?i ?? thì g?i danh sách câu h?i ?? cho Activity Tr?c nghi?m
                if (listDe == 1) {
                    intent.putExtra("DeT", (Serializable) choiceListDe);
                }
                // N?u ng??i dùng ?ã ch?n lo?i câu h?i Trung bình thì g?i danh sách câu h?i Trung bình cho Activity Tr?c nghi?m
                else if (listTB == 1) {
                    intent.putExtra("Trung BinhT", (Serializable) choiceListTB);
                }
                // N?u ng??i dùng ?ã ch?n lo?i câu h?i Khó thì g?i danh sách câu h?i Khó cho Activity Tr?c nghi?m
                else if (listK == 1) {
                    intent.putExtra("KhoT", (Serializable) choiceListK);
                }

                startActivity(intent); // Chuy?n sang Activity Tr?c nghi?m
            }
        });
    }
}
