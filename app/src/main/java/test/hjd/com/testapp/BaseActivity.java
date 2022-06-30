package test.hjd.com.testapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by allen on 2022-06-30.
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initListeners();
        initDatas();
    }

    public abstract void initListeners();

    public abstract void initView();

    public abstract void initDatas();
}
