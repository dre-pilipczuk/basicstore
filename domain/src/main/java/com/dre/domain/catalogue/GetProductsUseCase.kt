package com.dre.domain.catalogue

import com.dre.core.catalogue.Product

class GetProductsUseCase internal constructor(
    private val repository: CatalogueRepositoryInterface,
) {

    suspend fun execute(categoryId: String): List<Product> {
        return repository.getProducts(categoryId)
    }
}
