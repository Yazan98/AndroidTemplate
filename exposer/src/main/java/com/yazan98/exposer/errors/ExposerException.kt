package com.yazan98.exposer.errors


abstract class ExposerException : Exception() {

    init {
        println("""
            Exposer Exception Started ...
            Exception From Domain Layer
            Exception Details : $message
        """.trimIndent())
    }

    override val message: String?
        get() = getMainReason().toString()

    protected abstract fun getMainReason(): Any?

}
