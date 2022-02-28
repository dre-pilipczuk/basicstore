package com.dre.domain.cart

import com.dre.core.cart.Cart
import com.dre.core.catalogue.Product

interface CartRepositoryInterface {

    fun getCart(): Cart

    fun getItemCount(): Int

    fun addItem(productId: Int): Cart

    fun removeItem(productId: Int): Cart

    fun clearCart()
}
