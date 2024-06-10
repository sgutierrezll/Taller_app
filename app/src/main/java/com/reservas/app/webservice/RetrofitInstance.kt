package com.reservas.app.webservice

import android.content.Context
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private lateinit var authService: AuthService
//    private const val BASE_URL = "http://192.168.180.217:3000/api/"
    private const val BASE_URL = "http://192.168.101.75:3000/api/"
    //private const val BASE_URL =  "http://10.0.2.2:3000/api/"

    fun getAuthServiceLogin(tokenManager: TokenManager): AuthService {
        if (!::authService.isInitialized) {
            val client = OkHttpClient.Builder()
                .addInterceptor(AuthInterceptor(tokenManager))
                .build()
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            authService = retrofit.create(AuthService::class.java)
        }
        return authService
    }

    private fun provideOkHttpClient(tokenManager: TokenManager): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                val request = chain.request().newBuilder()
                    .addHeader("Authorization", "Bearer ${tokenManager.token}")
                    .build()
                chain.proceed(request)
            }.build()
    }

    fun getAuthService(tokenManager: TokenManager): AuthService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(provideOkHttpClient(tokenManager))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AuthService::class.java)
    }

    fun create(context: Context): Retrofit {

        val tokenManager = TokenManager(context)

        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val client = OkHttpClient.Builder()
            .addInterceptor(AuthInterceptor(tokenManager))
            .addInterceptor(loggingInterceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}








/*fun getAuthServicegin(tokenManager: TokenManager): Any {

}
/*
priv const val BASE_URL = "http://192.168.0.7:3000/api/"

private fun provideOkHttpClient(tokenManager: TokenManager): OkHttpClient {
   return OkHttpClient.Builder()
       .addInterceptor { chain ->
           val request = chain.request().newBuilder()
               .addHeader("Authorization", "Bearer ${tokenManager.token}")
               .build()
           chain.proceed(request)
       }.build()
}

fun getAuthService(tokenManager: TokenManager): AuthService {
   return Retrofit.Builder()
       .baseUrl(BASE_URL)
       .client(provideOkHttpClient(tokenManager))
       .addConverterFactory(GsonConverterFactory.create())
       .build()
       .create(AuthService::class.java)
}

*/