package com.yazan98.exposer.errors

class ExposerUseCaseCancelationException(
    private val reason: Any?
) : ExposerException() {

    override val message: String?
        get() = reason.toString() ?: ""

    override fun getMainReason(): Any? {
        return reason
    }

}