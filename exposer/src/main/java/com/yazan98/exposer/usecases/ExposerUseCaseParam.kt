package com.yazan98.exposer.usecases

abstract class ExposerUseCaseParam<Result, in Param> : ExposerUseCase<Result, Param>() {

    /**
     * Each UseCase Has Validation On Params And There Are UseCases That don't Require Params
     * To Execute The Request and This Method Should Lock The Validation When Params Not Found
     */
    override fun isValidationEnabled(): Boolean = true
}