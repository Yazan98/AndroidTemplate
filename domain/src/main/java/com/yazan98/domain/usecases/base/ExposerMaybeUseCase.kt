package com.yazan98.domain.usecases.base

import com.yazan98.exposer.usecases.ExposerUseCaseParam
import com.yazan98.exposer.usecases.ExposerUseCaseResult
import io.reactivex.Maybe

abstract class ExposerMaybeUseCase<Result> : ExposerUseCaseResult<Maybe<Result>>()
abstract class ExposerMaybeParamUseCase<Result, in Param> : ExposerUseCaseParam<Result, Param>()