package com.samhalperin.cooperhewitt.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.samhalperin.cooperhewitt.Controller;
import com.samhalperin.cooperhewitt.MyApplication;
import com.samhalperin.cooperhewitt.R;
import com.samhalperin.cooperhewitt.ui.detailview.DetailView;
import com.samhalperin.cooperhewitt.ui.maingridview.MainGridView;

/**
 * Created by sqh on 9/30/15.
 */
public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String objectId = getIntent().getExtras().getString(MyApplication.EXTRA_ITEM_ID_KEY);

        final DetailView dv = (DetailView)findViewById(R.id.detail_view);
        dv.load(objectId);

        FloatingActionButton shareButton = (FloatingActionButton)findViewById(R.id.share_fab);
        shareButton.setOnClickListener(
            new FloatingActionButton.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String text = dv.getUrl() + " (Brought to you by Moderne for Android)";
                    Controller.share(DetailActivity.this, text);
                }
            });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case (android.R.id.home):
                finish();
                break;
            case (R.id.action_about):
                Controller.switchMode(this, Controller.MODE_ABOUT);
                break;
        }

        return true;
    }




}
