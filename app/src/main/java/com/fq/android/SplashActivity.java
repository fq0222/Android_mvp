package com.fq.android;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.File;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private static final String TAG = SplashActivity.class.getSimpleName();
    private FullscreenVideoView mVideoView;
    private TextView mTvTimer;
    private CustomCountDownTimer timer;

    /**
     * Bundle 的概念：Bundle类型的数据与Map类型的数据相似，都是以key-value的形式存储数据的。
     * @param savedInstanceState
     * 在Activity被销毁的时候，可以保存进度，下次进来接上进度
     * public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mVideoView = findViewById(R.id.vv_play);
        mTvTimer = findViewById(R.id.tv_splash_timer);
        mTvTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
            }
        });
        mVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + File.separator + R.raw.splash));
        Log.e(TAG, "uri: " + getPackageName() + ", " + File.separator + ", " + R.raw.splash);
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
            }
        });
        //播放完成，再次进行播放，实现循环播放的功能
        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.start();
            }
        });

        timer = new CustomCountDownTimer(5, new CustomCountDownTimer.ICountDownHandler() {
            @Override
            public void onTicker(int time) {
                mTvTimer.setText(time + "秒");
            }

            @Override
            public void onFinish() {
                mTvTimer.setText("跳过");
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
            }
        });
        timer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        timer.cancel();
    }
}
