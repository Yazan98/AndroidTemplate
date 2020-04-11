package com.yazan98.reflex.di

import com.yazan98.reflex.ReflexApplication
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ApplicationModule::class
])
interface ApplicationComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun setApplication(application: ReflexApplication): Builder

        fun build(): ApplicationComponent
    }


}
