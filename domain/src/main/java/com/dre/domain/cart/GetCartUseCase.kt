package com.dre.domain.cart

import com.dre.core.cart.Cart

class GetCartUseCase internal constructor(
    private val repository: CartRepositoryInterface,
) {

    fun execute(): Cart {
        return repository.getCart()
    }
}
