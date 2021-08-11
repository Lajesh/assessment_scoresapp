package com.tarabut.scores.listeners

import com.tarabut.domain.entity.response.products.ScoresEntity

/*******
 * File Description
 * Author: Lajesh Dineshkumar
 ********/
interface ItemClickListener {
    fun select(score: ScoresEntity.Score)
}