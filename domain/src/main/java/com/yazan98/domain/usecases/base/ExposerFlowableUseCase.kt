package com.yazan98.domain.usecases.base

import com.yazan98.exposer.usecases.ExposerUseCaseParam
import com.yazan98.exposer.usecases.ExposerUseCaseResult
import io.reactivex.Flowable

abstract class ExposerFlowableUseCase<Result> : ExposerUseCaseResult<Flowable<Result>>()
abstract class ExposerFlowableParamUseCase<Result, in Param> : ExposerUseCaseParam<Result, Param>()
