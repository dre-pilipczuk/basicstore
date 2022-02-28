package com.dre.domain.cart

class ClearCartUseCase internal constructor(
    private val cartRepository: CartRepositoryInterface,
) {

    fun execute() {
        cartRepository.clearCart()
    }
}
