package com.dre.data.catalogue

import com.dre.core.catalogue.Product

internal data class ProductResponse(
    val id: Int? = null,
    val title: String? = null,
    val price: String? = null,
    val category: String? = null,
    val description: String? = null,
    val image: String? = null,
)

internal fun ProductResponse.toModel() = Product(
    id = id ?: 0,
    name = title.orEmpty(),
    imageUrl = image.orEmpty(),
)
