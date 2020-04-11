package com.yazan98.data.repos

import com.yazan98.data.components.DaggerNetworkComponent
import com.yazan98.data.components.NetworkComponent
import io.vortex.android.data.VortexRepository
import io.vortex.android.models.VortexAuth
import io.vortex.android.models.VortexRequestDetailsProvider
import io.vortex.android.models.VortexServiceProviderType
import retrofit2.Retrofit

abstract class ReflexRepository<Api> : VortexRepository<Api>() {

    private val networkComponent: NetworkComponent by lazy {
        getNetworkConfig()
    }

    private fun getNetworkConfig(): NetworkComponent {
        return DaggerNetworkComponent.builder()
            .bind(ReflexRepositoryHelper.networkModule).build()
    }

    override fun getServiceProvider(type: VortexServiceProviderType): Retrofit {
        return super.getServiceProvider(type)
    }

    override fun getRequestDetails(): VortexRequestDetailsProvider {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getBaseUrl(): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getBasicAuthConfiguration(details: VortexAuth): String {
        return super.getBasicAuthConfiguration(details)
    }

}
