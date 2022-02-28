package com.dre.core

sealed class BasicStoreException : Exception() {
    object Unauthenticated : BasicStoreException()
}
