package com.yazan98.exposer.models

data class ExposerNetworkError(
    val key: Int,
    val state: ExposerExceptionState,
    val message: String
)