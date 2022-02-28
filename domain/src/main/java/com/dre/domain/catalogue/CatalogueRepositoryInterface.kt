package com.dre.domain.catalogue

import com.dre.core.catalogue.Category
import com.dre.core.catalogue.Product

interface CatalogueRepositoryInterface {

    suspend fun getCategories(): List<Category>

    suspend fun getProducts(categoryId: String): List<Product>
}
