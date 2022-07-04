package com.sobhan.sabaideatask.data.api

import com.sobhan.sabaideatask.BuildConfig
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor

object APIUtils {
    const val API_BASE_URL = "https://www.filimo.com/api/en/v1/"

    fun getLoggingInterceptor(): Interceptor? {
        if (BuildConfig.DEBUG.not()) {
            return null
        }

        val logger = HttpLoggingInterceptor()
        logger.level = HttpLoggingInterceptor.Level.BODY

        return logger
    }
}