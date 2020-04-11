package com.yazan98.data

import com.yazan98.domain.rx.ReflexRxThreadProvider
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers

/**
 * Exposer For Android Applications With Domain Layer
 * Well Exposer Domain Layer Built With Pure Language (Java/Kotlin)
 * Each Request At The Android System Should Execute On Background Thread
 * And The UseCases Built On Native Code And There is No RxJava Or Something Like That
 * There is Just An In Coming Object And This Object Should Reflect The Implementaiton
 *
 * For Example
 * The UseCase Requires An Thread To Execute The Request
 * And Each UseCase Requires Threads Like Background, Main
 * And The Domain Layer Can Get An ExposerThreadProvider With The Base Implementation but Acually
 * The In Coming Thread Provider is RxJava Thread Provider And You Can Case Them
 *
 * In This Way Each Platform Can Implement ExposerThreadProvider And Return Each Thread
 */
object ReflexRxProvider : ReflexRxThreadProvider {
    override fun getUserInterfaceProvider(): Scheduler = AndroidSchedulers.mainThread()
}
