package com.tarabut.scores.view.fragment.products

import android.os.Bundle
import android.view.View
import com.tarabut.core.ui.base.BaseFragment
import com.tarabut.scores.R
import com.tarabut.scores.BR
import com.tarabut.scores.databinding.FragmentScoreListingBinding

/****
 * ProductListingFragment
 * Author: Lajesh Dineshkumar
 *****/
class ScoresListingFragment : BaseFragment<ScoresListingViewModel, FragmentScoreListingBinding>(
    ScoresListingViewModel::class
) {
    override val layoutRes: Int
        get() = R.layout.fragment_score_listing
    override val bindingVariable: Int
        get() = BR.viewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataBinding.pullRefreshLayout.run {
            setOnRefreshListener {
                viewModel.isSwipeRefresh = true
                viewModel.getScores()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        dataBinding.shimmerContainer.startShimmer()
    }
}