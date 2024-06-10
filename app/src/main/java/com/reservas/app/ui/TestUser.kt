package com.reservas.app.ui
import com.reservas.app.webservice.ApiService
import com.reservas.app.webservice.ApiClient
import com.reservas.app.dto.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//class TestUser {
//    fun fetchUserData() {
////        val postId = "37662844-a754-4309-bf36-f907d43339"
//        val postId = "bc67ec22-216b-4a7f-9c08-4a198e5ea208"
//        val call = ApiClient.apiService.getUsers(postId)
//
//        call.enqueue(object : Callback<User> {
//            override fun onResponse(call: Call<User>, response: Response<User>) {
//                if (response.isSuccessful) {
//                    val post = response.body()
//                    // Handle the retrieved post data
//                    println("Response")
//                    //print(post)
//                    println(post)
//                } else {
//                    // Handle error
//                }
//            }
//            override fun onFailure(call: Call<User>, t: Throwable) {
//                // Handle failure
//            }
//        })
//    }
//}
