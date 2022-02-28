package com.dre.core.catalogue

import org.junit.Assert.assertEquals
import org.junit.Test

internal class ProductTest {

    @Test
    fun shouldAssignId() {
        // Given
        val id = 1

        // When
        val result = Product(
            id = id,
            name = "",
            imageUrl = "",
        )

        // Then
        assertEquals(id, result.id)
    }

    @Test
    fun shouldAssignName() {
        // Given
        val name = "Cool hat"

        // When
        val result = Product(
            id = 1,
            name = name,
            imageUrl = "",
        )

        // Then
        assertEquals(name, result.name)
    }

    @Test
    fun shouldAssignImageUrl() {
        // Given
        val imageUrl = "www.abc.com/image"

        // When
        val result = Product(
            id = 0,
            name = "",
            imageUrl = imageUrl,
        )

        // Then
        assertEquals(imageUrl, result.imageUrl)
    }
}
