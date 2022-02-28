package com.dre.auth

import androidx.navigation.NavHostController
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val authModule = module {
    viewModel { (navController: NavHostController) -> AuthViewModel(navController, get()) }
}
