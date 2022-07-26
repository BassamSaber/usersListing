package com.samz.testparsingapplication.utils

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.samz.testparsingapplication.ui.base.BaseAdapter

object BindingUtils {

    @JvmStatic
    @BindingAdapter("imageUrl")
    fun setImageUrl(imageView: ImageView, imageUrl: String?) {
        if (imageUrl.isNullOrEmpty()) return

        Glide.with(imageView.context)
            .load(imageUrl)
            .circleCrop()
            .into(imageView)
    }

    @JvmStatic
    @BindingAdapter("adapter")
    fun setRecyclerViewAdapter(recyclerView: RecyclerView, adapter: BaseAdapter<*>) {
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
    }

    @JvmStatic
    @BindingAdapter("isVisible")
    fun setViewVisibility(view: View, isVisible: Boolean) {
        view.visibility = if (isVisible) View.VISIBLE else View.GONE
    }
}