package com.dre.domain.auth

import com.dre.domain.database.KeyValueDatabaseInterface

class GetLoggedInStatusUseCase internal constructor(
    private val keyValueDatabase: KeyValueDatabaseInterface,
) {

    fun execute(): Boolean {
        return keyValueDatabase.getString(AUTH_KEY, "").isNotEmpty()
    }
}
