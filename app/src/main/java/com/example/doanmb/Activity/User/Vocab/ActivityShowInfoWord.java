package com.example.doanmb.Activity.User.Vocab;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.doanmb.DataBase.DBHelper;
import com.example.doanmb.Model.Vocab;
import com.example.doanmb.R;

public class ActivityShowInfoWord extends AppCompatActivity {
    TextView tvtitle, tvEnglish, tvPhatAm, tvvd, tvvd2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showinfoword);
        String title ="",english="",phatam="",vi_du="",vi_du2="";
        FindID();
        Intent intent = getIntent();
        int id = (int) intent.getIntExtra("idContact", 0);
        int flag = (int) intent.getIntExtra("flag", 0);

        if(flag != 0){
            DBHelper dbHelper = new DBHelper(ActivityShowInfoWord.this);
            Vocab vocab = dbHelper.info(id);
            title = vocab.getChu_De();
            english = vocab.getEnglish();
            phatam = vocab.getPhat_Am();
            vi_du = vocab.getVi_Du();
            vi_du2 = vocab.getVi_Du2();
        }

        else {
            title  = getIntent().getExtras().getString("Tieng Viet");
            english = getIntent().getExtras().getString("English");
            phatam = getIntent().getExtras().getString("Phat Am") ;
            vi_du = getIntent().getExtras().getString("Vi Du");
            vi_du2 = getIntent().getExtras().getString("Vi Du2") ;
        }



        tvtitle.setText(title);
        tvEnglish.setText(english);
        tvPhatAm.setText(phatam);
        tvvd.setText(vi_du);
        tvvd2.setText(vi_du2);


    }

    private void FindID(){
        tvtitle = findViewById(R.id.tvtittle);
        tvEnglish = findViewById(R.id.tvEnglish);
        tvPhatAm = findViewById(R.id.tvPhatAm);
        tvvd = findViewById(R.id.vidu1);
        tvvd2 = findViewById(R.id.vidu2);
    }
}
