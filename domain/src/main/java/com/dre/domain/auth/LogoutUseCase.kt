package com.dre.domain.auth

import com.dre.domain.cart.CartRepositoryInterface
import com.dre.domain.database.KeyValueDatabaseInterface

class LogoutUseCase internal constructor(
    private val keyValueDatabase: KeyValueDatabaseInterface,
    private val cartRepository: CartRepositoryInterface,
) {

    fun execute() {
        keyValueDatabase.put(AUTH_KEY, "")
        cartRepository.clearCart()
    }
}
