package com.samhalperin.cooperhewitt.masterscreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;

import com.samhalperin.cooperhewitt.aboutscreen.AboutActivity;
import com.samhalperin.cooperhewitt.R;
import com.samhalperin.cooperhewitt.application.CooperHewittApplication;
import com.samhalperin.cooperhewitt.data.models.common.Image;
import com.samhalperin.cooperhewitt.data.models.searchobjects.SearchObject;
import com.samhalperin.cooperhewitt.data.repository.Repository;
import com.samhalperin.cooperhewitt.application.BaseActivity;
import com.samhalperin.cooperhewitt.detailscreen.DetailActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MasterActivity extends BaseActivity implements
        AdapterView.OnItemSelectedListener, MasterContract.View, View.OnClickListener{
    private MasterContract.UserActionHandler mPresenter;
    private Spinner mArtisticPeriodSelectionSpinner;
    private ProgressBar mProgressBar;
    private RecyclerView mRv;
    private ArtAdapter mAdapter;
    private int[] mArtisticPeriodCodesArray;
    private EndlessScrollListener mEndlessScrollListener;
    private GridLayoutManager mLayoutManager;

    //region Implement Activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setup(R.layout.activity_main);

        mArtisticPeriodSelectionSpinner = (Spinner) findViewById(R.id.period_spinner);
        mArtisticPeriodSelectionSpinner.setOnItemSelectedListener(this);
        mArtisticPeriodCodesArray = getResources().getIntArray(R.array.period_codes_array);

        mRv = (RecyclerView)findViewById(R.id.rv);
        mLayoutManager = new GridLayoutManager(this, 2);
        mRv.setLayoutManager(mLayoutManager);
        mAdapter = new ArtAdapter(new ArrayList<SearchObject>());
        mRv.setAdapter(mAdapter);
        mEndlessScrollListener = new EndlessScrollListener(mLayoutManager,
                CooperHewittApplication.EndlessScrollVisibilityThreshold);
        mRv.setOnScrollListener(mEndlessScrollListener);

        mProgressBar = (ProgressBar) findViewById(R.id.pb);
        mPresenter = new MasterPresenter(this, new Repository(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case (R.id.action_about):
                mPresenter.navigateToAboutActivity();
        }
        return true;
    }
    //endregion

    //region Implement OnItemSelectedListener for Artistic Period Selection Spinner
    @Override
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        mPresenter.selectArtisticPeriod(mArtisticPeriodCodesArray[pos]);
        mPresenter.loadPage(0, true);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {}
    //endregion

    //region Implement MasterContract.View Interface
    @Override
    public void displayProgressBar() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void navigateToAboutActivity() {
        startActivity(new Intent(this, AboutActivity.class));
    }

    @Override
    public void displayPage(List <SearchObject> objects) {
        mAdapter.mItems.addAll(objects);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void clearResults() {
        mAdapter.mItems.clear();
    }

    @Override
    public void navigateToDetailActivity(String id) {
        Intent i = new Intent(this, DetailActivity.class);
        i.putExtra(CooperHewittApplication.EXTRA_ITEM_ID_KEY, id);
        startActivity(i);
    }
    //endregion

    //region Implement Recycler View
    public class ArtAdapter extends RecyclerView.Adapter<ArtAdapter.ViewHolder> {
        private List<SearchObject> mItems;

        public class ViewHolder extends RecyclerView.ViewHolder {
            public SquareImageViewWithId mImageView;
            public ViewHolder(SquareImageViewWithId itemView) {
                super(itemView);
                mImageView = itemView;
            }
        }

        public ArtAdapter(List<SearchObject> items) {
            mItems = items;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            SquareImageViewWithId target = holder.mImageView;
            List<Image> images = mItems.get(position).getImages();
            if (images.size() != 0) {
                String sqUrl = mItems.get(position).getImages().get(0).getSq().getUrl();
                Picasso
                        .with(MasterActivity.this)
                        .load(sqUrl)
                        .fit()
                        .into(target);
            }
            target.mId = mItems.get(position).getId();
            holder.mImageView.setOnClickListener(MasterActivity.this);
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            SquareImageViewWithId v = (SquareImageViewWithId) LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.rv_item_view, parent, false);
            ViewHolder vh = new ViewHolder(v);
            return vh;
        }

        @Override
        public int getItemCount() {
            return mItems.size();
        }


    }


    public class EndlessScrollListener extends RecyclerView.OnScrollListener {
        private int previousTotal = 0;
        private boolean loading = true;
        private int visibleThreshold;
        int firstVisibleItem, visibleItemCount, totalItemCount;
        private int currentPage = 1;
        private GridLayoutManager layoutManager;

        public EndlessScrollListener(GridLayoutManager layoutManager, int visibilityThreshold) {
            this.layoutManager = layoutManager;
            this.visibleThreshold = visibilityThreshold;
        }

        @Override
        public void onScrolled(RecyclerView rv, int dx, int dy) {
            super.onScrolled(rv, dx, dy);

            visibleItemCount = rv.getChildCount();
            totalItemCount = layoutManager.getItemCount();
            firstVisibleItem = layoutManager.findFirstVisibleItemPosition();

            if (loading) {
                if (totalItemCount > previousTotal) {
                    loading = false;
                    previousTotal = totalItemCount;
                }
            } else {
                if ( (totalItemCount - visibleItemCount) <= (firstVisibleItem + visibleThreshold)) {
                    currentPage++;
                    onLoadMore(currentPage);
                    loading=true;
                }
            }
        }

        public void onLoadMore(int currentPage) {
            Log.d("Endless Scroll", "fetching new page");
            mPresenter.loadPage(currentPage, false);
        }

    }


    /* Implement View.OnClick Listrener for RV items */
    @Override
    public void onClick(View view) {
        mPresenter.navigateToDetailActivity(((SquareImageViewWithId)view).mId);
    }
    //endregion
}
