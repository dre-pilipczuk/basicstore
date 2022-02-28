package com.dre.domain.cart

import com.dre.core.cart.Cart
import com.dre.core.catalogue.Product

class AddItemUseCase internal constructor(
    private val repository: CartRepositoryInterface,
) {

    fun execute(productId: Int): Cart {
        return repository.addItem(productId)
    }
}
