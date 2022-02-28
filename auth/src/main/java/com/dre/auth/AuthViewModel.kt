package com.dre.auth

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.dre.core.navigation.AppRoute
import com.dre.core.BasicStoreException
import com.dre.domain.auth.LoginUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class AuthViewModel internal constructor(
    private val navController: NavHostController,
    private val loginUseCase: LoginUseCase,
    coroutineScopeProvider: CoroutineScope? = null,
) : ViewModel() {

    private val coroutineScope = coroutineScopeProvider ?: viewModelScope

    var loading: Boolean by mutableStateOf(false); private set
    var authError: Boolean by mutableStateOf(false); private set

    fun login(username: String, password: String) {
        authError = false
        loading = true
        coroutineScope.launch {
            try {
                loginUseCase.execute(username, password)
                navController.navigate(AppRoute.Catalogue.route)
            } catch (unauthenticated: BasicStoreException.Unauthenticated) {
                authError = true
            } finally {
                loading = false
            }
        }
    }
}
