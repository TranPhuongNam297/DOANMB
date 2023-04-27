package com.example.doanmb.Activity;

import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.doanmb.R;
import com.google.android.material.textfield.TextInputEditText;

public class ActivityAddEdit extends AppCompatActivity {
    TextInputEditText edID, edEnglish, edTiengViet, edPhatAm, edChuDe, edVi_du1, edVi_du2;
    Button btn_Okay;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        FindID();

    }

    private void FindID(){
        edID = findViewById(R.id.edID);
        edEnglish = findViewById(R.id.edEnglish);
        edTiengViet = findViewById(R.id.edTiengViet);
        edPhatAm = findViewById(R.id.edPhatAm);
        edVi_du1 = findViewById(R.id.edVi_Du);
        edVi_du2 = findViewById(R.id.edVi_Du2);
        edChuDe = findViewById(R.id.edChu_De);
        btn_Okay = findViewById(R.id.btn_Okay);
    }
}
