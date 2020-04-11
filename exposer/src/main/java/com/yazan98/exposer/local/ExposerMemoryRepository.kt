package com.yazan98.exposer.local

abstract class ExposerMemoryRepository<Type: Any>: ExposerMemoryRepositoryImpl<Type> {

    private var listener: ExposerMemoryListener<Type>? = null
    private val keys: HashMap<String, Type> by lazy {
        HashMap<String, Type>()
    }

    override fun add(key: String, value: Type) {
        this.keys[key] = value
    }

    override fun addAll(items: HashMap<String, Type>) {
        this.keys.putAll(items)
    }

    override fun execute() {
        this.listener?.let {
            it.acceptMemoryKeys(keys)
        }
    }

    override fun withListener(listener: ExposerMemoryListener<Type>) {
        this.listener = listener
    }

    override fun destroyListener() {
        this.listener = null
    }

}