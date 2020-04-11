package com.yazan98.exposer.log.config

import com.yazan98.exposer.log.keys.ExposerLoggerLevel
import com.yazan98.exposer.log.keys.ExposerLoggerMode
import com.yazan98.exposer.log.keys.ExposerLoggingStatus

interface ExposerBaseOptionsInitializer {

    fun getGlobalTag(): String

    fun getLoggingStatus(): ExposerLoggingStatus

    fun getDefaultPreMode(): ExposerLoggerMode

    fun getDefaultPostMode(): ExposerLoggerMode

    fun getDefaultLevel(): ExposerLoggerLevel

}