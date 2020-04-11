package com.yazan98.exposer.log.config

import com.yazan98.exposer.errors.ExposerLoggerInitException


object ExposerLoggerConfiguration {

    private lateinit var loggerConfiguration: ExposerBaseOptionsInitializer
    fun init(options : ExposerBaseOptionsInitializer) {
        loggerConfiguration = options
    }

    fun getLoggingConfiguration(): ExposerBaseOptionsInitializer {
        return if (::loggerConfiguration.isInitialized) {
            loggerConfiguration
        } else {
            throw ExposerLoggerInitException()
        }
    }

}