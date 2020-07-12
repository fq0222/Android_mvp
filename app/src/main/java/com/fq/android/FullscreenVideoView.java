package com.fq.android;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.VideoView;

public class FullscreenVideoView extends VideoView {


    //此构造方法，用于直接new 出来的对象
    public FullscreenVideoView(Context context) {
        super(context);
    }

    //主要用于xml文件当中,支持自定义属性
    public FullscreenVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    //主要用于xml文件当中,支持自定义属性,还支持style样式
    public FullscreenVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 自定义控件的测量方法
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = getDefaultSize(0, widthMeasureSpec);
        int height = getDefaultSize(0, heightMeasureSpec);
        setMeasuredDimension(width, height);
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    /**
     * 自定义控件的描画方法
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
