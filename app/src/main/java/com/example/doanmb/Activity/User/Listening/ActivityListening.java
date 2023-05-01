package com.example.doanmb.Activity.User.Listening;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.doanmb.R;

public class ActivityListening extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listening);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            mediaPlayer = null;
        }
        public void music(View view) {
            switch (view.getId()){
                case R.id.button:
                    if(mediaPlayer == null){
                        mediaPlayer = MediaPlayer.create(this, R.raw.lt);
                    }
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            stopMusic();
                        }
                    });
                    mediaPlayer.start();
                    break;
                case R.id.button2:
                    if(mediaPlayer != null) {
                        mediaPlayer.pause();
                    }
                    break;
                case R.id.button3:
                    if(mediaPlayer != null){
                        mediaPlayer.stop();
                        stopMusic();
                    }
                    break;
            }
        }

        private void stopMusic() {
            mediaPlayer.release();
            mediaPlayer = null;
        }

        @Override
        protected void onStop() {
            super.onStop();
            stopMusic();
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
