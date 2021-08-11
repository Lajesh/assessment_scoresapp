package com.tarabut.core.viewmodel

import androidx.lifecycle.ViewModel
import com.tarabut.domain.entity.response.products.ScoresEntity

/****
 * Shared view model for data sharing between fragments
 * Author: Lajesh Dineshkumar
 *****/
open class SharedViewModel : ViewModel() {

    var score: ScoresEntity.Score? = null

}