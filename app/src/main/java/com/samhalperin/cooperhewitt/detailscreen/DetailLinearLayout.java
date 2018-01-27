package com.samhalperin.cooperhewitt.detailscreen;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.Display;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.common.base.Joiner;
import com.samhalperin.cooperhewitt.R;
import com.samhalperin.cooperhewitt.data.models.common.Participant;
import com.samhalperin.cooperhewitt.data.models.detailobject.*;
import com.samhalperin.cooperhewitt.data.models.detailobject.Object;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sqh on 9/30/15.
 */
public class DetailLinearLayout extends LinearLayout {
    private Activity mActivity;
    private ImageView mIvView;
    private TextView mDateView;
    private TextView mDimensionsView;
    private TextView mMediumView;
    private TextView mTitleView;
    private TextView mDescriptionView;
    private TextView mParticipantsView;

    public DetailLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(getContext(), R.layout.detail_view, this);
        mActivity = (Activity)context;

        mIvView = (ImageView)findViewById(R.id.detail_image);
        mDateView = (TextView)findViewById(R.id.detail_date);
        mDimensionsView = (TextView)findViewById(R.id.detail_dimensions);
        mMediumView = (TextView)findViewById(R.id.detail_medium);
        mTitleView = (TextView)findViewById(R.id.detail_title);
        mDescriptionView = (TextView)findViewById(R.id.detail_description);
        mParticipantsView = (TextView)findViewById(R.id.detail_participants);
    }


    public void displayDetailObject(DetailObject data) {

        com.samhalperin.cooperhewitt.data.models.detailobject.Object o = data.getObject();
        String date = o.getDate();
        String dimensions = o.getDimensions();
        String medium = o.getMedium();
        String title = o.getTitle();
        String description = o.getDescription();
        String imageUrl = getImageUrl(o);
        String partipants = getParticipantNames(o);


        mDateView.setText(date);
        mDimensionsView.setText(dimensions);
        mMediumView.setText(medium);
        mTitleView.setText(title);
        mDescriptionView.setText(description);
        if (imageUrl != null) {
            setImage(mIvView, imageUrl);
        }
        mParticipantsView.setText(partipants);
        mDateView.setText(date);
        mDimensionsView.setText(dimensions);
        mMediumView.setText(medium);
    }

    private void setImage(ImageView target, String url) {
        // this is going to be ugly if anyone ever wants to change from a full display width layout.
        Display display = mActivity.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        Picasso
            .with(getContext())
            .load(url)
            .resize(width, 0)
            .into(target);
    }

    private static String getImageUrl(Object o) {
        if (o.getImages().size() != 0) {
            return o.getImages().get(0).getB().getUrl();
        } else {
            return null;
        }
    }

    private static String getParticipantNames(Object o) {
        List<String> participantNames = new ArrayList<String>();
        for (Participant p : o.getParticipants()) {
            participantNames.add(p.getPersonName());
        }
        return Joiner.on(", ").join(participantNames);
    }

}