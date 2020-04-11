package com.yazan98.logic

import com.yazan98.exposer.local.ExposerRequestRepository
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class ExposerRxRepository : ExposerRequestRepository<Disposable> {

    private val repository: CompositeDisposable by lazy {
        CompositeDisposable()
    }

    override fun addRxLocalRequest(request: Disposable) {
        this.repository += request
    }

    override suspend fun addRxRequest(request: Disposable) {
        withContext(Dispatchers.IO) {
            repository += request
        }
    }

    override fun clear() {
        repository.clear()
    }

}

private operator fun CompositeDisposable.plusAssign(request: Disposable) {
    add(request)
}
