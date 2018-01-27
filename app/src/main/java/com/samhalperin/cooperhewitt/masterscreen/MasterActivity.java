package com.samhalperin.cooperhewitt.masterscreen;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.samhalperin.cooperhewitt.Controller;
import com.samhalperin.cooperhewitt.application.CooperHewittApplication;
import com.samhalperin.cooperhewitt.R;
import com.samhalperin.cooperhewitt.masterscreen.maingridview.MainGridView;
import com.samhalperin.cooperhewitt.data.restclient.SearchTask;
import com.samhalperin.cooperhewitt.application.BaseActivity;

public class MasterActivity extends BaseActivity implements AdapterView.OnItemSelectedListener{

    private MainGridView mgv;
    private int mCurrentPeriod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setup(R.layout.activity_main);
        mgv = (MainGridView)findViewById(R.id.main_grid_view);
        Spinner periodSelectionSpinner = (Spinner) findViewById(R.id.period_spinner);
        periodSelectionSpinner.setOnItemSelectedListener(this);
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

    /**
     * Clear out the main grid view and reload a new set of data based on the selected time period.
     *
     * @param position The position of the time period in the period codes array
     *
     *
     */
    private void loadPeriod(Integer position ) {
        int[] codes = getResources().getIntArray(R.array.period_codes_array);
        mgv.clear();
        mCurrentPeriod = codes[position];
        mgv.getLoadingView().setVisibility(View.VISIBLE);
        new SearchTask(this, mgv).execute(
                0,
                CooperHewittApplication.DEFAULT_PER_PAGE,
                mCurrentPeriod
        );
    }

    /**
     * A callback for the main grid view to be able to latch the period so it can load more items
     * on endless scroll.
     * @return Returns the current period
     */
    public int getCurrentPeriod() {
        return mCurrentPeriod;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        loadPeriod(pos);
    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
