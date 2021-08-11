package com.tarabut.core.config

import com.tarabut.core.BuildConfig

/****
 * Keep all the common configurations here
 * Author: Lajesh Dineshkumar
 *****/
object Configuration {
    // Deployment Types
    private const val DEV = "dev"
    private const val SIT = "sit"
    private const val UAT = "uat"
    private const val PROD = "prod"
    private const val PILOT = "pilot"

    // Host URLs
    private const val DEV_URL = "https://run.mocky.io/v3/"
    private const val SIT_URL = "https://run.mocky.io/v3/sit/"
    private const val UAT_URL = "https://run.mocky.io/v3/uat/"
    private const val PROD_URL = "https://run.mocky.io/v3/prod/"
    private const val PILOT_URL = "https://run.mocky.io/v3//pilot/"

    const val CONNECT_TIMEOUT: Long = 60
    const val READ_TIMEOUT: Long = 60
    const val CALL_TIMEOUT: Long = 60


    val baseURL: String
        get() {

            return when (BuildConfig.FLAVOR) {

                DEV -> DEV_URL

                SIT -> SIT_URL

                UAT -> UAT_URL

                PROD -> PROD_URL

                PILOT -> PILOT_URL

                else -> DEV_URL
            }
        }
}
