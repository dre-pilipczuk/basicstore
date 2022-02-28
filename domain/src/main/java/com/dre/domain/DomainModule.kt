package com.dre.domain

import com.dre.domain.auth.GetLoggedInStatusUseCase
import com.dre.domain.auth.LoginUseCase
import com.dre.domain.auth.LogoutUseCase
import com.dre.domain.cart.*
import com.dre.domain.cart.ClearCartUseCase
import com.dre.domain.catalogue.GetCategoriesUseCase
import com.dre.domain.catalogue.GetProductsUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { GetLoggedInStatusUseCase(get()) }
    factory { LoginUseCase(get(), get()) }
    factory { LogoutUseCase(get(), get()) }
    factory { GetItemCountUseCase(get()) }
    factory { GetCartUseCase(get()) }
    factory { AddItemUseCase(get()) }
    factory { RemoveItemUseCase(get()) }
    factory { ClearCartUseCase(get()) }
    factory { GetCategoriesUseCase(get()) }
    factory { GetProductsUseCase(get()) }
}
