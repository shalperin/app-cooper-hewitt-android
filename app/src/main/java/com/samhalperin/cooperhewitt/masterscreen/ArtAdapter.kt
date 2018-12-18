package com.samhalperin.cooperhewitt.masterscreen

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.samhalperin.cooperhewitt.R
import com.samhalperin.cooperhewitt.data.models.searchobjects.SearchObject
import com.samhalperin.cooperhewitt.data.models.searchobjects.SearchObjects
import com.squareup.picasso.Picasso

class ArtAdapter(private val context: Context, private val imageViewClickListener: View.OnClickListener, private val mItems: MutableList<SearchObject>) : RecyclerView.Adapter<ArtAdapter.ViewHolder>() {

    override fun getItemCount():Int {
        return mItems.size
    }

    inner class ViewHolder(var mImageView: SquareImageViewWithId) : RecyclerView.ViewHolder(mImageView)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val target = holder.mImageView
        val images = mItems[position].images
        if (images.size != 0) {
            val sqUrl = mItems[position].images[0].sq.url
            Picasso
                    .with(context)
                    .load(sqUrl)
                    .fit()
                    .into(target)
        }
        target.mId = mItems[position].id
        holder.mImageView.setOnClickListener(imageViewClickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.rv_item_view, parent, false) as SquareImageViewWithId
        return ViewHolder(v)
    }

    fun clear() {
        mItems.clear()
    }

    fun addAll(objects: List<SearchObject>){
        objects.forEach{
            mItems.add(it)
        }

    }


}