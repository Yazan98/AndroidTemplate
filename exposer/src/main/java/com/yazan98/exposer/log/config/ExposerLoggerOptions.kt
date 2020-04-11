package com.yazan98.exposer.log.config

import com.yazan98.exposer.log.keys.ExposerLoggerLevel
import com.yazan98.exposer.log.keys.ExposerLoggerMode
import com.yazan98.exposer.log.keys.ExposerLoggingStatus

data class ExposerLoggerOptions(
    private var globalTag: String = Exposer_DEFAULT_TAG,
    private var loggingStatus: ExposerLoggingStatus = Exposer_DEFAULT_STATE,
    private var preMode: ExposerLoggerMode = Exposer_LOGGER_PRE_MODE_DEFAULT,
    private var postMode: ExposerLoggerMode = Exposer_LOGGER_POST_MODE_DEFAULT,
    private var defaultLevel: ExposerLoggerLevel = Exposer_DEFAULT_LEVEL
) : ExposerBaseOptionsInitializer {

    companion object {
        const val Exposer_DEFAULT_TAG = "Exposer Logger"
        val Exposer_LOGGER_PRE_MODE_DEFAULT = ExposerLoggerMode.DASH
        val Exposer_LOGGER_POST_MODE_DEFAULT = ExposerLoggerMode.DASH
        val Exposer_DEFAULT_STATE = ExposerLoggingStatus.ENABLED
        val Exposer_DEFAULT_LEVEL = ExposerLoggerLevel.DEBUG
    }

    override fun getGlobalTag(): String = globalTag
    override fun getLoggingStatus(): ExposerLoggingStatus = loggingStatus
    override fun getDefaultPreMode(): ExposerLoggerMode = preMode
    override fun getDefaultPostMode(): ExposerLoggerMode = postMode
    override fun getDefaultLevel(): ExposerLoggerLevel = defaultLevel

}