package com.yazan98.exposer.usecases

import com.yazan98.exposer.ExposerType

abstract class ExposerUseCaseResult<Result> : ExposerUseCase<Result, ExposerType>() {

    /**
     * Each UseCase Has Validation On Params And There Are UseCases That don't Require Params
     * To Execute The Request and This Method Should Lock The Validation When Params Not Found
     */
    override fun isValidationEnabled(): Boolean = false
}
