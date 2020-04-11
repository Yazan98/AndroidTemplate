package com.yazan98.domain.usecases.base

import com.yazan98.exposer.usecases.ExposerUseCaseParam
import com.yazan98.exposer.usecases.ExposerUseCaseResult
import io.reactivex.Observable

abstract class ExposerObservableUseCase<Result> : ExposerUseCaseResult<Observable<Result>>()
abstract class ExposerObservableParamUseCase<Result, in Param> : ExposerUseCaseParam<Result, Param>()