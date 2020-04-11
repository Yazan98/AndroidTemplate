package com.yazan98.exposer.usecases.base

interface ExposerThreadProvider<SchedularType> {

    fun getBackgroundThread(): SchedularType

    fun getMainThread(): SchedularType

    fun getNewThread(): SchedularType

}