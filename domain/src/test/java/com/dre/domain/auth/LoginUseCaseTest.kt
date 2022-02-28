package com.dre.domain.auth

import com.dre.core.BasicStoreException
import com.dre.core.auth.User
import com.dre.domain.database.KeyValueDatabaseInterface
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class LoginUseCaseTest {

    private val mockAuthRepository: AuthRepositoryInterface = mockk()
    private val mockKeyValueDatabase: KeyValueDatabaseInterface = mockk()
    private lateinit var useCase: LoginUseCase

    @Before
    fun before() {
        useCase = LoginUseCase(
            mockAuthRepository,
            mockKeyValueDatabase,
        )
    }

    @Test
    fun shouldReturnToken() = runBlockingTest {
        // Given
        val username = "test.account"
        val password = "1234"
        val token = "abc123"
        coEvery { mockAuthRepository.login(username, password) } returns User(authToken = token)

        // When
        val result = useCase.execute(username, password)

        // Then
        assertEquals(token, result.authToken)
    }

    @Test(expected = BasicStoreException.Unauthenticated::class)
    fun shouldBeNullAfterException() = runBlockingTest {
        // Given
        coEvery {
            mockAuthRepository.login(
                any(),
                any()
            )
        } throws BasicStoreException.Unauthenticated

        // Then
        useCase.execute("", "")
    }
}
