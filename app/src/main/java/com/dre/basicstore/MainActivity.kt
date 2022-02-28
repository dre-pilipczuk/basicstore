package com.dre.basicstore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dre.basicstore.ui.theme.BasicStoreTheme
import com.dre.core.navigation.AppRoute
import com.dre.domain.auth.GetLoggedInStatusUseCase
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf

class MainActivity : ComponentActivity(), KoinComponent {

    private val getLoggedInStatusUseCase: GetLoggedInStatusUseCase by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            BasicStoreTheme {
                Scaffold {
                    NavHost(navController = navController, startDestination = getStartDestination()) {
                        composable(AppRoute.Auth.route) {
                            AuthScreen(
                                authViewModel = getViewModel { parametersOf(navController) },
                            )
                        }
                        composable(AppRoute.Catalogue.route) {
                            CatalogueScreen(
                                catalogueViewModel = getViewModel { parametersOf(navController) },
                                cartViewModel = getViewModel(),
                            )
                        }
                    }
                }
            }
        }
    }

    private fun getStartDestination(): String {
        val isLoggedIn = getLoggedInStatusUseCase.execute()
        return if (!isLoggedIn) {
            AppRoute.Auth.route
        } else {
            AppRoute.Catalogue.route
        }
    }
}
