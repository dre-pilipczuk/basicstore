package com.dre.domain.cart

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
class RemoveItemUseCaseTest {

    private val mockRepository: CartRepositoryInterface = mockk()
    private lateinit var useCase: RemoveItemUseCase

    @Before
    fun before() {
        useCase = RemoveItemUseCase(mockRepository)
    }

    @Test
    fun shouldReturnResult() = runBlockingTest {
        // Given
        val product = Product(3, "", "")
        coEvery { mockRepository.removeItem(product) } returns true

        // When
        val result = useCase.execute(product)

        // Then
        assertEquals(true, result)
    }

    @Test
    fun shouldCallRemoveItem() = runBlockingTest {
        // Given
        val product = Product(3, "", "")
        coEvery { mockRepository.removeItem(product) } returns true

        // When
        useCase.execute(product)

        // Then
        coVerify { mockRepository.removeItem(product) }
    }
}
