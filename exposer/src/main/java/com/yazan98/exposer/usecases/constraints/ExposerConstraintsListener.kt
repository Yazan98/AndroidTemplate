package com.yazan98.exposer.usecases.constraints

interface ExposerConstraintsListener {

    fun onSuccessConstraints(items: List<ExposerConstraint<*>>)

    fun onFailedConstraints(items: List<ExposerConstraint<*>>)

}