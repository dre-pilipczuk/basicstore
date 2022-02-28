package com.dre.core.navigation

sealed class AppRoute(val route: String) {
    object Auth : AppRoute("/auth")
    object Catalogue : AppRoute("/catalogue")
}
