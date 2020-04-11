package com.yazan98.reflex.di

import android.app.Application
import android.content.Context
import com.yazan98.domain.scopes.ApplicationScope
import dagger.Module
import dagger.Provides

@Module(
    subcomponents = [
    ]
)
class ApplicationModule {

    @Provides
    @ApplicationScope
    fun provideApplicationContext(application: Application): Context {
        return application
    }

    @Provides
    @ApplicationScope
    fun provideContext(context: Context): Context {
        return context
    }

}
