package com.tarabut.scores.view.fragment.products

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.viewModelScope
import com.tarabut.core.utils.NavigationCommand
import com.tarabut.core.viewmodel.base.BaseViewModel
import com.tarabut.domain.common.ResultState
import com.tarabut.domain.entity.response.products.ScoresEntity
import com.tarabut.domain.usecases.products.IScoresUseCase
import com.tarabut.scores.BR
import com.tarabut.scores.R
import com.tarabut.scores.listeners.ItemClickListener
import com.tarabut.core.utils.idlingresource.EspressoIdlingResource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.launch
import me.tatarka.bindingcollectionadapter2.ItemBinding

/****
 * File Description
 * Author: Lajesh Dineshkumar
 *****/
class ScoresListingViewModel constructor(
    private val scoresUseCase: IScoresUseCase
) : BaseViewModel(), ItemClickListener {

    var isSwipeRefresh: Boolean = false
    val scoresList = ObservableArrayList<ScoresEntity.Score>()
    val itemBinding: ItemBinding<ScoresEntity.Score> = ItemBinding.of<ScoresEntity.Score>(
        BR.itemViewModel,
        R.layout.item_layout_score
    ).bindExtra(BR.listener, this)

    init {
        getScores()
    }

    /**
     * This methods executes 2 API calls in parallel and combines the result using zip
     * operator.
     */
    fun getScores() {
        EspressoIdlingResource.increment()
        scoresList.clear()
        showLoading(true)
        viewModelScope.launch {
            scoresUseCase.getScores()
                .zip(scoresUseCase.getScoresOfPopularMatches()) { scoresState, popularScoresState ->
                    if (scoresState is ResultState.Success || popularScoresState is ResultState.Success) {
                        showLoading(false)
                        isSwipeRefresh = false
                        scoresList.addAll((scoresState as ResultState.Success).data)
                        scoresList.addAll((popularScoresState as ResultState.Success).data)
                        EspressoIdlingResource.decrement()
                    } else {
                        setError(error = (scoresState as ResultState.Error).error)
                        showLoading(false)
                        isSwipeRefresh = false
                        EspressoIdlingResource.decrement()
                    }
                }.collect()
        }
    }


    override fun select(score: ScoresEntity.Score) {
        sharedViewModel.score = score
        navigationCommands.value =
            NavigationCommand.To(ScoresListingFragmentDirections.actionListingToDetails())
    }
}