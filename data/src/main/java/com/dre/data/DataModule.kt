package com.dre.data

import com.dre.data.auth.FakeStoreAuthRepository
import com.dre.data.cart.MemoryCartRepository
import com.dre.data.catalogue.FakeStoreCatalogueRepository
import com.dre.domain.auth.AuthRepositoryInterface
import com.dre.domain.cart.CartRepositoryInterface
import com.dre.domain.catalogue.CatalogueRepositoryInterface
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val dataModule = module {
    single(named("live")) { "https://fakestoreapi.com" }
    single { getFakeStoreService(get(named("live"))) }
    factory<AuthRepositoryInterface> { FakeStoreAuthRepository(get()) }
    factory<CatalogueRepositoryInterface> { FakeStoreCatalogueRepository(get()) }
    single<CartRepositoryInterface> { MemoryCartRepository() }
}

private fun getFakeStoreService(baseUrl: String): FakeStoreService {
    val okHttpClient = OkHttpClient.Builder()
        .readTimeout(30, TimeUnit.SECONDS)
        .build()

    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .build()
        .create(FakeStoreService::class.java)
}
