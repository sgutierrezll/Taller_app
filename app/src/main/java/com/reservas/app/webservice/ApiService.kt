package com.reservas.app.webservice
import com.reservas.app.dto.User
import com.reservas.app.dto.Image
import com.reservas.app.dto.Place


import retrofit2.Call
import retrofit2.http.GET


import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @GET("users")
    fun getUsers(): Call<List<User>>

    @GET("places")
    fun getPlaces(): Call<List<Place>>

//    @GET("users")
//    fun getUsers(@Path("id") postId: String): Call<User>

    @POST("auth/login")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>

    @GET("images")
    fun getImages(): Call<List<Image>>
}



