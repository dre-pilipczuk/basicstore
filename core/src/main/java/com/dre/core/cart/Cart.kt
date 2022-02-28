package com.dre.core.cart

data class Cart(
    val items: List<CartItem>,
) {

    val itemCount = items.sumOf { it.quantity }
}
