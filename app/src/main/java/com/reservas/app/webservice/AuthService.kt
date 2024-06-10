package com.reservas.app.webservice

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("auth/login")
    //suspend fun login(@Body request: LoginRequest): LoginResponse
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>
}