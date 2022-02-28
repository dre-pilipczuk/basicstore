package com.dre.catalogue

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.dre.core.navigation.AppRoute
import com.dre.core.catalogue.Category
import com.dre.domain.auth.LogoutUseCase
import com.dre.domain.catalogue.GetCategoriesUseCase
import com.dre.domain.catalogue.GetProductsUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CatalogueViewModel(
    private val navController: NavHostController,
    getCategoriesUseCase: GetCategoriesUseCase,
    private val getProductsUseCase: GetProductsUseCase,
    private val logoutUseCase: LogoutUseCase,
    coroutineScopeProvider: CoroutineScope? = null,
) : ViewModel() {

    private val coroutineScope = coroutineScopeProvider ?: viewModelScope

    var loading: Boolean by mutableStateOf(false); private set
    val categories: SnapshotStateList<String> = mutableStateListOf()
    val products: SnapshotStateList<CatalogueProduct> = mutableStateListOf()

    init {
        var newCategories: List<Category>
        coroutineScope.launch(Dispatchers.IO) {
            newCategories = getCategoriesUseCase.execute()
            withContext(Dispatchers.Main) {
                categories.clear()
                categories.addAll(newCategories.map { it.name })
            }
        }
    }

    fun onCategorySelected(categoryId: String) {
        coroutineScope.launch(Dispatchers.IO) {
            val newProducts = getProductsUseCase.execute(categoryId).map { CatalogueProduct(it.id, it.name) }
            withContext(Dispatchers.Main) {
                products.clear()
                products.addAll(newProducts)
            }
        }
    }

    fun onLogoutSelected() {
        logoutUseCase.execute()
        navController.navigate(AppRoute.Auth.route)
    }

    fun onBackSelected() {
        products.clear()
    }
}
