package com.dre.data.auth

import com.dre.core.BasicStoreException
import com.dre.data.FakeStoreService
import com.dre.domain.auth.AuthRepositoryInterface
import com.dre.core.auth.User
import retrofit2.HttpException

internal class FakeStoreAuthRepository(
    private val service: FakeStoreService,
) : AuthRepositoryInterface {

    private val unauthorised = 401

    override suspend fun login(username: String, password: String): User {
        try {
            return service.login(
                LoginRequest(username, password)
            ).toModel()
        } catch (httpException: HttpException) {
            if (httpException.code() == unauthorised) {
                throw BasicStoreException.Unauthenticated
            } else {
                throw httpException
            }
        }
    }
}
