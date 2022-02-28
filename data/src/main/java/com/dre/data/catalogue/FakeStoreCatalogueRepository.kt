package com.dre.data.catalogue

import com.dre.data.FakeStoreService
import com.dre.domain.catalogue.CatalogueRepositoryInterface
import com.dre.core.catalogue.Category
import com.dre.core.catalogue.Product

internal class FakeStoreCatalogueRepository(
    private val service: FakeStoreService,
) : CatalogueRepositoryInterface {

    override suspend fun getCategories(): List<Category> {
        return service.getCategories().map { Category(it, it) }
    }

    override suspend fun getProducts(categoryId: String): List<Product> {
        return service.getProducts(categoryId).map { it.toModel() }
    }
}
