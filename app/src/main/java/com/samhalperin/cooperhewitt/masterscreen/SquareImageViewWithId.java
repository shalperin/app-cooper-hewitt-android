package com.samhalperin.cooperhewitt.masterscreen;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class SquareImageViewWithId extends ImageView {
    public String mId;

    public SquareImageViewWithId(Context context) {
        super(context);
    }

    public SquareImageViewWithId(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth());
    }

}
