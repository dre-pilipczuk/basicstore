package com.dre.core.catalogue

import org.junit.Assert.assertEquals
import org.junit.Test

internal class CategoryTest {

    @Test
    fun shouldAssignId() {
        // Given
        val id = "hats"

        // When
        val result = Category(
            id = id,
            name = "",
        )

        // Then
        assertEquals(id, result.id)
    }

    @Test
    fun shouldAssignName() {
        // Given
        val name = "bags"

        // When
        val result = Category(
            id = "bags",
            name = name,
        )

        // Then
        assertEquals(name, result.name)
    }
}
