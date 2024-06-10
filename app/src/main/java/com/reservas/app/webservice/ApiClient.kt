package com.reservas.app.webservice

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroFitClient{
//    private const val BASE_URL = "http://169.254.135.55:3000/api/"
    private const val BASE_URL = "http://192.168.101.75:3000/api/"
    //private const val BASE_URL = "http://10.250.23.179:3000/api/"
    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}

object ApiClient {
    val apiService: ApiService by lazy {
        RetroFitClient.retrofit.create(ApiService::class.java)
    }
}