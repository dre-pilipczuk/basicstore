package com.dre.core.navigation

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

internal class AppRouteTest {

    @Test
    fun authShouldBeAppRouteType() {
        // Given
        val route = AppRoute.Auth

        // When
        val result = route is AppRoute

        // Then
        assertTrue(result)
    }

    @Test
    fun shouldSetAuthRoute() {
        // Given
        val route = AppRoute.Auth

        // When
        val result = route.route

        // Then
        assertEquals("/auth", result)
    }

    @Test
    fun catalogueShouldBeAppRouteType() {
        // Given
        val route = AppRoute.Catalogue

        // When
        val result = route is AppRoute

        // Then
        assertTrue(result)
    }

    @Test
    fun shouldSetCatalogueRoute() {
        // Given
        val route = AppRoute.Catalogue

        // When
        val result = route.route

        // Then
        assertEquals("/catalogue", result)
    }
}
