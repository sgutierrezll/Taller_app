package com.reservas.app.webservice

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Response

class LoginViewModel(private val tokenManager: TokenManager) : ViewModel() {
    private val _loginResult = MutableLiveData<Result<LoginResponse>>()
    val loginResult: LiveData<Result<LoginResponse>> = _loginResult
    fun login(username: String, password: String) {
        viewModelScope.launch {
            /*  try {
                  val response = RetrofitInstance.getAuthServiceLogin(tokenManager).login(LoginRequest(username, password))
                  val res = response.body()
                  tokenManager.token = res?.token
                  Log.d("Resultado", "OK"+tokenManager.token)
              } catch (e: Exception) {
                  // Handle error
                  Log.d("Resultado","Error: "+e.message.toString())
              }
           */
            try {
                val response: Response<LoginResponse> = RetrofitInstance.getAuthService(tokenManager)
                        .login(LoginRequest(username, password))
                if (response.isSuccessful) {
                    response.body()?.let { body ->
                        tokenManager.token = body.token
                        _loginResult.postValue(Result.success(body))
                        Log.d("Resultado", "OK" + tokenManager.token)
                    } ?: run {
                        _loginResult.postValue(Result.failure(Exception("Response body is null")))
                    }
                } else {
                    _loginResult.postValue(Result.failure(Exception("Login failed with code: ${response.code()}")))
                }
            } catch (e: Exception) {
                _loginResult.postValue(Result.failure(e))
            }
        }
    }
}