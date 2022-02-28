package com.dre.cart

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val cartModule = module {
    viewModel { CartViewModel(get(), get(), get(), get()) }
}
