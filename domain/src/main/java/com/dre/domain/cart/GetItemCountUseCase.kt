package com.dre.domain.cart

class GetItemCountUseCase internal constructor(
    private val repository: CartRepositoryInterface,
) {

    fun execute(): Int {
        return repository.getItemCount()
    }
}
