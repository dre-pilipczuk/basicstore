package com.dre.data

import com.dre.data.auth.LoginRequest
import com.dre.data.auth.LoginResponse
import com.dre.data.catalogue.CategoryResponse
import com.dre.data.catalogue.ProductResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

internal interface FakeStoreService {

    @POST("/auth/login")
    suspend fun login(@Body body: LoginRequest): LoginResponse

    @GET("/products/categories")
    suspend fun getCategories(): List<CategoryResponse>

    @GET("/products/category/{category}")
    suspend fun getProducts(
        @Path("category") category: String,
    ): List<ProductResponse>
}
