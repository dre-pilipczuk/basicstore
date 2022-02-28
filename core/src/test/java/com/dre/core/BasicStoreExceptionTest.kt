package com.dre.core

import org.junit.Assert.assertTrue
import org.junit.Test

internal class BasicStoreExceptionTest {

    @Test
    fun unauthenticatedShouldBeBasicStoreException() {
        // Given
        val exception = BasicStoreException.Unauthenticated

        // When
        val result = exception is BasicStoreException

        // Then
        assertTrue(result)
    }
}
