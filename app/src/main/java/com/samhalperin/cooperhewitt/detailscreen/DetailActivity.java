package com.samhalperin.cooperhewitt.detailscreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.samhalperin.cooperhewitt.aboutscreen.AboutActivity;
import com.samhalperin.cooperhewitt.application.CooperHewittApplication;
import com.samhalperin.cooperhewitt.R;
import com.samhalperin.cooperhewitt.application.BaseActivity;
import com.samhalperin.cooperhewitt.data.models.detailobject.DetailObject;
import com.samhalperin.cooperhewitt.data.repository.Repository;


public class DetailActivity extends BaseActivity implements DetailContract.View {
    private DetailLinearLayout mDetailLinearLayouit;
    private DetailContract.UserActionsHandler mPresenter;

    //region Implement Activity
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

        mPresenter = new DetailPresenter(this, new Repository(this));
        mPresenter.loadDetailObject(objectId);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case (android.R.id.home):
                finish();
                break;

            case (R.id.action_about):
                startActivity(new Intent(this, AboutActivity.class));

        }

        return true;
    }
    //endregion

    //region Implement DetailContract.View Interface
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
    //endregion

}
