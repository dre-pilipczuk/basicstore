package com.dre.core.cart

import org.junit.Assert.assertEquals
import org.junit.Test

internal class CartItemTest {

    @Test
    fun shouldAssignProductId() {
        // Given
        val productId = 4

        // When
        val result = CartItem(
            productId = productId,
            quantity = 0,
        )

        // Then
        assertEquals(productId, result.productId)
    }

    @Test
    fun shouldAssignQuantity() {
        // Given
        val quantity = 3

        // When
        val result = CartItem(
            productId = 1,
            quantity = quantity,
        )

        // Then
        assertEquals(quantity, result.quantity)
    }
}
