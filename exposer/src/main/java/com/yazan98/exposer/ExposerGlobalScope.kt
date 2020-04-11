package com.yazan98.exposer

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

object ExposerGlobalScope : CoroutineScope {

    private val scope = CoroutineScope(Dispatchers.Default + SupervisorJob())
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Default + SupervisorJob()

    fun destroyScope() {
        scope.cancel()
    }

    fun destroyScope(error: CancellationException) {
        scope.cancel(error)
    }

}