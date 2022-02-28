package com.dre.data.cart

import com.dre.domain.cart.CartRepositoryInterface
import com.dre.core.cart.Cart
import com.dre.core.cart.CartItem

/**
 * This would be done via an injected database given more time
 */
class MemoryCartRepository : CartRepositoryInterface {

    private val cartItems = mutableListOf<CartItem>()

    override fun getCart(): Cart {
        return Cart(cartItems.toList())
    }

    override fun getItemCount(): Int {
        return cartItems.sumOf { it.quantity }
    }

    override fun addItem(productId: Int): Cart {
        if (productId.getIndex() < 0) {
            insertItem(productId)
        } else {
            incrementItem(productId.getIndex())
        }
        return Cart(cartItems.toList())
    }

    override fun clearCart() {
        cartItems.clear()
        println(cartItems.size)
    }

    private fun insertItem(productId: Int) {
        cartItems.add(CartItem(productId, 1))
    }

    private fun incrementItem(index: Int) {
        if (index in 0 until cartItems.size) {
            cartItems[index] = cartItems[index].copy(quantity = cartItems[index].quantity + 1)
        }
    }

    override fun removeItem(productId: Int): Cart {
        val index = productId.getIndex()
        if (index in 0 until cartItems.size) {
            if (cartItems[index].quantity <= 1) {
                cartItems.removeAt(index)
            } else {
                cartItems[index] = cartItems[index].copy(quantity = cartItems[index].quantity - 1)
            }
        }
        return Cart(cartItems.toList())
    }

    private fun Int.getIndex() = cartItems.indexOfFirst { it.productId == this }
}
