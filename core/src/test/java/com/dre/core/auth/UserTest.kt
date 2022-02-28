package com.dre.core.auth

import org.junit.Assert.assertEquals
import org.junit.Test

internal class UserTest {

    @Test
    fun shouldAssignAuthToken() {
        // Given
        val authToken = "abc123"

        // When
        val result = User(authToken = authToken)

        // Then
        assertEquals(authToken, result.authToken)
    }
}
