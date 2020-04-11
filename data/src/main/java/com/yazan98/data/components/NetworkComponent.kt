package com.yazan98.data.components

import com.yazan98.data.ReflexNetworkModule
import com.yazan98.domain.scopes.NetworkScope
import dagger.BindsInstance
import dagger.Component
import dagger.Subcomponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@NetworkScope
@Component(modules = [ReflexNetworkModule::class])
interface NetworkComponent {

    fun getRetrofit(): Retrofit

    fun getOkHttpClient(): OkHttpClient

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun bind(application: ReflexNetworkModule): Builder

        fun build(): NetworkComponent
    }

}
