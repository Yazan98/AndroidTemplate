package com.yazan98.exposer.models

data class ExposerConstraintError(
    val reasons: List<Any>,
    val message: String
)