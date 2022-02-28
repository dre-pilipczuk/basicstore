package com.dre.domain.cart

import com.dre.core.cart.Cart
import com.dre.core.cart.CartItem
import com.dre.core.catalogue.Product
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class AddItemUseCaseTest {

    private val mockRepository: CartRepositoryInterface = mockk()
    private lateinit var useCase: AddItemUseCase

    @Before
    fun before() {
        useCase = AddItemUseCase(mockRepository)
    }

    @Test
    fun shouldReturnResult() = runBlockingTest {
        // Given
//        val product = Product(3, "", "")
//        coEvery { mockRepository.addItem(3) } returns Cart(items = listOf(CartItem(3, 1)))
//
//        // When
//        val result = useCase.execute(product)
//
//        // Then
//        assertEquals(true, result)
    }

    @Test
    fun shouldCallAddItem() = runBlockingTest {
        // Given
//        val product = Product(3, "", "")
//        coEvery { mockRepository.addItem(product) } returns true
//
//        // When
//        useCase.execute(product)
//
//        // Then
//        coVerify { mockRepository.addItem(product) }
    }
}
