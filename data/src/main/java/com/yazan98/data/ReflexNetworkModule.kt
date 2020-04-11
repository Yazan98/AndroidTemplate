package com.yazan98.data

import com.yazan98.domain.scopes.NetworkScope
import dagger.Module
import dagger.Provides
import io.vortex.android.prefs.VortexPrefs
import io.vortex.android.prefs.VortexPrefsConsts
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ReflexNetworkModule {

    companion object {
        const val AUTH_HEADER = "Authorization"
    }

    @Provides
    @NetworkScope
    fun getRetrofitInstance(retrofitInterceptor: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(retrofitInterceptor)
            .build()
    }

    @Provides
    @NetworkScope
    fun getRetrofitInterceptor(): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        httpClient.addInterceptor(interceptor)
        httpClient.addInterceptor { chain ->
            val request =
                chain.request()
                    .newBuilder()
                    .addHeader(AUTH_HEADER, VortexPrefs.getLocalKey(VortexPrefsConsts.ACCESS_TOKEN_KEY, "") as String)
                    .build()
            chain.proceed(request)
        }
        return httpClient.build()
    }

}
