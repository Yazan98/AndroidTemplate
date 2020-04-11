package com.yazan98.domain.usecases.base

import com.yazan98.exposer.usecases.ExposerUseCaseParam
import com.yazan98.exposer.usecases.ExposerUseCaseResult
import io.reactivex.Single

abstract class ExposerSingleUseCase<Result> : ExposerUseCaseResult<Single<Result>>()
abstract class ExposerSingleParamUseCase<Result, in Param> : ExposerUseCaseParam<Result, Param>()
