package com.tarabut.core.interceptors

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

/****
 * Retrofit interceptor to add all the common headers
 * Author: Lajesh Dineshkumar
 *****/
class HeaderInterceptor : okhttp3.Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var response: Response?
        var requestBuilder: Request.Builder = chain.request().newBuilder()
        requestBuilder = addCommonHeaders(requestBuilder)
        val request = requestBuilder.build()
        try {
            response = chain.proceed(request)
            response.takeIf { isHtmlResponse(it) }?.apply {
                // throw custom exception
            }
        } catch (e: Exception) {
            throw e
        }
        return response
    }

    /**
     * Add the common set of headers
     */
    private fun addCommonHeaders(requestBuilder: Request.Builder): Request.Builder {
        // Add all the common headers here

        return requestBuilder
    }

    private fun isHtmlResponse(response: Response): Boolean {
        return response.headers.names().contains("Content-Type")
            && response.headers["Content-Type"]?.contains("text/html") == true
    }
}
