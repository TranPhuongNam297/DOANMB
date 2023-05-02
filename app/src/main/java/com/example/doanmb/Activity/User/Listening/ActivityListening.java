package com.example.doanmb.Activity.User.Listening;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.doanmb.DataBase.DBHelper;
import com.example.doanmb.Model.Listening;
import com.example.doanmb.R;

import java.util.ArrayList;

public class ActivityListening extends AppCompatActivity {
    MediaPlayer player;
    DBHelper dbHelper = new DBHelper(ActivityListening.this);

    ArrayList<Listening> listenings;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listening);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView play = findViewById(R.id.play);
        listenings = dbHelper.getListening();
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listenings.size() > 0) {
                    try {
                        AssetFileDescriptor afd = getAssets().openFd("listening/" + listenings.get(0).getFilePath());
                        //Khởi tạo Media Player
                        if (player == null) {
                            player = new MediaPlayer();
                        } else {
                            player.reset();
                        }
                        player.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                        afd.close();
                        player.prepare();
                        player.start();
                    } catch (Exception ex) {
                        Toast.makeText(ActivityListening.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(ActivityListening.this, "No listening found", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (player != null) {
            player.release();
            player = null;
        }
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
