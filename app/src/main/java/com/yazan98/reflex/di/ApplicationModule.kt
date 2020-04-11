package com.yazan98.reflex.di

import android.app.Application
import android.content.Context
import com.yazan98.domain.scopes.ApplicationScope
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object ApplicationModule {

    @Provides
    @Singleton
    @ApplicationScope
    fun provideApplicationContext(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    fun provideContext(@ApplicationScope context: Context): Context {
        return context
    }

}
