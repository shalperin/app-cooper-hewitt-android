package com.samhalperin.cooperhewitt.ui.detailview;

import android.app.Activity;
import android.graphics.Point;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.common.base.Joiner;
import com.samhalperin.cooperhewitt.R;
import com.samhalperin.cooperhewitt.retrofit.DetailTask;
import com.samhalperin.cooperhewitt.retrofit.pojo.common.Participant;
import com.samhalperin.cooperhewitt.retrofit.pojo.detailobject.*;
import com.samhalperin.cooperhewitt.retrofit.pojo.detailobject.Object;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sqh on 9/30/15.
 */
public class DetailView {
    private View mView;
    private Activity mContext;
    private String mId;

    public DetailView(Activity context, View viewGroup, String id) {
        mView = viewGroup;
        mContext = context;
        mId = id;

        init();
    }

    private void init() {
        new DetailTask(mContext, this).execute(mId);
    }


    public void onData(DetailObject data) {
        ImageView ivView = (ImageView)mView.findViewById(R.id.detail_image);
        TextView dateView = (TextView)mView.findViewById(R.id.detail_date);
        TextView dimensionsView = (TextView)mView.findViewById(R.id.detail_dimensions);
        TextView mediumView = (TextView)mView.findViewById(R.id.detail_medium);
        TextView titleView = (TextView)mView.findViewById(R.id.detail_title);
        TextView descriptionView = (TextView)mView.findViewById(R.id.detail_description);
        TextView participantsView = (TextView)mView.findViewById(R.id.detail_participants);


        com.samhalperin.cooperhewitt.retrofit.pojo.detailobject.Object o = data.getObject();
        String id = o.getId();
        String date = o.getDate();
        String dimensions = o.getDimensions();
        String medium = o.getMedium();
        String title = o.getTitle();
        String description = o.getDescription();
        String imageUrl = getImageUrl(o);
        String partipants = getParticipantNames(o);


        dateView.setText(date);
        dimensionsView.setText(dimensions);
        mediumView.setText(medium);
        titleView.setText(title);
        descriptionView.setText(description);
        if (imageUrl != null) {
            setImage(ivView, imageUrl);
        }
        participantsView.setText(partipants);
        dateView.setText(date);
        dimensionsView.setText(dimensions);
        mediumView.setText(medium);
    }

    private void setImage(ImageView target, String url) {
        // this is going to be ugly if anyone ever wants to change from a full display width layout.
        Display display = mContext.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        Picasso
            .with(mContext)
            .load(url)
            .resize(width, 0)  //ugh
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