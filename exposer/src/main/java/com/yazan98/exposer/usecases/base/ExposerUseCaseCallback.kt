package com.yazan98.exposer.usecases.base

import com.yazan98.exposer.usecases.constraints.ExposerConstraint

interface ExposerUseCaseCallback<Result> {

    suspend fun onResult(result: Result)

    suspend fun onError(error: Throwable)

    suspend fun onConstraintsError(items: List<ExposerConstraint<*>>)

    suspend fun onCanceled(reason: String)

}