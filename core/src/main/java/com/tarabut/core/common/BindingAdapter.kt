package com.tarabut.core.common

import android.view.View
import androidx.databinding.BindingAdapter

/*******
 * Keep all the static binding adapters here
 * Author: Lajesh Dineshkumar
 ********/
object BindingAdapter {

    /**
     * Setting visibility for Views
     */
    @JvmStatic
    @BindingAdapter("visibility")
    fun setVisibility(
        view: View,
        visibility: Boolean?
    ) {
        if (null != visibility) {
            view.visibility = if (visibility) {
                View.VISIBLE
            } else
                View.GONE
        } else {
            view.visibility = View.GONE
        }
    }
}