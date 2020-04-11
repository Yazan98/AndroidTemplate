package com.yazan98.reflex

import android.content.Context
import android.os.Build
import com.yazan98.domain.scopes.ApplicationScope
import io.vortex.android.logger.VortexLog
import io.vortex.android.logger.VortexLoggerInitException
import io.vortex.android.logger.config.VortexLoggerConfiguration
import io.vortex.android.logger.config.VortexLoggerOptions
import io.vortex.android.logger.keys.VortexLoggerLevel
import io.vortex.android.logger.keys.VortexLoggerMode
import io.vortex.android.logger.keys.VortexLoggingStatus
import io.vortex.android.prefs.VortexPrefsConfig
import io.vortex.android.ui.VortexMessageDelegation
import io.vortex.android.utils.VortexApplication
import io.vortex.android.utils.VortexConfiguration
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.dsl.module
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ReflexApplication @Inject constructor() : VortexApplication(), Thread.UncaughtExceptionHandler {

    companion object {
        const val SHARED_PREFS_NAME = "ReflexApp"
        const val SHARED_PREFS_SCOPE = Context.MODE_PRIVATE
        const val REFLEX_LOGGING_TAG = "Reflex App Log :: "
        const val GENERAL_REPEAT_TIME = 100
    }

    private val messageController: VortexMessageDelegation by lazy {
        VortexMessageDelegation()
    }

    override fun onCreate() {
        super.onCreate()
        VortexPrefsConfig.prefs = getSharedPreferences(SHARED_PREFS_NAME, SHARED_PREFS_SCOPE)
        ReflexScope.launch {
            setupFresco()
            applyVortexLoggerConfiguration()
            setupTimber(BuildConfig.DEBUG)
            setupDeviceLocator()
            VortexConfiguration
                .registerLeakCanaryConfiguration()
                .registerApplicationClass(this@ReflexApplication)
                .registerApplicationState(true)
                .registerCompatVector()
                .registerStrictMode()
                .registerExceptionHandler(this@ReflexApplication)
                .registerVortexPermissionsSettings()
        }

        startKoin {
            androidLogger(Level.DEBUG)
            modules(getApplicationModules())
        }
    }

    private suspend fun applyVortexLoggerConfiguration() {
        withContext(Dispatchers.IO) {
            VortexLoggerConfiguration.init(
                VortexLoggerOptions(
                    globalTag = REFLEX_LOGGING_TAG,
                    postMode = VortexLoggerMode.EQUAL,
                    loggingStatus = VortexLoggingStatus.ENABLED,
                    defaultLevel = VortexLoggerLevel.DEBUG,
                    preMode = VortexLoggerMode.EQUAL
                )
            )
        }
    }

    private suspend fun setupDeviceLocator() {
        withContext(Dispatchers.IO) {
            try {
                VortexLog.print("""Reflex Device Info : Logging ${getDeviceInformation()}""".trimIndent()) {
                    VortexLog prePost VortexLoggerMode.EQUAL
                    VortexLog repeat GENERAL_REPEAT_TIME
                }
            } catch (error: VortexLoggerInitException) {
                println(error.message)
            }
        }
    }

    private fun getDeviceInformation(): String {
        var s = "Device Info : "
        s += "\n OS Version: " + System.getProperty("os.version") + "(" + Build.VERSION.INCREMENTAL + ")"
        s += "\n OS API Level: ${Build.VERSION.SDK_INT}"
        s += "\n Device: " + Build.DEVICE
        s += "\n Model (and Product): " + Build.MODEL + " (" + Build.PRODUCT + ")"
        return s
    }

    private fun getApplicationModules() = module {

    }

    override fun uncaughtException(t: Thread, e: Throwable) {
        ReflexScope.launch {
            e.message?.let { messageController.showShortMessage(it, applicationContext) }
        }
    }

}
