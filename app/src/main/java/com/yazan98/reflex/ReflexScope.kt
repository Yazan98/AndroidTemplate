package com.yazan98.reflex

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

object ReflexScope : CoroutineScope {

    private val scope = CoroutineScope(Dispatchers.IO + SupervisorJob())
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + SupervisorJob()

    fun destroyScope() {
        scope.cancel()
    }

    fun destroyScope(error: CancellationException) {
        scope.cancel(error)
    }

}