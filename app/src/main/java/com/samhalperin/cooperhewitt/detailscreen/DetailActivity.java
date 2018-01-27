package com.samhalperin.cooperhewitt.detailscreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.samhalperin.cooperhewitt.Controller;
import com.samhalperin.cooperhewitt.application.CooperHewittApplication;
import com.samhalperin.cooperhewitt.R;
import com.samhalperin.cooperhewitt.application.BaseActivity;
import com.samhalperin.cooperhewitt.data.models.detailobject.DetailObject;
import com.samhalperin.cooperhewitt.data.repository.Repository;

/**
 * Created by sqh on 9/30/15.
 */
public class DetailActivity extends BaseActivity implements DetailContract.View {
    private DetailLinearLayout mDetailLinearLayouit;
    private DetailContract.UserActionsHandler mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setup(R.layout.activity_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final String objectId = getIntent().getExtras().getString(CooperHewittApplication.EXTRA_ITEM_ID_KEY);
        mDetailLinearLayouit = (DetailLinearLayout)findViewById(R.id.detail_view);

        FloatingActionButton shareButton = (FloatingActionButton)findViewById(R.id.share_fab);
        shareButton.setOnClickListener(
            new FloatingActionButton.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mPresenter != null) {
                        mPresenter.shareDetailObject(objectId);
                    }
                }
            });



        mPresenter = new DetailPresenter(this, this,new Repository(this));
        mPresenter.loadDetailObject(objectId);
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

    @Override
    public void displayDetailObject(DetailObject detailObject) {
        mDetailLinearLayouit.displayDetailObject(detailObject);
    }

    @Override
    public void shareDetailObject(DetailObject detailObject) {
        String link = detailObject.getObject().getUrl();
        String text = link + " (Brought to you by Moderne for Android)";
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_TEXT, text);
        startActivity(shareIntent);
    }


}
