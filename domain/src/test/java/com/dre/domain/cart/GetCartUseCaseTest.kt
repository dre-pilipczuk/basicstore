package com.dre.domain.cart

import com.dre.core.cart.Cart
import com.dre.core.cart.CartItem
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class GetCartUseCaseTest {

    private val mockCartRepository: CartRepositoryInterface = mockk()
    private lateinit var useCase: GetCartUseCase

    @Before
    fun before() {
        useCase = GetCartUseCase(mockCartRepository)
    }

    @Test
    fun shouldCallGetCart() = runBlockingTest {
        // Given
        val cartItem = CartItem(1, 2)
        val cart = Cart(items = listOf(cartItem))
        coEvery { mockCartRepository.getCart() } returns cart

        // When
        useCase.execute()

        // Then
        coVerify { mockCartRepository.getCart() }
    }

    @Test
    fun shouldReturnCart() = runBlockingTest {
        // Given
        val cartItem = CartItem(1, 2)
        val cart = Cart(items = listOf(cartItem))
        coEvery { mockCartRepository.getCart() } returns cart

        // When
        val result = useCase.execute()

        // Then
        assertEquals(cart, result)
    }
}
