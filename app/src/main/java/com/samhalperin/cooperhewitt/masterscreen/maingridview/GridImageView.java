package com.samhalperin.cooperhewitt.masterscreen.maingridview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * from: https://github.com/square/picasso/blob/master/picasso-sample/src/main/java/com/example/picasso/SquaredImageView.java
 */
public class GridImageView extends ImageView {
    private int mAspectRatio;

    public GridImageView(Context context) {
        super(context);
        mAspectRatio = 100;
    }

    public GridImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        setMeasuredDimension(getMeasuredWidth(),
                (int)(mAspectRatio*getMeasuredWidth()*.01));
    }

}
