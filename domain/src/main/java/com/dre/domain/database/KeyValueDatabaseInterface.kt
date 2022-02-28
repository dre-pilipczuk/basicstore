package com.dre.domain.database

interface KeyValueDatabaseInterface {

    fun put(key: String, value: String)
    fun getString(key: String, defValue: String = ""): String
}
