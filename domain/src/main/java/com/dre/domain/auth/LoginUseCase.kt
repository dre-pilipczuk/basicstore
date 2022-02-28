package com.dre.domain.auth

import com.dre.core.auth.User
import com.dre.domain.database.KeyValueDatabaseInterface

class LoginUseCase internal constructor(
    private val authRepository: AuthRepositoryInterface,
    private val keyValueDatabase: KeyValueDatabaseInterface,
) {

    suspend fun execute(username: String, password: String): User {
        val user = authRepository.login(username, password)
        keyValueDatabase.put(AUTH_KEY, user.authToken)
        return user
    }
}
