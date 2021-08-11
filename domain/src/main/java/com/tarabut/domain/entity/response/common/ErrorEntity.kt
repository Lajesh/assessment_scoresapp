package com.tarabut.domain.entity.response.common

/****
 * Keep all the error related model class here
 * Author: Lajesh Dineshkumar
 *****/
sealed class ErrorEntity {
    data class Error(val errorCode: Any?, val errorMessage: String? = "") : ErrorEntity()
}