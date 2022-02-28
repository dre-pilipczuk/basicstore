package com.dre.data.auth

import com.dre.core.auth.User

internal data class LoginResponse(
    val token: String? = null,
)

internal fun LoginResponse.toModel() = User(
    authToken = token.orEmpty(),
)
