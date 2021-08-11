package com.tarabut.scores.common

import android.annotation.SuppressLint
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import java.text.SimpleDateFormat
import java.util.*

/****
 * Keep all static binding adapters here
 * Author: Lajesh Dineshkumar
 *****/
object BindingAdpaters {
    @JvmStatic
    @BindingAdapter("loadImage")
    fun loadImageUrl(view: ImageView, url: String?) {
        if (!url.isNullOrEmpty()) {
            Glide.with(view.context).load(url).circleCrop().into(view)
        }
    }


    @SuppressLint("SimpleDateFormat", "SetTextI18n")
    @JvmStatic
    @BindingAdapter("formattedDate")
    fun formatDate(view: TextView, date: Date?) {
        val dateFormatter = SimpleDateFormat("EEE dd MMM hh:mm aa")
        try {
            view.text = dateFormatter.format(date)
        } catch (ex: Exception) {
            view.text = ""
        }
    }

    @SuppressLint("SetTextI18n")
    @JvmStatic
    @BindingAdapter("uid")
    fun formatCreatedDate(view: TextView, uid: String?) {
        view.text =  uid
    }
}