package com.dre.domain.auth

import com.dre.core.auth.User

interface AuthRepositoryInterface {

    suspend fun login(username: String, password: String): User
}
