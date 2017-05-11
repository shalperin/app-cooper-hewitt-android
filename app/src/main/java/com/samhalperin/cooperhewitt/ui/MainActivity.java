package com.samhalperin.cooperhewitt.ui;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.samhalperin.cooperhewitt.Controller;
import com.samhalperin.cooperhewitt.MyApplication;
import com.samhalperin.cooperhewitt.R;
import com.samhalperin.cooperhewitt.ui.maingridview.MainGridView;
import com.samhalperin.cooperhewitt.retrofit.SearchTask;

public class MainActivity extends BaseActivity implements AdapterView.OnItemSelectedListener{

    private MainGridView mgv;
    private int mCurrentPeriod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setup(R.layout.activity_main);
        mgv = (MainGridView)findViewById(R.id.main_grid_view);
        Spinner spinner = (Spinner) findViewById(R.id.period_spinner);
        spinner.setOnItemSelectedListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case (R.id.action_about):
                Controller.switchMode(this, Controller.MODE_ABOUT);
        }
        return true;
    }

    public void loadPeriod(Integer position ) {
        int[] codes = getResources().getIntArray(R.array.period_codes_array);
        mgv.clear();
        mCurrentPeriod = codes[position];
        mgv.getLoadingView().setVisibility(View.VISIBLE);
        new SearchTask(this, mgv).execute(
                0,
                MyApplication.DEFAULT_PER_PAGE,
                mCurrentPeriod
        );
    }

    public int getCurrentPeriod() {
        return mCurrentPeriod;
    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        loadPeriod(pos);
    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
