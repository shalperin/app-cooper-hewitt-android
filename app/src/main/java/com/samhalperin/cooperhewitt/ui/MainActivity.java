package com.samhalperin.cooperhewitt.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.samhalperin.cooperhewitt.MyApplication;
import com.samhalperin.cooperhewitt.R;
import com.samhalperin.cooperhewitt.ui.maingridview.MainGridView;
import com.samhalperin.cooperhewitt.retrofit.SearchTask;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private MainGridView mgv;
    private static final int MODE_GRID = 1;
    private static final int MODE_SWIPE = 2;
    private int mode;
    private int mCurrentPeriod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Spinner spinner = (Spinner) findViewById(R.id.period_spinner);
        mgv = new MainGridView(this, findViewById(R.id.main_grid_view));
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
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
//        switch(item.getItemId()) {
//            case (R.id.toggle_display):
//                if (mode == MODE_GRID) {
//                    mode = MODE_SWIPE;
//                    item.setIcon(R.drawable.grid);
//                } else {
//                    mode = MODE_GRID;
//                    item.setIcon(R.drawable.swipe);
//                }
//                break;
//        }

        return true;
    }

    public void loadPeriod(Integer position ) {
        int[] codes = getResources().getIntArray(R.array.period_codes_array);
        mgv.clear();
        mCurrentPeriod = codes[position];
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
