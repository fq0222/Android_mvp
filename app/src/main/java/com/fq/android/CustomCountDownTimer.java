package com.fq.android;

import android.os.Handler;

public class CustomCountDownTimer implements Runnable{

    private final ICountDownHandler iCountDownHandler;
    private int time;
    private final Handler handler;
    private boolean isRun;
    private int countDown;

    public CustomCountDownTimer(int time, ICountDownHandler countDownHandler) {
        handler = new Handler();
        this.time = time;
        this.countDown = time;
        this.iCountDownHandler = countDownHandler;
    }

    @Override
    public void run() {
        if (isRun) {
            if (iCountDownHandler != null) {
                iCountDownHandler.onTicker(countDown);
            }
            if (countDown == 0) {
                cancel();
                if (iCountDownHandler != null) {
                    iCountDownHandler.onFinish();
                }
            } else {
                countDown = time--;
                handler.postDelayed(this, 1000);
            }
        }
    }

    public void start() {
        isRun = true;
        handler.post(this);
    }

    public void cancel() {
        isRun = false;
        handler.removeCallbacks(this);
    }

    public interface ICountDownHandler {
        void onTicker(int time);

        void onFinish();
    }
}
