package com.samhalperin.cooperhewitt.detailscreen

import android.app.Activity
import android.content.Context
import android.graphics.Point
import android.util.AttributeSet
import android.view.Display
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

import com.google.common.base.Joiner
import com.samhalperin.cooperhewitt.R
import com.samhalperin.cooperhewitt.data.models.common.Participant
import com.samhalperin.cooperhewitt.data.models.detailobject.*
import com.samhalperin.cooperhewitt.data.models.detailobject.Object
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.detail_view.view.*

import java.util.ArrayList

class DetailLinearLayout(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {
    private val mActivity: Activity

    init {
        View.inflate(getContext(), R.layout.detail_view, this)
        mActivity = context as Activity
    }


    fun displayDetailObject(data: DetailObject) {
        val o = data.getObject()
        val date = o.date
        val dimensions = o.dimensions
        val medium = o.medium
        val title = o.title
        val description = o.description
        val imageUrl = getImageUrl(o)
        val partipants = getParticipantNames(o)


        detail_date.text = date
        detail_dimensions.text = dimensions
        detail_medium.text = medium
        detail_title.text = title
        detail_description.text = description
        if (imageUrl != null) {
            setImage(detail_image, imageUrl)
        }
        detail_participants.text = partipants
        detail_date.text = date
        detail_dimensions.text = dimensions
        detail_medium.text = medium
    }

    private fun setImage(target: ImageView, url: String) {
        // this is going to be ugly if anyone ever wants to change from a full display width layout.
        val display = mActivity.windowManager.defaultDisplay
        val size = Point()
        display.getSize(size)
        val width = size.x
        Picasso
                .with(context)
                .load(url)
                .resize(width, 0)
                .into(target)
    }

    private fun getImageUrl(o: Object): String? {
        return if (o.images.size != 0) {
            o.images[0].b.url
        } else {
            null
        }
    }

    private fun getParticipantNames(o: Object): String {
        val participantNames = ArrayList<String>()
        for (p in o.participants) {
            participantNames.add(p.personName)
        }
        return Joiner.on(", ").join(participantNames)
    }

}