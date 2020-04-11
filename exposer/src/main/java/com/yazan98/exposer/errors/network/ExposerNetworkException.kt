package com.yazan98.exposer.errors.network

import com.yazan98.exposer.errors.ExposerException
import com.yazan98.exposer.models.ExposerExceptionState
import com.yazan98.exposer.models.ExposerNetworkError

abstract class ExposerNetworkException : ExposerException() {

    /**
     * This Method Should Provide The Exception With The Common Message About This Type Of Error
     */
    abstract fun getExceptionMessage(): String

    /**
     * This Should Return The Key About This Error
     */
    abstract fun getErrorState(): ExposerExceptionState

    /**
     * This Method Should Provide The Parent Layer The IN_COMING Key
     * Like If You Need To Display An Arabic Message From The Exception return 0
     * If You Need To Display English Message return 1 For Example
     */
    abstract fun getExceptionUniqueKey(): Int

    /**
     * Return The Base Message
     */
    override val message: String?
        get() = getExceptionMessage()

    override fun getMainReason(): Any? {
        return ExposerNetworkError(
            getExceptionUniqueKey(),
            getErrorState(),
            getExceptionMessage()
        )
    }

}