package com.dre.domain.cart

import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class ClearCartUseCaseTest {

    private val mockRepository: CartRepositoryInterface = mockk()
    private lateinit var useCase: ClearCartUseCase

    @Before
    fun before() {
        useCase = ClearCartUseCase(mockRepository)
    }

    @Test
    fun shouldCallClearCart() = runBlockingTest {
        // When
        useCase.execute()

        // Then
        coVerify { mockRepository.clearCart() }
    }
}
