package com.example.doanmb.Activity.User.Listening;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.doanmb.DataBase.DBHelper;
import com.example.doanmb.Model.Listening;
import com.example.doanmb.R;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class ActivityListening extends AppCompatActivity {
    MediaPlayer player;
    TextView tvStart, tvEnd;
    DBHelper dbHelper = new DBHelper(ActivityListening.this);

    ArrayList<Listening> listenings;
    int pausePosition;
    SeekBar seekBar;
    Handler myHandler = new Handler();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listening);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ImageView play = findViewById(R.id.play);
        ImageView pause = findViewById(R.id.pause);
        ImageView stop = findViewById(R.id.stop);
        TextView tv_settitle = findViewById(R.id.tv_settitle);
        seekBar = findViewById(R.id.seekBar);

        tvStart = findViewById(R.id.tvStart);
        tvEnd = findViewById(R.id.tvEnd);



        String title = getIntent().getExtras().getString("Title");
        tv_settitle.setText(title);
        String filePath = getIntent().getExtras().getString("FilePath");
        listenings = dbHelper.getListening();

        //cấm người dùng đụng vào seekbar
        seekBar.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });



        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listenings.size() > 0) {
                    try {
                        AssetFileDescriptor afd = getAssets().openFd("listening/" + filePath);
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
                        // Kiểm tra xem có đang trong trạng thái pause không
                        if (pausePosition > 0) {
                            // Tiếp tục phát nhạc từ thời điểm pause trước đó
                            player.seekTo(pausePosition);
                            pausePosition = 0;
                        }
                        //set giá trị đối đa của seekbar là thời gian của file mp3 đang được phát
                        seekBar.setMax(player.getDuration());
                        updateSeekBar();
                    } catch (Exception ex) {
                        Toast.makeText(ActivityListening.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(ActivityListening.this, "No listening found", Toast.LENGTH_SHORT).show();
                }
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(player != null) {
                    player.pause();
                    pausePosition = player.getCurrentPosition(); // Lưu lại thời điểm pause
                }
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (player != null) {
                    player.stop();
                    player.reset();
                    player.release();
                    player = null;
                }
            }
        });
    }

    private void updateSeekBar() {
        seekBar.setProgress(player.getCurrentPosition());
        Handler myHandler = new Handler();
        myHandler.postDelayed(updateTime, 3000);
    }

    private Runnable updateTime = new Runnable() {
        public void run() {
            if (player != null) {
                long currentDuration = player.getCurrentPosition();
                long totalDuration = player.getDuration();

                // Displaying Total Duration time
                tvEnd.setText(String.format("%d:%02d", TimeUnit.MILLISECONDS.toMinutes(totalDuration),
                        TimeUnit.MILLISECONDS.toSeconds(totalDuration) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(totalDuration))));

                // Displaying time completed playing
                tvStart.setText(String.format("%d:%02d", TimeUnit.MILLISECONDS.toMinutes(currentDuration),
                        TimeUnit.MILLISECONDS.toSeconds(currentDuration) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(currentDuration))));

                // Updating progress bar
                int progress = (int) (currentDuration * 100 / totalDuration);
                seekBar.setProgress(progress);
                myHandler.postDelayed(this, 1000);

                if (player != null) {
                    int mCurrentPosition = player.getCurrentPosition();
                    seekBar.setProgress(mCurrentPosition);
                }
                myHandler.postDelayed(this, 3000);
            }
        }
    };



    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (player != null) {
            player.release();
            player = null;
        }
        // Hủy bỏ tác vụ cập nhật giá trị của SeekBar
        myHandler.removeCallbacks(updateTime);
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
