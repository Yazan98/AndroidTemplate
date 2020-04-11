package com.yazan98.exposer.usecases

import com.yazan98.exposer.errors.ExposerUseCaseCancelationException
import com.yazan98.exposer.usecases.base.ExposerResult
import com.yazan98.exposer.usecases.base.ExposerUseCaseCallback
import com.yazan98.exposer.usecases.base.ExposerUseCaseParamImpl
import com.yazan98.exposer.usecases.constraints.ExposerConstraint
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine


abstract class ExposerUseCase<Result, in Param> : ExposerUseCaseParamImpl<Result, Param>, CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Default + SupervisorJob()

    /**
     * You Can Start UseCase Execution Here
     */
    override suspend fun execute(param: Param): ExposerResult<Result> = suspendCoroutine { continuation ->
        GlobalScope.launch {
            executeWithCallback(object : ExposerUseCaseCallback<Result> {
                override suspend fun onResult(result: Result) {
                    continuation.resume(ExposerResult.ExposerSuccessResult(result))
                }

                override suspend fun onError(error: Throwable) {
                    continuation.resumeWithException(error)
                }

                override suspend fun onConstraintsError(items: List<ExposerConstraint<*>>) {
                    // implement The Validation Listener
                }

                override suspend fun onCanceled(reason: String) {
                    continuation.resumeWithException(
                        ExposerUseCaseCancelationException(reason)
                    )
                }
            })
        }
    }

    /**
     * Here You Can Get The Result From Callback When Execute The UseCase
     * And You Should Implement The Execute Method With try , Catch To Handle
     * The In Coming Exceptions
     */
    override fun executeWithCallback(callback: ExposerUseCaseCallback<Result>) {

    }

    /**
     * Cancel The UseCase At AnyTime
     * Each UseCase Has execute Method And You Can Execute The Request From This Method
     * And Any Execute Call Should Executes On The UseCase Job And You Can Cancel The Job Execution at AnyTime
     */
    override fun cancel() {
        coroutineContext.cancel()
    }

    /**
     * Cancel The UseCase At AnyTime
     * Each UseCase Has execute Method And You Can Execute The Request From This Method
     * And Any Execute Call Should Executes On The UseCase Job And You Can Cancel The Job Execution at AnyTime
     *
     * Here You Can Choose The UseCase Reason Why it's Canceled
     */
    override fun cancelWithReason(reason: String) {
        coroutineContext.cancel(CancellationException(reason))
    }

    /**
     * When You Need To Destroy The UseCase
     * You Can Clean The Requests Once Finished From The UseCase
     */
    override fun destroy() {
        // kill listeners
    }

}