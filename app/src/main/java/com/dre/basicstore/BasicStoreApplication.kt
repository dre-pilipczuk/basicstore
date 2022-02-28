package com.dre.basicstore

import android.app.Application
import com.dre.auth.authModule
import com.dre.cart.cartModule
import com.dre.catalogue.catalogueModule
import com.dre.android.dataAndroidModule
import com.dre.data.dataModule
import com.dre.domain.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.component.KoinComponent
import org.koin.core.context.GlobalContext.startKoin

class BasicStoreApplication : Application(), KoinComponent {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@BasicStoreApplication)
            modules(
                dataAndroidModule,
                authModule,
                cartModule,
                catalogueModule,
                dataModule,
                domainModule,
            )
        }
    }
}
