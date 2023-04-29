package com.example.doanmb.Activity.User.Vocab;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.doanmb.R;

public class ActivityShowInfoWord extends AppCompatActivity {
    TextView tvtitle, tvEnglish, tvPhatAm, tvvd, tvvd2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showinfoword);
        FindID();

        String title  = getIntent().getExtras().getString("Tieng Viet");
        String english = getIntent().getExtras().getString("English");
        String phatam = getIntent().getExtras().getString("Phat Am") ;
        String vi_du = getIntent().getExtras().getString("Vi Du");
        String vi_du2 = getIntent().getExtras().getString("Vi Du2") ;

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
