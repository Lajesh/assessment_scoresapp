package com.tarabut.domain.common

import com.tarabut.domain.entity.response.common.ErrorEntity

/**
 * A wrapper for database and network states.
 * Created by Lajesh Dineshkumar
 */
sealed class ResultState<T> {

    /**
     * A state that shows the [data] is the last known update.
     */
    data class Success<T>(val data: T) : ResultState<T>()

    /**
     * A state to show an error
     */
    data class Error<T>(val error: ErrorEntity.Error?) : ResultState<T>()
}
