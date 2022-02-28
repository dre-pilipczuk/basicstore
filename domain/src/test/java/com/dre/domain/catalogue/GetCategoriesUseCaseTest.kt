package com.dre.domain.catalogue

import com.dre.core.catalogue.Category
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class GetCategoriesUseCaseTest {

    private val mockCatalogueRepository: CatalogueRepositoryInterface = mockk()
    private lateinit var useCase: GetCategoriesUseCase

    @Before
    fun before() {
        useCase = GetCategoriesUseCase(mockCatalogueRepository)
    }

    @Test
    fun shouldGetCategories() = runBlockingTest {
        // Given
        val category = Category(id = "an id", name = "some category")
        coEvery { mockCatalogueRepository.getCategories() } returns listOf(category)

        // When
        val result = useCase.execute()

        // Then
        assertEquals(category, result.first())
    }
}
