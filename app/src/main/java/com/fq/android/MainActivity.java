package com.fq.android;

import android.os.Bundle;
import android.widget.RadioButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import butterknife.BindView;
import butterknife.OnClick;

@ViewInject(mainLayoutId = R.layout.activity_main)
public class MainActivity extends BaseActivity {

    @BindView(R.id.fac_main_home)
    FloatingActionButton facMainHome;
    @BindView(R.id.rb_main_shanghai)
    RadioButton rbMainShanghai;
    @BindView(R.id.rb_main_hangzhou)
    RadioButton rbMainHangzhou;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @OnClick(R.id.fac_main_home)
    public void onClicked() {

    }
}
