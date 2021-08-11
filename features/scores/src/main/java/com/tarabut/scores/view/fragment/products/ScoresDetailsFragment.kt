package com.tarabut.scores.view.fragment.products

import com.tarabut.core.ui.base.BaseFragment
import com.tarabut.scores.BR
import com.tarabut.scores.R
import com.tarabut.scores.databinding.FragmentScoreDetailsBinding

/*******
 * ProductDetailsFragment
 * Author: Lajesh Dineshkumar
 ********/
class ScoresDetailsFragment :
    BaseFragment<ScoreDetailsViewModel, FragmentScoreDetailsBinding>(ScoreDetailsViewModel::class) {
    override val layoutRes: Int
        get() = R.layout.fragment_score_details
    override val bindingVariable: Int
        get() = BR.viewModel
}