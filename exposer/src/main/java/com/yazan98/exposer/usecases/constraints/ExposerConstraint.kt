package com.yazan98.exposer.usecases.constraints

abstract class ExposerConstraint<ExecutionType> {

    protected abstract fun isConstraintKillable(): Boolean
    protected abstract fun isConstraintDependable(): Boolean
    protected abstract fun canExecute(params: ExecutionType?): Boolean

}