package com.dre.cart

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.dre.domain.cart.*

class CartViewModel(
    private val getItemCountUseCase: GetItemCountUseCase,
    private val addItemUseCase: AddItemUseCase,
    private val removeItemUseCase: RemoveItemUseCase,
    private val clearCartUseCase: ClearCartUseCase,
) : ViewModel() {

    var itemCount: Int by mutableStateOf(0)

    fun addItem(productId: Int) {
        addItemUseCase.execute(productId)
        updateCount()
    }

    fun removeItem(productId: Int) {
        removeItemUseCase.execute(productId)
        updateCount()
    }

    fun onLogoutSelected() {
        clearCartUseCase.execute()
        updateCount()
    }

    private fun updateCount() {
        itemCount = getItemCountUseCase.execute()
    }
}
