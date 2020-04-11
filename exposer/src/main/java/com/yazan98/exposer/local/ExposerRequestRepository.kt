package com.yazan98.exposer.local

interface ExposerRequestRepository<Request> {

    fun addRxLocalRequest(request: Request)

    suspend fun addRxRequest(request: Request)

    fun clear()

}
