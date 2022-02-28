package com.dre.domain.catalogue

import com.dre.core.catalogue.Product
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class GetProductsUseCaseTest {

    private val mockCatalogueRepository: CatalogueRepositoryInterface = mockk()
    private lateinit var useCase: GetProductsUseCase

    @Before
    fun before() {
        useCase = GetProductsUseCase(mockCatalogueRepository)
    }

    @Test
    fun shouldGetProducts() = runBlockingTest {
        // Given
        val categoryId = "category"
        val product = Product(id = 123, name = "product", imageUrl = "")
        coEvery { mockCatalogueRepository.getProducts(categoryId) } returns listOf(product)

        // When
        val result = useCase.execute(categoryId)

        // Then
        assertEquals(product, result.first())
    }
}
