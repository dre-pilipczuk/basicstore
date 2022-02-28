package com.dre.data

import com.dre.data.auth.LoginResponse
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

internal class LoginResponseTest {

    @Test
    fun tokenShouldBeNullByDefault() {
        // Given
        val response = LoginResponse()

        // When
        val result = response.token

        // Then
        assertNull(result)
    }

    @Test
    fun shouldAssignToken() {
        // Given
        val token = "hello"

        // When
        val result = LoginResponse(token)

        // Then
        assertEquals(token, result.token)
    }
}
