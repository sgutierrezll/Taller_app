package com.reservas.app.ui.print

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.reservas.app.R
import com.reservas.app.dto.Place
import com.reservas.app.dto.User
import com.reservas.app.webservice.ApiService
import com.reservas.app.webservice.RetrofitInstance

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PrintActivity : AppCompatActivity() {
    private lateinit var apiService: ApiService


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Log.d("PrintActivity", "La actividad PrintActivity se ha creado")
        /*
                ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)){v, insets->
                    val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                    v.setPadding(systemBars.left,systemBars.top,systemBars.right,systemBars.bottom)
                    insets
                }*/

        Log.d("PrintActivity", "Activity creado correctamente")
        val retrofit = RetrofitInstance.create(this)
        apiService = retrofit.create(ApiService::class.java)

        Log.d("PrintActivity", "Servicio API inicializado correctamente")


        //LLAMA A GETUSER
        apiService.getUsers().enqueue(object : Callback<List<User>> {
            //apiService.getProductsDetails().enqueue(object : Callback<List<ProductDetail>> {
            override fun onResponse(

                call: Call<List<User>>,
                response: Response<List<User>>

                /*call: Call<List<ProductDetail>>,
                response: Response<List<ProductDetail>>*/

            ) {
                if (response.isSuccessful) {
                    val productos = response.body()
                    productos?.let {
                        // Manejar la lista de productos
                        it.forEach { data ->
                            Log.d("MainActivity", "User: $data")
                            //data
                        }
                    }
                } else {
                    Log.e("MainActivity", "Error en la respuesta: ${response.code()}")
                }
            }
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                //override fun onFailure(call: Call<List<ProductDetail>>, t: Throwable) {

                Log.e("MainActivity", "Error en la llamada: ${t.message}")
            }
        })

        apiService.getPlaces().enqueue(object : Callback<List<Place>> {
            //apiService.getProductsDetails().enqueue(object : Callback<List<ProductDetail>> {
            override fun onResponse(

                call: Call<List<Place>>,
                response: Response<List<Place>>

                /*call: Call<List<ProductDetail>>,
                response: Response<List<ProductDetail>>*/

            ) {
                if (response.isSuccessful) {
                    val productos = response.body()
                    productos?.let {
                        // Manejar la lista de productos
                        it.forEach { data ->
                            Log.d("MainActivity", "Place: $data")
                            //data
                        }
                    }
                } else {
                    Log.e("MainActivity", "Error en la respuesta: ${response.code()}")
                }
            }
            override fun onFailure(call: Call<List<Place>>, t: Throwable) {
                //override fun onFailure(call: Call<List<ProductDetail>>, t: Throwable) {

                Log.e("MainActivity", "Error en la llamada: ${t.message}")
            }
        })

//        // Llamada a getPlaces
//        apiService.getPlaces().enqueue(object : Callback<List<Place>> {
//            override fun onResponse(call: Call<List<Place>>, response: Response<List<Place>>) {
//                if (response.isSuccessful) {
//                    val place = response.body()
//                    place?.let {
//                        it.forEach { data ->
//                            Log.d("PrintActivity", "Place: $data")
//                        }
//                    }
//                } else {
//                    Log.e("PrintActivity", "Error en la respuesta de places: ${response.code()}")
//                }
//            }
//
//            override fun onFailure(call: Call<List<Place>>, t: Throwable) {
//                Log.e("PrintActivity", "Error en la llamada de places: ${t.message}")
//            }
//        })

        // Llamada a getPlaces
//        apiService.getAsientos().enqueue(object : Callback<List<Asiento>> {
//            override fun onResponse(call: Call<List<Asiento>>, response: Response<List<Asiento>>) {
//                if (response.isSuccessful) {
//                    val asientos = response.body()
//                    asientos?.let {
//                        it.forEach { data ->
//                            Log.d("PrintActivity", "Asiento: $data")
//                        }
//                    }
//                } else {
//                    Log.e("PrintActivity", "Error en la respuesta de asientos: ${response.code()}")
//                }
//            }
//
//            override fun onFailure(call: Call<List<Asiento>>, t: Throwable) {
//                Log.e("PrintActivity", "Error en la llamada de asientos: ${t.message}")
//            }
//        })
        Log.d("PrintActivity", "Solicitud de detalles de usuario enviada")
    }
    override  fun onSupportNavigateUp():Boolean{
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}