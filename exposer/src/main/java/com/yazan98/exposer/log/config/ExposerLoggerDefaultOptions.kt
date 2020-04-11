package com.yazan98.exposer.log.config

import com.yazan98.exposer.log.keys.ExposerLoggerLevel
import com.yazan98.exposer.log.keys.ExposerLoggerMode
import com.yazan98.exposer.log.keys.ExposerLoggingStatus

class ExposerLoggerDefaultOptions : ExposerBaseOptionsInitializer {

    companion object {
        const val Exposer_DEFAULT_TAG = "Exposer Logger"
        val Exposer_LOGGER_PRE_MODE_DEFAULT = ExposerLoggerMode.DASH
        val Exposer_LOGGER_POST_MODE_DEFAULT = ExposerLoggerMode.DASH
        val Exposer_DEFAULT_STATE = ExposerLoggingStatus.ENABLED
        val Exposer_DEFAULT_LEVEL = ExposerLoggerLevel.DEBUG
    }

    override fun getGlobalTag(): String = Exposer_DEFAULT_TAG
    override fun getLoggingStatus(): ExposerLoggingStatus = Exposer_DEFAULT_STATE
    override fun getDefaultPreMode(): ExposerLoggerMode = Exposer_LOGGER_PRE_MODE_DEFAULT
    override fun getDefaultPostMode(): ExposerLoggerMode = Exposer_LOGGER_POST_MODE_DEFAULT
    override fun getDefaultLevel(): ExposerLoggerLevel = Exposer_DEFAULT_LEVEL

}