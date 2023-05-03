package com.example.doanmb.Activity.Admin.DienTu;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanmb.Adapter.DienTu.AddFillBlanksAdapter;
import com.example.doanmb.DataBase.DBHelper;
import com.example.doanmb.Model.FillBlanks;
import com.example.doanmb.Model.Vocab;
import com.example.doanmb.R;

import java.util.ArrayList;

public class ActivityAddMucDoDienTu extends AppCompatActivity implements AddFillBlanksAdapter.Listener {
    ImageView imgAddChuDe;
    RecyclerView recyclerView;

    ArrayList<FillBlanks> fillBlanks;

    public AddFillBlanksAdapter addFillBlanksAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showlistmucdodt);

        setTitle("Level");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //imgAddChuDe = findViewById(R.id.imgAddChuDe);

        DBHelper dbHelper = new DBHelper(ActivityAddMucDoDienTu.this);
        recyclerView = findViewById(R.id.rc_addmucdodt);
        fillBlanks = dbHelper.getMucDoDT();
        addFillBlanksAdapter = new AddFillBlanksAdapter(ActivityAddMucDoDienTu.this, fillBlanks, this);
        recyclerView.setAdapter(addFillBlanksAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(ActivityAddMucDoDienTu.this, LinearLayoutManager.VERTICAL, false));

    }

    @Override
    public void OnItemListener(int pos, Vocab contact) {

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
