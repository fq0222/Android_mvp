package com.fq.android;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewInject annotation = this.getClass().getAnnotation(ViewInject.class);
        if (annotation != null) {
            int id = annotation.mainLayoutId();
            if (id > 0) {
                setContentView(id);
                ButterKnife.bind(this);
            } else {
                throw new RuntimeException("LayoutId < 0");
            }
        } else {
            throw new RuntimeException("Annotation = null");
        }
    }
}
