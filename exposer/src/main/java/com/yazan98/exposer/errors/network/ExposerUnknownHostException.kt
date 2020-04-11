package com.yazan98.exposer.errors.network

import com.yazan98.exposer.models.ExposerExceptionState

class ExposerUnknownHostException(
    private val cancelationReason: Any?,
    private val uniqueKey: Int
) : ExposerNetworkException() {

    override fun getExceptionMessage(): String = cancelationReason.toString() ?: ""
    override fun getErrorState(): ExposerExceptionState = ExposerExceptionState.UNKNOWN_HOST_ERROR
    override fun getExceptionUniqueKey(): Int = uniqueKey

}