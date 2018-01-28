package com.samhalperin.cooperhewitt.application;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.samhalperin.cooperhewitt.R;

public class BaseActivity extends AppCompatActivity {

    protected void setup(int contentView) {
        setContentView(contentView);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }
}
