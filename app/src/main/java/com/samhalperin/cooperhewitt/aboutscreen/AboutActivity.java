package com.samhalperin.cooperhewitt.aboutscreen;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.samhalperin.cooperhewitt.R;
import com.samhalperin.cooperhewitt.application.BaseActivity;

public class AboutActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setup(R.layout.activity_about);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return true;
    }
}
