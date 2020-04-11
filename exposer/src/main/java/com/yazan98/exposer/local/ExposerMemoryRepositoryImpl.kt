package com.yazan98.exposer.local

interface ExposerMemoryRepositoryImpl<Type: Any> {

    fun add(key: String, value: Type)

    fun addAll(items: HashMap<String, Type>)

    fun withListener(listener: ExposerMemoryListener<Type>)

    fun destroyListener()

    fun getByKey(key: String): Type

    fun save(key: String, value: Any)

    fun execute()

}