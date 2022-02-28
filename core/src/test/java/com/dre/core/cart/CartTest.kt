package com.dre.core.cart

import org.junit.Assert.assertEquals
import org.junit.Test

internal class CartTest {

    @Test
    fun shouldAssignItem() {
        // Given
        val item = CartItem(
            productId = 1,
            quantity = 3,
        )

        // When
        val result = Cart(items = listOf(item))

        // Then
        assertEquals(item, result.items.first())
    }

    @Test
    fun shouldCalculateTotal() {
        // Given
        val items = listOf(
            CartItem(
                productId = 1,
                quantity = 3
            ),
            CartItem(
                productId = 2,
                quantity = 7
            ),
        )

        // When
        val result = Cart(items = items)

        // Then
        assertEquals(10, result.itemCount)
    }
}
