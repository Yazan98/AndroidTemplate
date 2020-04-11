package com.yazan98.exposer.local

interface ExposerMemoryListener<Type> {

    fun acceptMemoryKeys(items: HashMap<String, Type>)

}