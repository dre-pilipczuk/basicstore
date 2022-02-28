package com.dre.domain.catalogue

import com.dre.core.catalogue.Category

class GetCategoriesUseCase internal constructor(
    private val repository: CatalogueRepositoryInterface
) {

    suspend fun execute(): List<Category> {
        return repository.getCategories()
    }
}
