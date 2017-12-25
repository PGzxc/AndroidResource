package com.example.androidresource.ui.asset;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.example.androidresource.R;

import java.io.FileDescriptor;
import java.io.IOException;

/**
 * Created by admin on 2017/12/26.
 */

public class AssetMusicActivity extends AppCompatActivity {
    private MediaPlayer mp;//mediaPlayer对象
    private Button play, pause, stop;//播放 暂停/继续 停止 按钮
    private TextView hint;//显示当前播放状态
    private boolean isPause = false;//是否暂停

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asset_music);
        initView();
        initData();
        setListener();
    }

    private void setListener() {
        mp.setOnCompletionListener(mediaPlayer -> {
            play();//重新开始播放
        });
        play.setOnClickListener(view -> {
            play();
            if(isPause){
                pause.setText("暂停");
                isPause=false;
            }
        });
        pause.setOnClickListener(view -> {
            if(mp.isPlaying()&&!isPause){
                mp.pause();
                isPause=true;
                pause.setText("继续");
                hint.setText("暂停播放音频...");
                play.setEnabled(true);
            }else{
                mp.start();
                pause.setText("暂停");
                hint.setText("继续播放音频...");
                isPause=false;
                play.setEnabled(false);
            }
        });
        stop.setOnClickListener(view -> {
            mp.stop();
            hint.setText("停止播放音频...");
            pause.setEnabled(false);
            stop.setEnabled(false);
            play.setEnabled(true);
        });
    }

    private void initView() {
        play = findViewById(R.id.btn_start);
        pause = findViewById(R.id.btn_pause);
        stop = findViewById(R.id.btn_stop);
        hint = findViewById(R.id.hint);
        hint.setTextSize(20);
    }

    private void initData() {
        try {
            AssetManager am = getAssets();
            //AssetManager am = getResources().getAssets();
            AssetFileDescriptor afd = null;
            afd = am.openFd("qichuang.mp3");
            FileDescriptor fd = afd.getFileDescriptor();
            mp = new MediaPlayer();
            mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mp.setDataSource(fd, afd.getStartOffset(), afd.getLength());
            //mp.setDataSource(fd);
            mp.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void play(){
        try{
            mp.reset();
            initData();
            mp.start();//开始播放
            hint.setText("正在播放音频...");
            play.setEnabled(false);
            pause.setEnabled(true);
            stop.setEnabled(true);
        }catch(Exception e){
            e.printStackTrace();//输出异常信息
        }
    }
    @Override
    protected void onDestroy() {
        if(mp.isPlaying()){
            mp.stop();
        }
        mp.release();//释放资源
        super.onDestroy();
    }
}
