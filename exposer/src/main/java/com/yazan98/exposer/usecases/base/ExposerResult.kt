package com.yazan98.exposer.usecases.base

sealed class ExposerResult<Result> {

    class ExposerSuccessResult<Result>(private val result: Result) : ExposerResult<Result>() {
        fun getResultContent() = Result
    }

    class ExposerErrorResult<ErrorType>(private val error: ErrorType) : ExposerResult<ErrorType>() {
        fun getErrors() = error
    }

}