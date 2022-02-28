package com.dre.catalogue

import androidx.navigation.NavHostController
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val catalogueModule = module {
    viewModel { (navController: NavHostController) -> CatalogueViewModel(navController, get(), get(), get()) }
}
